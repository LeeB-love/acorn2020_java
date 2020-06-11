package test.mypac;
/*
 * [ interface]
 * - 생성자가 없다 (단독 객체 생성 불가)
 * - 구현된 메소드는 가질 수 없다.(추상 메소드만 가질 수 있다)
 * - (메소드를 강제하는 역할을 가질 수 있음)
 * - 필드는 static final 상수만 가질 수 있다.
 * - data type의 역할을 할 수 있다.
 * - interface type의 참조값이 필요하면 구현(implements)클래스를 만들어서 객체를 생성해야한다.
 * - static final field / abstract method 
 * - 클래스 상속은 단일 상속이지만, 인터페이스는 다중 구현이 가능하다. 
 * (클래스 상속 - 한 클래스에 하나 상속, 인터페이스 - 한 클래스에 여러 인터페이스 구현 가능)
 * class MyObject extends Car implements Remocon, Drill{} 가능..
 * 
 * 인터페이스랑 클래스 상속 받으면 기능 엄청 많은데 그러면 필요한 기능을 찾기 어려우니까...
 * 필요한 기능만 골라서 부모타입으로 받아버리기...
 */
public interface Remocon {
	//필드 (static final 예약어 생략가능)
	public static final String COMPANY = "LG";
	//Remocon.COMPANY 로 참조
	 
	//메소드 (abstract 예약어 생략 가능)
	public abstract void up();
	public abstract void down();
}
