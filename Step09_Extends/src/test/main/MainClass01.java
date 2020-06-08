package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	public static void main(String[] args) {
		//Phone 클래스로 객체 생성해서 참조값을 지역변수에 담기
		Phone p1 = new Phone();
		Object p2 = new Phone();
		
		//HandPhone 클래스로 객체를 생성해서 참조값을 지역변수에 담기
		//Object => Phone => HandPhone 으로 상속해서 Object와 Phone과 HandPhone 클래스에 속해있는 메소드 모두를 사용 가능.
		HandPhone p3 = new HandPhone();
		Phone p4 = new HandPhone();
		Object p5 = new HandPhone();
		//poly type : HandPhone 객체는 다양한 형태의 타입으로 받을 수 있다. 받을 순 있지만, 부모타입에 정의된 기능밖에 못쓴다.
		
		//이미 만들어진 객체의 참조값을 다른 type으로 받아보기 - HandPhone은 다양한 타입을 가지고 있다. (부모타입으로 받을 수 있지만 전혀 상관없는 타입으로는 받는게 불가능하다.)
		Phone p6 = p3; //type이 달라서 HandPhone 객체를 대입했다고 해도 핸드폰 객체의 메소드 사용 불가 (필드나 지역변수에 타입을 선언하면 타입은 객체의 사용설명서다.)
		Object p7 = p3;
		//String str = p3;  // 오류남...
		
		HandPhone p8 = (HandPhone)p5;  //Casting 연산자를 이용해서 부모타입을 자식타입으로 Casting.
	}
}

/*
 * extends : 기존에 있는 class를 상속 받아서 class를 점점 확장시켜 나가는 것.
 * (상속이 허용되어있는 클래스여야 상속이 가능하다)
 */
