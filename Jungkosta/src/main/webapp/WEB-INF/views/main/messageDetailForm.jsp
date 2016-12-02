<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/Jungkosta/resources/js/auction/auctionMessage.js"></script>

<title>Insert title here</title>



<style type="text/css">
.md_center_ws {
	
}
</style>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h4 class="text-primary">상세 정보</h4>
				<table class="table table-bordered">
					<tr>
						<td class="md_center_ws">보낸 사람</td>
						<td>${message.sender }</td>
					</tr>
					<tr>
						<td class="md_center_ws">받는 사람</td>
						<td>${message.receiver }</td>
					</tr>
					<tr>
						<td class="md_center_ws">제목</td>
						<td>${message.title }</td>
					</tr>
					<tr>
						<td class="md_center_ws">보낸 시간</td>
						<td><fmt:formatDate value="${message.send_time}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td class="md_center_ws">내용</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2" id="content">${message.content }</td>
					</tr>
				</table>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>