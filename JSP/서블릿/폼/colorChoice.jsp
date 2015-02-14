<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>색상 선택</h1>
	<form  action="colorChoice" method="post">
		<select name="color">
			<option>red</option>
			<option>yellow</option>
			<option>blue</option>
			<option>orange</option>
			<option>dark</option>
		</select>
		<br>
		<label for="name">이름</label><input type="text" name="name" id="name"><br>
		<label for="area">메모</label><textarea id="area" name="area" rows="5" cols="10"></textarea><br>
		<label for="man">남자</label><input type="radio" name="gender" value="man" id="man"><br>
		<label for="woman">여자</label><input type="radio" name="gender" value="woman" id="woman"><br>
		<label for="passwrd">비밀번호</label><input type="password" id="passwrd" name="passwrd"><br>
		<input type="submit" value="색상선택">
		<input type="reset" value="리셋">
	</form>
</body>
</html>