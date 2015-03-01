<%@page import="vo.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#dogDetailArea{
	width: 500px;
	margin: auto;
	border : 1px solid red;
}
header{
	height : 100px;
	text-align:center;
}
h2{
	
}
#mainContent{
	height: 300px;
}

#imageArea{
	height: 300px; 
	width: 300px;
	float: left;
}

#productInfo{
	height: 300px;
	width: 198px;
	float: left
}

#commandList{
	height: 100px;
	text-align: center;
}
</style>
</head>
<body>
	<section id="dogDetailArea">
		<header>
			<h2>개상품 상세정보</h2>
		</header>
		<section id="mainContent">
			<aside id="imageArea">
				<img src = "${dog.image}" width="300px" height="300px">
			</aside>
			<section id="productInfo">
				<b>상품명 : </b> ${dog.kind}<br>
				<b>상품가격 : </b> ${dog.price} 원<br>
				<b>상품원산지 : </b> ${dog.country} <br>
				<b>평균신장 : </b> ${dog.height}<br>
				<b>평균체중 : </b> ${dog.weight}<br>
				<b>조회수 : </b> ${dog.readcount}<br>
				<b>상품설명 : </b> ${dog.content} <br>
			</section>
		</section>
		<div style="clear:both"></div>
		<section id = "commandList">
			<a href="dogList.dog">쇼핑계속하기</a>
			<a href="dogCartAdd.dog?id=${dog.id}">장바구니담기</a>
		</section>
	</section>
</body>
</html>