$(function() {
    $("#signup-form").on("submit", function(event) {
        event.preventDefault();
        const userName = $("#username").val();
        const pass = $("#password").val();
        if(userName.length <= 4){$("#username-error").text("아이디는 4자 이상이어야 합니다.");};
        if(pass.length <= 6){$("#password-error").text("비밀번호는 6자 이상이어야 합니다.");}
        if(userName.length > 4 && pass.length > 6){
            $.post("/api/signup", {"id": userName, "password": pass})
            .done(function() {
                $("#success-message").text("회원가입이 완료되었습니다!")
            })
            .fail(function() {
                $("#success-message").text("회원가입에 실패했습니다.");
            });
        };
    });
});
/**
 * $.post()와 $.ajax() 차이
 * - $.post()
 * 1. 서버에 데이터를 전송하는 HTTP POST 요청을 보내는 메서드
 * 2. ajax()의 post 요청을 간소화해서 만든 메서드
 * $.post(url, data, successCallback, dataType)
 * 1. url: 데이터를 전송할 서버의 주소
 * 2. data: 서버에 전송할 데이터
 * 3. data-type: 서버로부터 받을 데이터 타입
 * - $.ajax()
 * 1. 다양한 종류의 HTTP 요청을 보낼 수 있는 메서드
 * $.ajax({ url: '', method: '', data: {}, dataType: '' });
 * 1. url: 데이터를 주고받을 서버의 주소
 * 2. data: 서버에 전송할 데이터
 * 3. data-type: 서버로부터 받을 데이터 타입
 * 
 * done(), fail(), always()
 * - done()
 * 1. ajax 요청이 성공적으로 완료되었을 때 실행되는 콜백 함수를 정의한다
 * - fail()
 * 1. ajax 요청이 성공적으로 완료되지 못했을 때 실행되는 콜백 함수를 정의한다
 * - always()
 * 1. ajax 요청의 성공의 여부와 상관 없이 요청이 완료되면 실행되는 콜백 함수를 정의한다
 */