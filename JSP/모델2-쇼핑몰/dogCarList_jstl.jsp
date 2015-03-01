<%@page import="vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#cartListArea,#sumArea{
		width : 400px;
		margin : auto;
		border: 1px solid red;
	}
	h2,header{
		text-align: center
	}
	.tr_top{
		background: skyblue;
	}
	table{
		margin: auto;
	}
	#sumArea{
		text-align : right
	}
	.qtyupdown{
		padding:2px 3px; display:block; margin:2px; background: red; color: #fff; text-decoration: none !important; 
	}
	#deleteCommand{
		float: right;
		margin: 5px;
	}
</style>
<script>
	function checkQty(id,qty){
		if(qty != 1){ // 0일때 는 더 이상 수량을 뺄 수 없기 때문에 
			location.href="dogCartQtyDown.dog?id=" + id;
		}
	}
	
	function allCheck() {
		if(document.forms[0].delete1.length == undefined){ // delete1이 배열로 생성되었는지 확인 
			document.forms[0].delete1.checked = document.forms[0].allDelete.checked;
		}else{
			for(var i = 0;  i < document.forms[0].delete1.length; i++){
				document.forms[0].delete1[i].checked = document.forms[0].allDelete.checked;
			}
		}
	}
</script>
</head>
<body>
	<c:if test="${totalMoney == 0 }">
		<h2>장바구니 항목이 존재하지 않습니다.</h2>
	</c:if>
	<c:if test="${totalMoney != 0 }">
		<section id="cartListArea">
			<form method="post" action="dogCartRemove.dog">
				<header>
					<a href="dogList.dog">쇼핑 계속하기</a>
					<input type="submit" value = "삭제" id= "deleteCommand">
				</header>	
				<table>
					<tr class="tr_top">
						<td><input type="checkbox" name="allDelete" onclick="allCheck()"></td>
						<td>번호</td>
						<td>이미지</td>
						<td>상품명</td>
						<td>수량</td>
						<td>상품가격</td>
					</tr>
					<c:set var="num" value = "${0}"></c:set>
					<c:forEach var="cart" items="${cartList }">
						<c:set var="num" value = "${num + 1}"></c:set>
						<tr>
							<td><input type = "checkbox" name ="delete1" value="${cart.id }"> </td>
							<td>${num }</td>
							<td><img src="${cart.image}" width="20px" heigth="20px"></td>
							<td>${cart.kind }</td>
							<td>${cart.qty }</td>
							<td>${cart.price }</td>
							<td>
								<a href="dogCartQtyUp.dog?id=${cart.id }" class="qtyupdown">+</a>
							</td>
							<td>
								<a href="javascript:checkQty(${cart.id },${cart.qty })" class="qtyupdown">-</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
			<section id="sumArea">
				${totalMoney } 원
			</section>
		</section>
	</c:if>
</body>
</html>