package test.main;

import test.human.Blood;
import test.human.Man;
import test.human.Person;
import test.human.Woman;

public class MainClass11 {
	public static void main(String[] args) {
		/*
		 *  프로그래밍의 목적 : 영화를 보고싶다.
		 *  영화를 보는 프로그래밍의 목적을 달성해보세요.
		 */
		Man m1 = new Man(new Blood("rh+", "O"), 13, "이승하");
		m1.seeMovie();
	
		Person w1 = new Woman(new Blood("rh+", "O"), 28, "이봉하");
		w1.stydy();
	
		Woman w2 = (Woman)w1;
		w2.reading();
	}
	
}
