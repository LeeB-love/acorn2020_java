package test.main;

import java.util.Random;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 2. Random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내어 배열에 저장한다.
		 * 모두 다 저장이 되면 for 문을 이용해서 배열에 저장된 모든 로또 번호를 콘솔창에 순서대로 출력하는 코드를 작성해보세요.
		 */
		Random ran = new Random();
		//로또 번호를 저장할 수 있는 방 6개짜리 배열 객체 생성
		int[] nums = new int[6];
		//반복문 돌면서 로또 번호 6개를 얻어낸다.
		for(int i=0; i<6; i++) {
			int lottoNum = ran.nextInt(45)+1;	
			nums[i] = lottoNum;
		}
//		for(int i=0; i<nums.length; i++) {
//			int tmp = nums[i];
//			System.out.println(tmp);
//		}
		for(int tmp:nums) {
			System.out.println(tmp);
		} //줄인표현 콜론의 우측에는 배열의 참조값, 좌측에는 배열을 담을 지역변수를 써주면 된다.
		
		
	}
}
