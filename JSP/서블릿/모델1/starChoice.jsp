<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#starForm{
		width:400px;
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
	<section id="starForm" >
		<h2>좋아하는 아이돌 선택</h2>
		<form action="starChoicePro.jsp" method="post">
			<fieldset class="formfield">
				<label for="i">아이유</label><input type="checkbox" name="star" value="i.jpg" id="i"> 
				<label for="n">ns윤지</label><input type="checkbox" name="star" value="n.jpg" id="n"> 
				<label for="h">혜리</label><input type="checkbox" name="star" value="h.jpg" id="h"> 
				<label for="d">다솜</label><input type="checkbox" name="star" value="d.jpg" id="d"> 
				<input type="submit" value="선택">
			</fieldset>
		</form>
	</section>
</body>
</html>