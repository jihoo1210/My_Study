let arr1 = ["양촌", "구래", "마산", "장기"];
let arr2 = ["운양", "북변", "사우"];

let plus = arr1.join("-") + "-" + arr2.join("-");
console.log(plus);

let plusArr = arr1.concat(arr2);
console.log(plusArr);

arr1.pop();
arr1.shift();
console.log(arr1);

arr2.reverse();
console.log(arr2);

// *********** //

let greenArr = ["교대", "방배", "강남"];
let yellowArr = ["미금", "정자", "수서"];

greenArr.splice(2, 1, "서초", "역삼");
console.log(greenArr);

let popY = yellowArr.pop();
console.log(popY);
console.log(yellowArr);

let shiftY = yellowArr.shift();
console.log(shiftY);
console.log(yellowArr);

yellowArr.push(popY);
yellowArr.unshift(shiftY);
console.log(yellowArr);

// *********** //

let str = "a b c d e"

let strIndexOf = str.indexOf("b");
console.log(strIndexOf);

let strLastIndexOf = str.lastIndexOf("b");
console.log(strLastIndexOf);

let strMatch = str.match("c d");
console.log(strMatch);

// *********** //