let member = parseInt(prompt("입장객 수를 입력하세요."));
let colMem = parseInt(prompt("한 줄에 앉는 입장객 수를 입력하세요."));
let rowMem; 
if(member % colMem === 0){
rowMem = member / colMem;
} else {
    rowMem = parseInt(member / colMem) + 1;
}
//document.writeln(`모두 <big>${rowMem}</big>개의 줄이 필요합니다.`);

document.write('<table>')
for(let i = 0; i <= rowMem; i++){
    document.write('<tr>')
    for(j = 1; j <= colMem; j++){
    if(i*colMem+j > member) break;
    document.write(`<td>좌석 ${i+1}행 ${j}열</td>`);
    }
    document.write('</tr>')
}
document.write('</table>')