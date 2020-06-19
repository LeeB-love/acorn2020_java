package example1;

import java.io.IOException;
import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket = null;
				try {
					socket = new Socket("192.168.0.30", 5000);
					System.out.println("Socket 연결 성공!");
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					if(socket!=null)
						try {
							socket.close();  //접속을 끊고 나면 close()를 통해 닫아주어야 한다.
						} catch (IOException e) {}
				}
	}
}
