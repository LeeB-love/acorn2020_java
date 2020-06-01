package test.mypac;

public class Car {
	//필드
	public String name;
	
	//생성자...
	//지역변수는 뭘 전달해줘야하는지 힌트를 주는 역할
	public Car(String name) {
		//생성자의 인자로 전달받은 값을 필드에 저장하기
		this.name = name;
	}
	public void drive() {
		System.out.println(this.name + "이(가) 달려요");
	}
}
