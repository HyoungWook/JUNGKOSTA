<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-primary">무통장 입금</h4>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>제 품</th>
							<th>상품명</th>
							<th>판매자</th>
							<th>무통장 입금</th>
							<th>기간</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td><img alt="제목없음" src="${item.item_pic1}"></td>
								<td><a href="/Jungkosta/auction/auctionDetail?sale_id="${item.sale_id}>${item.item_name}</a></td>
								<td>${item.email}</td>
								<td>${item.purchase_cost }</td>
								<td>${item.purchase_deadline }</td>
								<td><button value="무통장 입금" id="${item.sale_id}"></button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>