package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	
	public static class YourWeapon extends Weapon{
		//static main에서는 static 자원만 접근가능함. non static 객체 생성 불가.
		@Override
		public void attack() {
			System.out.println("야ㅑㅑㅑㅑㅑㅑㅑㅑㅑ 주거라ㅏㅏㅏㅏㅏㅇㅇㅇㅇㅇㅇㅇㅇ");
			
		}
		
	}
	public static void main(String[] args) {
		/* 
		 * useWeapon() 메소드를 호출하는게 목적임니당
		 * 호출하려고 보니 Weapon 추상클래스 type 객체의 참조값이 필요하다.
		 * 따라서 Weapon 추상 클래스를 상속받은 클래스를 파일로 만들어야 된다.
		 * 군데... 불금이당 ㅠ 빨랑 집에가고싶다... 흐귱 클래스를 따로 만들기 시름
		 */
		Weapon w1 =new YourWeapon();
		useWeapon(w1);
		
		//local inner class도 이용해보자
		
		class OurWeapon extends Weapon{

			@Override
			public void attack() {
				// TODO Auto-generated method stub
					System.out.println("지겹다 이제 그만 공격하자");
			}
	
		}
		Weapon w2 = new OurWeapon();
		useWeapon(w2);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
/*
 * YourWeapon은 어차피 Weapon에 있던 기능을 오버라이드 했을 뿐... 새로운 기능을 추가한 것이 아니기 때문에
 * Weapon 타입으로 받아도 그게 그거.. 만약 오버라이드할 때 새 기능 추가했으면 Weapon 타입으로 받으면 새기능 사용
 * 불가하니까 걍 YourWeapon 타입으로 ㄱㄱ
 */
