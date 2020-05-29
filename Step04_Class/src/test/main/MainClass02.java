package test.main;

import test.mypac.MyUtil;

public class MainClass02 {
	public static void main(String[] args) {
		//MyUtil 클래스의 static 메소드 호출하기
		MyUtil.send();      //static이 붙은 클래스는 new를 붙이지 않아도 메소드를 사용할 수 있다. -> 참조값이 필요없다.
		//MyUtil 클래스의 static 필드에 값 대입하기
		MyUtil.version = "1.0";
	// static 은 객체 생성과 상관 ㄴㄴ 객체를 만들지 않고 클래스를 호출한다.
	}
}
