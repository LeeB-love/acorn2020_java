package test.main;

import test.mypac.Weapon;

public class MainClass08 {
	
	//static 메소드 안에서는 static 자원만 사용가능하기 때문에...
	static Weapon w1 = new Weapon() { //anonymous inner class 
		
		@Override
		public void attack() {
			System.out.println("핵미사일 발싸~~");
			
		}
	};
	
	public static void main(String[] args) {
		//필드에 저장된 Weapon type의 참조값을 이용해서 useWeapon() 메소드 호출하기
		
		useWeapon(w1);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}

