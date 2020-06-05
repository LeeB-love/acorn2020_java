package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[]  args) {
		//여러분이 직접 클래스를 만들고 객체생성을 해서 아래의 useWeapon() 메소드를 호출해보세요.
		Weapon w1 = new Gun(); //Gun은 Weapon이라는 추상클래스를 상속받아서 오버라이드하고 다시 전달하는 매개체일뿐............
		MainClass02.useWeapon(w1);
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
