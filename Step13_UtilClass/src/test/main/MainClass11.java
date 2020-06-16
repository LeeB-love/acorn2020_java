package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<>();
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		
		Scanner scan = new Scanner(System.in);
		
		/*
		 * 검색할 단어를 입력하세요 : house 
		 * house의 뜻은 집입니다.
		 */
		
		System.out.println("검색할 단어를 입력하세요");
		String word = scan.nextLine();
		
		if(dic.get(word)==null) {
			System.out.println("해당 단어는 존재하지 않습니다.");
			return;
		}
		
		System.out.println(word + "의 뜻은 " +dic.get(word)+"입니다.");
		
	}
}
