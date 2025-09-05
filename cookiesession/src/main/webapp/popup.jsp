<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	boolean hidePop = true;
	Cookie[] cs = request.getCookies();
	if (cs != null) {
		for(Cookie c : cs) {
			if("hidePopup".equals(c.getName()) && "close".equals(c.getValue())); {
					hidePop = false;
					break;
				}
			}
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.popup {
		border: 2px solid black;
		background-color: beige;
		width: 400px;
		height: 600px;
		position: relative;
		margin: 50px auto;
	}
	.close {
		position: absolute;
		bottom: 0;
		left: 50%;
		transform: translateX(-50%);
		width: 100%;
		height: 100px;
		color: white;
		background: black;
		cursor: pointer;
	}
</style>
<script src="http://code.jquery.com/jquery.min.js"></script>
</head>
<body>
	<% if(hidePop) { %>
	<div class="popup">
		<button class="close">오늘 하루 보이지 않기</button>
	</div>
	<% } %>
	<script>
		console.log('document.cookie :>> ', document.cookie);
		if(document.querySelector(".popup")) {
		document.querySelector(".close").addEventListener("click", function() {
			$.post("api/popup")
			.done(()=>{
				document.querySelector(".popup").style.display = "none"
			})
			.fail( e => {
				console.log(e);
			})
			});
		}
	</script>
</body>
</html>