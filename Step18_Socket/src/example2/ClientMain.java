package example2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		//서버에 전송할 문자열을 입력받아서
		Scanner scan = new Scanner(System.in);
		System.out.println("서버에 전송할 문자열 입력");
		String msg = scan.nextLine();
		
		Socket socket = null;
				try {
					socket = new Socket("192.168.0.30", 5000);
					System.out.println("Socket 연결 성공!");
					//문자열을 서버에 전송(출력 Output) 하기
					OutputStream os = socket.getOutputStream();
					OutputStreamWriter osw =new OutputStreamWriter(os);
					osw.write(msg);
					osw.write("\r\n");//개행기호도 출력(서버에서 줄단위로 읽어낼 예정)
					osw.flush();
					osw.close();//소캣을 일회용으로 사용하는 것. 
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					if(socket!=null)
						try {
							socket.close();
						} catch (IOException e) {}
				}
	}
}
