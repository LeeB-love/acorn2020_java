package test.main;

import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		//Car 클래스로 객체를 생성해서 참조값을 c1이라는 이름의 변수에 담아 보세요
		
		Car c1 = new Car("카니발");  //생성자 지역변수를 전달하기로 했는데 안전달하면 문법 오류
		Car c2 = new Car("프라이드");
		c1.drive(); //객체를 생성할 때 전달한 값을  메서드 동작할 때 사용함.
		c2.drive();
		
	}
}
