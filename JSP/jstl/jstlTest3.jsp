<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>forEach 태그</h2>
	<c:forEach items="${headerValues }" var="head">
		name : <c:out value="${head.key }"></c:out> <br>
		values : 
		<c:forEach items="${head.value }" var="val">
			<c:out value="${val }"></c:out>
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>