package test.main;

import test.mypac.SmartPhone;

public class MainClass06 {
	public static void main(String[] args) {
		SmartPhone p1 = new SmartPhone();
		p1.mobileCall();
		p1.doInternet();
		//SmartPhone 클래스에서 오버라이드 된 메소드가 호출된다.
		p1.takePicture();
	}
}
//SmartPhone 객체를 new 하는 것 : SmartPhone 클래스의 생성자를 호출하는 것.
/*
 * new SmartPhone 객체 하나만 생성해도 Object, Phone, HandPhone, SmartPhone 객체가 동시에 생성되며
 * 하나의 참조값으로 관리된다.
 * 
 * 객체 안에서 자기자신 객체를 이르는 말 : this
 * 어떤 객체 부모의 객체를 이르는 말 : super
 */
