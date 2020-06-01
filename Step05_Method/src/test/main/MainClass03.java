package test.main;

import test.mypac.Car;
import test.mypac.MyObject;

public class MainClass03 {
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		// .setNum() , .setName(), .useCar() 메소드를 호출해보세요
		
		obj1.setNum(10);
		obj1.setName("흠냐");
		obj1.useCar(new Car());
	}
}
