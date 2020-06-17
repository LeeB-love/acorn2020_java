package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass17 {
	public static void main(String[] args) {
		//필요한 참조값을 담을 지역 변수를 미리 만든다.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//파일에서 byte를 읽어낼 객체
			fis = new FileInputStream("c:/acorn2020/myFolder/1.jpg"); //여기서 input을 받아서
			//읽어낸 byte를 출력할 객체
			fos = new FileOutputStream("c:/acorn2020/myFolder/copied2.jpg"); //여기에다 output을 출력
			//byte 데이터를 읽어낼 방 1024개빠리 배열객체 생성
			byte[] buffer = new byte[1024];
			//반복문 돌면서 읽어내기
			while(true) {
				int readedByte = fis.read(buffer);  //몇 바이트를 읽어냈는지가 리턴하다가 더 이상 읽을게 ㅇ벗을 때 -1을 리턴
				if(readedByte == -1) {
					break;
				}
				//byte[]에 있는 데이터를 읽은만큼 출력하기
				fos.write(buffer, 0, readedByte); //0번방에서부터 읽어온만큼 출력하겠다. 그냥 write 쓰면 안되고 이거 써야함 (1024씩 계속 출력하다가 맨 마지막에 남언거 52출력하고 끝나면 -1리턴)
			}
			System.out.println("파일을 성공적으로 복사했습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)fis.close();
				if(fos!=null)fos.close();
			}catch (IOException e) {}
		}
	}
}
