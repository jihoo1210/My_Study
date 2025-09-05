<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
         </div><!--/.col-md-10-->
       </div><!-- /.row-->  
    </div><!--/.container-->     
</body>
</html>
<script src="<c:url value='/js/script.js'/>"></script>
<script>
  document.addEventListener('DOMContentLoaded', ()=> {
	 let useridInput = document.getElementById("userid"); 
	 const loginidInput = document.getElementById("loginid"); 
	 let rememberCheck = document.getElementById("remembera");
	 const rememberCheck2 = document.getElementById("rememberb");
	 
	 if(useridInput == null) {
		 useridInput = loginidInput;
	 }
	 if(rememberCheck == null){
		 rememberCheck = rememberCheck2;
	 }
	 
	 const cookies = document.cookie.split(";").map(cookie => cookie.trim());
	 const rememberidCookie = cookies.find(cookie => cookie.startsWith("rememberid="));
	 if(rememberidCookie){
		 const userid = rememberidCookie.split("=")[1];
		 if(userid) {
			 useridInput.value= userid;
			 rememberCheck.checked = true;
		 }
	 }
	 
  });
</script>