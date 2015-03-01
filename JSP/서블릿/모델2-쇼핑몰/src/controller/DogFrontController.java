package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import action.Action;
import action.DogCartAddAction;
import action.DogCartListAction;
import action.DogCartQtyDownAction;
import action.DogCartQtyUpAction;
import action.DogCartRemoveAction;
import action.DogDetailAction;
import action.DogListAction;
import action.DogRegistAction;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.dog")
public class DogFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DogFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    // doGet doPost ���� ó��
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	
    	//��û �ľ�
    	String requestURI = request.getRequestURI();
    	// /project/boardWriterForm.bo �� ��ȯ��
    	
    	String context = request.getContextPath();
    	// /project �� ��ȯ��
    	
    	String command = requestURI.substring(context.length());
    	// //boardWriterForm.bo �� ��ȯ��
    	
    	Action action = null;
    	//�� ��û�� ó���ϴ� Action Ŭ������ �԰��� ������ �������̽� (������)
    	
    	ActionForward forward = null;
    	
    	if (command.equals("/dogList.dog")) {
			action = new DogListAction();
			try {
				forward = action.execute(response, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    	if (command.equals("/dogDetail.dog")) {
    		action = new DogDetailAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/dogCartAdd.dog")) {
    		action = new DogCartAddAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/dogCartList.dog")) {
    		action = new DogCartListAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/dogCartQtyUp.dog")) {
    		action = new DogCartQtyUpAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/dogCartQtyDown.dog")) {
    		action = new DogCartQtyDownAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/dogCartRemove.dog")) {
    		action = new DogCartRemoveAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (command.equals("/dogRegist.dog")) {
    		action = new DogRegistAction();
    		try {
    			forward = action.execute(response, request);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (forward != null) {
			if (forward.isRedirect()) { //isRedirect ����϶�
				response.sendRedirect(forward.getUrl());
			}else{ // isRedirect �ƴ� ��
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
