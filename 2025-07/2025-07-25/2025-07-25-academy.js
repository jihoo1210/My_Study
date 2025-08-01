// node 2025-07-25-academy
let str = "안녕, 철수";
let strReplace = str.replace("철수", "지후");
console.log(strReplace);
console.log(str);

let strSlice = str.slice(1, 3);
console.log(strSlice);
console.log(str);

let strSubString = str.substring(1, 3);
console.log(strSubString);
console.log(str);

let strSplit = str.split(",");
console.log(strSplit);
console.log(str);

let str1 = "abcdefg가"
let str1Upper = str1.toUpperCase();
console.log(str1Upper);
console.log(str1);

console.log(str1.charCodeAt(7));
console.log(String.fromCharCode(65));

console.log("//********************//")

let t = "Hello Thank you good luck to you";
let tCharAt = t.charAt(16);
console.log(tCharAt);

let tSearch = t.search("you");
console.log(tSearch);

let tSearch16 = t.search("you", 16);
console.log(tSearch16);

let tLastIndexOf = t.lastIndexOf("you");
console.log(tLastIndexOf);

let tLastIndexOf25 = t.lastIndexOf("you", 25);
console.log(tLastIndexOf);

let tSlide = t.slice(21, 25);
console.log(tSlide);

let tSubstring = t.substring(6, 12);
console.log(tSubstring);

let tReplace = t.replace("you", "me");
console.log(tReplace);

let tUpper = t.toUpperCase();
console.log(tUpper);

let tLower = t.toLowerCase();
console.log(tLower);

let tLength = t.length;
console.log(tLength);

let tSplitSlice = (t.split("")).slice(0, 1) + (t.split("")).slice(4, 5);
console.log(tSplitSlice);

let tCharCodeAt = t.charCodeAt(0);
console.log(tCharCodeAt);

console.log(String.fromCharCode(70));
