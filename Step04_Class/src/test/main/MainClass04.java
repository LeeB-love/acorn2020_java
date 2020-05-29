package test.main;

import test.mypac.Member;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 	1, 김구라, 노량진
		 * 	이라는 int, String, String type의 값을
		 * 	객체의 필드에 저장하는 프로그래밍를 해보세요.
		 * 
		 * 	단 객체를 생성할 클래스의 이름은 Member로 작성하세요.
		 */
		
		Member mem1 = new Member();
		
		mem1.number = 1;
		mem1.name = "김구라";
		mem1.addr = "노량진";
		mem1.showInfo();
		
		Member mem2 = new Member();
		mem2.number = 2;
		mem2.name = "해골";
		mem2.addr = "행신동";
		mem2.showInfo();
	}
}
