package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.Member;

public class BoardDAO {
	private Connection con;
	private static BoardDAO boardDAO;
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getInstance(){
		if(boardDAO == null){
			//처음 호출 할때는
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public Member selectLoginMember(String id, String passwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
		Member loginMember = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				//인증됨
				loginMember = new Member();
				loginMember.setAddr(rs.getString("addr"));
				loginMember.setId(rs.getString("id"));
				loginMember.setName(rs.getString("name"));
				loginMember.setPassword(rs.getString("passwd"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return loginMember;
	}
}
