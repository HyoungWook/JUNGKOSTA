<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- bootstrap -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- template -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>




<!-- plug in -->
<link rel="stylesheet" type="text/css"
	href="/Jungkosta/resources/css/auction/star-rating-svg.css">
<script src="/Jungkosta/resources/js/auction/jquery.star-rating-svg.js"></script>

<link rel="stylesheet" type="text/css"
	href="/Jungkosta/resources/css/main/purchase_info.css">

<script type="text/javascript"
	src="/Jungkosta/resources/js/main/purchase_info.js"></script>

<script type="text/javascript"
	src="/Jungkosta/resources/js/main/purchase_info_trade.js"></script>
<div class="container">

	<input type="hidden" id="name" value="${member.name }"> <input
		type="hidden" id="phoneNum" value="${member.phone_num }">
	<input type="hidden" id="address" value="${member.address }">	

	<div class="row">
		<div class="col-md-3">
			<%@ include file="menu.jsp"%>
		</div>

		<div class="col-md-9">
			<div class="main">
				<h2>구매 내역</h2>
				<hr>

				<h4>경매 주문 내역</h4>
				<table class="table" id="aucPurList_info">

					<thead>
						<tr>
							<th width="300">주문 정보</th>
							<th width="100">상태</th>
							<th width="100">비고</th>
						</tr>
					</thead>
					<tbody id="aucPurchase_list">
					</tbody>

				</table>

				<br> <br>

				<h4>일반 주문 내역</h4>
				<table class="table">
					<thead>
						<tr>
							<th width="300">주문 정보</th>
							<th width="100">상태</th>
							<th width="100">비고</th>
						</tr>
					</thead>
					<tbody id="salePurchase_list">
					</tbody>

				</table>

			</div>
		</div>

	</div>


	<div class="modal fade" id="review_Modal" tabindex="-1" role="dialog"
		aria-labelledby="saleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="reviewModalLabel">내 상품평</h4>
				</div>
				<div class="modal-body" align="center">
					<form id="auctionReview" method="Post">
						<div id="id_area"></div>

						<table class="table table-bordered">
							<tr>
								<td class="active">별점 평가</td>
								<td><div class="content">
										<span class="my-rating-9"></span> <span class="live-rating"></span>
									</div></td>
							</tr>
							<tr>
								<td class="active">상품명</td>
								<td><b id="item_name"></b></td>
							</tr>
							<tr>
								<td class="active">상품평</td>
								<td><textarea cols="60" rows="10" name="content"></textarea></td>
							</tr>
						</table>
						<button id="register" type="submit"
							class="btn btn-info button_header">등록하기</button>
					</form>
				</div>
			</div>

		</div>

	</div>


</div>

<script id="template" type="text/x-handlebars-template">
	<tr>
		<td>
			<div class='row'>
				<div class='col-md-5'>
					<div id='item_image'>
						<img alt='item_image' src='{{item_pic}}' >
					</div>
				</div>
				<div class='col-md-7'>
					<div id='info'>
						<a href='{{sale_id}}' class='goToDetail'><b>{{item_name}}</b></a><br><br>
						<p>주문 번호 : <span>{{bid_id}}</span></p>
						<p>구매 일자 : <span>{{date_fomat purchase_date}}</span></p>
						<p>금액 : <span>{{money_format cost}}</span></p>
					</div>
				</div>
			</div>
		</td>
		<td align='center'>{{status}}</td>
		<td align='center'>
			<button class='btn btn-sm'>배송 조회</button><br><br>
			{{#check st}}
				<button class='btn btn-sm aucAfter' data-toggle="modal"
					data-target="#review_Modal" >구매 확정</button>
			{{/check}}
				<input type='hidden' value='{{sale_id}}'>
				<input type='hidden' value='{{item_name}}'>
		</td>
	</tr>
	<tr>
		<td colspan='3' align='center'><a href='#' class='detail_view'>주문 상세정보 보기</a> </td>
	</tr>
	<tr class='hide'>
		<td colspan='3'>
			<div class='row'>
				<div class='col-md-offset-3'>
					<div>
						<h5>배송 정보</h5>
						<p>받는 사람 : {{receive_man}}<p>
						<p>휴대폰 : {{phoneNum}}</p>
						<p>주소 : {{address}}</p>
					</div>
				</div>
			</div>
		</td>
	</tr>
</script>

<script id="template_trade" type="text/x-handlebars-template">
	<tr>
		<td>
			<div class='row'>
				<div class='col-md-5'>
					<div id='item_image'>
						<img alt='item_image' src='{{item_pic}}' >
					</div>
				</div>
				<div class='col-md-7'>
					<div id='info'>
						<a href='{{sale_id}}' class='goToDetail'><b>{{item_name}}</b></a><br><br>
						<p>주문 번호 : <span>{{bid_id}}</span></p>
						<p>구매 일자 : <span>{{date_fomat purchase_date}}</span></p>
						<p>금액 : <span>{{money_format cost}}</span></p>
					</div>
				</div>
			</div>
		</td>
		<td align='center'>{{status}}</td>
		<td align='center'>
			<button class='btn btn-sm'>배송 조회</button><br><br>
			{{#check st}}
				<button class='btn btn-sm aucAfter' data-toggle="modal"
					data-target="#review_Modal" >구매 확정</button>
			{{/check}}
				<input type='hidden' value='{{sale_id}}'>
				<input type='hidden' value='{{item_name}}'>
		</td>
	</tr>
	<tr>
		<td colspan='3' align='center'><a class='detail_view'>주문 상세정보 보기</a> </td>
	</tr>
	<tr class='hide'>
		<td colspan='3'>
			<div class='row'>
				<div class='col-md-offset-3'>
					<div>
						<h5>배송 정보</h5>
						<p>받는 사람 : {{receive_man}}<p>
						<p>휴대폰 : {{phoneNum}}</p>
						<p>주소 : {{address}}</p>
					</div>
				</div>
			</div>
		</td>
	</tr>
</script>