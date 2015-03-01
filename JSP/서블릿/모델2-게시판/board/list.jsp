<%@page import="VO.PageInfo"%>
<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "DAO.BoardDAO" %>
<%@ page import = "VO.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file="/view/color.jsp"%>
<%@ include file="/include/resource.jsp"%>

<%! 
    SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm"); //��¥�� ����ϴ� ���� 1999-09-09 12:12
%>
<%
	List<BoardVO> articleList = (List<BoardVO>)request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int count = pageInfo.getCount();
	int startPage = pageInfo.getStartPage();
	int currentPage = pageInfo.getCurrentPage();
	int endPage = pageInfo.getEndPage();
	int pageCount = pageInfo.getPageCount();
	int number = pageInfo.getNumber();
%>
<html>
<head>
<title>�Խ���</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="<%=bodyback_c%>">
<center><b>�۸��(��ü ��:<%=count%>)</b>
<table width="700">
<tr>
    <td align="right" bgcolor="<%=value_c%>">
    <a href="writeForm.jsp">�۾���</a>
    </td>
</table>

<%
	if (count == 0) {
%>
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    �Խ��ǿ� ����� ���� �����ϴ�.
    </td>
</table>

<%
	} else {
%>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="<%=value_c%>"> 
      <td align="center"  width="50"  >�� ȣ</td> 
      <td align="center"  width="250" >��   ��</td> 
      <td align="center"  width="100" >�ۼ���</td>
      <td align="center"  width="150" >�ۼ���</td> 
      <td align="center"  width="50" >�� ȸ</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
<%
	for (int i = 0 ; i < articleList.size() ; i++) {
          BoardVO article = (BoardVO)articleList.get(i);
%>
   <tr height="30">
    <td align="center"  width="50" > <%=number--%></td>
    <td  width="250" >
	<%
	      int wid=0; 
	      if(article.getRe_level()>0){
	        wid=5*(article.getRe_level());
	%>
	  <img src="<%=image_path%>level.gif" width="<%=wid%>" height="16">
	  <img src="<%=image_path%>re.gif">
	<%}else{%>
	  <img src="<%=image_path%>level.gif" width="<%=wid%>" height="16">
	<%}%>
           
      <a href="boardContent.bo?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
           <%=article.getSubject()%></a> 
          <% if(article.getReadcount()>=20){%>
         <img src="<%=image_path%>hot.gif" border="0"  height="16"><%}%> 
         </td>
    <td align="center"  width="100"> 
       <a href="mailto:<%=article.getEmail()%>">
       <%=article.getWriter()%></a></td>
    <td align="center"  width="150">
    <%= sdf.format(article.getReg_date())%></td>
    <td align="center"  width="50"><%=article.getReadcount()%>
    </td>
    <td align="center" width="100" ><%=article.getIp()%></td>
  </tr>
     <%}%>
</table>
<%}%>

<%
    if (count > 0) {
        if (startPage > 10) {    %>
        <a href="list.jsp?pageNum=<%= startPage - 10 %>">[����]</a>
<%      }
        for (int i = startPage ; i <= endPage ; i++) {  %>
        <a href="list.jsp?pageNum=<%= i %>">[<%= i %>]</a>
<%
        }
        if (endPage < pageCount) {  %>
        <a href="list.jsp?pageNum=<%= startPage + 10 %>">[����]</a>
<%
        }
    }
%>
</center>
</body>
</html>