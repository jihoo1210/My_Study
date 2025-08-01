let btn = document.querySelectorAll(".btn");
let back = document.querySelector(".back");
let rsp = document.querySelectorAll(".rsp");
let flex = document.querySelector(".flex")
let show = document.querySelector(".show");
let userNum = '';
let user = document.querySelector(".user");
let com = document.querySelector(".com");
let header = document.querySelector(".head-container")
let result = document.querySelector(".result");
let score = document.querySelector(".score")
let count = 0;
let lostCount = 0;
let gameHistory = [];
function enter(){
    show.style.display = "none";
    back.style.display = "block";
    header.style.display = "block";
    rsp.forEach((rsp, i)=>{
        count = 0;
        lostCount = 0;
        score.innerText = `${count} / ${lostCount}`;
        let userNum = i;
        rsp.style.display = "block";
        rsp.addEventListener("click", ()=>{
            com.classList.remove("rock");
            com.classList.remove("scissors");
            com.classList.remove("paper");
            let computer = parseInt(Math.random() * 3);
            switch(computer){
                case 0:
                    com.className = "com scissors";
                    break;
                case 1:
                    com.className = "com rock";
                    break;
                case 2:
                    com.className = "com paper";
                    break;
            };
            if((userNum == '0' && computer == '1') || (userNum == '1' && computer == '2') || (userNum == '2' && computer == '0')){
                result.innerText = "패배ㅠㅠ";
                lostCount++;
                score.innerText = `${count} / ${lostCount}`
            } else if((userNum == '0' && computer == '2') || (userNum == '1' && computer == '0') || (userNum == '2' && computer == '1')){
                result.innerText = "승리!";
                count++;
                score.innerText = `${count} / ${lostCount}`;
            } else {
                result.innerText = "무승부";
                score.innerText = `${count} / ${lostCount}`;
            };
            if(count == 3){
                result.innerText = "👍최종 승리!👍";
                count = 0;
                lostCount = 0;
            }else if(lostCount == 3){
                result.innerText = "🤔최종 패배!🤔";
                count = 0;
                lostCount = 0;
            };
        });
    });
    flex.style.display = "flex";
    flex.style.justifyContent = "space-around";
};
function close1() {
    show.style.display = "inline-block";
    back.style.display = "none";
    user.classList.remove("rock");
    user.classList.remove("scissors");
    user.classList.remove("paper");
    com.classList.remove("rock");
    com.classList.remove("scissors");
    com.classList.remove("paper");
    result.innerText = "결과"
    rsp.forEach((rsp)=>{
        rsp.style.display = "none";
    });
    flex.style.display = "none";
    header.style.display = "none";
};

function rspS() {
    user.className = "user scissors";
    userNum = 0;
}
function rspR() {
    user.className = "user rock";
    userNum = 1;
}
function rspP() {
    user.className = "user paper";
    userNum = 2;
}