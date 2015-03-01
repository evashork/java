package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogListService;
import vo.ActionForward;
import vo.Dog;

public class DogListAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		DogListService dogListService = new DogListService();
		ArrayList<Dog> dogList = dogListService.getDogList();
		
		// ��Ű �̹����� ���� �迭, ���� �� ��ǰ
		ArrayList<String> imageList = new ArrayList<String>();
		// ��Ű ��������, ��Ű�� �������� �� �� �ִ�.
		Cookie[] cookieArray = request.getCookies();
		// ��Ű�� ������ �� 
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){ // string �ձ��ڸ� ã��
					imageList.add(cookieArray[i].getValue());	
				}
			}
		}
		
		request.setAttribute("imageList", imageList);
		//�����ͼ� request�� ����
		request.setAttribute("dogList", dogList);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogList.jsp");
		
		return forward;
	}

}
