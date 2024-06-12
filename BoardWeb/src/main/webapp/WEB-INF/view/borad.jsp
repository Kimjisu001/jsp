<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="../public/header.jsp"%>

<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>


<table class='table'>

	<tr>
		<th class="col-sm-1">글번호</th>
		<td class="col-sm-3"><%=board.getBoardNo()%>
		<th class="col-sm-1">조회수</th>
		<td class="col-sm-2"><%=board.getClickCnt()%>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="3"><%=board.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
		<textarea rows="3" cols="80"><p><%=board%></p></textarea>
		</td>
	</tr>

	<tr>
		<td>작성자</td>
		<td colspan="3"><%=board.getWriter()%></td>
	</tr>
    <tr>
		<td>작성일시</td>
		<td colspan="3"><%=board.getCreationDate()%></td>
	</tr>


	<tr>
		<td>조회수</td>
		<td colspan="3"><%=board.getTitle()%></td>
	</tr>
</table>



<%@include file="../public/footer.jsp"%>