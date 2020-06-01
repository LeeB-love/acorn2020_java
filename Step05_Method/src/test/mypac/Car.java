package test.mypac;

/*
 * 	[클래스의 용도]
 * 
 *  1. 객체의 설계도 역할을 한다.
 *  2. 데이터 type의  역할을 한다.
 *  3. static 필드나 static 메소드를 가지고 있는 역할을 한다.
 */

public class Car {
	// 자동차의 이름을 저장할 필드
	public String name;
	
	
	// 달리는 메소드
	public static void drive() {
		System.out.println("부릉 부릉 달려요~");
	}
	
	public void run(String vName) {
		System.out.println(vName+"가 "+this.name + " 를 타고 도망갑니다! 저놈 잡앗!!");
	}
	
}
// 위의 class로 객체를 찍어내면 String 타입의 name의 저장소와 drive라는 메소드를 가지게 될 것 이다.
// Heap 영역에 name이라는 저장소와 drive라는 기능을 저장해놓은 상태 ==> 설계도. 하나 파놓으면 엄청 찍어낼 수 있는 것. 
