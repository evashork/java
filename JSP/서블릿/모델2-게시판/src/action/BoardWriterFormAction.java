package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.ActionForward;
import VO.ReplyInfo;

public class BoardWriterFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		
		int num=0,ref=1,re_step=0,re_level=0;
		if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
		}
		
		ReplyInfo replyInfo = new ReplyInfo();
		replyInfo.setNum(num);
		replyInfo.setRe_level(re_level);
		replyInfo.setRe_step(re_step);
		replyInfo.setRef(ref);
		
		request.setAttribute("replyInfo", replyInfo);
		ActionForward forward = new ActionForward();
		forward.setUrl("/board/writeForm.jsp");
		
		return forward;
	}
}
