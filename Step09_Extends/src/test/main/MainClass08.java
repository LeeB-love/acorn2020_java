package test.main;

import test.auto.Bus;
import test.auto.Engine;
import test.auto.Human;
import test.auto.SportsCar;
import test.auto.Truck;

public class MainClass08 {
	public static void main(String[] args) {
		//Truck 객체를 생성해서 .driv() .dump 메소드를 호출해보세요.
		
		Truck T1 = new Truck(new Engine()); //new Engine()객체는 Car 생성자로 흘러흘러 들어간다~
		T1.drive();
		T1.dump();
		//T1.engine; => 이거 필드를 public으로 만들었을 때만 참조할 수 있음.
		
		//SportsCar 객체를 생성해서 .drive()메소드를 호출해보세요.
		
		SportsCar s1 = new SportsCar(new Engine());
		s1.drive();
		
		Bus b1 = new Bus(new Engine(), new Human());
		b1.human.ride();
		b1.drive();
		
	}
}
