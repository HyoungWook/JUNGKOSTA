<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<title>경매 주문 완료 페이지</title>
<!-- bootstrap -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/Jungkosta/resources/js/auction/auctionPurchase.js"></script>

<link href="/Jungkosta/resources/css/auction/auctionPurchase.css"
	rel="stylesheet">


<div class="container">

	<div class="main">
		<input type="hidden" id="sale_id" value="${sale_id }">

		<br> <br> <br>


		<div class="row">
			<div class="col-md-offset-3 col-md-6" align="center">
				<b>해당 물품의 주문이 완료 되었습니다.</b>
			</div>
		</div>

		<br>

		<div class="row">
			<div class="col-md-offset-3 col-md-6">

				<div class="form_phw">
					<table>
						<thead>
							<tr>
								<th width="200">주문 번호 :</th>
								<th width="300"><strong> ${purchase.bid_id } </strong></th>
							</tr>
						</thead>
						<tr>
							<td>구매 일자 :</td>
							<td><span> <fmt:formatDate
										value="${purchase.purchase_date}" type="both"
										pattern="yyyy년 MM월 dd일 aa hh시 mm분" />
							</span></td>
						</tr>
						<tr>
							<td>입금 계좌 :</td>
							<td><strong>${admin.bank_name } /
									${admin.account_num }</strong></td>
						</tr>
						<tr>
							<td>입금 금액 :</td>
							<td><strong> <fmt:formatNumber
										value="${purchase.total_cost }" pattern="#,### 원" />
							</strong></td>
						</tr>
						<tr>
							<td>입금 기한 :</td>
							<td><strong> <fmt:formatDate
										value="${purchase.purchase_deadline }" type="both"
										pattern="yyyy년 MM월 dd일 aa hh시 mm분" /> 까지
							</strong></td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<br>

		<div class="row">
			<div class="col-md-offset-3 col-md-6">

				<table class="table" id="product_info_phw">
					<tr>
						<td colspan="2">주문 정보</td>
						<td>상태</td>
						<td>비고</td>
					</tr>
					<tr>
						<td><img alt="product_image"
							src="displayFile?fileName=${item.item_pic1 }"></td>
						<td><b>${item.item_name }</b></td>
						<td>${purchase.bid_status }</td>
						<td></td>
					</tr>
				</table>

			</div>
		</div>

		<div class="row">
			<div class="button_phw">
				<input type="hidden" id="payment_method"
					value="${purchase.payment_method }">
				<c:choose>
					<c:when test="${purchase.payment_method == '무통장입금' }">
						<a href="#" class="btn btn-primary" id="check">확인</a>
					</c:when>
					<c:otherwise>
						<a href="#AucPay_modal" class="btn btn-primary"
							data-toggle="modal">결제하기</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>



	</div>

	<div class="modal fade" id="AucPay_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="payForm" method="post">
					<input type="hidden" id="total_cost"
						value="${purchase.total_cost }"> <input type="hidden"
						name="bid_id" id="bid_id" value="${purchase.bid_id }">
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
									<p>비밀번호 :</p>
								</div>
								<div class="col-md-5">
									<input maxlength="4" class="form-control" type="password"
										placeholder="비밀번호 4자리 입력">
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
							id="complete_btn">완료</button>
						<button type="button" class="payForm_btn btn btn-primary"
							id="fail_btn">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>