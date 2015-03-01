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
		
		int pageSize = 10; // 한 페이지당 출력될 글의 갯수
		
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) { // 페이지 번호
	        pageNum = "1";
	    }

	    //페이지 연산
	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1; 
	    //해당페이지의 처음으로 출력되는 레코드 번호 (1-1)*10 + 1  ----> 1번 레코드 
	    
	    int count = 0; //총 글의 갯수를 저장
	    int number=0; //해당 페이지에 처음으로 출력되는 글의 번호

	    //서비스 객체 생성
	    BoardListService boardListService = new BoardListService();
	    
	    List<BoardVO> articleList = null;
	    count = boardListService.getArticleCount();
	    if (count > 0) { //글이 하나라도 있으면 
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
