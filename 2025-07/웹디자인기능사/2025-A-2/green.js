let a = document.querySelectorAll("a");
a.forEach(function(a){
    a.addEventListener("click", function(event){
        event.preventDefault();
    })
})
let A = document.querySelector(".A");
let A1 = document.querySelector(".A-1");
let B = document.querySelector(".B");
let B1 = document.querySelector(".B-1");
A.addEventListener("click", function(){
    A1.classList.add("block");
    B1.classList.remove("block");
    A1.classList.remove("none");
    B1.classList.add("none");
    A.classList.add("bColor");
    B.classList.remove("bColor");
});
B.addEventListener("click", function(){
    A1.classList.remove("block");
    B1.classList.add("block");
    A1.classList.add("none");
    B1.classList.remove("none");
    A.classList.remove("bColor");
    B.classList.add("bColor");
    //클래스 이름을 . 없이 적는다
});
//팝업
let pop = document.querySelector(".pop");
pop.addEventListener("click", function(){
    window.open("https://m.megabox.co.kr/movie-detail?rpstMovieNo=25008000", "titan-pop", "width:500px,height:500px")
});
let close1 = document.querySelector('#close');
close1.addEventListener("click", ()=>{
    window.close();
})
//이동
let f = document.querySelector(".family");
f.addEventListener("click", function(){
    location.href = "https://shingeki.tv/";
})