package test.auto;

public class Bus extends Car {
	
	public Human human;
	
	public Bus(Engine engine, Human human) {
		super(engine);
		this.human = human; 
	}
	
	
	@Override
	public void drive() {
		if((human == null)||(human.ManCount == 0)) {
			System.out.println("사람이 올 때 까지 기다립니다.");
			return;
		}
		System.out.println("버스가 사람을 태우고 떠납니다.");
	}
	

}
