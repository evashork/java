<%--
   %@ : 지지사
   jsp 코드가 java 코드로 변환 될 때 변환하는 정보를 제공하는 부분
 --%>

<%@page contentType="text/html; charset=UTF-8" import="java.util.*"%>



<%--
	%! : 선언부
	맴버 변수를 선언하거나, 맴버 메소드를 선언하는 영역
--%>
<%!
	//자바 주석 : 자바코드로 변환은 되지만 컴파일이 되지 않으므로 클라이언트로 응답되지 않음
	int memberVar = 10;
	public int add(int x, int y){
		return x + y;
	}
%>



<%--
	% : 스크립트릿
	실질적인 jsp 로직이 오는 부분, 로컬 변수 선언
--%>
<%
	int localVar = 9;
	out.println("localVar = " + localVar);
%>



<%--
	%= : 맴버 변수
--%>
<%=memberVar %>