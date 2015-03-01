package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardContentService;
import VO.ActionForward;
import VO.BoardVO;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardContentService boardContentService = new BoardContentService();
		
		BoardVO boardVO = boardContentService.getBoardVO(num);
		
		request.setAttribute("article", boardVO);
		request.setAttribute("pageNum", pageNum);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/content.jsp");
		return forward;
	}

}
