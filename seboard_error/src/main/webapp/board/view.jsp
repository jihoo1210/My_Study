<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="view mt-5">
        <div class="title"><c:out value="${dto.title }" /></div>
        <div class="d-flex border-bottom">
            <div class="col-md-2"><span>작성자</span></div>
            <div class="col-md-4 py-2">${dto.writer}</div>
            <div class="col-md-2"><span>작성일</span></div>
            <div class="col-md-4 py-2">${dto.createAt}</div>
        </div>
        <div class="d-flex border-bottom">
            <div class="col-md-2"><span>조회수</span></div>
            <div class="col-md-10 py-2">1</div>
        </div>
        <div class="content">
                   ${dto.content}
        </div>
        <div class="d-flex justify-content-end">
            <a href="<c:url value='list' />" class="btn btn-dark me-3">목록</a>
            <a href="updat.jsp" class="btn btn-dark me-3">수정</a>
            <a href="delete.jsp" class="btn btn-dark">삭제</a>
        </div>
    </div>
<%@ include file="../include/footer.jsp" %>