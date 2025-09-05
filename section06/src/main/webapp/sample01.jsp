<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스크립트릿으로 User 클래스 객체 사용하기</h1>
	<%
		User user = new User();
		user.setUserId("홍길동");
		user.setUserName("hong");
		user.setAge(20);
	%>
	<p>유저 아이디: <%=user.getUserId() %><p>
	<p>유저 이름: <%=user.getUserName() %><p>
	<p>유저 나이: <%=user.getAge() %><p>
</body>
</html>