<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../public/header.jsp"%>
                                                   

<h3>게시글 목록(boardList.jsp)</h3>


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
    <c:forEach var="vo" items="${boardList}">
        <tr>
            <td>${vo.boardNo}</td>
            <td><a href="getBoard.do?bno=${vo.boardNo}&page=${paging.page}"><c:out value="${vo.title}" /></a></td>
            <td><c:out value="${vo.writer}" /></td>
            <td><c:out value="${vo.clickCnt}" /></td>
        </tr>
    </c:forEach>
</tbody>
	
</table>
<body>

<h2>Centered Pagination</h2>

<div class="center">
  <div class="pagination">
  
  <!-- 이전페이지 있는지 여부 검사 -->
  <c:if test="${paging.prev }">
  <a href = "boardList.do?page=${paging.startPage-1 }">&laquo;</a>
  </c:if>
  
  <!-- 현재페이지 있는지 검사-->
<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
    <c:choose>
        <c:when test="${p == paging.page}">
            <a href="boardList.do?page=${p}" class="active"><c:out value="${p}" /></a>
        </c:when>
        <c:otherwise>
            <a href="boardList.do?page=${p}"><c:out value="${p}" /></a>
        </c:otherwise>
    </c:choose>
</c:forEach>
  
  <!-- 마지막 페이지 검사-->
   <c:if test="${paging.next }">
  <a href = "boardList.do?page=${pageing.endPage+1 }">&laquo;</a>
  </c:if>
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

