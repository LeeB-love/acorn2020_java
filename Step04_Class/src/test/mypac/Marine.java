package test.mypac;

public class Marine {
	// 공격력을 저장하고 있는 static field
	public static int attackPower = 6;
	//에너지를 저장하고 있는 non static 필드
	public int energy = 40;
	
	//움직이는 메소드
	public void move() {
		System.out.println("마린이 움직여요");
	}
	
	//공격하는 메소드
	public void attack() {
		System.out.println(Marine.attackPower+" 의 공격력으로 공격을 해요");
	}
	//non static method 에서 static field를 참조하는 방법 : Marine.attackPower
	
	//현재 에너지를 출력하는 메소드
	public void showEnergy() {
		System.out.println("현재 에너지  : " + this.energy);
	}
	
	public void attacked() {
		System.out.println("적에게 공격당했습니다.");
		this.energy -= 10;
	}
	
	public void died() {
		if(this.energy <= 0) {
			System.out.println("마린이 주겄슴돠;;");
		}
	}
}
