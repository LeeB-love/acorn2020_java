package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass09 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num = 1;
		String name = "이정호";
		String addr = "독산동";
		List<MemberDto> list = new ArrayList<>();
		
		MemberDto dto = new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		update(dto);
		list.add(dto);
		
	}
	//인자로 MemberDto 객체를 전달받아서 DB에 수정작업을 하는 메소드
	public static void update(MemberDto  dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "UPDATE member "
					+ " Set name = ?, addr = ? "
					+ " where num = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
			} catch (Exception e2) {}
		}
		
		
	}
}
