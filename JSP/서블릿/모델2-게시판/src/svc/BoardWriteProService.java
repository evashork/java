package svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import DAO.BoardDAO;
import VO.BoardVO;

public class BoardWriteProService {

	public boolean registBoardVO(BoardVO boardVO) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		
		int insertCount = boardDAO.insertArticle(boardVO);
		boolean isRegistSuccess = false;
		
		if(insertCount > 0){
			commit(conn);
			isRegistSuccess = true;
		}else{
			rollback(conn);
		}
		
		close(conn);
		return isRegistSuccess;
	}

}
