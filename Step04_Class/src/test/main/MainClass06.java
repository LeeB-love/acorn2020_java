package test.main;

import test.mypac.Box;
import test.mypac.Car;
import test.mypac.Member;
import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		Member a = Box.mem;  //null
		Rect b = Box.rect;  // null
		Car c = Box.car;  // 참조값이 들어있다.
		c.drive(); // 메소드 호출가능
		
		Box.car.drive();   //Box 클래스의 static field인 car는 Car 타입 데이터. Car 타입 데이터의 (.) drive 메소드를 호출 
		
		a.showInfo();  // a는 null 이기 때문에 NullPointerException 발생 (문법적으론 맞음)
		b.getArea(); // b 또한 null 이기 때문에 위와 같은 문제 발생 
		
		
		
	}
}
