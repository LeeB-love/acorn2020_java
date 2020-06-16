package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainClass13 {
	public static void main(String[] args) {
		// 정수를 담을 수 있는 HashSet 객체를 생성해서 참조값을 Set type 지역변수에 담기
		Set<Integer> nums = new HashSet<>();
		
		// 0~9 정수를 for문을 이용해서 담기
		for(int i=0; i<10; i++) {
			nums.add(i);
		}
		
		// Set에 저장된 item의 개수?
		int size = nums.size();
		
		// Set에 저장된 item을 모두 불러오기? = Iterator 반복자 객체 얻어오기 : 순서는 보장할 수 없고 nums 객체 안에 있는 value를 모조리 꺼내서 일렬로 세우기
		Iterator<Integer> it = nums.iterator();
		
		//it.hasNex() 는 커서 다음에 읽어낼 데이터가 있는지 확인해서있으면 true를 리턴하고 없으면 false를 리턴한다.
		while(it.hasNext()) {
			int tmp = it.next();
			System.out.println(tmp);
		}
		
	}
}
