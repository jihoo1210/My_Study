let i = 1;
while(i <= 10) {
    console.log("hello"+i);
    i++;
}
// node 2025-07-21-academy
// cd ./www/2025-07/2025-07-21
i = 1;
while(i <=10){
    if(i % 2 == 0){
        console.log(`${i}는`+"짝수입니다.")
    }
    i++;
};
let j = 6 //Number(prompt("숫자를 입력하시오"));
switch( j%3==0){
    case true:
        console.log(`${j}는 3의 배수입니다.`);
    break;
    default:
        console.log(`해당 없음`);
    break;
}
let p;
do {
    p = 1234; //prompt('비밀번호를 입력하시오')
    switch(p == 1234){
        case true:
            console.log("로그인 성공")
        break;
        case false:
            console.log("다시 입력하시오")
        break;
    }
} while (p !== 1234)
i = 1;
while(i <= 5){
    switch(i == 4){
        case true:
            console.log("중요 숫자!");
        break;
        default: 
            console.log(i.toString());
        break;
    }
    i++;
}
console.log("===========END===========")
for(i = 1; i < 21; i++){
    if(i % 3 == 0){
        console.log(i);
    } else console.log(i.toString());
}
console.log("===========END===========")
for(i = 1; i <= 3; i++){
    switch(i){
        case 1:
            console.log(`${i}단계 시작`);
        break;
        case 2:
            console.log(`${i}단계 시작`);
        break;
        case 3:
            console.log(`${i}단계 - 모든 단계 완료`);
        break;
    }
}
console.log("===========END===========")
for(i = 1; i < 11; i++){
    if(i == 6){break;}
    console.log(i);
}
console.log("===========END===========")
let s ='';
for(i = 0; i < 26; i++){
    if(i % 5 == 0 && i != 0){
        console.log(s);
        s = '';
    }
    s += i + ' ';
}