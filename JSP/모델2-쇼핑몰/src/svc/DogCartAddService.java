package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.DogDAO;
import vo.Cart;
import vo.Dog;

public class DogCartAddService {

	public Dog getDog(int id) {
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		Dog dog = dogDAO.selectCartDog(id);
		close(con);
		return dog;
	}

	public void addCart(HttpServletRequest request, Dog dog) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null){
			// 첫번째 장바구니 요청시 
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);	
		}
		
		boolean isNewCart = true; // 새상품인가 아닌가
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getId() == dog.getId()) {
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty() + 1);
			}
		}
		
		Cart cart = null;
		if(isNewCart){ //새상품일 경우
			cart = new Cart();
			cart.setImage(dog.getImage());
			cart.setKind(dog.getKind());
			cart.setId(dog.getId());
			cart.setQty(1);
			cart.setPrice(dog.getPrice());
			
			cartList.add(cart);
		}
	}

}
