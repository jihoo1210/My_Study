<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty sessionScope.searchError}">
	<script>
		alert("${sessionScope.searchError}");
	</script>
</c:if>
<c:if test="${not empty sessionScope.searchResult}">
	<script>
		alert("${sessionScope.searchResult}");
	</script>
</c:if>
		<form id="searchId" class="ms-5" action="<c:url value='/search' />" method="post">
			<h1 class="mt-5">아이디 찾기</h1>
			<div class="form-group">
				<label for="exampleInputEmail1">이메일</label>
				<input type="text" name="useremail" class="form-control mb-4" id="useremail" aria-describedby="emailHelp"
					placeholder="이메일" />
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">전화번호</label>
				<input type="text" name="usertel" class="form-control" id="usertel" placeholder="000-0000-000" />
			</div>
			<button type="submit" class="btn btn-primary my-3">아이디 찾기</button>
		</form>
		<hr />
		<form id="searchPass" class="ms-5" action="<c:url value='/search' />" method="post">
			<h1 class="mt-5">비밀번호 찾기</h1>
			<div class="form-group">
				<label for="exampleInputEmail1">아이디</label>
				<input type="text" name="userid" class="form-control" id="userid" aria-describedby="emailHelp" placeholder="아이디" />
			</div>
			<button type="submit" class="btn btn-primary my-3">비밀번호 찾기</button>
		</form>
		<script>
			$(function () {
				$("#usertel").on("input", function () {
					const input = $(this).val().replace(/[^0-9]/g, '');
					let content = "";
					if (input.length >= 11) {
						content += input.substring(0, 3) + "-";
						content += input.substring(3, 7) + "-";
						content += input.substring(7, 11);
						$(this).val(content);
						return;
					} else if (input.length >= 10) {
						content += input.substring(0, 2) + "-";
						content += input.substring(2, 6) + "-";
						content += input.substring(6, 10);
						$(this).val(content);
						return;
					} else if (input.length >= 6) {
						content += input.substring(0, 2) + "-";
						content += input.substring(2, 6) + "-";
						content += input.substring(6);
						$(this).val(content);
						return;
					} else if (input.length >= 2) {
						content += input.substring(0, 2) + "-";
						content += input.substring(2);
						$(this).val(content);
						return;
					}
				});
			});
		</script>