<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<title>경매 주문 완료 페이지</title>

<link href="/Jungkosta/resources/css/auction/auctionPurchase.css"
	rel="stylesheet">


<div class="container">

	<div class="main">

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
							<td><span> ${purchase.purchase_date} </span></td>
						</tr>
						<tr>
							<td>입금 계좌 :</td>
							<td><strong>입금 계좌</strong></td>
						</tr>
						<tr>
							<td>입금 금액 :</td>
							<td><strong> ${purchase.total_cost } </strong></td>
						</tr>
						<tr>
							<td>입금 기한 :</td>
							<td><strong> ${purchase.purchase_deadline } </strong></td>
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
				<button type="button" class="btn btn-primary btn-lg">확인</button>
			</div>
		</div>



	</div>
</div>