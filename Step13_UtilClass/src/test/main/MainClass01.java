package test.main;
import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		//String type 을 저장할 수 있는 index로 관리되는 목록(List) 객체
		ArrayList<String> names = new ArrayList<String>(); //담고자하는 데이터 타입을 Generic에 넣어준다. generic의 타입에 따라 arraylist에서 제공하는 메소드의 지역변수 타입이 바뀐다.
		names.add("이봉하");
		names.add("길인아");
		names.add("원숭이");
		//자바에서 주로 사용하는 배열의 형태. ArrayList / add
		//ArrayList는 참조형 데이터만 넣을 수 있다. 정수형 데이터를 저장하고 싶으면 Integer 등 객체형 기본데이터를 사용하면 된다.
		//String type의 참조값 저장하기

		int size = names.size();
		
		//각각의 방에 저장된 값 불러오기 - 메서드를 통해서 참조한다.
		String name1 = names.get(0);  // 0번방
		String name2 = names.get(1);  // 1번방
		String name3 = names.get(2);  // 2번방
		
		//특정 방의 값 수정(덮어쓰기)
		names.set(1, "김춘배");  //1번방 수정
		
		//특정 방의 값 삭제(방 자체를  제고하기)
		names.remove(2); //2번방 삭제
		
		//모든 방 깨끗히 삭제
		names.clear();
		
		
		//add, size, get 을 가장 많이 사용하고, set, remove, clear을 가끔 사용.
		
	}
}
