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
		
		// 쿠키 이미지를 담을 배열, 오늘 본 상품
		ArrayList<String> imageList = new ArrayList<String>();
		// 쿠키 가져오기, 쿠키는 여러가지 일 수 있다.
		Cookie[] cookieArray = request.getCookies();
		// 쿠키가 존재할 때 
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){ // string 앞글자를 찾음
					imageList.add(cookieArray[i].getValue());	
				}
			}
		}
		
		request.setAttribute("imageList", imageList);
		//가져와서 request에 공유
		request.setAttribute("dogList", dogList);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogList.jsp");
		
		return forward;
	}

}
