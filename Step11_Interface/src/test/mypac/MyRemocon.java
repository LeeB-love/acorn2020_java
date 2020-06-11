package test.mypac;
//interface 는 implements(구현)를 통해서 받는다.
//구현클래스에서는 인터페이스에 정의된 추상메소드를 반드시 오버라이드해야한다. 
//implements는 상속은 아니지만 부모타입 역할을 하긴한다.
/*
 * 인터페이스는 생각보다 많이 사용된다.
 */
public class MyRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("뭔가를 올려용");
		
	}

	
	public void down() {
		System.out.println("뭔가를 내려용");
		
	}
	
}
