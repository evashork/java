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
		// ��2 ���� �����Ͻ� ������ ��Ʈ�ѷ����� �������� �ʴ´�.
		// ��Ʈ�ѷ��� ��û�� �޾� �������ϴ� ���Ҹ� �Ѵ�.
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		LoginService loginService = new LoginService(); // Model
		
		Member loginMember = loginService.getLoginMember(id,passwd);
		//getLoginMember : ������ �Ǹ� ������ ������� ������ member ��ü�� ��Ƽ� ����
		//���� �����ϸ� null �� ����
		
		if(loginMember != null){
			//���� ����
			
			/*
			 *  �������� �����͸� �����ϴ� ���
			 *  1. �ʱ�ȭ �Ķ���͸� ����ϴ� ���(�����ӿ�ũ)
			 *  
			 *  2. �Ӽ��� ����ϴ� ���
			 *  2-1. �Ӽ��� ������ ��(����)
			 *  ������ü.setAttribute(String attrName, Object attrValue) (�̸�,��ü)
			 *  2-2. �Ӽ��� ����� ��(������)
			 *  Object ������ü.getArribute(String attrName) 
			 *  
			 *  ������ü 
			 *  page - ���� ������ �������� ��� ����
			 *  request - ��� ���������� ��� ����
			 *  session - ����ڴ� �ϳ��� ������, �������� �������� ��� ����
			 *  application - �������� ���� �ѵ� ��밡��, �������� �� ���� �Ҷ� ����
			 */
			
			// JSP ������ - ��ũ �̵� 
			request.setAttribute("loginMember", loginMember); // 2-1
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("logingSuccess.jsp"); 
			dispatcher.forward(request, response);
			
		}else{
			//���� ����
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('��������');");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}

}
