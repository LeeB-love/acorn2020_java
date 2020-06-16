package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		//정수를 저장할 수 있는 가변 배열 객체 생성
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		//배열의 길이를 리턴하는 메소드
		int size = nums.size();
		
		//배열의 n번방에 저장되어있는 인자를 리턴하는 메소드
		int num1 = nums.get(0);
		Integer num2 = nums.get(1);
		int num3 = nums.get(2);
		
		//n1번방의 인자를 n2로 바꿔주는 메소드
		nums.set(1, 40);
		
		//n번방을 삭제
		nums.remove(1);
		
		//배열 전체 삭제
		nums.clear();
	}
}
