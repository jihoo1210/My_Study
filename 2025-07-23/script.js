$(function(){
    $(".nav-item").hover(function(){
        $(this).find('ul.lnb').slideToggle("fast");
    });
    
    $(".category").hover(function(){
        let w = $(".container").width();
        $(".categorybox").css({"width": `${w}px`});
        $(".categorybox").fadeToggle("fast");
    });
    $(".img-best-box").hover(function(){
        $(this).toggleClass("scaleup filter-brightness");
    });
    $(".best-btn .shoping-icon").mouseenter(function(){
        $(this).find("i").addClass("ri-shopping-bag-fill").removeClass("ri-shopping-bag-line");
    }).mouseleave(function(){
        $(this).find("i").removeClass("ri-shopping-bag-fill").addClass("ri-shopping-bag-line");
    })
        $(".best-btn .heart-icon").mouseenter(function(){
        $(this).find("i").addClass("ri-heart-2-fill").removeClass("ri-heart-2-line");
    }).mouseleave(function(){
        $(this).find("i").removeClass("ri-heart-2-fill").addClass("ri-heart-2-line");
    })

    const navTopHeight = $(".navigation").offset().top * 2;
    $(window).on("scroll", function(){
        if($(this).scrollTop() > 45){
            $(".navigation").css({
                "position": "fixed",
                "top": "45px",
                "width": "100%"
            });
            $("body").css({
                "paddingTop": navTopHeight + "px"
            })
        }else{
            $(".navigation").css({
                "position": "static"
            });
            $("body").css({
                "paddingTop": 30 + "px"
            })
        };
    });
});





let search = document.querySelector("#searchInput");
let form = document.querySelector("#search")
search.addEventListener("focus", ()=>{
    form.classList.add("focus");
});

search.addEventListener("blur", ()=>{
    form.classList.remove('focus');
})

let slideIndex = 1;
function pushSlide(n){
    showSlide(slideIndex += n)
}
function currentSlide(n){
    showSlide(slideIndex -= n)
}
function showSlide(n) {
    let i;
    let slide = document.getElementsByClassName("mySlide");
    if(n > slide.length){
        slideIndex = 1;
    }
    for(i = 0; i < slide.length; i++){
        slide[i].style.display = "none";
    }
    slide[slideIndex - 1].style.display = "block";
}
setInterval(function(){
    pushSlide(1);
}, 3000);