package test.mypac;

public class Champion {
	public String name;
	public int hp = 100;
	public int attackPower = 10;
	
	public void attacked(int a) {
		this.hp -= a;
		System.out.println(name+"이(가)"+a+"만큼 공격을 당했습니다. 현재 hp는"+this.hp+" 입니다.");
	}
	public void protect(String vName) {
		this.hp += 5;
		System.out.println(name + "이(가)"+vName+"의 공격을 막았습니다. 현재 hp는 "+this.hp+" 입니다.");
	}
	public void attack(String vName) {
		System.out.println(vName+"를 "+attackPower+" 만큼 공격했습니다.");
	}
	
}
