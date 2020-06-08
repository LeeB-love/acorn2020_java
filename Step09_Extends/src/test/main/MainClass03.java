package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass03 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 HandPhone type 지역변수 p1에 담기
		HandPhone p1 = new HandPhone();
		
		//인터넷을 해야한다. 즉, SmartPhone type 객체가 필요하다. p1안에 있는 값을 이용해서 인터넷을 할 수 있을까?
		SmartPhone p2 = (SmartPhone)p1; //실행 시 ClassCastException 발생
		p2.doInternet(); //그냥 핸드폰인데 설명만 스마트폰으로 바꿨다고 그게 핸드폰이 되겠느냐구~
		
	}
}
