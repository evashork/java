package svc;

import java.sql.Connection;

import DAO.DogDAO;
import vo.Dog;
import static db.JdbcUtil.*;
public class DogDetailService {

	public Dog getDog(int id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		Dog dog = dogDAO.selectDog(id);
		
		if (dog == null) {
			rollback(con);
		}
		else{
			commit(con);
		}
		
		close(con);
		return dog;
	}

}
