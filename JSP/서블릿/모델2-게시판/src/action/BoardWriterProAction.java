package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardWriteProService;
import VO.ActionForward;
import VO.BoardVO;

public class BoardWriterProAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		// 글쓰기 등록
		
		BoardVO boardVO = new BoardVO();
		boardVO.setContent(request.getParameter("content"));
		boardVO.setEmail(request.getParameter("email"));
		boardVO.setIp(request.getRemoteAddr());
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));
		boardVO.setPasswd(request.getParameter("passwd"));
		boardVO.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		boardVO.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		boardVO.setReadcount(0);
		boardVO.setRef(Integer.parseInt(request.getParameter("ref")));
		boardVO.setReg_date(new Timestamp(System.currentTimeMillis()));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setWriter(request.getParameter("writer"));
		
	    
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		
		boolean isRegistSuccess = boardWriteProService.registBoardVO(boardVO);
		//등록성공여부 체크
		
		ActionForward forward = null;
		if(isRegistSuccess){
			forward = new ActionForward();
			forward.setUrl("boardList.bo"); //글 등록 후 목록보기
			forward.setRedirect(true); // 리다이렉트 방식으로 전환
		}else{
			response.setCharacterEncoding("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
