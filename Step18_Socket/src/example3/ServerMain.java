package example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;  //클라이언트의 접속을 기다리게 하는 객체. 클라이언트가 접속하고 나면 Socket 객체를 리턴한다.
import java.net.Socket;  //Socket을 이용하여 클라이언트와 소통한다. 10명이 접속하면 Socket 10개, 20명이 접속하면 Socket 20 ...이런식으로 늘어나간다.

/*
 * ServerSocket/Socket = 컴퓨터끼리 네트워크를 통해서 데이터를 주고받을 수 있다.
 */

public class ServerMain {
	public static void main(String[] args) {
		//필요한 객체를 저장할 지역변수를 미리 만들기
		ServerSocket serverSocket = null;
		try {
			//5000번 통신 port를 열고 클라이언트의 접속을 기다린다.
			serverSocket = new ServerSocket(5000);
			/*
			 * accept() 메소드는 클라이언트가 실제 접속을 할 때 까지 리턴하지 않고 블록킹 되는 메소드입니다.
			 * 클라이언트가 접속을 해오면 Socket 객체의 참조값을 반환하면서 리턴된다.
			 */
			while(true) { //계속 기다리려면 무한루프로 돌려야한다.
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다");
				Socket socket = serverSocket.accept();
				serverSocket.accept(); 
				System.out.println("클라이언트가 접속을 했습니다.");
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 아이피 : "+clientIp);
				
				//클라이언트로부터 읽어들일 (Input) 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream(); //입력메소드(read())가 정수타입을 입력해준다 불편...
				InputStreamReader isr = new InputStreamReader(is);//역시 줄단위로 읽어오는 메소드는 없음 또 기능 업
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
				System.out.println("메세지 : "+msg);
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket !=null) serverSocket.close();
			}catch (Exception e) {}
		}//try/catch/finally
	}//main
}//class ServerMain

/*
 * 본인 아이피 알아내는 법 : 명령프롬프트 -> ipconfig -> IPv4 주소 (반 안에서만 통용되는 가상의 아이피-외부에서 접근하려면 학원 와이파이에 접속되어있어야한다.)
 */
