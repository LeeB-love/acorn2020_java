package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		
		// 0으로 초기화된 방 3개짜리 int[] 객체를 만들어서 참조값을 지역변수 nums 에 담기
		int[] nums = {0, 0, 0}; // 이거 자체가 new의 역할(객체를 생성하는 역할)을 함
		
		// 나중에 값을 넣기
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		// 0으로 초기화된 방 3개짜리 int[] 객체를 만들어서 참조값을 지역변수 nums 에 담기
		int[] nums2 = new int[3];   //대괄호 안에 방 개수 적어넣기
		nums2[0]=100;
		nums2[1]=200;
		nums2[2]=300;
		//nums2[3]=400;   //java.lang.ArrayIndexOutOfBoundsException: 3  오류(Exception)이 생김
	
		System.out.println("마무리 작업을 하고 app을 종료합니다.");
	}
}
