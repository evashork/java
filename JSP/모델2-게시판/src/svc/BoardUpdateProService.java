package svc;

import java.sql.Connection;

import DAO.BoardDAO;
import VO.BoardVO;
import static db.JdbcUtil.*;
public class BoardUpdateProService {

	public boolean modifyArticle(BoardVO boardVO) throws Exception{
		// TODO Auto-generated method stub
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateArticle(boardVO);		
		
		if(updateCount > 0){
			isModifySuccess = true;
			//트랜젝션 처리
			commit(con); 
		}else{
			rollback(con);
		}
		
		return isModifySuccess;
	}
	
}
