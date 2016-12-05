<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- 현우 추가 부분 -->
<script type="text/javascript"
	src="/Jungkosta/resources/js/auction/mainAucList.js"></script>

<style type="text/css">
.div_ws {
	padding-top: 3.0em;
}
</style>

</head>
<body>
	<div class="container">
		<div class="row">
			<!-- start 현우 추가부분 -->
			<div class="col-md-3">
				<%@ include file="menu.jsp"%>
			</div>


			<div class="col-md-9">

				<br>
				<br>

				<!-- end 현우 추가부분 -->

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
								<td><div class="div_ws">
										<a
											href="/Jungkosta/auction/auctionDetail?sale_id=${item.sale_id }">${item.item_name }</a>
									</div></td>
								<td><div class="div_ws">${item.email }</div></td>
								<td><div class="div_ws">${item.purchase_deadline }</div></td>
								<td><div class="div_ws">
										<%-- <button id="${item.sale_id }" class="btn btn-primary">무통장
											입금</button> --%>

										<!-- 현우 추가부분 -->
										<a href="#AucPay_modal" class="btn btn-primary pay_btn"
											data-toggle="modal">무통장 입금</a> <input type="hidden"
											value="${item.sale_id }">
										<!-- 현우 추가부분 -->
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<!-- start 현우 추가 부분 -->
		<div class="modal fade" id="AucPay_modal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">



			<div class="modal-dialog">
				<div class="modal-content">
					<form id="payForm" method="post">
						<div id="sale_area"></div>
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">결제 하기</h4>
						</div>
						<div class="modal-body">


							<div class="bank">
								<div class="row">
									<div class="col-md-offset-2 col-md-3">
										<p>은행 명 :</p>
									</div>
									<div class="col-md-5">
										<select class="form-control">
											<option>선택</option>
											<option>국민은행</option>
											<option>신한은행</option>
											<option>농협</option>
										</select>
									</div>
								</div>

								<br>

								<div class="row">
									<div class="col-md-offset-2 col-md-3">
										<p>계좌번호 :</p>
									</div>
									<div class="col-md-5">
										<input class="form-control" type="text"
											placeholder="'-'를 생략하고 입력하세요">
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-offset-2 col-md-3">
										<p>금액 :</p>
									</div>
									<div class="col-md-5">
										<div class="input-group">
											<input class="form-control" id="cost" name="cost" type="text"
												placeholder="금액을 입력하세요."><span
												class="input-group-addon"> 원 </span>
										</div>
									</div>
								</div>
								<br>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="payForm_btn btn btn-default"
								id="deposit_btn">입금하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- start 현우 추가 부분 -->

	</div>
</body>
</html>