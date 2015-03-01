<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#registFormArea{
	width:500px;
	height: 500px;
	margin:auto;
	border : 1px solid red
}
h2{
	text-align: center;
}
#registTable{
	margin:auto;
}
.td_left{
	width: 200px;
}
.td_right{
	width: 300px;
}
</style>
</head>
<body>
	<section id="registFormArea">
		<h2>새 상품등록</h2>
		<form method="post" action="dogRegist.dog" enctype="multipart/form-data">
			<table id="registTable">
				<tr>
					<td class="td_left">
						<label for="kind">개품종</label>
					</td>
					<td class="td_right">
						<input type="text" name="kind" id="kind">
					</td>
				</tr>
				<tr>
					<td class="td_left">
						<label for="country">원산지</label>
					</td>
					<td class="td_right">
						<input type="text" name="country" id=""country">
					</td>
				</tr>
				<tr>
					<td class="td_left">
						<label for="price">개가격</label>
					</td>
					<td class="td_right">
						<input type="text" name="price" id="price">
					</td>
				</tr>
				<tr>
					<td class="td_left">
						<label for="height">개신장</label>
					</td>
					<td class="td_right">
						<input type="text" name="height" id="height">
					</td>
				</tr>
				<tr>
					<td class="td_left">
						<label for="weight">개체중</label>
					</td>
					<td class="td_right">
						<input type="text" name="weight" id="weight">
					</td>
				</tr>
				<tr>
					<td class="td_left">
						<label for="content">설명</label>
					</td>
					<td class="td_right">
						<textarea id="content" name="content" rows="7" cols="20">
						
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_left">
						<label for="image">이미지</label>
					</td>
					<td class="td_right">
						<input type="file" name="image" id="image">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right; padding-right: 20px">
						<input type="submit" value="상품등록">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>