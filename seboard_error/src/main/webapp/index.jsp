<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp" %>
        <!-- 본문 -->
        <div class="page-info ps-5">
            <i class="ri-file-list-fill"></i>
            <span class="me-3">총 게시글 <span>1234</span> 건</span>
            <span>현재 페이지 <span>1/23</span>
        </div>
        <div class="table-container ps-5">
            <table class="table table-striped table-hover">
                <colgroup>
                <col width="8%">
                <col>
                <col width="15%">
                <col width="10%">
                <col width="15%">
                </colgroup>
                <thead>
                    <tr>
                    <th scope="col">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">조회수</th>
                    <th scope="col">날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <!--loop-->
                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="view.html">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>
                                    <tr>
                    <th scope="row">1</th>
                    <td class="text-start"><a href="#">제목입니다.</a></td>
                    <td>Otto</td>
                    <td>35</td>
                    <td>2025.08.22</td>
                    </tr>

                <!-/loop-->
                </tbody>
            </table>
        </div>

        <div class="mt-3 ps-5">
            <div class="row">
                <div class="col-md-4">
                <form id="searchform" class="d-flex" name="searchform" action="" method="get">
                    <select class="form-select" name="searchopt" aria-label="Default select example">
                        <option value="title">제목</option>
                        <option value="write">이름</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="search" name="searchtext" class="form-control">
                    <button type="submit" class="btn btn-dark">검색</button>
                </form>
                </div>
                <div class="col-md-4 offset-md-4 d-flex justify-content-end">
                    <a href="#" class="btn btn-dark me-3">목록보기</a>
                    <a href="#" class="btn btn-dark">글쓰기</a>
                </div>
            </div>
        </div>

        <div class="my-5 ps-5">
            <!--페이징-->
                <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <li class="page-item"><a class="page-link" href="#"><i class="ri-arrow-left-double-line"></i></a></li>
                    <li class="page-item"><a class="page-link" href="#"><i class="ri-arrow-left-s-line"></i></a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#"><i class="ri-arrow-right-s-line"></i></a></li>
                    <li class="page-item"><a class="page-link" href="#"><i class="ri-arrow-right-double-line"></i></a></li>
                </ul>
                </nav>
            <!--/페이징-->
        </div>
        <!-- 본문 -->
        
        <%@ include file="include/footer.jsp" %>
        