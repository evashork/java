package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogDetailService;
import vo.ActionForward;
import vo.Dog;

public class DogDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		// 해당 id 가져오기
		int id = Integer.parseInt(request.getParameter("id"));
		DogDetailService dogDetailService = new DogDetailService();
		
		Dog dog = dogDetailService.getDog(id);
		
		// 세션과 쿠키 저장
		Cookie cookie = new Cookie("today"+id, dog.getImage());
		cookie.setMaxAge(24 * 60 * 60); //쿠키 생존시간
		response.addCookie(cookie); // 상품을 볼 때 마다 쿠키를 저장 
		request.setAttribute("dog", dog);
		ActionForward forward = new ActionForward();
		
		forward.setUrl("dogDetail.jsp");
		return forward;
	}

}
