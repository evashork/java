package svc;

import java.sql.Connection;

import static db.JdbcUtil.*;
import DAO.BoardDAO;
import VO.BoardVO;

public class BoardContentService {

	public BoardVO getBoardVO(int num) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int updateCount = boardDAO.updateReadCount(num);
		if(updateCount > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		BoardVO boardVO = boardDAO.selectArticle(num);
		close(conn);
		return boardVO;
	}

}
