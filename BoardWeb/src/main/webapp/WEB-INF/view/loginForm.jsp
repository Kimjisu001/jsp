<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<!-- 만든 태그 사용방법 1-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../public/header.jsp" /><!-- 남이 만들어 놓은 태그 사용 1-->
<h3>로그인 화면(loginForm.jsp)</h3>
<myTag:line />
<!-- 만든 태그 사용방법 3-->
<!-- JSP standard tag library 를 가져와서 사용 (남이 만들어 놓은 태그 사용 1-->

<c:set var="name" value="hong"></c:set>

<form action="login.do">

	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id">
			<td></td>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw">
			<td></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="로그인">
		</tr>
	</table>
</form>
<%@include file="../public/footer.jsp"%>
