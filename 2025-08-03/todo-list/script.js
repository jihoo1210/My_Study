$(function() {
    $("#add-btn").on("click", function() {
        const userValue = $("#todo-input").val();
        if(userValue == ''){
            return;
        } else {
            const todoItem = $("<li></li>").addClass("todo-item").text(userValue);
            $("#todo-list").append(todoItem);
            $("#todo-input").val('');
        };
    });
    $("#todo-list").on("click", ".todo-item", function() {
        $(this).remove();
    })
});
/**
 * userValue == ''
 * 1. 문자열이 비었는지 확인
 * 팩토리 함수
 * 1. 새로운 HTML 요소 생성
 * 1-1. 태그 문자열을 인수로 받아, 새로운 DOM 요소를 생성하고 이를 jQuery 객체로 감싸서 반환
 * 2. HTML 요소 선택
 * 2-1. CSS 선택자를 인수로 받아, 문서 내에서 해당 선택자에 일치하는 모든 요소를 jQuery 객체로 감싸서 반환
 * 3. jQuery 객체로 감싸는 이유
 * 3-1. jQuery 메서드를 사용할 수 있게 하기 위함
 * .on() 이벤트 위임
 * 1. 이벤트 위임: 부모 요소에 단 하나의 이벤트 핸들러를 바인딩하여 자식 요소에서 발생하는 이벤트를 처리하는 기술
 * 2. $(부모요소).on('이벤트', '자식요소선택자', function() { ... });
 * val()과 text()
 * - val()
 * 1. 폼 요소의 값을 가져오거나 설정하는 데 사용
 * 2. 사용자가 입력한 값을 다룸
 * - text()
 * 1. HTML 요소의 텍스트 콘텐츠를 가져오거나 설정하는 데 사용
 * 2. HTML 태그는 무시됨
 */