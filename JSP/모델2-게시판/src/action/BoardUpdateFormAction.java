package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardUpdateFormService;
import VO.ActionForward;
import VO.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		//페이지 정보
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardUpdateFormService boardUpdateFormService
		  = new BoardUpdateFormService();
		
		//글정보 가져오기
		BoardVO article = boardUpdateFormService.getArticle(num);
		//
		request.setAttribute("article", article);
		request.setAttribute("pageNum", pageNum);
		// 포워딩
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/updateForm.jsp");
		
		return forward;
	}

}
