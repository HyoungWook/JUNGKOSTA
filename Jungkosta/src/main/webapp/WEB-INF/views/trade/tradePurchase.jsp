<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>무통장입금 주문 완료 페이지</title>
<!-- bootstrap -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/Jungkosta/resources/js/trade/itemPurchase.js"></script>

<link href="/Jungkosta/resources/css/trade/tradePurchase.css" rel="stylesheet">

<div class="container">
	<div class="main">
		<input type="hidden" id="sale_id" value="${register.sale_id }">
		<input type="hidden" id="subca_id" value="${register.subca_id }">
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
								<th width="300"><strong> ${purchase.purchase_id } </strong></th>
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
										value="${purchase.purchase_cost }" pattern="#,### 원" />
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
							src="displayFile?fileName=${register.item_pic1 }"></td>
						<td><b>${register.item_name }</b></td>
						<td>${purchase.purchase_status }</td>
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
						<a href="/Jungkosta/trade/tradeList?subca_id=${register.subca_id }" class="btn btn-primary" id="check">확인</a>
					</c:when>
				<%-- 	<c:otherwise>
						<a href="#AucPay_modal" class="btn btn-primary"
							data-toggle="modal">결제하기</a>
					</c:otherwise> --%>
				</c:choose>
			</div>
		</div>



	</div>

</div>