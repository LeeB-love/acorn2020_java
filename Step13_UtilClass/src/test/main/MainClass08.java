package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * HashMap<key 값의 type, value 값의 type>
		 * HashMap으로 생성해서 Map으로 많이 받는다.
		 * 인덱스로 관리되는게 아닌, key값으로 관리되는 것.
		 * value는 object로 받으니 어떤 값이든 저장될 수 있다. - 여러개 타입을 섞어서 받으려면 어쩔 수 없음
		 * key 값은 90퍼센트 String으로 관리... 가끔 정수로 관리하기도 한다.
		 */
		Map<String, Object> map1 = new HashMap<>();  //Key, Value
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		
		/*
		 * valud의 Generic 클래스가 Object 로 지정되어있기 때문에
		 * 리턴되는 Object type을 원래 type으로 casting 해야한다.
		 */
		
		int num = (int)map1.get("num");
		String name = (String)map1.get("name");
		String addr = (String)map1.get("addr");
		
	}
}

