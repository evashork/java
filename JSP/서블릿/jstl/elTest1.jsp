<%@page import="vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL ����غ���</title>
</head>
<body>
<%

	//���׸�
	ArrayList<String> al = new ArrayList<String>();
	al.add("aaaa");
	al.add("bbbb");
	al.add("cccc");
	request.setAttribute("al", al);
	
	//�÷���
	HashMap<String,String> hashMap = new HashMap<String,String>();
	hashMap.put("aaa", "aValue");
	hashMap.put("bbb", "bValue");
	hashMap.put("ccc", "cValue");
	request.setAttribute("hashMap", hashMap);
	
	//�迭
	String[] strArray = new String[3];
	strArray[0] = "aaa";
	strArray[1] = "bbb";
	strArray[2] = "ccc";
	request.setAttribute("strArray", strArray);
	
	//VO
	Member member = new Member();
	member.setName("������");
	request.setAttribute("member", member);
%>
	<h2>�迭�̳� List Ÿ��</h2>
	\${requestScope.al[0]} : ${requestScope.al[0]} <br>
	\${requestScope.al.0} : �� �� ����. �迭�� []�θ� ������ �� �ִ�. <br>
	\${requestScope.strArray[0]} : ${requestScope.strArray[0]} <br>
	
	<h2>���̳� VO ��ü�� ���</h2>
	\${requestScope.hashMap.aaa} : ${requestScope.hashMap.aaa } <br>
	\${requestScope.hashMap['aaa']} : ${requestScope.hashMap['aaa'] } <br>
	\${requestScope.member.name} : ${requestScope.member.name } <br>
	\${requestScope.member['name']} : ${requestScope.member['name'] } <br>
	\${member.name} : ${member.name}
	
	<h2>�����</h2>
	\${2 + 3} : ${2 + 3}<br>
	\${2 / 3} : ${2 / 3}<br>
</body>
</html>