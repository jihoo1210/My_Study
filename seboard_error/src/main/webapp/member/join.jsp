<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ include file="../include/header.jsp" %>

<!-- 로그인 확인 영역 -->
<c:if test="${not empty sessionScope.loginUser }">
   <c:redirect url="/index.jsp" />
</c:if>
    <div class="mt-5">
       <h2 class="text-center fw-bold">회원가입</h2> 
       <div class="text-danger mb-3 text-center">*표는 필수 입니다.</div>
       <form id="joinForm" name="joinForm" action="<c:url value='/join' />" method="post">
       <ul class="list-group list-group-flush mb-4">
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">아이디</label>
              <div class="col-3">
                 <input type="text" 
                        name="userid" 
                        id="userid" 
                        class="form-control"
                        placeholder="아이디">                   
              </div>
              <div class="col-5 ps-2"><span class="text-danger">*</span>
                 <span class="hidden-error text-danger" id="error"></span>
              </div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">비밀번호</label>
              <div class="col-3">
                 <input type="password" 
                        name="userpass" 
                        id="userpass" 
                        class="form-control"
                        placeholder="비밀번호">
              </div>
              <div class="col-1 ps-2"><span class="text-danger">*</span></div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">비밀번호확인</label>
              <div class="col-3">
                 <input type="password" 
                        name="reuserpass" 
                        id="reuserpass" 
                        class="form-control"
                        placeholder="비밀번호 확인">
              </div>
              <div class="col-1 ps-2"><span class="text-danger">*</span></div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">이름</label>
              <div class="col-3">
                 <input type="text" 
                        name="username" 
                        id="username" 
                        class="form-control"
                        placeholder="이름">
              </div>
              <div class="col-1 ps-2"><span class="text-danger">*</span>
             
              </div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">이메일</label>
              <div class="col-5">
                 <input type="text" 
                        name="useremail" 
                        id="useremail" class="form-control"
                        placeholder="이메일">
              </div>
              <div class="col-5 ps-2"><span class="text-danger">*</span>
               <span class="hidden-error text-danger" id="erroremail"></span>
              </div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">전화번호</label>
              <div class="col-5">
                 <input type="text" name="usertel" id="usertel" class="form-control"
                  placeholder="000-0000-0000">
              </div>
              <div class="col-5 ps-2"><span class="text-danger">*</span>
              <span class="hidden-error text-danger" id="errortel"></span>
              </div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">우편번호</label>
              <div class="col-2">
                 <input type="text" name="post" id="postcode" class="form-control">
              </div>
              <div class="col-2">
                  <button type="button" class="btn btn-secondary" id="post-btn" onclick="execPostcode()">우편번호 찾기</button>
              </div>
          </li>
          <li class="list-group-item py-3 d-flex align-items-center">
              <label class="col-2 text-end pe-3 fw-bold">주소</label>
              <div class="col-10">
                 <input type="text" name="addr" id="address" class="form-control mb-3" placeholder="주소">
                 <input type="text" name="addr2" id="detailAddress" class="form-control" placeholder="상세주소">
              </div>
          </li>
       </ul>
       <div class="text-center">
             <button type="reset" class="btn btn-warning me-3 px-4">취소</button>
             <button type="submit" class="btn btn-secondary px-4">전송</button> 
       </div>
       </form>
   </div>
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
     document.addEventListener('DOMContentLoaded', ()=> {
    	 const joinForm = document.getElementById("joinForm");
    	 const useridInput = document.getElementById("userid");
    	 const userpassInput = document.getElementById("userpass");
    	 const reuserpassInput = document.getElementById("reuserpass");
    	 const usernameInput = document.getElementById("username");
    	 const useremailInput = document.getElementById("useremail");
    	 const userTelInput = document.getElementById("usertel");
    	 
    	 
     /** 아이디, 이메일, 전화번호 **/
    	 useridInput.addEventListener('blur', async ()=>{
        	 const v = userid.value.trim();
             const dup = await checkExists("userid", v); 
             const error = document.getElementById("error");
             if(dup === "1") {
            	error.textContent = "이미 사용중인 아이디입니다.";
            	error.classList.remove('hidden-error');
            	useridInput.value="";
            	useridInput.focus();
            	
            	//2초 후 원상복구
            	setTimeout(()=>{
            		error.classList.add('hidden-error');
            		error.textContent = "";
            	}, 2000);
             }
         });
     
    	 useremailInput.addEventListener('blur', async ()=>{
        	 const v = useremail.value.trim();
             const dup = await checkExists("email", v); 
             const erroremail = document.getElementById("erroremail");
             if(dup === "1") {
            	erroremail.textContent = "이미 사용중인 이메일입니다.";
            	erroremail.classList.remove('hidden-error');
            	useremailInput.value="";
            	useremailInput.focus();
            	
            	//2초 후 원상복구
            	setTimeout(()=>{
            		erroremail.classList.add('hidden-error');
            		erroremail.textContent = "";
            	}, 2000);
             }
         });
    	 
    	 userTelInput.addEventListener('blur', async ()=>{
        	 const v = usertel.value.trim();
             const dup = await checkExists("tel", v); 
             const error = document.getElementById("errortel");
             if(dup === "1") {
            	error.textContent = "이미 사용중인 전화번호입니다.";
            	error.classList.remove('hidden-error');
            	userTelInput.value="";
            	userTelInput.focus();
            	
            	//2초 후 원상복구
            	setTimeout(()=>{
            		error.classList.add('hidden-error');
            		error.textContent = "";
            	}, 2000);
             }
         });
            
    	 
    	 userTelInput.addEventListener("input", (e)=>{
    		let input = e.target.value.replace(/[^0-9]/g, ''); 
    		let tel = '';
    		
    		//지역번호 그룹의 숫자 개수 결정
    		const firstGroup = input.startsWith('02') ? 2 : 3;
    		
            if(input.length > firstGroup) {
            	tel += input.substr(0, firstGroup);
            	if(input.length - firstGroup > 4) {
            		//국번이 4자리인 경우 02-0000-0000  010-0000-0000
            		tel += '-' + input.substr(firstGroup, 4);
            		tel += '-' + input.substr(firstGroup + 4, 4);
            	}else{
            		tel += '-' + input.substr(firstGroup, 3);
            		tel += '-' + input.substr(firstGroup + 3, 4);
            	}
            }else{
            	tel = input;
            }
    		e.target.value = tel;
    	 });

         joinForm.addEventListener("submit", (event) => {
        	 event.preventDefault(); 
        	 const errors = [];
        	 
        	 //1. 아이디 유효성 검사 - 한글, 숫자시작 불가, 3-8자 이하
        	 const useridReg = /^[a-zA-Z][a-zA-Z0-9]{2,7}$/;
        	 if(!useridReg.test(useridInput.value)){
        		 errors.push("아이디는 한글, 숫자시작불가, 3-8자 사이여야 합니다.")
        	 } 
        	        	 
        	 //2. 비밀번호 유효성 검사 - 대,소,특 적어도 하나 이상 4~10
        	 /*
        	 const userpassReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+~]).{4,10}$/;
        	 if(!userpassReg.test(userpassInput.value.trim())) {       		
        		 errors.push("비밀번호는 대문자,소문자,특수문자를 하나이상 포함하고, 총 4~10자여야 합니다.");
        	 }       	 
        	 */
        	 
        	 //3. 비밀번호 확인
        	 if(userpassInput.value !== reuserpassInput.value){
        		 errors.push("비밀번호가 일치하지 않습니다.");
        	 }
        	 
        	 //4. 이름 유효성 검사 (2~6 자이하, 한글, 영문)
        	 const usernameReg = /^[가-힣a-zA-Z]{2,6}$/;
        	 if(!usernameReg.test(usernameInput.value)){
        		 errors.push("이름은 2자에서 6자까지의 한글 또는 영문만 가능합니다.");
        	 }
        	 
        	 //5. 이메일 유효성 검사
        	 const useremailReg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        	 if(!useremailReg.test(useremailInput.value)){
        		 errors.push("올바른 이메일 형식이 아닙니다.");
        	 }
        	 
        	 //6. 전화번호 유효성 검사
        	 const usertelReg = /^\d{2,3}-\d{3,4}-\d{4}$/;
        	 if(!usertelReg.test(userTelInput.value)){
        	     errors.push("전화번호는 000-0000-0000 형식이어야 합니다.");
        	 }
        	 
        	 if(errors.length > 0) {
        		 alert(errors.join('\n'));
        	 }else{
        		 joinForm.submit();
        	 }
         });
    	 
     });

     
     //중복검사
     const CHECK_URL = "<c:url value='/member/check'/>";

     async function checkExists(field, value) {
    	 if(!value) return null;
    	 const url = CHECK_URL+"?field="+encodeURIComponent(field)+"&value="+ encodeURIComponent(value);
    	 const res = await fetch(url, { "Accept": "text/plain"});
    	 if(!res.ok) throw new Error('network');
    	 const txt = (await res.text()).trim();
    	 return txt;
     }
     
     
     //주소 api
       function execPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
   </script>
<%@ include file="../include/footer.jsp" %>