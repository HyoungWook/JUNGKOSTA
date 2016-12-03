<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
.div_ws{

padding-top:3.0em;
	
}
</style>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-primary">경매 무통장 입금</h4>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>제 품</th>
							<th>제 목</th>
							<th>판매자</th>
							<th>입금 기한</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="item">
							<tr>
								<td><img alt="제목없음" src="${item.item_pic1 }"></td>
								<td><div class="div_ws"><a href="/Jungkosta/auction/auctionDetail?sale_id=${item.sale_id }">${item.item_name }</a></div></td>
								<td><div class="div_ws">${item.email }</div></td>
								<td><div class="div_ws">${item.purchase_deadline }</div></td>
								<td><div class="div_ws"><button id="${item.sale_id }" class="btn btn-primary">무통장 입금</button></div></td>
							</tr>
						</c:forEach>						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>