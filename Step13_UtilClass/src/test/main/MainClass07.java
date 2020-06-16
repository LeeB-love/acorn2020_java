package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass07 {
	public static void main(String[] args) {
		
		//default 생성자를 이용해서 객체를 생성한 경우
		MemberDto m1 = new MemberDto();
		m1.setNum(1);
		m1.setName("이봉하");
		m1.setAddr("강남구");
		
		//인자로 필드에 저장할 생성자를 이용해서 객체를 생성한 경우
		MemberDto m2 = new MemberDto(2, "길인아", "별내");
		
		//위에서 생성한 객체의 참조값을 List 객체에 담아보세요.
		List<MemberDto> li = new ArrayList<MemberDto>();
		li.add(m1);
		li.add(m2);
		
		//for문을 이용해서 List 객체에 담긴 MemberDto 객체를 순서대로 참조해서 아래와 같은 형식으로 출력해보세요.
		//1 | 김구라 | 노량진
		for(MemberDto tmp : li) {
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
		}
		List<MemberDto> a = li;
		MemberDto b = li.get(0);
		int c = li.get(0).getNum();
		String d = li.get(0).getName();
		String e = li.get(0).getAddr();
	}
}
