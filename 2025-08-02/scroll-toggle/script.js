$(function() {
    $(window).on("scroll", function() {
        const scrollHeight = $(window).scrollTop();
        if(scrollHeight > 100){
            $("#main-header").addClass("scrolled");
        } else {$("#main-header").removeClass("scrolled")}
    });
});
/**
 * 이벤트 바인딩
 * - 특정 이벤트가 발생할 때 특정 코드를 실행시키는 것
 */