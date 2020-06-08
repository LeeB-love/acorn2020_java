package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Monkey; //Monkey type import - Monkey는 Zoo클래스의 inner Class type
import test.mypac.Zoo.Tiger;

public class MainClass03 {
	public static void main(String[] args) {
		//Zoo 클래스에 있는 getMonkey() 메소드를 호출해서 리턴되는 값을 m1이라는 지역변수에 담아보세요.
		Zoo z1 = new Zoo();
		Monkey m1 = z1.getMonkey();  //Monkey 객체를 리턴해주는 메소드를 이용해서 생성
		m1.say();

		Tiger t1 = z1.getTiger();
		t1.say();
		
		Zoo.Monkey m2 = z1.new Monkey();  //Monkey 객체 new 한거

	}
}
