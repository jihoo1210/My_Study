<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String sessionUserId = (String) session.getAttribute("userId");
    	String sessionUserName = (String) session.getAttribute("userName");
    	int sessionUserAge = (int) session.getAttribute("age"); // int -> Httpsession -> int
    	boolean isLogin = true;
    	if(sessionUserId == null) {
    		isLogin = false;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요? </h1>
	<% if(isLogin) {%>
	<p> <%=sessionUserId %>님 환영합니다 <p>
	<%} else { %>
	<p> 로그인에 실패했습니다 <p>
	<%} %>
</body>
</html>