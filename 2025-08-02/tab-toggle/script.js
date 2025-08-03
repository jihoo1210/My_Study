$(function () {
    $("li.tab-item").on("click", function () {
        $(".tab-item.active").removeClass("active");
        //모든 .active를 지닌 .tab-item에서 .active 제거
        $(this).addClass("active");
        //click된 .tab-item에 .active 추가
        $(".tab-content.active").removeClass("active");
        //모든 .active를 지닌 .tab-content에서 .active 제거
        $("#" + $(this).data("tab")).addClass("active");
        //클릭된 tab-item의 attr값과 동일한 id를 지닌 요소에 active 추가
    });
});
/**
 * data()
 * - data-* 속성값을 더욱 편하게 다루기 위해서 만들어짐
 * ex) data("tab") = attr("data-tab")
 */