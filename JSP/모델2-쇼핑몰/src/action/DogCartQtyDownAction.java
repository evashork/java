package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartQtyDownservice;
import vo.ActionForward;

public class DogCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		DogCartQtyDownservice dogCartQtyDownservice = 
				new DogCartQtyDownservice();
		
		dogCartQtyDownservice.downQty(id,request);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogCartList.dog");
		forward.setRedirect(true);
		
		return forward;
		
	}

}
