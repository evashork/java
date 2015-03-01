package svc;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import DAO.BoardDAO;
import VO.BoardVO;

public class BoardDeleteProService {

	public boolean deleteArticle(BoardVO boardVO) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int DeleteCount = boardDAO.deleteArticle(boardVO.getNum(), boardVO.getPasswd());		
		
		if(DeleteCount > 0){
			isDeleteSuccess = true;
			//트랜젝션 처리
			commit(con); 
		}else{
			rollback(con);
		}
		
		return isDeleteSuccess;
	}

}
