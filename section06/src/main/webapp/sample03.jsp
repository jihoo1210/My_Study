<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User"%>
    <jsp:useBean id="userBean" class="model.User" scope="page" />
<%
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String userAge = request.getParameter("age");
	
	int age = (userAge != null ? age = Integer.parseInt(userAge) : 0); 
	
	User user = new User();
	user.setUserId(userId);
	user.setUserName(userName);
	user.setAge(age);
%>
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