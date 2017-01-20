<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>views/cafe/list.jsp</title>
<link rel="stylesheet" 
	href="${pageContext.request.contextPath }/resource/css/bootstrap.css" />
</head>
<body>
<div class="container">
<h3>카페 글 목록입니다.</h3>
<a href="private/insertform.do">새글쓰기</a>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="tmp" items="${list }">
		<tr>
			<td>${tmp.num }</td>
			<td><a href="detail.do?num=${tmp.num }">${tmp.title }</a></td>
			<td>${tmp.writer }</td>
			<td>${tmp.viewCount }</td>
			<td>${tmp.regdate }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<ul class="pagination">
		<c:choose>
			<c:when test="${startPageNum ne 1 }">
				<li>
					<a href="list.do?pageNum=${startPageNum-1 }">&laquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a href="javascript:">&laquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${i eq pageNum }">
					<li class="active">
						<a href="list.do?pageNum=${i }">${i }</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="list.do?pageNum=${i }">${i }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum lt totalPageCount }">
				<li>
					<a href="list.do?pageNum=${endPageNum+1 }">&raquo;</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="disabled">
					<a class="muted" href="javascript:">&raquo;</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</body>
</html>








