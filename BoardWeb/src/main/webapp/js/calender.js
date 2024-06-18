document.querySelectorAll('.container-fluid h3') //NodeList
	.forEach(item => item.remove());

document.querySelectorAll('.container-fluid table.table') //NodeList
	.forEach(item => item.remove());


document.getElementById('fruit').remove();

//월을 변경하면 달력을 출력하는 이벤트를 등록.(selectMonth)
document.getElementById('selectMonth').addEventListener('change',function(){
	makeCalender(parseInt(this.value));
})

//달력을 첫째날 계산하는 함수, 마지막날 계산하는 함수가 필요함.
function getFirstDay(month = 6) {
	switch (month) {
		case 5:
			return 4;
		case 7:
			return 2;
	}
	return 7;
}

function getLastDate(month = 6) {
	switch (month) {
		case 5:
		case 7:
			return 31;
	}
	return 30;
}

function makeCalender(month = 6) {
	//월에 따라 보여주는 달력을 바꾸어줌
	let firstDay = getFirstDay(month); //1일의 위치를 지정하기 위해서 공란의 갯수를 반환.
	let lastDate = getLastDate(month); // 월의 마지막날을 반환.
	
	document.getElementById('show').innerHTML = '';
	//table 생성, border="2"도 줘야함.
	
	let tbl = document.createElement('table');
	tbl.setAttribute('border', 'table');
	let thd = document.createElement('thead');
	let tbd = document.createElement('tbody');

	//thd쪽에 들어가야할 일,월화... 만들어야함
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	let tr = document.createElement('tr');

	days.forEach(day => {
		let td = document.createElement('th');
		td.innerHTML = day;
		tr.appendChild(td);
	})
	thd.appendChild(tr);
	//thd작업 끝

	//tbd쪽에 들어가야하는 것 정의
	tr = document.createElement('tr')
	//빈 날짜 만들어줌 1일의 위치를 잡아줌
	for (let i = 1; i < getFirstDay(month); i++) {
		let td = document.createElement('td');
		tr.appendChild(td);
	}
	//날짜 출력
	for (let d = 1; d <= getLastDate(month); d++) {
		let td = document.createElement('td');
		td.innerHTML = d;
		tr.appendChild(td);

		if ((d + getFirstDay(month) - 1) % 7 == 0) { //7일마다 줄바꿈.
			tbd.appendChild(tr);
			tr = document.createElement('tr')
		}

		//토요일은 배경색은 파랑색.
		if ((d + getFirstDay(month) - 1) % 7 == 0) {
			td.style.background = 'blue'
			td.style.color = "yellow"
		}
		//일요일은 배경색을 빨간색.
		if ((d + getFirstDay(month) - 2) % 7 == 0) {
			td.style.background = 'red'
			td.style.color = '#fbfbfb'
		}
		tbd.appendChild(tr);
		//7일 마다 줄바꿈
	}
	tbd.appendChild(tr);

	tbl.appendChild(thd);
	tbl.appendChild(tbd);

	document.getElementById('show').appendChild(tbl);
}
makeCalender(6);