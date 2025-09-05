<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript" src="//code.jquery.com/jquery.min.js"></script>
<link rel="stylesheet" href="<c:url value='css/summernote-lite.min.css' />">
<script src="<c:url value='js/summernote-lite.min.js' />"></script>
<script src="<c:url value='js/lang/summernote-ko-KR.js' />"></script>
<script>
  $(function(){
	  $("#content").summernote({
		  height: 300,
		  lang: 'ko-KR',
		  toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	          ['para', ['ul', 'ol', 'paragraph']],
	          ['table', ['table']],
	          ['insert', ['link', 'video']],
	          ['view', ['fullscreen', 'codeview', 'help']]
	        ]
	  });  
  });   
</script>
    <form class="writeform pt-5">
    <div class="write mt-5">
        <div class="row">
            <div class="mb-5 col-md-6 row">
                <label for="username" class="col-sm-4 text-end">이름</label>
                <div class="col-sm-8">
                   <input type="text" id="username" class="form-control" name="username" placeholder="이름">
                </div>
            </div>
            <div class="mb-5 col-md-6 row">
                <label for="pass" class="col-sm-4 text-end">비밀번호</label>
                <div class="col-sm-8">
                   <input type="password" name="pass" id="pass" class="form-control" placeholder="비밀번호">
                </div>
            </div>
            <div class="col-md-12 mb-5 row">
                <label for="title" class="title-label text-end">제목</label>
                <div class="col-title">
                    <input type="text" name="title" id="title" class="form-control" placeholder="제목">
                </div>
            </div>
            <div class="col-md-12 mb-5 row">
                <label class="title-label text-end">내용</label>
                <div class="col-title">
                    <textarea 
                        id="content" 
                        name="content"></textarea>
                </div>
            </div>
        </div>

        <div class="btn-box text-center ms-140">
            <a href="list.html" class="btn btn-danger px-5 me-3">취소</a>
            <button type="submit" class="btn btn-dark px-5">등록</button>
        </div>

    </div>
    </form>
<%@ include file="../include/footer.jsp" %>