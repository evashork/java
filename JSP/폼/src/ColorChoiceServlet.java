

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ColorChoiceServlet
 */
@WebServlet("/colorChoice")
public class ColorChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColorChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color");
		String name = request.getParameter("name");
		String passwrd = request.getParameter("passwrd");
		String memo = request.getParameter("area");
		String gender = request.getParameter("gender");
		PrintWriter out = response.getWriter();
		
		out.println("<body bgcolor='" + color +  "' >");
		out.println("당신이 선택한 색상은 " + color + " 입니다. <br>");
		out.println("당신의 이름은 " + name + " 입니다. <br>");
		out.println("비밀번호는  " + passwrd + " 입니다. <br>");
		out.println("메모는 " + memo + " 입니다. <br>");
		out.println("성별은 " + gender + " 입니다. <br>");
		out.println("</body>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String color = request.getParameter("color");
		PrintWriter out = response.getWriter();
		out.print("당신이 선택한 색상은 " + color + " 입니다.");
	}

}
