package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass10 {
	public static void main(String[] args) {
		//만일 MemberDao 객체의 참조값이 필요하다면?
		//MemberDao dao = new MemberDao(); 직접 객체 생성 불가
		//Static 메소드를 이용해서 MemberDao 객체의 참조값을 받아올 수 있다.
		//getInstance는 MemberDao 객체를 한번만 new를 한다. Connection 객체가 무한하지 않기 때문에 insert, update등 sql 쿼리를 수행할 dao를 무한히 만들 수 없다.
		MemberDao dao = MemberDao.getInstance();
		
		MemberDto dto = new MemberDto();
		dto.setName("덩어리");
		dto.setAddr("상도동");
		dao.insert(dto);
		
		MemberDao dao2 = MemberDao.getInstance();
		//수정할 회원의 정보라면
		MemberDto dto2 = new MemberDto(1, "김구라", "독산동");
		dao.update(dto2);
	}
}
