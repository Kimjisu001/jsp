//아작스
//비동기처리방식
//매개값: 실행할 함수, 지연시간(밀리세컨단위 1000=1초)
setTimeout(function(){
	console.log("1번");
},1000);

setTimeout(function(){
	console.log("2번");
},3000);

setTimeout(function(){
	console.log("3번");
},2000);

console.log("end");