<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
.mr_overflow_ws{
	overflow:hidden;
}
.mr_middle_ws{
	text-align: center;
}
.mr_a_ws{
	text-decoration: none;
}
.mr_a_black_ws{
	color:black;
}
.mr_a_red_ws{
	color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/Jungkosta/resources/js/main/messageReceive.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
		
		<div class="col-md-2"></div>
			<div class="col-md-8">
				<h4 class="text-primary">메시지 함</h4>
					<hr>
					<div class="row">
					<div class="col-md-2 mr_middle_ws">번호</div>
					<div class="col-md-5">제목</div>
					<div class="col-md-3 mr_middle_ws">보낸 사람</div>
					<div class="col-md-2 mr_middle_ws">날짜</div>	
					</div>
					
					<c:forEach items="${list }" var="item" varStatus="status">
					<hr>
					<div class="row">
					<div class="col-md-2 mr_middle_ws">${status.count }</div>
					<div class="col-md-5 mr_overflow_ws">
					<c:if test="${item.message_isread eq 'N' }">
						<a href="/Jungkosta/messageDetailForm/${item.message_id }" class="mr_a_ws mr_a_red_ws">${item.title}</a>
					</c:if>
					<c:if test="${item.message_isread eq 'Y' }">
						<a href="/Jungkosta/messageDetailForm/${item.message_id }" class="mr_a_ws mr_a_black_ws">${item.title}</a>
					</c:if>
					</div>
					<div class="col-md-3 mr_overflow_ws mr_middle_ws">${item.sender }</div>
					<div class="col-md-2 mr_middle_ws"><fmt:formatDate value="${item.send_time }" pattern="yyyy-MM-dd"/></div>	
					</div>
					</c:forEach>
			</div>
		<div class="col-md-2"></div>	
		
		</div>
	</div>
</body>
</html>