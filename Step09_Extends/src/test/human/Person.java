package test.human;

public class Person {
	//필드
	public Blood blood;
	
	//생성자
	public Person(Blood blood) {
		this.blood = blood;
	}
	public void walk() {
		System.out.println("뚜벅뚜벅 걸어용~");
	}
	
	public void stydy() {
		System.out.println("공부해영...");
	}
	
}
