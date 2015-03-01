<%@page import="vo.Dog"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="DAO.DogDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#dogListArea,#todayImageArea{
		width: 620px;
		margin: auto;
		border: 1px solid red;
	}
	
	h2{
		text-align: center;
	}
	table{
		margin: auto;
		
	}
	#productImage{
		width: 150px;
		height: 150px;
		border: none;
	}
	
	#todayImage{
		width: 50px;
		height: 50px;
		border: none;
	}
</style>
</head>
<body>
<c:if test="${empty dogList }">
	<h2>개상품이 존재하지 않습니다.</h2>
</c:if>
<c:if test="${not empty dogList }">
	<section id="dogListArea">
		<h2>개상품 목록 <a href="dogRegistForm.jsp">새상품등록</a></h2>
		<table>
			<tr>
				<c:forEach var="dog" items="${dogList }" varStatus="status">
					<c:if test="${status.index % 4 == 0 }">
						</tr>
						<tr>
					</c:if>
					<td>
						<a href="dogDetail.dog?id=${dog.id }"><img alt="" src="${dog.image }" id="productImage"><br>
						${dog.kind}<br>
						${dog.price}원</a>
					</td>
				</c:forEach>
			</tr>
		</table>
	</section>
</c:if>
	<br>
<c:if test="${not empty imageList }">
	<section id = "todayImageArea">
			<table>
			<tr>
				<c:forEach var="image" items="${imageList }" varStatus="status">
					<c:if test="${status.index % 4 == 0 }">
					</tr>
					<tr>
				</c:if>
					<td>
						<img alt="" src="${image }" id="todayImage"><br>
					</td>
				</c:forEach>
			</tr>
		</table>
	</section>
</c:if>
</body>
</html>