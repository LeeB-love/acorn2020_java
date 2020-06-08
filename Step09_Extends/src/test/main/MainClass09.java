package test.main;

import test.auto.Bus;
import test.auto.Car;
import test.auto.Engine;
import test.auto.Human;

public class MainClass09 {
	public static void main(String[] args) {
		//여러분들이 Car 클래스를 상속받아서 만든 클래스로 객체를 생성해서 아래의 useCar() 메소드를 호출해보세요.
		Bus b1 = new Bus(new Engine(), new Human());
		b1.human.ManCount = 3;
		b1.human.ride();
		MainClass09.useCar(b1);
		
		Bus b2 = new Bus(new Engine(), null);
		useCar(b2);
		
		Bus b3 = new Bus(new Engine(), new Human());
		b3.human.ManCount=0;
		useCar(b3);
	}
	
	public static void useCar(Car car) {
		car.drive();
	}
}
