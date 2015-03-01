package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.ActionForward;
import VO.BoardVO;

public class BoardDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		// 페이지 확인
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum"); 

		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		// 포워딩
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/deleteForm.jsp");
		
		return forward;
	}

}
