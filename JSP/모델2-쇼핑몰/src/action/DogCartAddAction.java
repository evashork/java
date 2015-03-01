package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartAddService;
import vo.ActionForward;
import vo.Dog;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		DogCartAddService dogCartAddService = new DogCartAddService();
		
		Dog dog = dogCartAddService.getDog(id);
		dogCartAddService.addCart(request,dog);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setUrl("dogCartList.dog");
		
		return forward;
	}

}
