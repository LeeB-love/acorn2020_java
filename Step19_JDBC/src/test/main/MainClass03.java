package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * member 테이블에 추가할 회원의 정보
		 * 1, 김구라, 노량진
		 * 회원의 번호는 시퀀스 객체를 이용해서 넣기
		 * 시퀀스 명 : member_seq
		 * (명령프롬프트로 테이블과 시퀀스를 미리 만들어놓고 프로그래밍 ㄱㄱ)
		 */
		String name = "김구라";
		String addr = "노량진";
		/*
		 * insert, delect, select 등등 다양한 쿼리를 수행하기 위해선
		 * 1.Connection
		 * 2. PreparedStatement 
		 * 두가지 객체가 필요하다.
		 */
		
		Connection conn = null;
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보 @아이피주소:port번호:db이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			 System.out.println("Oracle DB 접속 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt = null;
		try {
			//실행할 sql문
			String sql = "insert into member"
					+" (num, name, addr)"
					+" values(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 값을 바인딩해서 미완성을 sql 문을 완성시킨다.
			//parameterIndex에 칼럼네임 인덱스 값을 넣으면 된다.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			//실제로 수행하기 - executeUpdate 쓰기(return type int- 영향받은 row의 개수 리턴)
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch (Exception e) {}
		}
	}
}
