package test.main;

import test.human.Blood;
import test.human.Man;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적 : 아래의 useMan() 메소드를 호출하는 것.
		 * 아래의 useMan() 메소드를 호출해보세요.
		 */
		//Man 객체를 생성해서 참조값을 m1이라는 지역변수에 담기
		Man m1 = new Man(new Blood("rh-", "A"), 25, "Tom");
		//useMan() 메소드 호출하면서 Men 객체의 참조값 전달하기 (객체 네개. Man, Blood, "rh-",  "A")
		MainClass13.useMan(m1);
	}
	public static void useMan(Man m) {
		m.walk();                
		m.stydy();
		m.seeMovie();
	}
}
