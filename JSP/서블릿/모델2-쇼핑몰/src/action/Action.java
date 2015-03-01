package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request)
			throws Exception;  // 추상 메서드
}
