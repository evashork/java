<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jstl</title>
</head>
<body>
	<h2> 변수값 설정 </h2>
	<c:set var = "browser" value="${header['User-Agent']}"></c:set>
	<c:out value="${browser}"></c:out>
	
	<h2> 변수값 제거 </h2> 
	<c:remove var="browser"/>
	<c:out value="${browser}"></c:out>
</body>
</html>