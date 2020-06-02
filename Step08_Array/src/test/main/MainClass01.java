package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		//int type 5개를 저장하고 있는 배열
		int[] nums = {10, 20, 30, 40, 50};
		//double type 5개를 저장하고 있는 배열
		double [] nums2 = {10.1, 10.2, 10.3, 10.4, 10.5};
		// boolean type 5개를 저장하고 있는 배열 - 배열안에 기본데이터 타입이 직접 들어가있음.
		boolean [] truth = {true, false, false, true, true};
		
		// String type(참조데이터 type) 5개를 저장하고 있는 배열 - 배열 안에 참조값이 들어있다.
		String[] names = {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		
		// 배열의 각각의 방 참조하기
		int result1 = nums[0];
		double result2 = nums[1];
		boolean result3 = truth[2];
		String result4 = names[3];
		int result5 = nums.length;
		
		//배열 객체의 메소드와 필드 사용해보기
		int[] cloned = nums.clone();
		int sixe = nums.length;
 	}

}

//자바에서 배열은 한번 정해지면 배열에 인자들을 추가를 하거나 제거를 할 수 없다. 그래서 비효율적이고 잘 사용하진 않지만,
//길이가 정해져있는 경우 사용하기도 한다.
