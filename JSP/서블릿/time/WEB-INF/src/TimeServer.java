import javax.servlet.*;
//서블릿에 관한 인터페이스들이 정의됨

import javax.servlet.http.*;
//서블릿 중 http 요청(프로토콜)을 처리하는 인터페이스들이 정의 됨

import java.io.*;
//자바와 외부간에 입출력 기능 제공 


public class TimeServer extends HttpServlet{  // HttpServlet 클래스를 상속
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		//클라이언트에서 요청이 GET 방식으로 전송되면 doGet()
		// POST 방식으로 전송되어 오면 doPost()가 자동 호출됨
		response.setContentType("text/html"); // 타입지정
		PrintWriter out = response.getWriter();

		out.println(new java.util.Date());
		//자바에서 객체가 + 연산 되거나 print의 파라미터 값으로 지정되면
		//해당 객체의 toString() 메소드가 자동으로 호출됨.
		
	}
}

