<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri = "http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DB 연결</title>
</head>
<body>
<sql:query var="rs" dataSource="jdbc/jsptest">
	SELECT * FROM board 
</sql:query>  <!-- var 반환값  -->
<table border=1>
	<tr>
		<c:forEach var="columName" items="${rs.columnNames }">
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