package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File myFile = new File("c:/");
		File[] files= myFile.listFiles();
		//반복문 돌면서 하나씩 참조해서 작업해보기
		for(File tmp : files) {
			if(tmp.isDirectory()) {
				System.out.println("[ "+tmp.getName()+" ]");
			}else {
				System.out.println(tmp.getName());
			}
		}
	}
}
