package test.main;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;
import test.mypac.Orange;

public class MainClass01 {
	public static void main(String[] args) {
		//Generic 클래스를 다양하게 지정을 해서 객체를 생성하고 참조값을 담을 수 있다.
		FruitBox<Apple> box1 = new FruitBox<Apple>();  //객체를 생성하는 시점에 type을 결정해주는 것
		//Generic 클래스로 지정한 type 객체를 넣어주어야 한다.
		box1.push(new Apple());
		
		FruitBox<Orange> box2 = new FruitBox<Orange>();
		box2.push(new Orange());
		
		FruitBox<Banana> box3 = new FruitBox<Banana>();
		box3.push(new Banana());
		
		//Generic 클래스로 지정한 type 객체가 리턴된다.
		Apple result1 = box1.pull();
		Orange result2 = box2.pull();
		Banana result3 = box3.pull();
		
	}//main
}//MainClass01
