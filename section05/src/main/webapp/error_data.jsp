<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date now = new Date();
		String today = now.toString();
		
		int num = 1 / 0;
	%>
	
	<%= today %>
	
	<%--
	에러 종류
	300 : 권한 에러
	400 : 파일 에러
	500 : 코드 에러
	 --%>
</body>
</html>