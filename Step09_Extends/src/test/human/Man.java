package test.human;

public class Man extends Person{

	public int age;
	private String name;
	
	public Man(Blood blood, int age, String name) {
		super(blood);  //부모 생성자에 필요한 값을 전달한다.
		this.age = age;
		this.name = name;
	}
	
	public void seeMovie() {
		System.out.println(this.name + "이(가) 영화를 봐요");
	}
	
	public String getName() {
		return name;
	}
	
}
