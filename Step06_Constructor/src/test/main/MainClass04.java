package test.main;

import java.util.Random;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 *  프로그래밍의 목적 : 무작위 정수를 얻어내고 싶다
		 *  	>> Random 클래스 사용&클래스의 메소드 사용
		 *  얻어내서 뭘하지? 그냥 콘솔창에 출력하고 싶다.
		 */
		Random ran = new Random();
		//ran. 해서 눈치껏 무슨 기능이 있는지 확인해보자
		int a = ran.nextInt();
		System.out.println(a);
		
		/*
		 * 	또 해결해야하는 문제 : 원하는 범위 내에서 정수값을 얻어내고 싶다!
		 * 	범위는? 1~45
		 * 	얻어내서 뭘할까? 콘솔창에 출력한다.
		 */
		int lottoNum = ran.nextInt(45)+1;
		System.out.println(lottoNum);
	}
}
