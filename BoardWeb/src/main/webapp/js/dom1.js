/**
 * dom1.js
 */
document.getElementById('fruit').style.display = 'none';

document.querySelector('table.table tr:nth-of-type(5)')//
	.setAttribute('align', 'center'); //추가 버튼 가운데 정렬

// 페이지가 로딩되는 시점에 회원 3명 출력.
for (let mem of myMembers) {
	document.getElementById('memberList')//
		.appendChild(addRow(mem));
}

//추가버튼 클릭이벤트 등록.
document.getElementById('addBtn').addEventListener('click', addMemberFnc);
//수정버튼
document.getElementById('modBtn').addEventListener('click', modMemberFnc);
//선택삭제버튼
document.getElementById('delBtn').addEventListener('click', removeMemberFnc);
//전체선택
document.querySelector('thead input[type="checkBox"]').addEventListener('change',allCheckFnc)
//전체선택해제
//document.querySelector('thead input[type="checkBox"]').addEventListener('change',notCheckFnc)


//전체선택해제
//function notCheckFnc(){
//	console.log(this.checked)
//}

//전체 선택
// this => 1. 이벤트(이벤트대상), 2.함수 (window) 3. 객체(객체자신)
function allCheckFnc(){
	console.log(this.checked); //함수에서 쓰여지는 this는 window객체임
	let checkVal = this.checked;
	document.querySelectorAll('#memberList tr')//
	.forEach(item => item.children[5].children[0].checked =this.checked);
}//end allCheckFnc

//선택삭제
function removeMemberFnc() {
	let targetTr = document.querySelectorAll('#memberList tr');
	for (let tr of targetTr) {
		console.log(tr.children[5].children[0].checked);
		if (tr.children[5].children[0].checked) {
			tr.remove();
		}
	}
	document.querySelector('thead input[type="checkBox"]').checked = false;
}//end removeMemberFnc

function modMemberFnc() {
	let targetTr = document.querySelectorAll('#memberList tr');
	//입력화면의 회원 아이디 값을 가져와서 mid 변수 저장.
	let mid = document.getElementById('mid').value;
	let mname = document.getElementById('mname').value;
	let mphone = document.getElementById('mphone').value;
	for (let tr of targetTr) {
		console.log(tr.children[0].innerHTML);
		if (tr.children[0].innerHTML == mid) {
			tr.children[1].innerHTML = mname;
			tr.children[2].innerHTML = mphone;
			tr.children[3].innerHTML = document.getElementById('mpoint').value;
		}
	}
}//end modMemberFnc



function addMemberFnc() {
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;

	if (!id || !name || !phone || !point) {
		alert("필수 값을 입력");
		return;
	}

	document.getElementById('memberList')//
		.appendChild(addRow({ id, name, phone, point }));

	document.getElementById('mid').value == "";
	document.getElementById('mname').value == "";
	document.getElementById('mphone').value == "";
	document.getElementById('mpoint').value == "";
}//end if addMemverFnc()


function addRow(member = { id, name, phone, point }) {
	// tr > td * 4개
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc);

	for (let prop in member) {
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}

	//삭제 버튼 생성
	// <td><botton>삭제</botton></td>
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', removeTrElement);
	btn.innerText = '삭제';
	//btn.addEventListener('click', () => { btn.parentNode.parentNode.remove() });
	td.appendChild(btn);
	tr.appendChild(td);
	//체크박스 생성
	td = document.createElement('td');
	btn = document.createElement('input');
	btn.setAttribute('type', 'checkbox');
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}//end of ddRow()

//이벤트 핸들러 함수
function removeTrElement(e) {
	console.log('btn', e);
	e.stopPropagation();//상위요소로 이벤트 전파 차단
	console.log(this.parentElement.parentElement.remove());
}

//tr을 클릭을 하면 정보를 다시 분할
function showDetailFnc() {
	//tr의 자식 요소의 값을 입력 input에 반환.
	console.dir(this.children[1].innerText);
	document.getElementById('mid').value = this.children[0].innerText;
	document.getElementById('mname').value = this.children[1].innerText;
	document.getElementById('mphone').value = this.children[2].innerText;
	document.getElementById('mpoint').value = this.children[3].innerText;
}