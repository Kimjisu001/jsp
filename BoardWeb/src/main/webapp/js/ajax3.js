//아작스3 목록 가져오기
const xthp = new XMLHttpRequest();
xthp.open('get', 'membersAjax.do');
xthp.send();
xthp.onload = function() {
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(user => {
		document.getElementById('list').appendChild(makeRow(user))
	})
}
//제이슨 문자열의 필드 이름을 활용
const fields = ['userId', 'userName', 'userPw', 'responsibility'];
function makeRow(obj = {}) {
	let tr = document.createElement('tr');
	fileds.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
	return tr;
}

//등록이벤트 추가(addBtn)
document.getElementById('addBtn').addEventListener('click', function() {
	let id = document.getElementById('uid').value;
	let pw = document.getElementById('upw').value;
	let name = document.getElementById('uname').value;
	let auth = document.getElementById('auth').value;

	const addAjax = new XMLHttpRequest();
	let url = 'addAjax.do?id=' + id + '&pw=' + pw + '&nm=' + nm + '&auth=' + auth;
	addAjax.open('get', url);
	addAjax.send();
	addAjax.onload = function() {
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'OK') {
			let newMem = {userId: id, userName: nm, UserPw: pw, responsibility: auth }
			alert(result.retMsg);
			document.getElementById('list').appendChild(makeRow(newMem));
		} else {
			alert('실패');
		}
		
	}
})
