package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		OutputStream os = ps;   //콘솔과 연결된 객체
		try {
			os.write(97); //출력하기
			os.write(98);
			os.write(99);
			os.flush(); //출력된 내용을 방출하기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
