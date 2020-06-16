package test.main;

import java.util.List;
import java.util.ArrayList;

public class MainClass03{
	public static void main(String[] args) {
		//String type을 저장할 ArrayList 객체를 생성하고 참조값을 List 인터페이스 type 지역변수 msgs 에 담기
		List<String> msgs = new ArrayList<String>();  //Generic은 받을 때 가장 중요.
		msgs.add("김구라");
		msgs.add("해골");
		msgs.add("원숭이");
		msgs.add("주뎅이");
		msgs.add("덩어리");
		
		//List 객체에 담긴 문자열을 for 문을 이용해서 순서대로 콘솔창에 출력해보세요.
		for(int i=0; i<msgs.size(); i++) {
			String m = msgs.get(i);
			System.out.println(m);
		}
		//확장 for문
		for(String m : msgs) {
			System.out.println(m);
		}
		
	}
}
