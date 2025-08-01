let slide = document.querySelectorAll('.slide');
const total = slide.length;
let current = 0;

function showSlide(index){
    slide.forEach((slide)=>{
        slide.classList.remove("active");
        //모든 slide의 active를 삭제
    });
    slide[index].classList.add("active");
    //index번 째의 slide에 active 추가
};

function nextSlide() {
  current = (current + 1) % total;
  // 1 > 2 > 0
  showSlide(current);
};

setInterval(nextSlide, 3000);
// setInterval(실행 함수, 실행 delay)
// 1s = 1000ms

//nextSlide → "함수를 전달"하려는 목적 (이건 콜백이라고 불러요)
//nextSlide() → "함수를 즉시 실행하고 결과값 전달" (의도와 다름)

// array.forEach(function(element, index, array) {
//   // 실행할 코드
// });
// element:	현재 처리 중인 배열 요소
// index:	현재 요소의 인덱스
// array:	forEach가 호출된 원본 배열
let a = document.querySelectorAll("a");
a.forEach((a)=>{
    a.addEventListener("click", function(event){
        event.preventDefault();
    });
});
// a 기본 동작 방지
let c1 = document.querySelector(".announcement")
let c2 = document.querySelector(".gallery")
let c1_1 = document.querySelector("#announcement-con");
let c1_2 = document.querySelector("#gallery-con");
let ca1 = document.querySelector("#c-a1")
let ca2 = document.querySelector("#c-a2")
let c = document.querySelector(".c1");
c1.addEventListener("click", ()=>{
    c1_1.classList.add("block");
    c1_1.classList.remove("none");
    c1_2.classList.add("none");
    c1_2.classList.remove("block");
    ca1.classList.add("bg");
    ca2.classList.remove("bg");
    c.classList.add("overflow");
});
c2.addEventListener("click", ()=>{
    c1_2.classList.add("block");
    c1_2.classList.remove("none");
    c1_1.classList.add("none");
    c1_1.classList.remove("block");
    ca1.classList.remove("bg");
    ca2.classList.add("bg");
    c.classList.remove("overflow");
});
// 탭 구현
let pop = document.querySelector('.pop');
pop.addEventListener("click", function(){
    window.open("../2025-A-2/green.html", "movie", "width: 500px; height:500px;");
})
// 팝업 구현
// 경로, 이름, 크기