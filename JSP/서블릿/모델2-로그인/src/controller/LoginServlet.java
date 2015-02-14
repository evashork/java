/*
 *   1.doPost
 *   로그인페이지에서 전송되어 넘어옴 
 *   
 *   2.doGet
 *   로그인이 되어있으면 넘어가고 로그인 쿠키가 없을 경우 로그인 페이지로 다시 보낸다
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    
    // 2.로그인을 거치지 않고 로그인 결과 페이지로 왔을 때
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// 클라이언트에서 전달 된 쿠키 객체 얻어오기
    	Cookie[] cookieArray = request.getCookies();
    	String id = "";
    	String passwd = "";
    	
    	if (cookieArray != null) {
			//클라이언트에서 전송 된 쿠키가 하나라도 있으면 null이 아님
    		//cookieName=cookieValue; 쿠키의 형태
    		for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().equals("id")){ // .getName()쿠키이름을 반환 cookieName
					id = cookieArray[i].getValue();
				}
				else if(cookieArray[i].getName().equals("passwd")){ // .getName()쿠키이름을 반환 cookieName
					passwd = cookieArray[i].getValue();
				}
			}
		}
    	
    	/* 
    	 * 인증 성공 처리는 doPost와 같다 
    	 */
    	
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
			
			// 디스패치 방식 
			// 주소 표시줄의 주소가 변경이 되지 않는다.
			// 요청 변경이 없다. logingSuccess.jsp
			request.setAttribute("loginMember", loginMember); // 2-1
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("logingSuccess.jsp"); 
			dispatcher.forward(request, response);
			
		}else{
			
			// 리다이렉트 방식
			// 주소 표시줄의 주소가 변경되는 포워딩 방식
			// 완전히 다른 요청을 하는 것
			response.sendRedirect("loginForm.jsp");
		}
    }
    
    // 1. 로그인페이지를 거쳤을 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모델2 에서 비지니스 로직은 컨트롤러에서 구현되지 않는다.
		// 컨트롤러는 요청을 받아 제어하하는 역할만 한다.
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// 쿠기 사용 여부 처리
		String useCookie = request.getParameter("useCookie");
		//체크박스에 value 속성을 설정하지 않았을 때 
		//체크박스를 체크하지 않으면 null 값이 전송되고 
		//체크박스를 체크하면 on 이 전송됨.
		
		if(useCookie != null){
			Cookie idCookie = new Cookie("id",id);
			//쿠키객체를 처음 생성하면 생존기간이 -1로 지정된다.
			//브라우저가 실행될 때는 쿠키가 존재하지만 브라우저 종료하면 소멸됨.
			
			idCookie.setMaxAge(60 * 60 * 24); //단위 : 초
			response.addCookie(idCookie);
			
			Cookie passwdCookie = new Cookie("passwd",passwd);
			passwdCookie.setMaxAge(60 * 60 * 24);
			response.addCookie(passwdCookie);
		}
		
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
