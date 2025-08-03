$(function() {
    $("#toggle-btn").on("click", function() {
        const currentWidth = $("#animate-image").width();
        if(currentWidth == 200){
            $("#animate-image").animate({
                "width": "250px",
                "height": "250px",
                "opacity": "1"
            }, 1000);
        } else {
                $("#animate-image").animate({
                "width": "200px",
                "height": "200px",
                "opacity": ".5"
            }, 1000);
        }
    })
})
/**
 * width()
 * 1. 패딩, 보더, 마진을 제외한 현재 요소의 너비를 반환한다.
 * 2. (반환할 값)px.
 * 3. width(set-width-value)
 * 3-1. 매개 변수를 통해 너비값을 조절할 수 있다.
 */