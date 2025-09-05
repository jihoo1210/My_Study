<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>list</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/4.6.0/remixicon.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Batang&family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <header class="bg-dark text-white py-2">
       <h2 class="text-center">Servlet 게시판</h2>
    </header>
    <div class="container">
        <div class="row">
            <aside class="col-md-3 p-5">
            <c:choose>
               <c:when test="${not empty sessionScope.loginUser}">
                 <div class="logged">
                    <p>${sessionScope.loginUser }님 로그인</p>
                    <a href="<c:url value='/logout' />">로그아웃</a> | 
                    <a href="<c:url value='/member/edit.jsp'/>">내정보수정</a>
                  </div>                 
               </c:when>
               <c:otherwise>
	                <!-- login -->
	                <form action="<c:url value='/login'/>" class="login" id="login" method="post">
	                    <input type="text" name="userid" id="loginid" class="form-control mb-3" placeholder="아이디">
	                    <input type="password" name="userpass" id="loginpass" class="form-control mb-2" placeholder="비밀번호">
	                    <div class="form-check mb-3">
	                       <input class="form-check-input" type="checkbox" name="remember" value="ok" id="remembera">
	                       <label class="form-check-label" for="remembera">
	                          아이디를 기억
	                       </label>
	                    </div> 
	                    <button type="submit" class="btn btn-dark w-100">로그인</button>
	                </form>
	                <a href="<c:url value='/member/search.jsp' />" >아이디/비밀번호 찾기</a>
               </c:otherwise>
            </c:choose>
            
            <div class="text-end mt-2">
             <c:choose>
               <c:when test="${not empty sessionScope.loginUser}">
                  회원탈퇴
               </c:when>
               <c:otherwise>
                <a href="<c:url value='/member/join.jsp' />">회원가입</a></div>
               </c:otherwise>
             </c:choose>   
            </aside>
            <div class="col-md-9">