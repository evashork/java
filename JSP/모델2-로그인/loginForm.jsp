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
	<section id="loginForm" >
		<h2>로그인</h2>
		<form action="login" method="post">
			<fieldset class="formfield">
				<label for="id">아이디</label><input type="text" name="id" id="id"><br> 
				<label for="passwd">패스워드</label><input type="password" name="passwd" id="passwd"><br> 	
						
				<label for="useCookie">쿠키사용</label><input type="checkbox" name="useCookie" id="useCookie"><br> 							
				<input type="submit" value="로그인">
			</fieldset>
		</form>
	</section>
</body>
</html>