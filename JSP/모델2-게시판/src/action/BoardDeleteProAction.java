package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import svc.BoardUpdateProService;
import VO.ActionForward;
import VO.BoardVO;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Integer.parseInt(request.getParameter("num")));
		boardVO.setPasswd(request.getParameter("passwd"));
		
		String pageNum = request.getParameter("pageNum");
		
		// 삭제가 성공했는지 확인
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		boolean isDeleteSucess = boardDeleteProService.deleteArticle(boardVO);
		
		// 페이지 이동
		ActionForward foward = null;
		
		if(isDeleteSucess){
			//수정에 성공했다면
			foward = new ActionForward();
			foward.setUrl("boardList.bo?pageNum=" + pageNum);
		}else{
			//실패시
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return foward;
	}

}
