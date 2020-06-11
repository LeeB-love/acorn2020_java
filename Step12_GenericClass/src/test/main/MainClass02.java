package test.main;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;
import test.mypac.Orange;

public class MainClass02 {
	public static void main(String[] args) {
		//객체를 생성할 때 Generic 클래스는 생략이 가능하다.
		FruitBox<Apple> box1 = new FruitBox<>(); //타입 받을 때 잘 받으면 됨...
		FruitBox<Orange> box2 = new FruitBox<>();
		FruitBox<Banana> box3 = new FruitBox<>();
		
	}
}
