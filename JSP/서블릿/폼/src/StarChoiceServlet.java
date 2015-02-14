

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StarChoiceServlet
 */
@WebServlet("/starChoice")
public class StarChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] starArray = request.getParameterValues("star");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<body color='black'>");
		out.println("<table align='center'>");
		out.println("<tr>");
		for (int j = 0; j < starArray.length; j++) {
			out.println("<td>");			
			out.println("<img src= '" + starArray[j] + "'/>");			
			out.println("</td>");	
		}
				
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
	}

}
