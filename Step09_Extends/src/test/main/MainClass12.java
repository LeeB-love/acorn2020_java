package test.main;

import test.human.Blood;
import test.human.Person;
import test.human.Woman;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적 : 독서를 하고싶다.
		 * 독서하는 프로그래밍을 해보세요.
		 */
		Person w1 = new Woman(new Blood("rh+", "O"), 28, "이봉하");
		w1.stydy();
	
		Woman w2 = (Woman)w1;
		w2.reading();
	}
}
