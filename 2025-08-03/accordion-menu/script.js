$(function() {
    $(".accordion-header").on("click", function() {
        $(".accordion-item").not($(this).parent()).find(".accordion-content").slideUp();
        // $(this).parent().siblings().find(".accordion-content").slideUp();
        $(this).next().slideToggle();
    });
});

/**
 * not(selector)
 * 1. selector와 일치하지 않는 요소들을 반환
 * $(selector).parent()
 * 1. selector의 직계 부모 요소 반환
 * .find(selector)
 * 1. selector와 일치하는 자손 요소 반환
 * .next()
 * 1. 바로 다음 형제 요소 반환
 * .siblings()
 * 1. 현재 요소의 모든 형제 요소 반환
 */