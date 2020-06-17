package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MainClass14 {
	public static void main(String[] args) {
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				//반복문 돌면서 문자열을 줄단위로 읽어낸다.
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//try catch
	}
}
