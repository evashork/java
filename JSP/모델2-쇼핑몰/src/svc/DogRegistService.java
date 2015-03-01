package svc;

import java.sql.Connection;

import DAO.DogDAO;
import vo.Dog;
import static db.JdbcUtil.*;

public class DogRegistService {

	public boolean registDog(Dog dog) {
		// TODO Auto-generated method stub
		boolean isRegistSuccess = false;
		Connection conn = getConnection();
		DogDAO dogDAO = DogDAO.getInstance(); //싱글톤
		dogDAO.setConnection(conn);
		int insertCount = dogDAO.insetDog(dog);
		
		if (insertCount > 0 ) { // 등록이 성공시
			isRegistSuccess = true;
			commit(conn);
		}else{
			rollback(conn);
		}
		
		return isRegistSuccess;
	}

}
