package svc;

import java.sql.Connection;
import java.util.List;

import static db.JdbcUtil.*;
import DAO.BoardDAO;
import VO.BoardVO;

public class BoardListService {

	public int getArticleCount() throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		
		int articleCount = boardDAO.selectArticleCount();
		
		close(conn);
		return articleCount;
	}

	public List<BoardVO> getArticles(int startRow, int pageSize) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		
		List<BoardVO> articleList = boardDAO.selectArticlesList(startRow, pageSize);
		close(conn);
		return articleList;
	}

}
