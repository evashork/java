package SVC;

import java.sql.Connection;

import DAO.BoardDAO;
import VO.Member;
import static db.JdbcUtil.*;
// static ����Ʈ = Ư�� Ŭ������ ���� �Ǿ� �ִ� static �޼ҵ峪 static ���� ����Ʈ
public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		// Ʈ������ ������ ���⼭ Ŀ�ؼ��� ó���Ѵ�.
		Connection con = getConnection();
		
		//�̱��� DAO�� �ܼ��� ������ �ٷ�� ���̶� �Ӽ��� �ٷ��� �ʴ´�.
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		Member loginMember = boardDAO.selectLoginMember(id,passwd);
		
		close(con);
		return loginMember;
	}
	
}
