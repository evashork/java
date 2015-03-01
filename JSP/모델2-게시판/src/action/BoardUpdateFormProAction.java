package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardUpdateProService;
import VO.ActionForward;
import VO.BoardVO;

public class BoardUpdateFormProAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		BoardVO boardVO = new BoardVO();
		boardVO.setContent(request.getParameter("content"));
		boardVO.setEmail(request.getParameter("email"));
		boardVO.setIp(request.getRemoteAddr());
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));
		boardVO.setPasswd(request.getParameter("passwd"));
		boardVO.setReg_date(new Timestamp(System.currentTimeMillis()));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setWriter(request.getParameter("writer"));
		
		String pageNum = request.getParameter("pageNum");
		
		// 수정이 성공했는지 확인
		BoardUpdateProService boardUpdateProService = new BoardUpdateProService();
		boolean isModifySucess = boardUpdateProService.modifyArticle(boardVO);
		
		// 페이지 이동
		ActionForward foward = null;
		
		if(isModifySucess){
			//수정에 성공했다면
			foward = new ActionForward();
			foward.setUrl("boardList.bo?pageNum=" + pageNum);
		}else{
			//실패시
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return foward;
	}

}
