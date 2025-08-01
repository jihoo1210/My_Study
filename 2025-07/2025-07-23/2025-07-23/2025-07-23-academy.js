//node 2025-07-23-academy
const tv = new Object();
tv.color = "white";
tv.price = "5,000,000";
tv.info = function(){
    console.log(`tv 색상 : ${this.color}`);
    console.log(`tv 가격 : ${this.price}`);
};

tv.info();
//날짜 관련 메서드
const toDay = new Date();
console.log(toDay);

const nowMonth = toDay.getMonth()+1;
const nowDate = toDay.getDate();
let nowDay = '';
switch(toDay.getDay()){
    case 0:
        nowDay = "일요일";
        break;
    case 1:
        nowDay = "월요일";
        break;
    case 2:
        nowDay = "화요일";
        break;
    case 3:
        nowDay = "수요일";
        break;
    case 4:
        nowDay = "목요일";
        break;
    case 5:
        nowDay = "금요일";
        break;
    case 6:
        nowDay = "토요일";
        break;
}
console.log(`${nowMonth}월 ${nowDate}일 ${nowDay}`);
// 과거 요일 알기
const bDay = new Date(2025, 11, 10);
let hDay = '';
switch(toDay.getDay()){
    case 0:
        hDay = "일요일";
        break;
    case 1:
        hDay = "월요일";
        break;
    case 2:
        hDay = "화요일";
        break;
    case 3:
        hDay = "수요일";
        break;
    case 4:
        hDay = "목요일";
        break;
    case 5:
        hDay = "금요일";
        break;
    case 6:
        hDay = "토요일";
        break;
}
console.log(hDay);
//오늘부터 연말까지의 남은 날짜
const nowYear = toDay.getFullYear();
console.log(nowYear);

const lastDate = new Date(nowYear, 11, 32);
console.log(lastDate);

const diffDate = lastDate.getTime() - toDay.getTime();
console.log(diffDate);

let result = parseInt(diffDate / (1000 * 60 * 60 * 24));
console.log(`${toDay.getFullYear()}년까지 ${result}일 남았습니다`);