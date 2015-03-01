package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartRemoveService;
import vo.ActionForward;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		String[] deleteIdArray = request.getParameterValues("delete1");
		DogCartRemoveService dogCartRemoveService = 
				new DogCartRemoveService();
		
		dogCartRemoveService.removeCart(deleteIdArray,request);
		ActionForward forward = new ActionForward();
		
		forward.setUrl("dogCartList.dog");
		forward.setRedirect(true);
		
		return forward;
	}

}
