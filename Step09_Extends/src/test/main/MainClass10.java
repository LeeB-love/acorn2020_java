package test.main;

import test.human.Blood;

public class MainClass10 {
	public static void main(String[] args) {
		Blood b1 = new Blood("rh+", "O");  // ==> 필드와 생성자를 통해 여러개의 정보를 한 번에 묶어서 관리할 수 있다.(like javascript's object)
		//b1. 을 해도 Blood field는 보이지 않는다. private로 가려놨기 때문에... 
		//getter method로 접근하자. ===> 이런 형태를 정말 많이 쓴다. 필드를 직접 접근할 수 있게 하는건 좀 위험쓰
		System.out.println(b1.getRh());
		System.out.println(b1.getType());
		
		Blood  b2 = new Blood("rh+", "A");
		String result1 = b2.getRh(); //b2의 rh를 불러와서 result1변수에 담기
		String result2 = b2.getType();
		System.out.println(result1);
		System.out.println(result2);
		
	}
}
