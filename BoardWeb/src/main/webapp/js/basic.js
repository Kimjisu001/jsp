
 //DOM 핸들링 연습

 //li 생성
 let li = document.createElement('li'); //li태그를 만듬
 li.innerHTML = '<b>오렌지</b>' //<li><b>오렌지</b></li>
 
 document.querySelector('ul#fruit').appendChild(li);
 document.querySelector('ul#fruit>li').remove();
 document.querySelector('ul#fruit>li').style.backgroundColor = 'yellow';//스타일 적용
 
 console.log(document.querySelectorAll('#fruit>li'));
 let lists =document.querySelectorAll('#fruit>li');
 for (let list of lists) {
 //버튼 생성.
 console.log(list)
 let btn = document.createElement('button');
 btn.innerText = '삭제';
 btn.setAttribute('class','btn btn-primary');//삭제버튼의 스타일 적용됨 Attribute가 id,스타일 등의 속성을 뜻함.
 btn.addEventListener('click',function(){ 
	 btn.parentElement.remove();//삭제버튼을 눌렀을때 삭제 됨
 });//이벤트 유형, 해당되는 이벤트가 호출 되었을때 실행할 실행 코드가 함수 형태로 적용 되야함
 list.appendChild(btn);
 }
