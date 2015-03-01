<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri = "http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jstl </title>
</head>
<body>
	<h2>수정 전 board 테이블 정보</h2>
	<sql:query var="rs" dataSource="jdbc/jsptest">
		SELECT * FROM board 
	</sql:query>  <!-- var 반환값  -->
	<table border=1>
		<tr>
			<c:forEach var="columnName" items="${rs.columnNames }">
				<th>
					<c:out value="${columnName }"/>
				</th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${rs.rowsByIndex }">
			<tr>
				<c:forEach var="column" items = "${row }">
					<td>
						<c:if test="${column != null }">
							<c:out value="${column }"></c:out>
						</c:if>
						<c:if test="${column == null }">
							<c:out value="${column }"></c:out>
						</c:if>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	
	<h2>수정 후 board 테이블 정보</h2>
	<sql:update dataSource="jdbc/jsptest">
		UPDATE board SET passwd = ? WHERE num = ?
		<sql:param value="${'2222' }"></sql:param>
		<sql:param value="${1}"></sql:param>		
	</sql:update>
	<table border=1>
		<tr>
			<c:forEach var="columnName" items="${rs.columnNames }">
				<th>
					<c:out value="${columnName }"/>
				</th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${rs.rowsByIndex }">
			<tr>
				<c:forEach var="column" items = "${row }">
					<td>
						<c:if test="${column != null }">
							<c:out value="${column }"></c:out>
						</c:if>
						<c:if test="${column == null }">
							<c:out value="${column }"></c:out>
						</c:if>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>