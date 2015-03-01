<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp 변수 종류</title>
</head>
<body>
<%
	String str = " java " + str2;
%>
<%!
	String str2 = "Fighting";
	//선언부에서 선언하는 변수는 페이지 전체에서 인식이 되므로 변수 사용한 부분 뒤에 선언해도 인식된다.
%>
</body>
</html>