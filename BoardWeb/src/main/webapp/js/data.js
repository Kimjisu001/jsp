const myMembers = [
	{id: 'user01',name:'홍길동', phone: '010-0000-1111', point:90},//new Object();
	{id: 'user02',name:'김홍씨', phone: '010-1000-1111', point:95},//new Object();
	{id: 'user03',name:'김달홍', phone: '010-1300-1111', point:100}//new Object();
]; //new Array()

const json = `[{"id":1,"first_name":"Winston","last_name":"Kyle","email":"wkyle0@com.com","gender":"Male","salary":4927},
{"id":2,"first_name":"Jessi","last_name":"Spurrior","email":"jspurrior1@nifty.com","gender":"Female","salary":4545},
{"id":3,"first_name":"Barnebas","last_name":"Cuttell","email":"bcuttell2@google.fr","gender":"Male","salary":5689},
{"id":4,"first_name":"Fionnula","last_name":"Beaudry","email":"fbeaudry3@wufoo.com","gender":"Female","salary":3988},
{"id":5,"first_name":"Ginevra","last_name":"Brabbs","email":"gbrabbs4@nytimes.com","gender":"Female","salary":3670},
{"id":6,"first_name":"Shelley","last_name":"Pocock","email":"spocock5@unblog.fr","gender":"Male","salary":5078},
{"id":7,"first_name":"Redford","last_name":"Gallihawk","email":"rgallihawk6@msn.com","gender":"Male","salary":5749},
{"id":8,"first_name":"Catarina","last_name":"Collomosse","email":"ccollomosse7@bandcamp.com","gender":"Female","salary":6494},
{"id":9,"first_name":"Thedric","last_name":"Anstee","email":"tanstee8@geocities.com","gender":"Male","salary":4000},
{"id":10,"first_name":"Megan","last_name":"Freestone","email":"mfreestone9@businessweek.com","gender":"Female","salary":4333},
{"id":11,"first_name":"Benjamen","last_name":"Mc Gee","email":"bmcgeea@virginia.edu","gender":"Male","salary":5644},
{"id":12,"first_name":"Bear","last_name":"Setterthwait","email":"bsetterthwaitb@seesaa.net","gender":"Male","salary":6053},
{"id":13,"first_name":"Dirk","last_name":"Cranage","email":"dcranagec@accuweather.com","gender":"Male","salary":6507},
{"id":14,"first_name":"Lauralee","last_name":"Larret","email":"llarretd@parallels.com","gender":"Female","salary":3483},
{"id":15,"first_name":"Carly","last_name":"Horley","email":"chorleye@china.com.cn","gender":"Female","salary":7584}]`;

//자바스크립트 객체로 만들어줌
const employees =  JSON.parse(json);