package SVC;

import java.sql.Connection;

import DAO.BoardDAO;
import VO.Member;
import static db.JdbcUtil.*;
// static 임포트 = 특정 클래스에 정의 되어 있는 static 메소드나 static 변수 임포트
public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		// 트랜젝션 때문에 여기서 커넥션을 처리한다.
		Connection con = getConnection();
		
		//싱글톤 DAO는 단순히 쿼리만 다루는 곳이라서 속성을 다루지 않는다.
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Member loginMember = boardDAO.selectLoginMember(id,passwd);
		
		close(con);
		return loginMember;
	}
	
}
