import javax.servlet.*;
//������ ���� �������̽����� ���ǵ�

import javax.servlet.http.*;
//���� �� http ��û(��������)�� ó���ϴ� �������̽����� ���� ��

import java.io.*;
//�ڹٿ� �ܺΰ��� ����� ��� ���� 


public class TimeServer extends HttpServlet{  // HttpServlet Ŭ������ ���
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		//Ŭ���̾�Ʈ���� ��û�� GET ������� ���۵Ǹ� doGet()
		// POST ������� ���۵Ǿ� ���� doPost()�� �ڵ� ȣ���
		response.setContentType("text/html"); // Ÿ������
		PrintWriter out = response.getWriter();

		out.println(new java.util.Date());
		//�ڹٿ��� ��ü�� + ���� �ǰų� print�� �Ķ���� ������ �����Ǹ�
		//�ش� ��ü�� toString() �޼ҵ尡 �ڵ����� ȣ���.
		
	}
}

