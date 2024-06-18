
console.log(employees); //강력새로고침

let result = [23, 45, 22, 39, 10, 56]
//새로운 배열에 담아주는게 filter
result.filter(function(item, idx, ary) {
	if (item % 2 == 0) {
		return false;
	}
	return true;
});
console.log(result);

//employees.forEach(console.log);

// 급여가 5000이 넘는 여자만 필터링.

let over5000 = [];
let over5000Sum = [];

let filterFnc = emp => emp.gender == 'Female' && emp.salary > 5000;

filterFnc = function(emp) {
	return emp.gender == 'Female' && emp.salary > 5000;
}
//[A,A,A]->[A,A]
//over5000 = employees.filter(filterFnc);
employees.filter(filterFnc).forEach(function(emp) {
	over5000Sum += emp.salary;
});


console.log('조건을 만족하는 사람 급여 합:' + over5000Sum);

//[A,A,A] -> [A',A',A'] map을 쓰면 형태를 바꿀수 있음
employees
	.map(function(elem, idx, ary) {
		const obj = {}
		obj.name = elem.first_name + ' ' + elem.last_name;
		obj.no = elem.id;
		obj.salary = elem.salary;
		return obj;
	})
	.forEach(console.log);
