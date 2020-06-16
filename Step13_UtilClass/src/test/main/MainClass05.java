package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Info;

public class MainClass05 {
	public static void main(String[] args) {
		//Info 클래스로 객체를 생성해서 참조값을 i1 이라는 지역변수에 담기
		Info i1 = new Info();
		//필드는 public 으로 선언되어 있기 떄문에 직접 접근해서 대입연산자로 값을 대입할 수 있다.
		i1.num = 1;
		i1.name = "이봉하";
		i1.addr = "강남구";
		
		Info i2 = new Info();
		i2.num = 2;
		i2.name = "해골";
		i2.addr = "행신동";
		
		//위의 Info type 객체의 참조값을 List 객체에 순서대로 담아보세요
		List<Info> li = new ArrayList<>();
		li.add(i1);
		li.add(i2);
		
		//반복문 for를 이용해서 List 객체에 담긴 정보를 아래와 같은 형식으로 출력해보세요.
		for(Info l : li) {
			System.out.println(l.num +" | "+l.name+" | "+l.addr);
		}
	}
}