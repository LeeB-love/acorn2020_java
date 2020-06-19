package example5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;  //클라이언트의 접속을 기다리게 하는 객체. 클라이언트가 접속하고 나면 Socket 객체를 리턴한다.
import java.net.Socket;  //Socket을 이용하여 클라이언트와 소통한다. 10명이 접속하면 Socket 10개, 20명이 접속하면 Socket 20 ...이런식으로 늘어나간다.
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * ServerSocket/Socket = 컴퓨터끼리 네트워크를 통해서 데이터를 주고받을 수 있다.
 */

public class ServerMain {
	
	
	
	
	
	//필드
	static List<ServerThread> threadList = new ArrayList<>();
	
	
	
	
	
	
	public static void main(String[] args) {
		//필요한 객체를 저장할 지역변수를 미리 만들기
		ServerSocket serverSocket = null;
		
		//메인 스레드에서 하는 일은 이게 다임
		try {
			//5000번 통신 port를 열고 무한루프 돌면서 클라이언트의 접속을 기다린다.
			serverSocket = new ServerSocket(5000);
			while(true) {
				Socket socket = serverSocket.accept();
				
				//방금 접속한 클라이언트를 응대할 스레드를 시작시킨다.
				ServerThread thread = new ServerThread(socket);
				thread.start();
				//생성하고 시작한 스레드의 참조값을 List에 저장하기
				threadList.add(thread);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket !=null) serverSocket.close();
			}catch (Exception e) {}
		}//try/catch/finally
	}//main
	
	
	
	
	
	
	
	//클라이언트의 문자열을 출력할 스레드
	public static class ServerThread extends Thread{
		//필드
		Socket socket;
		//클라이언트에게 출력할 문자열을 저장해 놓을 필드
		BufferedWriter bw;
		//클라이언트의 대화명을 저장할 필드
		String chatName;
		
		//생성자
		public ServerThread(Socket socket) {
			this.socket = socket;
			//클라이언트에게 출력할 문자열을 객체
		}
		
		public void sendMessage(String msg) throws IOException {
			//반복문 돌면서 모든 스레드의 BufferWriter 객체를 이용해서 문자열을 전송한다. 
			for(ServerThread tmp : threadList) {
				tmp.bw.write(msg); //문자열 출력
				tmp.bw.newLine(); //개행기호 출력
				tmp.bw.flush(); //방출
			}
		}
		//참여자 목록을 얻어내서 Client 에게 출력해주는 메소드
		public void sendChatNameList() {
			JSONObject jsonObj = new JSONObject();
			JSONArray jsonArr = new JSONArray();
			//스레드 리스트에서 대화명을 순서대로 참조해서 JSONArray 객체에 순서대로 넣기
			for(int i=0; i<threadList.size(); i++) {
				ServerThread tmp = threadList.get(i);
				jsonArr.put(i, tmp.chatName);
			}
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonArr);
			
			try {
				sendMessage(jsonObj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//새로운 작업단위가 시작되는 run() 메소드
		@Override
		public void run() {
			
			//클라이언트로부터 읽어들일 (Input) 객체의 참조값 얻어오기
			InputStream is;
			try {
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 아이피 : "+clientIp);
				is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);//역시 줄단위로 읽어오는 메소드는 없음 또 기능 업
				BufferedReader br = new BufferedReader(isr);
				
				//클라이언트에게 출력할 수 있는 객체
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				while(true) {
					/*
					 * 클라이언트가 문자열을 한 줄(개행기호와 함께) 보내면
					 * readLine() 메소드가 리턴하면서 보낸 문자열을 가지고온다.
					 * 보내지 않으면 계속 블로킹되어서 대기하고 있다가 접속이 끊기면 Exception이 발생하거나 혹은 null이 리턴된다.
					 * 따라서 null이 리턴되면 반복문을 빠져나가게 break문을 만나도록한다.
					 * 실행순서가 try 블럭을 번서나면 run()메소드가 리턴하게 되고 run() 메소드가 리턴되면 해당 스레드는 종료된다.
					 */
					
					//클라이언트가 전송하는 문자열을 읽어낸다.
					String msg = br.readLine();
					//전송된 JSON 문자열을 사용할 준비를 한다.
					JSONObject jsonObj = new JSONObject(msg);
					String type = jsonObj.getString("type");
					
					//type을 읽어낸다.
					if(type.equals("enter")) {
						//누가 입장했나? - 현재 스레드가 대응하는 클라이언트의 대화명을 필드에 저장한다.
						String chatName = jsonObj.getString("name");
						this.chatName=chatName;
						//대화명 목록을 보내준다.
						sendChatNameList();
					}
					
					System.out.println("메세지 : "+msg);
					//클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다.
					sendMessage(msg);
					if(msg==null) {
						break;  //클라이언트의 접속이 끊겼기 때문에 반복문(while)을 빠져나오도록한다.
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				//접속이 끊겨서 종료되는 스레드는 List에서 제거한다. -접속이 끊긴 스레드의 참조값(ServerThread)이 있는 방을 찾아서 알아서 삭제
				threadList.remove(this);
				//this가 퇴장한다고 메세지를 보낸다.
				try {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", this.chatName);
					sendMessage(jsonObj.toString());
					//대화명 목록을 보내준다.
					sendChatNameList();
					if(socket!=null)socket.close();
				} catch (IOException e) {}
			}
		}
	}
	
}//class ServerMain

/*
 * 작업단위가 하나이면 한명의 클라이언트를 응대하는게 시간이 오래걸릴 경우, 다른 클라이언트는 응대할 수 없다. 응대하고있던 클라이언트의 응대가 끝날 때까지 기다려야함
 * 메인스레드와 새로운 스레드를 분리해서 serverSocket은 메인에서, socket 부분은 새로운 스레드에서 ㄱㄱ
 * 
 * 1. 클라이언트의 접속을 기다리고 승인하는(serverSocket) 메인스레드
 * 2. 문자열을 클라이언트에게서 받아오는 스레드
 * 총 두가지가 필요함.
 * 
 * xml, json
 */
