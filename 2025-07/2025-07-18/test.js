let num = parseInt(Math.random()*100)+1;
let age =  num;
if(age >= 19){
    console.log("성인입니다.");
}else if(age >= 13){
    console.log("청소년입니다.");
} else console.log("어린이입니다.");
console.log(age);
