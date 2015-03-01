package svc;

import java.sql.Connection;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import DAO.DogDAO;
import vo.Dog;

public class DogListService {

	public ArrayList<Dog> getDogList() {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		ArrayList<Dog> dogList = dogDAO.selectDogList();
		
		close(con);
		
		return dogList;
	}

}
