package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


// DB 관련 작업 모음

public class JdbcUtil {
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			//InitialContext 톰캣(서버) 자체의 context를 가져온다. 
			Context envCtx = (Context)initCtx.lookup("java:comp/env"); 
			//Context.xml 에 정의 된 Resource 컨텍스트에 접근
			
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
			
			con = ds.getConnection();
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con){
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//트렌젝션에 관한 메소드
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
