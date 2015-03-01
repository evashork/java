<%@page import="vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL 사용해보기</title>
</head>
<body>
<%

	//제네릭
	ArrayList<String> al = new ArrayList<String>();
	al.add("aaaa");
	al.add("bbbb");
	al.add("cccc");
	request.setAttribute("al", al);
	
	//컬랙션
	HashMap<String,String> hashMap = new HashMap<String,String>();
	hashMap.put("aaa", "aValue");
	hashMap.put("bbb", "bValue");
	hashMap.put("ccc", "cValue");
	request.setAttribute("hashMap", hashMap);
	
	//배열
	String[] strArray = new String[3];
	strArray[0] = "aaa";
	strArray[1] = "bbb";
	strArray[2] = "ccc";
	request.setAttribute("strArray", strArray);
	
	//VO
	Member member = new Member();
	member.setName("오정원");
	request.setAttribute("member", member);
%>
	<h2>배열이나 List 타입</h2>
	\${requestScope.al[0]} : ${requestScope.al[0]} <br>
	\${requestScope.al.0} : 쓸 수 없다. 배열은 []로만 접근할 수 있다. <br>
	\${requestScope.strArray[0]} : ${requestScope.strArray[0]} <br>
	
	<h2>맵이나 VO 객체인 경우</h2>
	\${requestScope.hashMap.aaa} : ${requestScope.hashMap.aaa } <br>
	\${requestScope.hashMap['aaa']} : ${requestScope.hashMap['aaa'] } <br>
	\${requestScope.member.name} : ${requestScope.member.name } <br>
	\${requestScope.member['name']} : ${requestScope.member['name'] } <br>
	\${member.name} : ${member.name}
	
	<h2>연산식</h2>
	\${2 + 3} : ${2 + 3}<br>
	\${2 / 3} : ${2 / 3}<br>
</body>
</html>