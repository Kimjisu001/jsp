/**함수정의문 */
function sum(a,b){
	return a + b;
}

function sum(a = 0, b = 0){
	if (b = undefined){
		return a;
	}
	return a+b;
}
//함수 표현식
sum = function sum(a=0,b=0){
	return a + b;
}
console.log(sum);
let result = sum(10,20);
result= sum(10);
console.log('결과:',result);

let name = "홍길동";
let age = 20;

const obj = {
	name,
	age
}

function showObj(obj = {name: '홍길순',age: 25}) {
	return obj.name + ' - ' + obj.age;	
}//end showObj
console.log(showObj(obj));

function sumAry(ary = []){
	let sum = 0;
	for (let i = 0; i <ary.length; i++){
		sum += ary [i];
	}
	return sum;
}//end sumAry
result = sumAry([1, 2, 3, 4, 5]);
console.log('결과: ', result);

function showItem(item){
	let days = ['Sun', 'Mon', 'Wed', 'Thr', 'Fri', 'Sat'];
	
	days.forEach(function(val){
		let span = document.createElement('span');
		span.innerHTML = val + " ";
		item.appendChild(span);
	});
} //end showItem

showItem(document.getElementById('show'));

console.log(window);


