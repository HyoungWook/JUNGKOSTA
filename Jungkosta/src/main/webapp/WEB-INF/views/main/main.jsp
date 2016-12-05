<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>중코스타 - 국내 1위 중고거래 사이트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/Jungkosta/resources/js/main/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/Jungkosta/resources/js/auction/upload.js"></script>
<link href="/Jungkosta/resources/css/auction/auction_main_phw.css" rel="stylesheet">

<script>
 	$('.carousel').carousel()
 </script>

<style type="text/css">
#carousel_ws {
	
}

.main_title_ws {
	margin-top: 2.5em;
}

.auc_bid_info_phw table td {
	text-align: center;
	height: 30px;
}

.auc_bid_list span {
	font-size: 10px;
}

.auc_bid_list table {
	font-size: 10px;
}

.auc_bid_list table th {
	text-align: center;
	background: #EEEEEE;
}

.auc_bid_list table td {
	text-align: center;
}

#bid_person_phw {
	color: red;
}

#bid_able_phw {
	color: blue;
}

.button_phw {
	text-align: center;
}
</style>

</head>
<body>
	<!-- 2016/12/04 우성 추가 -->
		<input type="hidden" value="${hotItem }" id="hotItem_ws">
	<!-- 끝 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="main_title_ws">New Item</h2>
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div id="carousel-example-generic1" class="carousel slide">
					<div class="carousel-inner" id="carousel_ws1"></div>
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic1"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic1"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right "></span>
					</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h2 class="main_title_ws">Hot Item</h2>
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div id="carousel-example-generic2" class="carousel slide">
					<div class="carousel-inner" id="carousel_ws2"></div>
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic2"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic2"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right "></span>
					</a>
				</div>
			</div>
		</div>
		<c:if test="${email != null}">
			<div class="row">
			<div class="col-md-12">
				<h2 class="main_title_ws">Recommended Item</h2>
				<input type="hidden" value="${preferList }" id="preferList_ws">
				
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
					<div id="carousel-example-generic3" class="carousel slide">
						<div class="carousel-inner" id="carousel_ws3">
							
						</div>
						<a class="left carousel-control" href="#carousel-example-generic3"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic3" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right "></span>
						</a>

					</div>
				</div>
		</div>
		<div id="allProduct">
		
		</div>
		</c:if>
	</div>
</body>
<!-- 2016/11/26 우성 추가 -->

<script id="template1" type="text/x-handlebars-template">
 		<div class="col-md-3 item_info_phw" onclick="sendDetailAuction({{sale_id}})">
 			<br> 
 			<b>무료배송</b> <img id="icon_auc_phw" alt="auction_icon" src="/Jungkosta/resources/images/auction/icon_auc.png">
 			<div class="item_img_phw">
 				<img id="item_main_img" alt="main_image" src="{{item_pic1}}">
 					{{#if_phw auction_end_status}}
 						<img id="close_auc_phw" alt="auction_close" src="/Jungkosta/resources/images/auction/auction_close.png">
 					{{/if_phw}}
 			</div>
 			<div>
 				<a>관심상품 담기</a> | <a>미리 보기</a>
 			</div>
 			<br> <br> 
 			<b class="item_name_phw">{{item_name}}</b>
 			<br> <br> 
 			<span>현재가 </span> &nbsp;&nbsp; 
 			<strong class="product_price_phw">
 				{{money_fomat item_cost}}
 			</strong>
 			<br>
			<br>
 		</div>
 </script>

<script id="template2" type="text/x-handlebars-template">
 		<div class="col-md-3 item_info_phw" onclick="sendDetailTrade({{sale_id}})">
 			<br> 
 			<b>무료배송</b>
			<div class="item_img_phw">
 				<img id="item_main_img" alt="main_image" src="{{item_pic1}}">
 					
 			</div>
 			<div>
 				<a>관심상품 담기</a> | <a>미리 보기</a>
 			</div>
 			<br> <br> 
 			<b class="item_name_phw">{{item_name}}</b>
 			<br> <br> 
 			<span>가격 </span>
 			<strong class="product_price_phw"> &nbsp; 
 				{{money_fomat item_cost}}
 			</strong>
 			<br> <br>
 		</div>
 </script>

<!-- 종료 -->
</html>