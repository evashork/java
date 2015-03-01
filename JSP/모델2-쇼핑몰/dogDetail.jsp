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
			<h2>����ǰ ������</h2>
		</header>
		<section id="mainContent">
			<aside id="imageArea">
				<img src = "${dog.image}" width="300px" height="300px">
			</aside>
			<section id="productInfo">
				<b>��ǰ�� : </b> ${dog.kind}<br>
				<b>��ǰ���� : </b> ${dog.price} ��<br>
				<b>��ǰ������ : </b> ${dog.country} <br>
				<b>��ս��� : </b> ${dog.height}<br>
				<b>���ü�� : </b> ${dog.weight}<br>
				<b>��ȸ�� : </b> ${dog.readcount}<br>
				<b>��ǰ���� : </b> ${dog.content} <br>
			</section>
		</section>
		<div style="clear:both"></div>
		<section id = "commandList">
			<a href="dogList.dog">���ΰ���ϱ�</a>
			<a href="dogCartAdd.dog?id=${dog.id}">��ٱ��ϴ��</a>
		</section>
	</section>
</body>
</html>