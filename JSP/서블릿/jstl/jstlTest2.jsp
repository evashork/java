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
	<h2>if�� ���</h2>
	<c:set var="country" value="${'Korea' }"></c:set>
	<c:if test="${country != null }">
		������ : <c:out value="${country }"></c:out>	
	</c:if>
	
	<h2>choose ���� ���</h2>
	<c:choose>
		<c:when test="${country == 'Korea' }">
			<c:out value="${country }"></c:out>�� �ܿ��� ��� .
		</c:when>
		<c:when test="${country == 'Cananda' }">
			<c:out value="${country }"></c:out>�� �ܿ��� �ʹ� ��� .
		</c:when>
		<c:otherwise>
			�� ���� ������ �ܿ��� �� �� ����.
		</c:otherwise>
	</c:choose>
</body>
</html>