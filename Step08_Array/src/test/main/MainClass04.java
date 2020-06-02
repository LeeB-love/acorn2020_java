package test.main;

import test.mypac.Bike;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 1. Bike 객체를 담을 수 있는 방 3개짜리 배열객체를 생성해서 참조값을 bikes라는 지역변수에 담아보세요.
		 * 2. 배열 각각의 방(0,1,2번)에 Bike 객체를 생성해서 담아보세요.
		 * 3. 반복문 for를 이용해서 배열 각각의 방에 있는 Bike 객체의 ride()메소드를 호출해보세요.
		 */
		
		Bike[] bikes = new Bike[3];
		
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		Bike b3 = new Bike();
		
		bikes[0] = b1;
		bikes[1] = b2;
		bikes[2] = b3;
		
		for(int i=0; i<bikes.length; i++) {
			bikes[i].ride();
		}
		
	}
}
