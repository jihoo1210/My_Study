<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="user" class="model.User" scope="request"/>
    <jsp:setProperty name="user" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디: <%=user.getUserId() %>
	이름: <%=user.getUserName() %>
	나이: <%=user.getAge() %>
</body>
</html>