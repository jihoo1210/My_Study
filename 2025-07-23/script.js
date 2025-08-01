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
        $(this).toggleClass("scaleup");
        $(this).find(".shadow-bg").fadeToggle("slow");
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