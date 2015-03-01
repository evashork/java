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
	<h2>if문 사용</h2>
	<c:set var="country" value="${'Korea' }"></c:set>
	<c:if test="${country != null }">
		국가명 : <c:out value="${country }"></c:out>	
	</c:if>
	
	<h2>choose 문장 사용</h2>
	<c:choose>
		<c:when test="${country == 'Korea' }">
			<c:out value="${country }"></c:out>의 겨울은 춥다 .
		</c:when>
		<c:when test="${country == 'Cananda' }">
			<c:out value="${country }"></c:out>의 겨울은 너무 춥다 .
		</c:when>
		<c:otherwise>
			그 외의 나라의 겨울은 알 수 없다.
		</c:otherwise>
	</c:choose>
</body>
</html>