<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#number_ws{
		width: 10.0em;	
	}
	
	#writer_ws{
		width:10.0em;
	}
	#views_num_ws{
		width:10.0em;
	}
	.item_ws{
		text-align: center;
	}
	#page_num_ws{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h3 class="text-primary" id="title_ws">커뮤니티</h3>
				<table class="table table-hover">
					<thead>
						<tr>
							<th id="number_ws" class="item_ws">번 호</th>
							<th>제 목</th>
							<th id="writer_ws" class="item_ws">글쓴 이</th>
							<th id="views_num_ws" class="item_ws">조회 수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td class="item_ws">${item.board_id }</td>
								<td><a href="board_detail.jsp?board_id=${item.board_id }">${item.title }</a></td>
								<td class="item_ws">${item.name }</td>
								<td class="item_ws">${item.views_num }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
		<div class="col-md-1"></div>
			<div class="col-md-10">
			<hr>
			<c:if test="${email != null }">
				<a href="write_board.jsp" class="a_ws">글 쓰기</a>
			</c:if>
			</div>
		<div class="col-md-1"></div>	
		</div>
		<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4" id="page_num_ws">
			<c:if test="${listModel.startPage > 5 }">
				<a href="boardList.jsp/${listModel.startPage-5 }">[이전]</a>
			</c:if>
			<c:forEach var="pageNo" begin="${listModel.startPage }" end="${listModel.endPage }">
			
				<c:choose>
					<c:when test="${listModel.requestPage != pageNo }">
						<a href="boardList.jsp/${pageNo }">[${ pageNo}]</a>
					</c:when>
					<c:otherwise>
						<a href="boardList.jsp/${pageNo }"><b>[${ pageNo}]</b></a>
					</c:otherwise>	
				</c:choose>
				
			
			</c:forEach>
			
			<c:if test="${listModel.endPage < listModel.totalPageCount }">
				<a href="board.jsp?pageNum=${listModel.startPage-5 }">[이후]</a>
			</c:if>
		</div>
		<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>