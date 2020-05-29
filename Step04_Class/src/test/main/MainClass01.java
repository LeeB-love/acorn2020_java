package test.main;

import test.mypac.Car;

public class MainClass01 {
	//run 했을 때 실행 순서가 시작되는 특별한 main() 메소드
	public static void main(String[] args) {   //args 의 이름만 바꿀 수 있고 나머지는 똑같이 써야 run했을 때 실행된다.
			//Car 클래스를 이용해서 객체를 생성하고 참조값을 지역 변수에 담기
			// Car 클래스를 이용해서 만든 클래스의 데이터 타입 => Car type
			Car car1 = new Car(); // 설계도를 이용해서 객체 생성 => 참조값이 저장되어있다.
			// Car 객체의 메소드 호출하기
			car1.drive();
			//Car 객체의 필드에 값 대입하기
			car1.name = "소나타";
			
			//1. Car 클래스를 이용해서 객체를 생성하고 참조값을 car2라는 이름의 지역변수에 담아보세요
			Car car2 = new Car();
			//2. 메소드를 호출해보세요.
			car2.drive();
			//3. name 이라는 필드에 차 이름을 담아보세요.
			car2.name = "카니발";
	}
}

// 1. new해서 객체 생성하고 참조값 얻어내기
// 2. 객체.메소드 호출
// 3. 객체.필드 값 대입