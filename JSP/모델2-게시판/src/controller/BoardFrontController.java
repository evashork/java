package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.ActionForward;
import action.Action;
import action.BoardContentAction;
import action.BoardDeleteFormAction;
import action.BoardDeleteProAction;
import action.BoardListAction;
import action.BoardUpdateFormAction;
import action.BoardUpdateFormProAction;
import action.BoardWriterFormAction;
import action.BoardWriterProAction;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    // doGet doPost 전부 처리
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	
    	//요청 파악
    	String requestURI = request.getRequestURI();
    	// /project/boardWriterForm.bo 가 반환됨
    	
    	String context = request.getContextPath();
    	// /project 가 반환됨
    	
    	String command = requestURI.substring(context.length());
    	// //boardWriterForm.bo 가 반환됨
    	
    	Action action = null;
    	//각 요청을 처리하는 Action 클래스의 규격을 정의한 인터페이스 (다형성)
    	
    	ActionForward forward = null;
    	
    	if (command.equals("/boardWriterForm.bo")) {
			action = new BoardWriterFormAction();
			try {
				forward = action.execute(response, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    	else if (command.equals("/boardWritePro.bo")) {
    		action = new BoardWriterProAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if (command.equals("/boardList.bo")) {
    		action = new BoardListAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if (command.equals("/boardContent.bo")) {
    		action = new BoardContentAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if (command.equals("/boardUpdateForm.bo")) {
    		action = new BoardUpdateFormAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if (command.equals("/boardUpdateFormPro.bo")) {
    		action = new BoardUpdateFormProAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if (command.equals("/boardDeleteForm.bo")) {
    		action = new BoardDeleteFormAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	else if (command.equals("/boardDeletePro.bo")) {
    		action = new BoardDeleteProAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (forward != null) {
			if (forward.isRedirect()) { //isRedirect 방식일때
				response.sendRedirect(forward.getUrl());
			}else{ // isRedirect 아닐 때
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
    	
    	
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
