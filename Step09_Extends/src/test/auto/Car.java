package test.auto;

public class Car {
	//필드
	protected Engine engine;
	
	//Engine 객체를 인자로 전달받는 생성자
	public Car(Engine engine) {
		//인자로 받은 Engine 객체를 필드에 저장하기
		this.engine = engine;
	}
	
	public void drive() {
		if(engine == null) {
			System.out.println("Engine 객체가 없어서 달릴 수 없어요");
			return; //메소드 끝내기
		}
		System.out.println("달려요");
	}
}
/*
* Car는 객체가 생성되기 위해서는 생성자를 호출할 수 밖에 없다. new Car(Engine engine);
* 반드시 Engine 타입 객체를 전달해야지 Car 객체를 생성할 수 있다.
* Truck의 생성자를 호출하면 Car의 생성자가 먼저 호출되는데, 그 때 Engine 타입 객체를 전달해주지 않으면
* Car 객체가 만들어지지 않는다. 
* 		부모타입이 먼저 만들어지고 차례로 족보가 내려감. 특정  생성자가 필요한 부모타입일 경우 맨 막내가 필요한 생성자를
* 		받아서 부모에게 전달한다~
*/