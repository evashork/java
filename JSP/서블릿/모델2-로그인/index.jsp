<%@page import="VO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<style>
	#loginForm{
		width:300px;
		height: 200px;
		border: 1px solid orange;
		margin:auto; 
	}
	
	h2{
		text-align: center;
	}
	.formfield{
		text-align: center;
		border: none;
	}
</style>
</head>
<body>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
	if(loginMember == null){
%>
	<a href = "loginForm.jsp">로그인</a>
<%
	} else{
%>
	<h1>로그인 한 사용자 정보</h1>
	아이디 : <%= loginMember.getId() %><br>
	비밀번호 : <%= loginMember.getPassword() %><br>
	이름 : <%= loginMember.getName() %><br>
	주소 : <%= loginMember.getAddr() %><br>
	<a href = "logout">로그아웃</a>
<%
	}
%>
</body>
</html>