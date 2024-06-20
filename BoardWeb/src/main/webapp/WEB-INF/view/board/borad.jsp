<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 남이 사용한 코드 사용 방법 깔끔하게 구문 만드는 방법  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
div.reply div {
	magin: auto;
}

div.reply ul {
	list-style-type: none;
	magin-top: 3px;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}
</style>
<h3>상세화면</h3>
<form name="myFrm" action="removeForm.do">
	<input type="hidden" value="${page }" name="page"> <input
		type="hidden" value="${board.boardNo }" name="bno"> <input
		type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">
	<table class='table'>

		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-3">${board.boardNo }</td>

			<th class="col-sm-1">조회수</th>
			<td class="col-sm-2">${board.clickCnt}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="3" cols="80">${board.content}</textarea>
			</td>
		</tr>

		<tr>
			<td>작성자</td>
			<td colspan="3">${board.writer}</td>
		</tr>

		<tr>
			<td>작성일시</td>
			<td colspan="3">${board.creationDate}</td>
		</tr>

		<tr>
			<td>조회수</td>
			<td colspan="3">${board.title}</td>
		</tr>
		
		<tr>
			<td>삭제</td>
			<td colspan="3">${board.title}</td>
		</tr>

		<tr align="center">
			<td colspan="3">
				<!-- if else 구문 -->
				<c:choose>
					<c:when test="${!empty logId && logId==board.writer}">
						<button type="submit" class="btn btn-outline-primary">삭제 이동</button>
						<button type="button" class="btn btn-warning">수정 이동</button>
					</c:when>
					<c:otherwise>
						<button type="submit" disabled class="btn btn-outline-primary">삭제 이동</button>
						<button type="button" disabled class="btn btn-warning">수정 이동</button>
					</c:otherwise>
				</c:choose>
	<button type="button" class="btn btn-outline-primary">목록으로 이동하기</button>
	</table>

</form>
<!-- 댓글관련 시작. -->
<!-- 목록가져오기 -->
<div class="container reply">

	<div class="header">
	<input class = "col-sm-8" id = "reply">
	<button class = "col-sm-3" id = "addReply">등록</button> 
	
		<div class="content">
		<ul>
			<li><span class="col-sm-2">글번호</span> <span class="col-sm-4">댓글내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-2">작성일시</span>
			</li>
			<li><hr /></li>
			<li style="display: none"><span class="col-sm-2">3</span> <span
				class="col-sm-4">글 잘봤어용</span> <span class="col-sm-2">user01</span>
				<span class="col-sm-2">2024-05-08 13:22:34</span> 
				<span class="col-sm-1"><button onclick="deleteRow(event)">삭제</button></span></li>
		</ul>
		</div>

	</div>

</div>


<!-- 댓글관련 끝. -->
<script>
	//jsp페이지에 담아놓고
	const bno = "${board.boardNo }";
	//
    const replyer = "${logId}";
	//이벤트 핸들러를 발생 시키세요
	document.querySelector('button.btn-warning').addEventListener('click',
			function(e) {
				document.forms.myFrm.action = "modifyForm.do";
				document.forms.myFrm.submit();
			});
	//삭제화면 이동일 경우에는 removeForm.do
	//수정 화면이동으로 처리할 경우에는 action = "modifyForm.do"
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>
