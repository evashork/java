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
		DogDAO dogDAO = DogDAO.getInstance(); //�̱���
		dogDAO.setConnection(conn);
		int insertCount = dogDAO.insetDog(dog);
		
		if (insertCount > 0 ) { // ����� ������
			isRegistSuccess = true;
			commit(conn);
		}else{
			rollback(conn);
		}
		
		return isRegistSuccess;
	}

}
