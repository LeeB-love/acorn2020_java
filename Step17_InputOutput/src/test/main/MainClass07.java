package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		File myfile = new File("c:/");
		String[] names = myfile.list();
		for(String tmp : names) {
			System.out.println(tmp);
		}
		
	}
}
