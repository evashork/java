package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import VO.ActionForward;
import VO.BoardVO;
import VO.PageInfo;
import VO.ReplyInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		int pageSize = 10; // �� �������� ��µ� ���� ����
		
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) { // ������ ��ȣ
	        pageNum = "1";
	    }

	    //������ ����
	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1; 
	    //�ش��������� ó������ ��µǴ� ���ڵ� ��ȣ (1-1)*10 + 1  ----> 1�� ���ڵ� 
	    
	    int count = 0; //�� ���� ������ ����
	    int number=0; //�ش� �������� ó������ ��µǴ� ���� ��ȣ

	    //���� ��ü ����
	    BoardListService boardListService = new BoardListService();
	    
	    List<BoardVO> articleList = null;
	    count = boardListService.getArticleCount();
	    if (count > 0) { //���� �ϳ��� ������ 
	        articleList = boardListService.getArticles(startRow, pageSize);
	    }
	    
		number=count-(currentPage-1)*pageSize;
		//134 - (1 - 1) +10 ---> 134
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		
		if (count > 0) {	
	        pageCount = count / pageSize + 
	        		( count % pageSize == 0 ? 0 : 1);
			 
	        startPage = ((currentPage-1)/10)*10+1;
			int pageBlock=10;
	        endPage = startPage + pageBlock-1;
	        if (endPage > pageCount) endPage = pageCount;
		}
		
		request.setAttribute("articleList", articleList);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setNumber(number);
		request.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/list.jsp");
		return forward;
	}

}
