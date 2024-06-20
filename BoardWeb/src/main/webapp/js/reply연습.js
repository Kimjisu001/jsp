/**
 * reply.js
 */
//댓글로 li 생성하는 부분 함수 만들기
function makeRow(reply = {}) {
	let fields = ['replyNo', 'reply', 'replyer', 'replyDate'];
	let li = document.createElement('li');
	fields.forEach(field => {
		let span = document.createElement('span');
		span.innerHTML = reply[field];
		if (field == 'reply') {
			width = '4';
		} else if (field == "replyDate") {
			width = '3';
		} else {
			width = '2';
		}

		span.setAttribute('class', 'col-sm-' + width);
		li.appendChild(span);
	})
	return li;
}

function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);

	template.style.display = 'block';

	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	return template;
}

//한건삭제
function deleteRow(e){
	//버튼을 지우는게 아니고 리스트 태그를 지우는게 목적임. 
	e.target.remove();
}

const listAjax = new XMLHttpRequest();
listAjax.open('get', 'replyListJoson.do?bno=' + bno);
listAjax.send();
listAjax.onload = function() {
	let data = JSON.parse(listAjax.responseText);

	data.forEach(reply => {
		//document.querySelector('div.content>ul').appendChild(makeRow(reply));
		document.querySelector('div.content>ul').appendChild(cloneRow(reply));
	})

}

