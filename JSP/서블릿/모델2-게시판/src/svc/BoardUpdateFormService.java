package svc;

import java.sql.Connection;

import DAO.BoardDAO;
import VO.BoardVO;
import static db.JdbcUtil.*;

public class BoardUpdateFormService {

	public BoardVO getArticle(int num) throws Exception{
		// TODO Auto-generated method stub
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		Connection con = getConnection();
		boardDAO.setConnection(con);
		
		BoardVO article = boardDAO.selectUpdateArticle(num);
		
		return article;
	}
	
}
