<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ include file="../include/header.jsp" %>

<c:if test="${not empty sessionScope.loginUser }">
   <c:redirect url="/index.jsp" />
</c:if>
 
<div class="errorbox">
   <c:if test="${not empty requestScope.loginError }">
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
         <strong>${requestScope.loginError }</strong> 
         <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
   </c:if>
</div>

<form name="loginform" class="loginform" action="<c:url value='/login' />" method="post">
   <div class="mb-4 d-flex">
      <label class='col-3'>
         아이디
      </label>
      <div class="col-9">
         <input type="text" name="userid" class="form-control" id="userid" placeholder="아이디" />
      </div>
   </div>
   <div class="mb-4 d-flex">
      <label class='col-3'>
         비밀번호
      </label>
      <div class="col-9">
         <input type="password" name="userpass" class="form-control" id="userpass" placeholder="비밀번호" />
         
      </div>
   </div>
   <div class="form-check mb-3">
        <input class="form-check-input" type="checkbox" name="remember" value="ok" id="rememberb">
        <label class="form-check-label" for="rememberb">
               아이디를 기억
        </label>
   </div> 
   <button type="submit" class="btn btn-dark w-100">로그인</button>
</form>
<%@ include file="../include/footer.jsp" %>
