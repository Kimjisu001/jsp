/**
 * 공공데이터 연습 20240621
 */

//public.js
//let url = "공공데이터 url /10개 가져왔습니다. 공공데이터 키: "
let url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=NgQzl3x1WI6c8Zo8ZgMIkhtHoo%2B%2FXfMdVi0XhgdQWfFhq7ur18mi67nBD5JIIWViLagFYeh9kRkhU8lY9AV5vA%3D%3D"
//const xhtp = new XMLHttpRequest
//xhtp.open('get', url);
//xhtp.send();
//xhtp.onload = function(){
//    let data = JSON.parse(xhtp.responseText);
//    console.log(data);
//}

fetch(url)
	.then(function(result) {
		return result.json()
	})
	.then(function(result) {
		console.log(result);
		console.log(result.data);
		//result.data.forEach(center => { })
	})

//위 구문을 간단하게 줄이고 몇줄 추가함.
const target = document.querySelector('#centerList'); //하위목록.
fetch(url)
	.then(result => result.json()) //[{"id":1, "center.."},{},{}]->[{},{}]
	.then(result => {
		console.log(result.data);//
		result.data.forEach(center => console.log(center));
		target.appendChild(makeRow(center));
	});

const fields = ['id', 'centerName', 'phoneNamber', 'address'];

function makeRow(center = {}) {
	let tr = document.createElement('tr');

	fields.forEach(field => {
		let td = document.createElement('tr');
		td.innerHTML = center[field];
		tr.appendChild(td);
	});
	return tr;
}

