<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- bootstrap -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- template -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="/Jungkosta/resources/css/main/sale_info.css">
	
<script src="/Jungkosta/resources/js/main/sale_info.js"></script>
<script src="/Jungkosta/resources/js/main/sale_info_trade.js"></script>

<div class="container">

	<div class="row">
		<div class="col-md-3">
			<%@ include file="menu.jsp"%>
		</div>

		<div class="col-md-9">
			<div class="main">
				<h2>판매내역</h2>
				<hr>

				<h4>경매 판매 내역</h4>
				<table class="table">

					<thead>
						<tr>
							<th width="300">판매 정보</th>
							<th width="100">상태</th>
							<th width="100">최고 입찰가</th>
						</tr>
					</thead>
					<tbody id="auction_list">
					</tbody>

				</table>

				<br> <br>

				<h4>일반 판매 내역</h4>
				<table class="table" id="aucPurList_info">
					<thead>
						<tr>
							<th width="300">판매 정보</th>
							<th width="100">상태</th>
							<th width="100">비고</th>
						</tr>
					</thead>
					<tbody id="sale_list">
					</tbody>

				</table>

			</div>
		</div>

	</div>
</div>


<script id="template" type="text/x-handlebars-template">
	<tr>
		<td>
			<div class='row'>
				<div class='col-md-5'>
					<div class='item_image'>
						<img alt='item_image' src='{{item_pic}}'>
					</div>
					
				</div>
				<div class='col-md-7'>
					<div id='info'>
						<a href='{{sale_id}}' class='goToDetail'><b>{{item_name}}</b></a><br><br>
						<p>시작가 : <span>{{money_format stcost}}</span></p>
						<p>등록일 : <span>{{date_fomat sale_date}}</span></p>
						<p>죵료일 : <span>{{date_fomat end_date}}</span></p>
					</div>
				</div>
			</div>
		</td>
		<td align='center'>{{status}}</td>
		<td align='center'>{{money_format bidding_cost}}</td>
	</tr>
</script>

<script id="template2" type="text/x-handlebars-template">
	<tr>
		<td>
			<div class='row'>
				<div class='col-md-5'>
					<div class='item_image'>
						<img alt='item_image' src='{{item_pic}}'>
					</div>
					
				</div>
				<div class='col-md-7'>
					<div id='info'>
						<a href='{{sale_id}}' class='goToDetail'><b>{{item_name}}</b></a><br><br>
						<p>금액 : <span>{{money_format item_cost}}</span></p>
						<p>상품 등록일 : <span>{{date_fomat sale_date}}</span></p>
					</div>
				</div>
			</div>
		</td>
		<td align='center'>{{status}}</td>
		<td></td>
	</tr>
</script>
