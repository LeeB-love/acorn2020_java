package test.main;

import test.mypac.Marine;

public class MainClass07 {
	public static void main(String[] args) {
		// Marine 객체를 생성해서 참조값을 m1이라는 지역변수에 담아보세요
		 Marine m1 = new Marine();
		 m1.move();
		 m1.attack();
		 m1.showEnergy();
		 System.out.println("----- m1 -----");
		 
		 Marine m2 = new Marine();
		 m2.move();
		 m2.attack();
		 m2.showEnergy();
		 System.out.println("----- m2 -----");
	
		 //Marine의 공격력을 올려보자
		 Marine.attackPower += 2;   //모든 마린객체가 모두 영향을 받는다.
		 m1.attack();
		 m2.attack();
		 
		 //m1의 에너지 감소 시키기 (m2의 에너지에는 영향을 주지 않는다.)
		 m1.energy -= 10;
		 m1.showEnergy();
		 m2.showEnergy();
		 
		 // m1이 공격 당함
		 m1.attacked();
		 m1.showEnergy();
		 
		 //m2가 공격당함
		 m2.attacked();
		 m2.showEnergy();
		 
		 m1.attacked();
		 m1.attacked();
		 m1.showEnergy();
		 
		 m1.died();
	}
}
