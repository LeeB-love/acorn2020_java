package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
/*
 * 1. 필요한 객체의 참조값을 담을 지역변수 미리 만들기 (여기서 선언 안하면 finally 블럭에서 변수 사용 불가)
 * 2. 지역변수의 참조값은 사용되는 try 블럭 내에서 넣어주기 (어차피 new 하는 시점에서 try catch 해야하는 경우가 있기 때문에 그냥 여기서 해주는게 나음)
 * 3. 맨 마지막에 finally 블럭에서 close 해주기 (null 체크해주기)
 */
public class MainClass15 {
	public static void main(String[] args) {
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		//필요한 객체의 참조값을 담을 지역변수를 미리 만든다.
		FileReader fr = null;
		BufferedReader br = null;
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			//파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어둔 지역변수에 담기
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);
			while(true) {
				//반복문 돌면서 문자열을 준단위로 읽어낸다.
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally { //예외가 발생하던 안하던 반드시 실행이 보장되는 블럭
			try {
				//null 체크한 다음에 메소드를 호출해서 마무리 작업을 한다.
				if(fr!=null)fr.close();
				if(br!=null)br.close();
			}catch (IOException ie) {}
		}
	}
}
