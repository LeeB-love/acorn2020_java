package example2;

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

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5000);

			while(true) { //계속 기다리려면 무한루프로 돌려야한다.
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다");
				Socket socket = serverSocket.accept();
				serverSocket.accept(); 
				System.out.println("클라이언트가 접속을 했습니다.");
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 아이피 : "+clientIp);
				
				//클라이언트로부터 읽어들일 (Input) 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream(); 
				InputStreamReader isr = new InputStreamReader(is);
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
