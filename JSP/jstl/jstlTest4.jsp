<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jstl </title>
</head>
<body>
	<c:forTokens items="������,������,�ƹ���,�׷���,Ƽ��,��Ÿ��" delims="," var = "car">
		�ڵ��� �̸� : <c:out value="${car }"></c:out> <br>
	</c:forTokens>
</body>
</html>