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
	<c:forTokens items="베르나,포르쉐,아반테,그랜저,티코,싼타페" delims="," var = "car">
		자동차 이름 : <c:out value="${car }"></c:out> <br>
	</c:forTokens>
</body>
</html>