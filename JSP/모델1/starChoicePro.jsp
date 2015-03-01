<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
	<%
		String[] starArray = request.getParameterValues("star");
		for(int i=0; i<starArray.length;i++){
	%>
		<td>
			<img src="<%= starArray[i] %>"/>
		</td>
	<%
		}
	%>
		</tr>
	</table>
</body>
</html>