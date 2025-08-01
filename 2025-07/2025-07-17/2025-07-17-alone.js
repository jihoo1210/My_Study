// function
// -- 세미 콜론을 확인해라
// 익명 함수
let i = function (a, b) {
  return a + b;
};
document.writeln(i(10, 20));
  //즉시 실행 함수
  (function (a, b) {
    document.writeln(a + b);
  }(10, 20));

//화살표 함수 - 익명 함수인 경우
let iii = a => a * 10;
document.writeln(iii(20));