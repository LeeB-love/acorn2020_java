package test.mypac;

/*	[생성자]
 * 	1. 클래스명과 동일하다.
 * 	2. 메소드 모양과 유사하지만, 리턴타입이 없다.
 * 	3. 객체를 생성할 때 (new 할 때) 호출된다. - 객체를 처음 만들 때 실행순서가 들어온다.
 * 	4. 객체를 생성하는 시점에서 무언가 준비 작업을 해야할 때 유용하다. - 객체가 생성될 때 초기화작업이 필요하면 생성자 사용.
 * 	5. 생성자를 명시적으로 정의하지 않아도 기본 생성자는 있다고 간주된다. (안필요하면 안써도 됨)
 */

public class Student {
	//생성자 
	public Student() {
		System.out.println("Student 클래스의 생성자 호출됨!");
	}
	public void study() {
		System.out.println("공부를 해요");
	}
	public void goSchool() {
		System.out.println("학교를 가요");
	}
}
