 package DAO;
 
 import java.sql.*;

import static db.JdbcUtil.*;

import javax.sql.*; 
import javax.naming.*;

import VO.BoardVO;

import java.util.*;
 
 public class BoardDAO {
	 private Connection conn;
    
 	private static BoardDAO instance = new BoardDAO();
    
    public static BoardDAO getInstance() {
        return instance;
    }
    
    private BoardDAO() {
    }
    
    public void setConnection(Connection conn) {
		this.conn = conn;
	}
    
    public int insertArticle(BoardVO article) 
    throws Exception {
        PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount = 0;

		int num=article.getNum();
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		int number=0;
        String sql="";

        try {

            pstmt = conn.prepareStatement
            		("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if (rs.next())
			//이전에 작성된 글이 하나라도 있으면
		      number=rs.getInt(1)+1;
		    else
		    //지금 작성한 글이 첫번째 글이면
		      number=1; 
		   
		    if (num!=0)   //답글이면
		    {  
		      sql="update board set re_step=re_step+1 " +
		      		"where ref= ? and re_step> ?";
              pstmt = conn.prepareStatement(sql);
              pstmt.setInt(1, ref);
			  pstmt.setInt(2, re_step);
			  pstmt.executeUpdate();
			  re_step=re_step+1;
			  re_level=re_level+1;
		     }else{ //답글이 아니고 원글일 경우
		  	  ref=number;
			  re_step=0;
			  re_level=0;
		     }	 
            // 쿼리를 작성
            sql = "insert into board" +
           "(num,writer,email,subject,passwd,reg_date,";
            sql+="ref,re_step,re_level,content,ip) " +
            "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getWriter());
            pstmt.setString(2, article.getEmail());
            pstmt.setString(3, article.getSubject());
            pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getReg_date());
            pstmt.setInt(6, ref);
            pstmt.setInt(7, re_step);
            pstmt.setInt(8, re_level);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			
			insertCount = pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			close(rs);
			close(pstmt);
        } return insertCount;
    }
    
	public int selectArticleCount()
    throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int x=0;

        try {
            pstmt = conn.prepareStatement
            		("select count(*) from board");
            rs = pstmt.executeQuery();

            if (rs.next()) {
               x= rs.getInt(1);
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
           close(rs);
           close(pstmt);
        }
		return x;
    }

	public List<BoardVO> selectArticlesList(int start, int end)
    throws Exception {
        ResultSet rs = null;
        List<BoardVO> articleList=null;
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(
"select list2.* from(select rownum r, list1.*  " +
"from(select *  from board order by ref desc, re_step asc)list1) " +
"list2 where r between ? and ?");
            pstmt.setInt(1, start);
			pstmt.setInt(2, start+end-1);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
            	int i = 0;
            	articleList = new ArrayList<BoardVO>(end);
                do{
                  BoardVO article= new BoardVO();
      article.setNum(rs.getInt("num"));
      article.setWriter(rs.getString("writer"));
                  article.setEmail(rs.getString("email"));
                  article.setSubject(rs.getString("subject"));
                  article.setPasswd(rs.getString("passwd"));
         article.setReg_date(rs.getTimestamp("reg_date"));
      article.setReadcount(rs.getInt("readcount"));
                  article.setRef(rs.getInt("ref"));
                  article.setRe_step(rs.getInt("re_step"));
      article.setRe_level(rs.getInt("re_level"));
                  article.setContent(rs.getString("content"));
         article.setIp(rs.getString("ip")); 
      
                  articleList.add(article);
       }while(rs.next());
                i++;
            }
   }
         catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return articleList;
    }

 
	public int updateReadCount(int num) throws Exception{
		PreparedStatement pstmt = null;
		int updateCount = 0;
		try {
			 pstmt = conn.prepareStatement(
		            	"update board set readcount=readcount+1 where num = ?"); //조회수 증가
					pstmt.setInt(1, num);
					updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close(pstmt);
		}
		return updateCount;
	}
	
    public BoardVO selectArticle(int num)
    throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardVO article=null;
        try {
            pstmt = conn.prepareStatement(
            	"select * from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new BoardVO();
                article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
                article.setEmail(rs.getString("email"));
                article.setSubject(rs.getString("subject"));
                article.setPasswd(rs.getString("passwd"));
			    article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
                article.setRef(rs.getInt("ref"));
                article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
                article.setContent(rs.getString("content"));
			    article.setIp(rs.getString("ip"));     
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
          close(rs);
          close(pstmt);
        }
		return article;
    }

    
    public BoardVO selectUpdateArticle(int num)
    throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardVO article=null;
        try {

            pstmt = conn.prepareStatement(
            	"select * from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new BoardVO();
                article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
                article.setEmail(rs.getString("email"));
                article.setSubject(rs.getString("subject"));
                article.setPasswd(rs.getString("passwd"));
			    article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
                article.setRef(rs.getInt("ref"));
                article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
                article.setContent(rs.getString("content"));
			    article.setIp(rs.getString("ip"));     
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
        }
		return article;
    }
    
    
    
    public int updateArticle(BoardVO article)
    throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs= null;

        String dbpasswd="";
        String sql="";
		int updateCount = 0; //수정여부를 판단 
        try {
            
			pstmt = conn.prepareStatement(
            	"select passwd from board where num = ?"); //비밀번호 확인
            pstmt.setInt(1, article.getNum());
            rs = pstmt.executeQuery();
            
			if(rs.next()){
			  dbpasswd= rs.getString("passwd"); 
			  if(dbpasswd.equals(article.getPasswd())){
                sql="update board set writer=?,email=?,subject=?,passwd=?";
			    sql+=",content=? where num=?";
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, article.getWriter());
                pstmt.setString(2, article.getEmail());
                pstmt.setString(3, article.getSubject());
                pstmt.setString(4, article.getPasswd());
                pstmt.setString(5, article.getContent());
			    pstmt.setInt(6, article.getNum());
			    updateCount = pstmt.executeUpdate(); // 적용된 쿼리의 횟수 
			  }
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
        }
		return updateCount;
    }
    
    
    public int deleteArticle(int num, String passwd)
    throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String dbpasswd="";
        int deleteCount = 0;
        try {

            pstmt = conn.prepareStatement(
            	"select passwd from board where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				dbpasswd= rs.getString("passwd"); 
				if(dbpasswd.equals(passwd)){
					pstmt = conn.prepareStatement(
            	      "delete from board where num=?");
                    pstmt.setInt(1, num);
                    deleteCount = pstmt.executeUpdate();
				}
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
        }
		return deleteCount;
    }
 }