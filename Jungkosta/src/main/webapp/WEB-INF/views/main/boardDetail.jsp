<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<style type="text/css">

.detail_ws{
	text-align: center;
}
#reply_td_ws{
	width:40.0em;
}

</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table">
					<tr>
						<th class="detail_ws">번 호</th>
						<td colspan="7">${board.board_id}</td>
					<tr>
					<tr>
						<th class="detail_ws">작성자</th>
						<td colspan="7">${board.name }</td>
					</tr>
					<tr>
						<th class="detail_ws">작성일</th>
						<td colspan="7">${board.write_date }</td>
					</tr>
					<tr>	
						<th class="detail_ws">조회수</th>
						<td colspan="7">${board.views_num }</td>
					</tr>
					<tr>
						<th class="detail_ws">제목</th>
						<td colspan="7">${board.title }</td>
					</tr>
					<tr>
						<th class="detail_ws">내용</th>
						<c:if test="${email == 'abc@naver.com'}">
							<td><a href="delete_board.jsp?board_id=${board.board_id }">삭제하기</a></td>
						</c:if>
						
					</tr>
					<tr>
						<td colspan="8">
						<pre>${board.content }</pre>
						</td>
					</tr>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<hr>
			</div>
			<div class="col-md-2"></div>
		</div>
		<c:if test="${email != null }">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<form class="form-horizontal" role="form" action="/Jungkosta/replyProc/${boardNum }">
						<div class="form-group">
							<label for="Name" class="col-xs-2 col-lg-2 control-label">${name }</label>
							<div class="col-xs-10 col-lg-10">
								<input type="text" class="form-control" placeholder="내용"
									name="content"> <input type="hidden"
									value="${name }" name="name">
									
								<input type="hidden" value="${boardNum }" name="board_id">
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table">
					<c:forEach items="${list }" var="item">
						<tr>
							<td>${item.name }</td>
							<td id="reply_td_ws">${item.content }</td>
							
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.write_date }"/></td>						
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>