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


<div class=container>

	<div class="main">
		<form method="post">

			<h2>경매 낙찰 상품 주문</h2>

			<hr>

			<div class="product_info">
				<div class="row">
					<div class="col-md-offset-2">
						<h4>상품 정보</h4>

						<br>

						<table id="payment_date">
							<tr>
								<td width="200px" align="center">낙찰일 : <b> <span>날짜</span>
								</b>
								</td>
								<td width="200px" align="center">낙찰 번호 : <b> <span>번호</span> </b>
								</td>
							</tr>
						</table>

						<br>

						<table id="item_info">
							<tr>
								<th width="150"></th>
								<th width="450"></th>
							</tr>
							<tr>
								<td align="center"><img alt="thumbnale" src=""></td>
								<td>
									<div class="row">
										<div class="col-md-offset-2">${sale.item_name }/1개</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<br> <br>

			<div class="member_info">
				<div class="row">
					<div class="col-md-offset-2">
						<h4>받는 사람 정보</h4>
						<br>
						<table>
							<tr height="50px">
								<td width="200">
									<div class="row">
										<div class="col-md-offset-3">수령인</div>
									</div>
								</td>
								<td width="600">
									<div class="row">
										<div class="col-md-offset-1">이름 </div>
									</div>
								</td>
							</tr>
							<tr height="50px">

								<td>
									<div class="row">
										<div class="col-md-offset-3">연락처</div>
									</div>
								</td>
								<td><div class="row">
										<div class="col-md-offset-1">연락처</div>
									</div></td>
							</tr>
							<tr height="50px">
								<td>
									<div class="row">
										<div class="col-md-offset-3">주소</div>
									</div>
								</td>
								<td><div class="row">
										<div class="col-md-offset-1">주소</div>
									</div></td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<br> <br> <br>

			<div id="payment_info">
				<div class="row">
					<div class="col-md-offset-2">
						<h4>주문 정보</h4>
						<br>
						<table>
							<tr>
								<td colspan="3">결제 수단</td>
								<td></td>
							</tr>
							<tr>
								<td height="100"><label for="deposit">무통장 입금</label> <input
									class="payment_phw" type="radio" name="payment_method"
									value="무통장입금" id="deposit" checked="checked"></td>
								<td><label for="transfer">실시간 계좌이체</label> <input
									class="payment_phw" type="radio" name="payment_method"
									value="실시간계좌이체" id="transfer"></td>
								<td><label for="card">카드 결제</label> <input
									class="payment_phw" type="radio" name="payment_method"
									value="카드결제" id="card"></td>
								<td width="500" rowspan="2" class="payment_info_style">
									
									<div class="col-md-offset-1">
										<br>
										<b>주문 가격 정보</b>
									</div>
									
									<br>
									
									<div class="row">
										<div class="col-md-offset-3 col-md-3">
											<p align="right">총 상품 가격 :</p>
										</div>
										<div class="col-md-offset-1 col-md-5">
											<p align="right" id="product_cost">500,000 원</p>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-offset-3 col-md-3">
											<p align="right" >배송료 :</p>
										</div>
										<div class="col-md-offset-1 col-md-5">
											<p align="right">2,500 원</p>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-offset-3 col-md-3">
											<p align="right" >수수료(<span id="charge_type"></span>) :</p>
										</div>
										<div class="col-md-offset-1 col-md-5">
											<p align="right" id="charge_cost">3,000 원</p>
										</div>
									</div>
									
									<hr>
									
									<div class="row">
										<div class="col-md-offset-3 col-md-3">
											<p align="right" >총 주문 금액 :</p>
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
								</td>
							</tr>
							<tr>
								<td colspan="3" id="pay_method"><br>
									<div class="bank">
										<div class="deposit apper_phw">
											<label for="deposit_bank">은행 : </label> <select name="bank"
												id="deposit_bank">
												<option>신한 은행</option>
												<option>국민 은행</option>
												<option>농협</option>
											</select> <br> <label>예금주 :</label> <input type="text"
												name="name" size="20">
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

									</div></td>
							</tr>
						</table>
					</div>
				</div>

			</div>


			<input type="hidden" id="cost" name="cost" value="${total_cost }">
			<input type="hidden" id="point" name="point"
				value="${total_cost * 0.01}"> <input type="hidden"
				name="email" value="${bidding.email }"> <input type="hidden"
				name="bid_id" value="${bid.bid_id }">
			<hr>
			<div align="right" id="payment_btn">
				<button class="btn btn-lg" type="submit">주문하기</button>
			</div>



		</form>

	</div>
</div>









