<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>ajax 연습</h3>
<div id="register">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" id="uid"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="upw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" id="uname"></td>
		</tr>

		<tr>
			<th>권한</th>
			<td><select id="auth">
				<option value="User">사용자</option>
				<option value="Admin">관리자</option>
				
			</select></td>
		</tr>
		<tr>
		<td colspan ="2"><button id = "addBtn">등록</button>
	</table>
</div>

<script src="js/ajax3.js">
</script>