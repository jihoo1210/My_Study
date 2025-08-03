$(function() {
    $("#filter-input").on("keyup", function() {
        const searchText = $(this).val().toLowerCase();
        $("#product-list li").each(function() {
            if($(this).text().toLowerCase().indexOf(searchText) > -1){
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    });
});
/**
 * keyup()
 * 1. 사용자가 키를 눌렀다가 땔 때 발생하는 이벤트
 * each()
 * 1. 선택된 요소를 순회하며 각 요소에 지정된 콜백 함수를 실행하는 반복 함수
 * 2. each() 안에서 사용된 $(this)는 현재 순회 중인 요소를 가리킨다.
 * 3. index와 element를 반환한다
 * 3-1. index: 현재 순회 중인 요소의 index
 * 3-2. element: 현제 순회 중인 요소
 */