package test.main;

import test.mypac.MemberInfo;

public class MainClass06 {
	public static void main(String[] args) {
;		//default 생성자를 호출해서 MemberInfo 객체 생성
		MemberInfo m1 = new MemberInfo();
		//필드에 값을 각각 대입하기
		m1.num = 1;
		m1.name = "이봉하";
		m1.addr = "강남구";
		
		//int, String, String type을 인자로 전달하는 생성자를 호출해서 MemberInfo 객체 생성
		MemberInfo m2 = new MemberInfo(2, "길인아", "별내");
		
		/*
		 * 생성자 오버로딩 : 생성자가 여러 개 있는 클래스의 객체를 생성할 때 생성자가 오버로딩 되어있다고 한다. 
		 */
	}
}
