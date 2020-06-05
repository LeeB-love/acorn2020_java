package test.auto;

public class Truck extends Car{
//반드시 아래와 같은 생성자가 있어야 문법적으로 성립함. 
	//Engine 객체를 생성자의 인자로 전달받는 생성자
	public Truck(Engine engine) {
		//자식생성자로 받은 객체를 부모 생성자에 전달해주어야 부모 객체가 생성된다. 
		super(engine);  //super()는 부모의 생성자를 가리킨다.
	}
	//메소드 
	public void dump() {
		System.out.println("짐을 쏟아내요");
	}

}
