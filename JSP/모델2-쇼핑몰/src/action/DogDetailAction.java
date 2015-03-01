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
		
		// �ش� id ��������
		int id = Integer.parseInt(request.getParameter("id"));
		DogDetailService dogDetailService = new DogDetailService();
		
		Dog dog = dogDetailService.getDog(id);
		
		// ���ǰ� ��Ű ����
		Cookie cookie = new Cookie("today"+id, dog.getImage());
		cookie.setMaxAge(24 * 60 * 60); //��Ű �����ð�
		response.addCookie(cookie); // ��ǰ�� �� �� ���� ��Ű�� ���� 
		request.setAttribute("dog", dog);
		ActionForward forward = new ActionForward();
		
		forward.setUrl("dogDetail.jsp");
		return forward;
	}

}
