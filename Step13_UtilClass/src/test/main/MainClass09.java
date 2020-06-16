package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 3명의 회원정보 (번호, 이름, 주소)를 HashMap 객체에 담고
		 * HashMap 객체의 참조값을 ArrayList 객체에 순서대로 담아보세요
		 */
		
		Map<String, Object> m1 = new HashMap<>();
		m1.put("num", 1);
		m1.put("name", "이봉하");
		m1.put("addr", "강남구");
		
		Map<String, Object> m2 = new HashMap<>();
		m2.put("num", 2);
		m2.put("name", "길인아");
		m2.put("addr", "남양주");
		
		Map<String, Object> m3 = new HashMap<>();
		m3.put("num", 3);
		m3.put("name", "심수연");
		m3.put("addr", "청량리");
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		// for문 이용해서 출력하기
		for(Map l : list) {
			System.out.println(
					(int)l.get("num")+" | "
					+(String)l.get("name")+" | "
					+(String)l.get("addr"));
		}
		
		//참조 연습
		List<Map<String, Object>> a = list;
		Map<String, Object> b = list.get(0);
		Object c = list.get(0).get("num");
		Object d = list.get(0).get("name");
		Object e = list.get(0).get("addr");
		int f = (int)list.get(0).get("num");
		String g = (String)list.get(0).get("name");
		String h = (String)list.get(0).get("addr");
		int i = ((String)list.get(0).get("addr")).length();
		
		
	}//main
}
