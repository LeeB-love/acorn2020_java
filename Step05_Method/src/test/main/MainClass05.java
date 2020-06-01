package test.main;

import test.mypac.Car;
import test.mypac.Champion;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * test.mypac 패키지에 다양한 모양의 메소드를 가지는 클래스를 정의하고 
		 * 그 클래스를 이용하여 객체를 생성하고 메소드도 호출해보세요.
		 */
	
		Champion cham1 = new Champion();
		
		cham1.name = "이봉하";
		System.out.println(cham1.hp);
		cham1.attacked(4);
		cham1.attack("심수");
		cham1.protect("심수");
		
		Car car = new Car();
		car.name = "소나타";
		car.run("심수");
	}
}
