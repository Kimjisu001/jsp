document.getElementById('dom').remove();




const obj = {
	data: '',
	fields: ['id', 'first_name', 'email', 'salary'],
	showList: function(ary = []) {
		ary.forEach((emp, idx) => {
			if (idx < 5)
				document.querySelector('#list').appendChild(this.makeRow(emp));
		});
	},
	makeRow(emp = { id, first_name, email, salary }) {
		let tr = document.createElement('tr');
		this.fields.forEach(field => {
			let td = document.createElement('td');
			td.innerText = emp[field];
			tr.appendChild(td);
		});
		return tr;
	}
	
}
obj.showList(employees);

//추가 버튼 클릭 시 사번, 이름, 이메일, 급여 저장
document.getElementById('addBtn').addEventListener('click', function(e) {
	const employee = {
		id: document.getElementById('mid').value,
		first_name: document.getElementById('mname').value,
		email: document.getElementById('mphone').value,
		salary: document.getElementById('mpoint').value
	}
	//목록에 추가
	document.querySelector('#list').appendChild(obj.makeRow(employee));

})