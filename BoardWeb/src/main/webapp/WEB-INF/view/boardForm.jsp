<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="../public/header.jsp"%>
<!DOCTYPE html>

<h3>게시판 등록</h3>
<form action="addBoard.do" >
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="등록하기"
				class="btn btn-primary"></td>
		</tr>
	</table>
	</form>
<%@include file="../public/footer.jsp"%>