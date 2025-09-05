<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Bean에 값 입력 및 출력 -->
	<!--  name="id" property="key" value="value" -->
	<jsp:setProperty name="user"  property="userId" 	value="james"/>
	<jsp:setProperty name="user" property="userName" 	value="hong"/>
	<jsp:setProperty name="user" property="age" 	value="40"/>
	<!-- 입력 -->
	<!--  name="id" property="key" -->
	<p> 아이디: <jsp:getProperty name="user" property="userId"/></p>	
	<p> 이름: <jsp:getProperty name="user" property="userName"/></p>	
	<p> 나이: <jsp:getProperty name="user" property="age"/></p>	
	<!-- 출력 -->
</body>
</html>