let track = document.querySelector(".slideInBox")
let slide = document.querySelectorAll(".sld");
let current = 0;
function slideTrack(){
    current++;
    track.style.transition = "transform 0.5s ease";//스타일 추가 방법: 요소.style.속성 = "값";
    const moveX = current*slide[current].offsetWidth;//offsetWidth: 화면상 보이는 width
    track.style.transform = `translateX(-${moveX}px)`;
    if(current == slide.length - 1){
        setTimeout(()=>{
            track.style.transition = "none";
            track.style.transform = `translateX(0)`;
            current = 0;
        }, 500)//0.5s 뒤에 실행되는 함수(setTimeout)
    }
};
setInterval(slideTrack, 3000);