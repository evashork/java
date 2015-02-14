package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SVC.LoginService;
import VO.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모델2 에서 비지니스 로직은 컨트롤러에서 구현되지 않는다.
		// 컨트롤러는 요청을 받아 제어하하는 역할만 한다.
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		LoginService loginService = new LoginService(); // Model
		
		Member loginMember = loginService.getLoginMember(id,passwd);
		//getLoginMember : 인증이 되면 인증된 사용자의 정보를 member 객체에 담아서 리턴
		//인증 실패하면 null 값 리턴
		
		if(loginMember != null){
			//인증 성공
			
			/*
			 *  서블릿에서 데이터를 공유하는 방법
			 *  1. 초기화 파라미터를 사용하는 방식(프레임워크)
			 *  
			 *  2. 속성을 사용하는 방식
			 *  2-1. 속성을 공유할 때(생성)
			 *  영역객체.setAttribute(String attrName, Object attrValue) (이름,객체)
			 *  2-2. 속성값 사용할 때(얻어오기)
			 *  Object 영역객체.getArribute(String attrName) 
			 *  
			 *  영역객체 
			 *  page - 동일 페이지 내에서만 사용 가능
			 *  request - 모든 페이지에서 사용 가능
			 *  session - 사용자단 하나씩 지정됨, 브라우저를 끌때까지 사용 가능
			 *  application - 브라우저를 껐다 켜도 사용가능, 서버에서 온 오프 할때 까지
			 */
			
			// JSP 포워딩 - 링크 이동 
			request.setAttribute("loginMember", loginMember); // 2-1
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("logingSuccess.jsp"); 
			dispatcher.forward(request, response);
			
		}else{
			//인증 실패
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('인증실패');");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}

}
