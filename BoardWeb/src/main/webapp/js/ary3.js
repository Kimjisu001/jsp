//배열 메소드
//어떤 값이든 만들어서 반환할수 있음.
//누적값, 요소, 인덱스, 배열자체
let sum =
	[10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) {
		console.log(acc, elem, idx, ary);
		if (acc > elem) {
			return acc;
		}
		return elem;
	}, 0);
console.log('최대값:', sum);

//최소값
let sum1 =
	[10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) {
		console.log(acc, elem, idx, ary);
		if (acc < elem) {
			return acc;
		}
		return elem;
	}, 100);
console.log('최소값:', sum1);


['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'].reduce(function(acc,elem){
	let li = document.createElement('li');
	li.innerHTML = elem;
	acc.appendChild(li);

	return acc;	
},document.getElementById('fruit'));