 package DAO;
 
 import java.sql.*;

import static db.JdbcUtil.*;

import vo.Dog;

import java.util.*;
 
 public class DogDAO {
	 private Connection conn;
    
 	private static DogDAO instance = new DogDAO();
    
    public static DogDAO getInstance() {
        return instance;
    }
    
    private DogDAO() {
    }
    
    public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Dog> selectDogList() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dog> dogList = null;
		String sql = "SELECT * FROM dog";
		Dog dog = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				//다음 레코드가 있을때 까지 do ~ 
				do {
					dog = new Dog();
					dog.setContent(rs.getString("content"));
					dog.setCountry(rs.getString("country"));
					dog.setHeight(rs.getInt("height"));
					dog.setWeight(rs.getInt("weight"));
					dog.setId(rs.getInt("id"));
					dog.setImage(rs.getString("image"));
					dog.setKind(rs.getString("kind"));
					dog.setPrice(rs.getInt("price"));
					dog.setReadcount(rs.getInt("readcount"));
					
					dogList.add(dog);
				} while (rs.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}

	public Dog selectDog(int id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE dog SET readcount = readcount + 1" 
				+ " where id = ?";
		Dog dog = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			sql = "SELECT * FROM dog WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dog = new Dog();
				dog.setContent(rs.getString("content"));
				dog.setCountry(rs.getString("country"));
				dog.setHeight(rs.getInt("height"));
				dog.setWeight(rs.getInt("weight"));
				dog.setId(rs.getInt("id"));
				dog.setImage(rs.getString("image"));
				dog.setKind(rs.getString("kind"));
				dog.setPrice(rs.getInt("price"));
				dog.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return dog;
	}

	public Dog selectCartDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		Dog dog = null;
		
		try {
			
			sql = "SELECT * FROM dog WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dog = new Dog();
				dog.setContent(rs.getString("content"));
				dog.setCountry(rs.getString("country"));
				dog.setHeight(rs.getInt("height"));
				dog.setWeight(rs.getInt("weight"));
				dog.setId(rs.getInt("id"));
				dog.setImage(rs.getString("image"));
				dog.setKind(rs.getString("kind"));
				dog.setPrice(rs.getInt("price"));
				dog.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return dog;
	}

	public int insetDog(Dog dog) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO dog VALUES(dog_seq.nextval,?,?,?,?,?,?,?,0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dog.getKind());
			pstmt.setInt(2, dog.getPrice());
			pstmt.setString(3, dog.getImage());
			pstmt.setString(4, dog.getCountry());
			pstmt.setInt(5, dog.getHeight());
			pstmt.setInt(6, dog.getWeight());
			pstmt.setString(7, dog.getContent());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return insertCount;
	}
 }