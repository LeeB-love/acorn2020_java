package test.main;

import java.util.HashSet;
/*
 * 순서도 없고 키값도 없는 하나의 묶음. 몇 개가 있는지는 알 수 있지만, 랜덤으로 섞여있다. 
 * 중복된 데이터는 허용하지 않는다.
 */
import java.util.Set;

import test.mypac.Car;

public class MainClass12 {
	public static void main(String[] args) {
		// 정수값을 저장할 수 있는 HashSet 객체
		// 디버그 돌려보면 index가 있는 것 같아보이지만, index로 관리되는 것은 아니다.
		// 중복을 허용하지 않기 때문에 중복제거할 때 종종 쓰인다.
		
		/*
		 * HashSet 은 Set 인터페이스를 구현한 클래스이다.
		 * 	- 순서가 없다.
		 * 	- key값이 없다.
		 * 	- 중복을 허용하지 않는다.
		 * 	- 어떤 data를 묶음(집합)으로 관리하고자 할 때 사용한다.
		 * 	- Set 타입으로 받아서 사용한다.
		 */
		Set<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		set1.add(40);
		set1.add(50);
		
		//문자열을 저장할 수 있는 HashSet 객체
		Set<String> set2 = new HashSet<>();
		set2.add("Kim");
		set2.add("Lee");
		set2.add("Park");
		set2.add("Lee");
		set2.add("Park");
		
		
		//Car 객체를 저장할 수 있는 HashSet 객체
		Set<Car> set3 = new HashSet<>();
		set3.add(new Car("프라이드"));
		set3.add(new Car("프라이드"));
		set3.add(new Car("소나타"));
		set3.add(new Car("그랜저"));
	}
}
