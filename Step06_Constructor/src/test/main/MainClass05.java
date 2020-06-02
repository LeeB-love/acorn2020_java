package test.main;

import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 *  프로그래밍의 목적 : 키보드로부터 문자열을 입력받고 싶다.
		 *  입력받아서 무얼하나? 콘솔창에 출력한다.
		 */
		//System.in => inputstream 타입 관련
		Scanner scan = new Scanner(System.in);    
		//out은 콘솔에 출력하는 객체, in은 키보드와 연결되어있는 객체
		//System.in을 생성자 인자에 넣지 않으면 제대로 작동하지 않는다.
		
		//키보드로 입력받기 위해서는 일단 콘솔창을 열리게 해야한다.
		System.out.println("문자열을 입력하세요");
		//Scanner 객체의 메소드를 이용해서 문자열 (String) 입력 받기
		String str = scan.nextLine(); //메소드가 리턴할 때 까지 실행순서를 잡아두고 있는다. (입력하면 입력한 String 리턴)
		System.out.println(str);
		
		int a = str.length(); //문자열 객체는 길이를 반환하는 함수 존재
		System.out.println(a);
		
		System.out.println("main 메소드가 종료됩니다.");
		
	}
}
