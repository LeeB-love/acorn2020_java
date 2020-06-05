package test.human;

public class Woman extends Person {

	public int age;
	private String name;
	
	public Woman(Blood blood, int age, String name) {
		super(blood);
		this.age = age;
		this.name = name;
	}

	//메소드
	public void reading() {
		System.out.println(this.name+"이(가) 책을 읽어용~");
	}
	
	public String getName() {
		return name;
	}
}
