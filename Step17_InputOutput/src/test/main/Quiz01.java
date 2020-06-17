package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 문자열 한 줄을 입력받은 다음
		 * c:/acorn2020/myFolder/quiz.txt 파일을 만들어서
		 * 해당 파일에 문자열을 저장해보세요.
		 */
		
		//문자열 입력창 만들기
		Scanner scan = new Scanner(System.in);
		System.out.println("저장할 문자열 입력 : ");
		String message = scan.nextLine();
		
		//c:/acorn2020/myFolder/quiz.txt 파일 만들기
		File quiz = new File("c:/acorn2020/myFolder/quiz.txt");
		
		//
		try {
			boolean isExist = quiz.exists();
			if(!isExist) {
				quiz.createNewFile();
				//파일에 문자열을 출력할 객체
			}
			FileWriter fw = new FileWriter(quiz, true);  //append를 사용하려면 true를 붙여줘야한다.
			//fw.write(message);
			fw.append(message);
			fw.append("\r\n");
			fw.close();  //자동 flush가 된다.
			System.out.println("파일에 문자열을 저장했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
