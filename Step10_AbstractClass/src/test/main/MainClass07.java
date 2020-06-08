package test.main;

import test.mypac.Weapon;

public class MainClass07 {
	
	//run 했을 때 실행순서가 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		Weapon w1 = new Weapon() {     //Abstract Class인 Weapon을 new할 때 걍 커서놓고 컨엔터하면 됨
			/*
			 * Weapon 추상 클래스를 상속받은 익명의 local inner class의 생성자를 호출해서 
			 * Weapon type의 참조값 얻어내고 지역변수 w1에 담기
			 * 
			 * Class의 일종 - 이름이 없지만 Weapon 클래스를 상속받은 클래스이다. class ? extends Weapon{}
			 * 즉, new Weapon()은 anonymous local inner class의 생성자 역할을 하는 것이라고 볼 수 있다.
			 */
			
			@Override
			public void attack() {
				System.out.println("아무나 공격해요!");
				
			}
		};
		Weapon w2 = new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("공중 공격을 해요~");
				
			}
		};
		
		
		useWeapon(w1);
		useWeapon(w2);
		//객체를 일회용으로 만드는 것... -> 지역변수 내에서 바로 생성
		useWeapon(new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("미사일 발싸~~");
				
			}
		});
	}
	
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
/*
 * YourWeapon은 어차피 Weapon에 있던 기능을 오버라이드 했을 뿐... 새로운 기능을 추가한 것이 아니기 때문에
 * Weapon 타입으로 받아도 그게 그거
 */
