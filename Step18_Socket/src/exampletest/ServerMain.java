package exampletest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerMain {
	public static void main(String[] args) {
		/*
		 * 1. 필요한 객체(ServerSocket)을 저장할 지역변수를 미리 만들기.
		 * 2. 5000번 통신 port를 열기
		 * 	> ServerSocket 객체 new 할 시 통신 port 번호를 생성자 인자로 ㄱㄱ
		 * 3. 무한루프를 돌면서 클라이언트의 접속을 기다리기
		 * 	> ServerSocket 객체의 accept() 메소드를 활용하여 접속 허가 후 
		 * 	클라이언트의 소켓을 받는다.
		 * 4. 클라이언트의 다중 접속이 가능하도록 클라이언트가 접속할 때 마다 새로운 스레드를 생성하도록 만든다.
		 * 		(클라이언트가 작성한 문자열을 받아올 목적으로 만드는 스레드)
		 * 	> Thread를 상속받은 내부 클래스를 만든다.
		 * 	> run() 메소드를 강제 오버라이드 하여 
		 */
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5000);
		
			while(true) {
				Socket socket = serverSocket.accept();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public class ServerThread extends Thread{
		@Override
		public void run() {

		}
	}
}
