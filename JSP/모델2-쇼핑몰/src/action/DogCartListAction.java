package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DogCartListService;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		DogCartListService dogCartListService = new DogCartListService();
		
		ArrayList<Cart> cartList = dogCartListService.getDogCartList(request);
		//장바구니 총합 구하기
		int totalMoney = 0;
		
		for (int i = 0; i < cartList.size(); i++) {
			totalMoney += cartList.get(i).getPrice() * cartList.get(i).getQty();
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogCarList.jsp");
		return forward;
	}

}
