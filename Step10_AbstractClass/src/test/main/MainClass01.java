
/*
 *  [ 추상클래스 (Abstract Class) ]
 *  
 *  - class 예약어 앞에 abstract 를 명시해서 클래스를 정의한다.
 *  - 형태만 정의되고 실제 구현은 되지 않은 메소드가 존재할수 
 *    있다.
 *  - 형태만 정의된 메소드를 만들때는 abstract 예약어를 
 *    붙어서 메소드를 정의한다.
 *  - 생성자는 존재하지만 단독으로 객체 생성은 불가하다
 *  - 추상클래스 Type 의 id 가 필요하다면 추상클래스를 상속받은 
 *    자식클래스를 정의해서 객체 생성한다.
 *  - 추상클래스를 상속받은 자식클래스는 부모의 추상메소드를 
 *    모두 오버라이드(재정의) 해야한다. 
 */

package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		Weapon w1 = new MyWeapon();
		w1.prepare();
		w1.attack();
		//오류 안남... 추상클래스도 데이터 타입의 일종.
		
		Weapon w2 = new Weapon() {
			
			@Override
			public void attack() {
				// TODO Auto-generated method stub 이건... 뭐지............;;
				
			}
		};
	}
}
/*
 * Abstract class인 Weapon은 일반적인 방법으로는 객체생성이 되지 않는다. (attack method가 정의되지 않았기 때문에)
 * Weapon을 상속하여 자식클래스를 생성하고 attack method를 Override를 한다.
 * (미완성된 부모객체의 메소드를 자식객체에서 완성하고 메소드 불러내기) - 추상클래스, 추상메소드의 경우 무조건 강제로
 * override된다.
 * 추상클래스의 참조값을 얻어내려면 '자 식 클 래 스' 가 필요하다.
 * 추상클래스는 누군가 만들어놓은 것을 import 해서 사용함. 프로그램의 자유도를 높이려고? 빈칸으로 만들어놓기
 * 떡은 내가 만들어놓을테니 넌 니가 먹기 좋게 썰기만해~
 */
