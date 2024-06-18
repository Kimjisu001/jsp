//forEach, map, reduce 정리

const numAry = [23, 17, 6, 41, 30, 12];
let result = 0;

let evenSum = function(elem, idx, ary){
	console.log(elem, idx, ary);
	if (elem % 2 == 0) {
		result += elem;
	}
};

let oddSum = function(elem, idx, ary){
	console.log(elem, idx, ary);
	if (idx % 2 == 0) {
		result += elem;
	}
};


//35보다 작은 값들의 합을 저장
let less35 = function(elem, idx, ary){
	if(elem < 35){
		result += elem;
	}
};

numAry.forEach(evenSum);
console.log("짝수의 합은 ", result);

numAry.forEach(oddSum);
console.log("홀수의 합은 ", result);

numAry.forEach(less35);
console.log("35보다 작은 값의 합은 ", result);

const dupAry = [10, 27, 32, 55, 27, 10];
const ary = [];//indexof(10) -> 인덱스 값을 반환해줌. 없으면 -1을 반환함.

//중복된 값 제거된 값만 ary라는 값에 담고싶어서 함수를 만들려고 함.....
dupAry.forEach(function(elem){
	if(dupAry.indexOf(elem) == -1){
		ary.push(elem);
	}	
});
console.log('새로운 배열:',ary);