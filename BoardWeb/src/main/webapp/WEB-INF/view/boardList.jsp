<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>

<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
PageDTO pageDTO = (PageDTO) request.getAttribute("paging");  
%>                                                     



<h3>게시글 목록</h3>


<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>


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
		<td><%=vo.getBoardNo()%></td>
		<td><a href= "getBoard.do?bno=<%=vo.getBoardNo()%>"><%=vo.getTitle() %></a></td>
		<td><%=vo.getWriter() %></td>
		<td><%=vo.getClickCnt() %></td>
		</tr>
		<%} %>
	</tbody>
	
</table>
<body>

<h2>Centered Pagination</h2>

<div class="center">
  <div class="pagination">
  
  <!-- 이전페이지 있는지 여부 검사 -->
  <%if (pageDTO.isPrev()){ %>
  <a href = "boardList.do?page=<%=pageDTO.getStartPage()-1%>">&laquo;</a>
  <%} %>
  
  <!-- 현재페이지 있는지 검사-->
  <%for(int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage();p++) {%>
  <%  if (p==pageDTO.getPage()) { %>
  <a href="boardList.do?page=<%=p %>"class="active"><%=p %></a>
  <%} else{ %>
  <a href = "boardList.do?page=<%=p %>"><%=p %></a>
  <%} }%>
  
  
  
  <!-- 마지막 페이지 검사-->
    
  <%if (pageDTO.isNext()){ %>
  <a href = "boardList.do?page=<%=pageDTO.getEndPage() + 1%>">&laquo;</a>
  <%} %>
    </div>
</div>

  
  
  <!-- 
  <a href="#">1</a>
  <a href="#" class="active">2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">6</a>
  <a href="#">&raquo;</a>
   -->
  


</body>

<%@include file="../public/footer.jsp"%>

