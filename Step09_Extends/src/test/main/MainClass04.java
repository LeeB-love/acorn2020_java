package test.main;

import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		SmartPhone p1;  // 지역변수 안만들어짐. SmartPhone type의 지역변수 p1을 만들 준비만 함.
		SmartPhone p2 = null;  //SmartPhone type 빈 지역변수가 만들어짐
		SmartPhone p3 = new SmartPhone(); //SmartPhone 객체가 저장되어있는 SmartPhone type 지역변수 생성
		
		//p1은 아직 만들어지지 않았기 때문에 문법이 성립하지 않는다.
		//p1.call();
		
		//p2는 null이기 때문에 실행 안됨. 문법상으론 맞다고 해도 run time에서 NullPointerException이 뜸
		p2.call();
		
		//p3에는 참조값이 들어있으므로 정상적으로 사용 가능
	}
}
