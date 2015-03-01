<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String realFolder = ""; //파일이 실제로 업로드 될 서버 상의 물리적인 경로
	String saveFolder = "/fileSave"; //파일이 업로드될 폴더명 - 상대경로
	String encType = "UTF-8"; // 인코딩 속성
	int maxSize = 5 * 1024 * 1024; //
	
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	//파라미터 값으로 지정된 상대 경로의 서버 상의 물리적인 경로를 얻어옴.
	
	MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
	
	Enumeration params = multi.getParameterNames();
	
	while(params.hasMoreElements()){ // hasMoreElements 작업할 다음요소가 있을 경우 true
		String name = (String)params.nextElement();
		// nextElement 다음요소 반환
		out.println(name + " = " + multi.getParameter(name) + "<br>");
	}
	
	out.println("--------------------------------------" + "<br>");
	Enumeration files = multi.getFileNames();
	
	while(files.hasMoreElements()){
		String name = (String)files.nextElement();
		
		String filename = multi.getFilesystemName(name);
		String origName = multi.getOriginalFileName(name);
		String type = multi.getContentType(name);
		
		out.println("filename = " + filename + "<br>");
		out.println("origName = " + origName + "<br>");
		out.println("type = " + type + "<br>");
	}
	

%>
</body>
</html>