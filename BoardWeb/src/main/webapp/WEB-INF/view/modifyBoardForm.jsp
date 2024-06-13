<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../public/header.jsp"%>
<!-- 모디파이보드 -->
<h3>수정화면</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>

<form action="modifyBoard.do" >
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" readonly value="<%=board.getBoardNo()%>"
				name="bno"></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" value="<%=board.getTitle()%>"
				name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" name="content"><%=board.getContent()%></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=board.getCreationDate()%></td>
		</tr>
		<tr>
			<td colspan="4"><input class="btn btn-warning" type="submit"></td>
		</tr>

	</table>
</form>
<%@include file="../public/footer.jsp"%>