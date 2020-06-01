package test.main;

import test.mypac.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		
		MyObject obj1 = new MyObject();  //1. import하고 객체 생성하기
		
		obj1.walk(); // 얘는 void라 리턴값이 없어서 그림자가 다시 안돌아옴
		obj1.getNumber();  // int 10을 주러 돌아온다.
		obj1.getGreeting();  //String type 참조값 49을 돌려주러 온다.
		
		
		//메소드가 리턴해주는 데이터를 지역 변수에 담아보기
		int a = obj1.getNumber();
		String b = obj1.getGreeting();
	}
}
