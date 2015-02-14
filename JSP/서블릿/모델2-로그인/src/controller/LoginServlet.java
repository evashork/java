/*
 *   1.doPost
 *   �α������������� ���۵Ǿ� �Ѿ�� 
 *   
 *   2.doGet
 *   �α����� �Ǿ������� �Ѿ�� �α��� ��Ű�� ���� ��� �α��� �������� �ٽ� ������
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
    
    // 2.�α����� ��ġ�� �ʰ� �α��� ��� �������� ���� ��
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// Ŭ���̾�Ʈ���� ���� �� ��Ű ��ü ������
    	Cookie[] cookieArray = request.getCookies();
    	String id = "";
    	String passwd = "";
    	
    	if (cookieArray != null) {
			//Ŭ���̾�Ʈ���� ���� �� ��Ű�� �ϳ��� ������ null�� �ƴ�
    		//cookieName=cookieValue; ��Ű�� ����
    		for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().equals("id")){ // .getName()��Ű�̸��� ��ȯ cookieName
					id = cookieArray[i].getValue();
				}
				else if(cookieArray[i].getName().equals("passwd")){ // .getName()��Ű�̸��� ��ȯ cookieName
					passwd = cookieArray[i].getValue();
				}
			}
		}
    	
    	/* 
    	 * ���� ���� ó���� doPost�� ���� 
    	 */
    	
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
			
			// ����ġ ��� 
			// �ּ� ǥ������ �ּҰ� ������ ���� �ʴ´�.
			// ��û ������ ����. logingSuccess.jsp
			request.setAttribute("loginMember", loginMember); // 2-1
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("logingSuccess.jsp"); 
			dispatcher.forward(request, response);
			
		}else{
			
			// �����̷�Ʈ ���
			// �ּ� ǥ������ �ּҰ� ����Ǵ� ������ ���
			// ������ �ٸ� ��û�� �ϴ� ��
			response.sendRedirect("loginForm.jsp");
		}
    }
    
    // 1. �α����������� ������ ��
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��2 ���� �����Ͻ� ������ ��Ʈ�ѷ����� �������� �ʴ´�.
		// ��Ʈ�ѷ��� ��û�� �޾� �������ϴ� ���Ҹ� �Ѵ�.
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// ��� ��� ���� ó��
		String useCookie = request.getParameter("useCookie");
		//üũ�ڽ��� value �Ӽ��� �������� �ʾ��� �� 
		//üũ�ڽ��� üũ���� ������ null ���� ���۵ǰ� 
		//üũ�ڽ��� üũ�ϸ� on �� ���۵�.
		
		if(useCookie != null){
			Cookie idCookie = new Cookie("id",id);
			//��Ű��ü�� ó�� �����ϸ� �����Ⱓ�� -1�� �����ȴ�.
			//�������� ����� ���� ��Ű�� ���������� ������ �����ϸ� �Ҹ��.
			
			idCookie.setMaxAge(60 * 60 * 24); //���� : ��
			response.addCookie(idCookie);
			
			Cookie passwdCookie = new Cookie("passwd",passwd);
			passwdCookie.setMaxAge(60 * 60 * 24);
			response.addCookie(passwdCookie);
		}
		
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
