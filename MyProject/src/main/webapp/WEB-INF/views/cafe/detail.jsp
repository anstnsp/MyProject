<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>views/cafe/detail.jsp</title>
<style>
	.content{ border: 1px solid blue;}
</style>
</head>
<body>
<c:if test="${dto.prevNum ne 0 }">
	<a href="detail.do?num=${dto.prevNum }">이전글</a>
</c:if>
<c:if test="${dto.nextNum ne 0}">
	<a href="detail.do?num=${dto.nextNum }">다음글 </a>
</c:if>
<h3>상세글 내용 페이지</h3>
<table>
	<tr>
		<th>글번호</th>
		<td>${dto.num }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${dto.title }</td>
	</tr>
</table>
<div class="content">${dto.content }</div>


<%-- 로그인한 회원이 작성한 글이라면 수정 링크를 제공해준다. --%>
<c:if test="${id eq dto.writer }">
	<a href="private/updateform.do?num=${dto.num }">수정</a>
	<a href="javascript:deleteCheck()">삭제</a>
	
</c:if>
<c:if test="${!empty id }">
	<form action="comment.do?num=${dto.num }" method="post">
	
	<input type="text" name="comment" id="comment" size=30/>
	
	<button id="ok" type="submit">댓글달기</button>
	</form>
</c:if>
	<c:forEach var="tmp" items="${list }">
	${tmp.content }
	</c:forEach>
	
	<script src="${pageContext.request.contextPath }/resource/js/jquery-3.1.1.js"></script>
<script>
	function deleteCheck(){
		var isDelete=confirm("글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="private/delete.do?num=${dto.num}";
		
	}
	
		
	});
	

</script>
</body>
</html>











