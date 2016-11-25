<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<title>경매 주문 페이지</title>

<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- style -->

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="/Jungkosta/resources/css/auction/auctionPurchaseForm.css">


<!-- jQuery -->
<script type="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="/Jungkosta/resources/js/auction/auctionPurchaseForm.js"></script>

<!-- daum map api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script
	src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript"
	src="/Jungkosta/resources/js/auction/daumApi.js"></script>


<body>
	<div class="container">
		<form id="auctoin_purchase" method="post">
			<input type="hidden" name="sale_id" id="sale_id" value="${item.sale_id }">
			<input type="hidden" name="sale_id" id="bidding_id" value="${bidding.bidding_id }">
			<h2>낙찰 상품 주문하기</h2>
			<div class="row">
				<div class="col-md-offset-1 col-md-4 left_ktw">
					<h3>배송 정보</h3>
					<br> <br>

					<h4>이름</h4>
					<h4>
						<input type="text" class="form-control korean"
							placeholder="이름(한글만 가능)" value="${member.name }" name="name">
					</h4>
					<br>
					<h4>전화번호</h4>
					<h5 class="tel form-group">
						<input type="text" class="form-control phone_num"
							placeholder="'-'없이 입력" value="${member.phone_num }"
							name="phone_num">
					</h5>
					<br>
					<div class="addressForm_ktw form-group">
						<h4>주소</h4>

						<div class="row">
							<div class="col-md-9 addressForm_ktw">
								<input type="text" class="form-control address_ktw"
									id="sample4_postcode" name="postCode" placeholder="우편번호"
									value="${address1 }" />


							</div>
							<div class="col-md-3">
								<input type="button" id="sample4_postcode"
									class="btn btn-primary" value="우편번호 찾기"
									onClick="sample4_execDaumPostcode()">

							</div>
						</div>

						<h4>상세주소</h4>
						<h5>
							<input type="text" class="form-control" id="sample4_roadAddress"
								name="address" placeholder="도로명주소" value="${address2 }" /><br>
							<input type="text" class="form-control" id="sample4_jibunAddress"
								name="address" placeholder="상세주소" value="${address3 }" /><br>
						</h5>
						<div id="layer">
							<img
								src="//i1.daumcdn.net/localimg/localimage_ktws/07/postcode/320/close.png"
								id="btnCloseLayer" alt="닫기 버튼">
						</div>
					</div>
					<br>
					<hr>

					<h4>결제수단</h4>
					<!-- 	<br> <br>
					 -->
					<div class="row" align="center">
						<br> <label class="pay_method" for="deposit">무통장 입금</label> <input
							class="payment_phw" type="radio" name="payment_method"
							value="무통장입금" id="deposit" checked="checked"> <label
							class="pay_method" for="transfer">실시간 계좌이체</label> <input
							class="payment_phw" type="radio" name="payment_method"
							value="실시간계좌이체" id="transfer"> <label class="pay_method"
							for="card">카드 결제</label> <input class="payment_phw" type="radio"
							name="payment_method" value="카드결제" id="card"> <br>
						<hr>
					</div>
					<div class="bank">
						<div class="deposit apper_phw">
							<label for="deposit_bank">은행 : </label> <select name="bank"
								id="deposit_bank">
								<option>신한 은행</option>
								<option>국민 은행</option>
								<option>농협</option>
							</select> <br> <label>예금주 :</label> <input type="text" name="name"
								size="20">
						</div>

						<div class="transfer hide_phw">
							<label for="transfer_bank">은행 : </label> <select name="bank"
								id="transfer_bank">
								<option>신한 은행</option>
								<option>국민 은행</option>
								<option>농협</option>
							</select>
						</div>

						<div class="card hide_phw">
							<label for="card_company ">카드사 : </label> <select name="bank"
								id="card_company">
								<option>신한 카드</option>
								<option>국민 카드</option>
								<option>농협 카드</option>
							</select>
						</div>

					</div>

					<br>
				</div>
				<div class="col-md-offset-1 col-md-6 right_ktw">
					<h3>주문 상품</h3>
					<br>
					<div class="row">
						<div class="col-md-offset-1 col-md-2">
							<div id="item_sub_imgs_ktw">
								<img alt="" src="displayFile?fileName=${item.item_pic1}">
							</div>
							<br>
						</div>
						<div class="col-md-offset-2 col-md-7">
							<div id="item_num_name_ktw">입찰 번호 : ${bidding.bidding_id }</div>
							<br>
							<div>
								입찰일 : <b> <fmt:formatDate value="${bidding.bidding_time}"
										dateStyle="long" />
								</b>
							</div>
							<br>

							<div>상품명 : ${item.item_name } / 1개</div>
						</div>

						<br>

					</div>
					<br> <br> <br>
					<hr>
					<div class="row">
						<div class="col-md-offset-1">
							<br>
							<h3>주문 가격 정보</h3>
						</div>
						<br>

						<div class="row">
							<div class="col-md-offset-3 col-md-3">
								<p align="right">총 상품 가격 :</p>
							</div>
							<div class="col-md-offset-1 col-md-5">
								<p align="right" id="product_cost">${item.item_cost }</p>
							</div>
						</div>

						<div class="row">
							<div class="col-md-offset-3 col-md-3">
								<p align="right">배송료 :</p>
							</div>
							<div class="col-md-offset-1 col-md-5">
								<p align="right">2,500 원</p>
							</div>
						</div>

						<div class="row">
							<div class="col-md-offset-3 col-md-3">
								<p align="right">
									수수료(<span id="charge_type"></span>) :
								</p>
							</div>
							<div class="col-md-offset-1 col-md-5">
								<p align="right" id="charge_cost"></p>
							</div>
						</div>

						<hr>

						<div class="row">
							<div class="col-md-offset-3 col-md-3">
								<p align="right">총 주문 금액 :</p>
							</div>
							<div class="col-md-offset-1 col-md-5">
								<p align="right" id="total_cost"></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-offset-7 col-md-5">
								<div class="mileage_info_style" align="right">
									<span>적립금 : </span><b id="mileage"></b>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div align="right" id="payment_btn">
				<button class="btn btn-lg" type="submit">주문하기</button>
				<button class="btn btn-lg" type="button" id="cancel">취소</button>
			</div>

		</form>
	</div>
</body>