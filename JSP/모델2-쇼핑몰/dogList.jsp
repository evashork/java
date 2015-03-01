<%@page import="vo.Dog"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="DAO.DogDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	ArrayList<Dog> dogList = (ArrayList<Dog>)request.getAttribute("dogList");
	if(dogList == null || dogList.size() == 0){
%>
	<h2>개상품이 존재하지 않습니다.</h2>
<%		
	}else{
%>
	<section id="dogListArea">
		<h2>개상품 목록 <a href="dogRegistForm.jsp">새상품등록</a></h2>
		<table>
			<tr>
				<%
					for(int i=0; i<dogList.size(); i++){
						if(i != 0 && i % 4 == 0){
				%>
					</tr>
					<tr>
				<% 
					}
				%>
					<td>
						<a href="dogDetail.dog?id=<%=dogList.get(i).getId()%>"><img alt="" src="<%=dogList.get(i).getImage()%>" id="productImage"><br>
						<%= dogList.get(i).getKind() %> <br>
						<%= dogList.get(i).getPrice() %>원</a>
					</td>
				<%
					
					}
				 %>
			</tr>
		</table>
	</section>
<%
	}
%>
	<br>
<%
	ArrayList<String> imageList = (ArrayList<String>)request.getAttribute("imageList");
	if(imageList.size() > 0 ){
%>
	<section id = "todayImageArea">
			<table>
			<tr>
				<%
					for(int i=0; i<imageList.size(); i++){
						if(i != 0 && i % 4 == 0){
				%>
					</tr>
					<tr>
				<% 
					}
				%>
					<td>
						<img alt="" src="<%=imageList.get(i)%>" id="todayImage"><br>
					</td>
				<%
					}
				 %>
			</tr>
		</table>
	</section>
<%
	}
%>
</body>
</html>