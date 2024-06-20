//아작스
//비동기처리방식 대표적으로 비동기 방식으로 처리해주는게 XMLHttpRequest()임
//XMLHttpRequest객체
//객체라서 속성, 메소드가 있음
//처리된 결과를 response,responsetext 안에다가 가져옴
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json');
xhtp.send();
xhtp.onload = function(){
	//데이터를 불러올 때 제이슨 문자열을 자바스크립트 문자열로 변환함.
	let data = JSON.parse(xhtp.responseText)
	console.log(data);
	//DOM메소드를 사용해서 페이지를 작성.
	data.forEach(function(emp){
		console.log(emp);
		document.getElementById('list').appendChild(makeRow(emp));
	});
}
//{id:'Hong', name:'홍길동', age: 20}
// =>객체타입보다는 문자열로 보내는게 수월함
// 제이슨 문자열 이라고 부름 [{"id":"Hong","name": "홍길동","age":20}]


// makeRow에서 보여줘야할 필드를 정의해줌
let fileds = ['id','first_name','email','salary'];
//값이 전달 안되면 이놈으로 쓰세요
//makeRow 표 형식을 만들어줌
function makeRow(obj = {}){
	let tr = document.createElement('tr');
	fileds.forEach(field =>{
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
	return tr;
}

