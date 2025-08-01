/*
let gnb = document.querySelectorAll(".gnb");
gnb.forEach(function(gnb){
    gnb.addEventListener("mouseover", function(event){
        let lnb = document.querySelectorAll(".lnb");
        lnb.forEach(function(lnb){
                    lnb.classList.add("block");
                    lnb.classList.add("bottom")
        });
    });
});
gnb.forEach(function(gnb){
    gnb.addEventListener("mouseout", function(event){
        let lnb = document.querySelectorAll(".lnb");
        lnb.forEach(function(lnb){
                    lnb.classList.remove("block");
        });
    });
});
*/
// a 기능 제한
let a = document.querySelectorAll("a");
a.forEach(function(a){
    a.addEventListener("click", function(event){
        event.preventDefault();
    });
});
// 탭
let at = document.querySelector(".alert");
let gal = document.querySelector(".gal");
let text1 = document.querySelector(".text1")
let text2 = document.querySelector(".gal-img")
at.addEventListener("click", function(event){
    at.style.background = "black";
    at.style.color = "white";
    gal.style.background = "white";
    gal.style.color = "black";
    text1.style.display = "block"
    text2.style.display = "none"
});
gal.addEventListener("click", function(event){
    gal.style.background = "black";
    gal.style.color = "white";
    at.style.background = "white";
    at.style.color = "black";
    text1.style.display = "none"
    text2.style.display = "block"
});

