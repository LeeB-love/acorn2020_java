package test.main;

import test.mypac.Car;
import test.mypac.MyObject;

public class MainClass02 {
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		//getCar() 메소드가 리턴해주는 참조값을 지역변수에 담아보기
		Car a = obj1.getCar(); 
		Car b = obj1.getCar(); 
		Car c = obj1.getCar(); // 타입은 같지만 셋 다 다른 참조값을 가지고있음. 계속 new 되기 때문에
		
		//지역변수에 담긴 객체 사용하기
		a.drive();
		b.drive();
		c.drive();
	}
	//int type 를 메소드의 인자(지역변수임)로 전달받는 메소드

}








