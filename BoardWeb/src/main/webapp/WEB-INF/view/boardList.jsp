<%@page import="co.yedam.service.BoardServiceImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
List<BoardServiceImpl> list = (List<BoardVO>) request.getAttribute("boardList");
%>
<h3>게시글 목록</h3>
<table class = "table">
	<thead>
		<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<tr>
	</thead>
	
	<tbody>
		<%for (BoardVO vo : list) {%>
		<tr>
		<td><%=vo.getBoardNo() %></td>
		<td><%=vo.getTitle() %></td>
		<td><%=vo.getWriter() %></td>
		<td><%=vo.getClickCnt() %></td>
		</tr>
		<%} %>
	</tbody>
	
</table>


<%@include file="../public/footer.jsp"%>