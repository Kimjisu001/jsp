/**
 * reply.js
 */
//svc.replyList({bno,page} replyListFnc);

//이 값을 바꿔서 페이지 5장씩 보기
let page = 2;
svc.replyList({bno,page}, replyListFnc);

//댓글등록 이벤트.(요소를 가져와서 그 버튼을 클릭하면 이 함수가 실행)
document.getElementById('addReply').addEventListener('click', addReplyFnc);
//등록 버튼을 누르면 실행될 함수
function addReplyFnc(){
	let reply = document.getElementById('reply').value;
	svc.addReply({replyer,reply,bno}, addReplyCallback);
}

function addReplyCallback() {
    console.log(this.responseText);
    let result = JSON.parse(this.responseText);

    if (result.success) { // Assuming there's a 'success' key in the response
        alert('등록성공');

        // 새로운 li 요소를 생성합니다.
        let li = document.createElement('li');
        li.textContent = result.reply; // Assuming 'reply' is the text to be displayed

        document.querySelector('div.content > ul').appendChild(li);
        document.getElementById('reply').value = '';
    } else {
        alert('실패=> ' + result.retVal);
    }
    // svo.addReply({replyer: replyer, reply: reply, bno: bno}, addReplyCallback); // 주석 처리된 부분은 필요에 따라 활성화
}

//replyList의 매개값으로 사용될 함수.
function replyListFnc() {
	let data = JSON.parse(this.responseText);
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
}

function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);

	template.style.display = 'block';
	template.setAttribute('id', reply.replyNo)
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	return template;
}

//한건삭제

function deleteRow(e) {
	//버튼을 지우는게 아니고 리스트 태그를 지우는게 목적임. 
	let li = e.target.parentElement.parentElement;
	console.log(li);
	let rno = li.getAttribute('id');


	svc.removeReply(rno,deletReplyFnc);
	function deletReplyFnc(){
		let result = JSON.parse(this.responseText);
		if (result.retCode=="OK"){
			alert(result.retMsg);
			li.remove();
		}else{
			alert('Error=>' + result.retMsg);
		}
	}
	
}	
