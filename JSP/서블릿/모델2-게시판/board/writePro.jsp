<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "DAO.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>

<%
	request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="article" scope="request" class="VO.BoardVO">
   <jsp:setProperty name="article" property="*"/>
</jsp:useBean>
 
<%
 	article.setReg_date(new Timestamp(System.currentTimeMillis()) );
  	article.setIp(request.getRemoteAddr());

  		BoardDAO dbPro = BoardDAO.getInstance();
      dbPro.insertArticle(article);

      response.sendRedirect("list.jsp");
 %>
