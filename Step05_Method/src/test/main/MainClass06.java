package test.main;

import test.mypac.Car;
import test.mypac.Messenger;

public class MainClass06 {
	public static void main(String[] args) {
		//Messenger 클래스의 static 메소드 3개를 하나씩 호출해보세요.
		
		Car c = new Car();
		
		Messenger.sendMessage("야호");
		String msg = Messenger.getMessage();
		System.out.println(msg);
		Messenger.useCar(c);
	}
}
