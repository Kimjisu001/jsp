<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>

<h3>학생등록화면</h3>
<form action="addStudent.do" method="post">
	<table class="table">
		<tr>
			<th>학생번호</th>
			<td><input type="text" name="sno"></td>
		</tr>
		<tr>
			<th>학생이름</th>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><input type="text" name="bldType"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="등록하기"
				class="btn btn-primary"></td>
		</tr>
		</form>
		<%@include file="../public/footer.jsp"%>