package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass10 {
	public static void main(String[] args) {
		//키와 밸류로 관리하고 싶으면 HasnMap인터페이스 떠올리기
		Map<String, Object> map1 = new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "봉하");
		map1.put("isMan", false);
		map1.put("phone", "010-2234-5674");
		
		//이름을 참조하려면?
		String name = (String)map1.get("name");
		
		//전화번호를 수정하려면? == 동일한 key 값으로 다시 담는다.
		map1.put("phone", "010-4679-8839");
		
		//"isMan" 이라는 키값이 존재하는지 여부?
		boolean isExist = map1.containsKey("isMan");
		
		//"num" 이라는 키값으로 저장된 값 삭제
		map1.remove("nums");
		
		//전체삭제
		map1.clear();
		
	}
}
