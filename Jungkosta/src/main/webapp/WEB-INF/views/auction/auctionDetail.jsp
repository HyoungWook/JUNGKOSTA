<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<head>
<title>경매 상품 상세 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/Jungkosta/resources/css/auction/star-rating-svg.css">

</head>

<!-- bootstrap -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>


<!-- jQuery -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- zoom in -->
<link href="/Jungkosta/resources/css/auction/zoom_in.css"
	rel="stylesheet" type="text/css" />
<link href="/Jungkosta/resources/lib/imageviewer.css" rel="stylesheet"
	type="text/css" />
<script src="/Jungkosta/resources/lib/imageviewer.js"></script>

<script src="/Jungkosta/resources/js/auction/auctionDetail_zoom.js"
	type="text/javascript"></script>


<script type="text/javascript"
	src="/Jungkosta/resources/js/auction/auction_detail_phw.js"></script>

<!-- template -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>


<link href="/Jungkosta/resources/css/auction/auction_detail_phw.css" rel="stylesheet">

<div class="container">
	<input type="hidden" id="sale_id" value="${auction.sale_id }">
	<input type="hidden" id="status" value="${auction.auction_end_status}">
	<input type="hidden" id="end_date" value="${auction.auction_end_date}">
	<input type="hidden" id="saler" value="${auction.email }"> <br>
	<br>

	<div class="main_phw">

		<h1>경매</h1>
		<br> <br>

		<div class="category_phw">
			<label>${category.ca_name } <img alt=""
				src="/Jungkosta/resources/images/auction/down.PNG">
			</label> &nbsp;&nbsp;>&nbsp;&nbsp; <label>${category.subca_name } <img
				alt="" src="/Jungkosta/resources/images/auction/down.PNG">
			</label>
		</div>

		<div class="info_phw">
			<div class="row">
				<div class="col-md-offset-1 col-md-4 item_detail_phw">
					<div class="item_imgs_phw">
						<img id="item_main_phw" alt="main_Image" src="">

						<hr>

						<div id="item_sub_imgs_phw">
							<c:forEach var="thumb" items="${thumbnail }">
								<img alt="thumb" src="displayFile?fileName=${thumb}">
							</c:forEach>
						</div>

						<br>


					</div>
				</div>
				<div class="col-md-6 col-md-offset-1">

					<div>
						<img id="good_phw" alt=""
							src="/Jungkosta/resources/images/auction/good.png"> &nbsp;
						&nbsp; <strong>중코스타</strong> &nbsp;&nbsp;<img id="check_phw"
							alt="" src="/Jungkosta/resources/images/auction/check.jpg">
						<br>
						<div class="row">
							<div class="col-md-offset-2 message_phw">
								<span>1등 중고거래 커뮤니사이트가 되고싶다.</span>
							</div>
						</div>
					</div>

					<hr>

					<div class="product_info_phw">
						<h3>${auction.item_name }</h3>
						<span>상품번호 : ${auction.sale_id }</span> <br> <br> <br>




						<h4>
							현재가 : <span id="product_price_phw"> <fmt:formatNumber
									value="${auction.item_cost }" pattern="#,###" /> 원



							</span> &nbsp;&nbsp;
						</h4>
						<div>
							<span id="start">시작가 : </span> <span id="start_price_phw">
								<fmt:formatNumber value="${auction.auction_stcost }"
									pattern="#,###" /> 원
							</span> | &nbsp;&nbsp;&nbsp;<span id="immedidate_cost_phw">즉시 구매가
								: <fmt:formatNumber value="${auction.immediate_bid_cost }"
									pattern="#,###" /> 원
							</span>
						</div>

						<hr>


						<div class="row">
							<div class="col-md-2">
								<br> <span>입찰수 </span>
							</div>

							<div class="col-md-10">
								<b id="bid_count_phw">${countBidding } 회 (총 판매수량 : 1개)</b>
								&nbsp;&nbsp;&nbsp; <a id="auction_record"
									href="${auction.sale_id}">경매기록</a>
							</div>

						</div>

						<br> <br>

						<div class="row">
							<div class="col-md-2">
								<span>배송 방법</span>
							</div>
							<div class="col-md-10 delivery_phw">
								<b id="delivery_phw">택배</b>
							</div>
						</div>

						<br> <br>

						<div class="row">
							<div class="col-md-2">
								<span>배송비</span>
							</div>
							<div class="col-md-10 delivery_phw">
								<b id="delivery_charge_phw">후결제 2,500원</b>
							</div>
						</div>

						<hr>

						<div class="auction_info_phw">
							<strong>남은 시간 : </strong> &nbsp; <strong id="remainning_time_phw"></strong>
							<br> <strong>종료 : </strong> <strong> <fmt:formatDate
									type="both" value="${auction.auction_end_date }"
									dateStyle="long" timeStyle="short" />


							</strong> <br> <br> <br>

							<button type="button" class="btn btn-primary btn-lg"
								id="bid_button_phw">입찰하기</button>

						</div>

					</div>


				</div>

			</div>
		</div>


		<br> <br>
		<hr>

		<div class="detail_phw">

			<ul class="nav nav-tabs detail_select_phw">
				<li class="active"><a href="#product_info" data-toggle="tab">상품
						정보</a></li>
				<li><a href="#comment" data-toggle="tab">판매자가 받은 상품평</a></li>
				<li><a href="#qAnda" data-toggle="tab">상품문의</a></li>
			</ul>


			<div class="tab-content">
				<br /> <br /> <br />
				<div class="tab-pane active" id="product_info">
					<label>상품 정보</label> <br /> <br />
					<!-- start 현우 추가 부분 -->
					<div id="item_pic_list">
						<div id="image-gallery">
							<div class="image-container"></div>
							<img src="/Jungkosta/resources/images/auction/left.svg"
								class="prev" /> <img
								src="/Jungkosta/resources/images/auction/right.svg" class="next" />
							<div class="footer-info">
								<span class="current"></span>/<span class="total"></span>
							</div>
						</div>
					</div>
					<!-- end 현우 추가 부분 -->
					<br /> <br /> <span id="info">제품구입 일자:</span>&nbsp;
					<!-- src변경 -->
					<fmt:formatDate value="${auction.buy_time}" pattern="yyyy년 MM월 dd일" />
					<br /> <br /> <span id="info">상품 상태:</span>&nbsp;${auction.item_status}
					<br /> <br /> <span id="info">제품 흠집 정도:</span>&nbsp;${auction.item_scratch}
					<br /> <br /> <span id="info">제품구매 경로:</span>&nbsp;${auction.buy_info}
					<br /> <br /> <span id="info">제품 추가정보:</span>&nbsp;${auction.additional_info}
					<br /> <br />
				</div>

				<div class="tab-pane" id="comment">
					<div class="row">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<div class="col-md-12">
										<h4 id="comment_title_si">상품평</h4>
									</div>
								</div>
							</div>
						</div>
						<div class="comment_table_si">
							<table class="table table-hover">
								<thead>
									<tr>
										<th width="100">별점</th>
										<th width="500">내용</th>
										<th width="140">구매자</th>
										<th width="140">판매자</th>
									</tr>
								</thead>
								<tbody id="listComment">
									<c:forEach var="temp" items="${reviewList}">
										<tr>
											<td align='center'><div class="content">
													<p>${temp.satisfaction}</p>
													<span class="my-rating-9"></span>
												</div></td>
											<td align='center'>${temp.content}</td>
											<td align='center'>${temp.purchaser}</td>
											<td align='center'>${temp.seller}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
				<!-- 판매자 상품평 -->

				<div class="tab-pane" id="qAnda">
					<div class="row">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="row">
										<div class="col-md-10">
											<h4 id="reply_title_si">상품문의</h4>
										</div>
										<div class="col-md-2">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapseOne" class="sellerReply_si btn btn-default"
													role="button">글쓰기</a>
											</h4>
										</div>
									</div>
								</div>
								<div id="collapseOne" class="panel-collapse collapse">
									<div class="panel-body">


										<form id="reply_phw">
											<input type="hidden" id="email" name="email"
												value="${email }"> <input type="hidden"
												name="sale_id" value="${auction.sale_id }"> <input
												type="hidden" name="qa_level" value="0">
											<div class="qAnda form-group">


												<textarea class="form-control" id="content" name="content"></textarea>
											</div>
											<div class="reply_button_si">
												<button type="submit" class="btn btn-default"
													name="reply_confirm_si">확인</button>
												<button type="reset" class="btn btn-default"
													id="reply_reset_si">취소</button>
											</div>
										</form>


									</div>
								</div>
							</div>
						</div>
						<div class="reply_table_si">
							<table class="table table-hover">
								<thead>
									<tr>
										<th width="80">글번호</th>
										<th width="400">내용</th>
										<th width="200">글쓴이</th>
										<th width="100">작성일자</th>
										<th width="100">비고</th>
									</tr>
								</thead>
								<tbody id="listReply">

								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

		</div>

		<br> <br>

	</div>
</div>
<script id="template" type="text/x-handlebars-template">
	<tr>
		<td align='center'>{{index}}</td>
		<td>
			{{#if_phw info}}
			&nbsp;<img class='answer_icon' alt='icon' src='/Jungkosta/resources/images/auction/AnswerLine.gif'>
			{{/if_phw}}
			{{content}}
		</td>
		<td align='center'>{{email}}</td>
		<td align='center'>{{time}}</td>
		<td align='center'>
			{{#if_phw info}}
			<button class="btn btn-primary">답변 달기</button>
			{{/if_phw}}
			<input type='hidden' name='sale_id' value='{{sale_id}}' >
			<input type='hidden' name='item_qa_id' value='{{item_qa_id}}' >
		</td>
	</tr>
</script>

<!-- start 현우 추가 부분 -->
<script id="templateReply" type="text/x-handlebars-template">
	<tr>
		<td colspan='5'>
			<form>
				<input type='hidden' name='email' value='{{email}}' >
				<input type='hidden' name='sale_id' value='{{sale_id}}' >
				<input type='hidden' name='qa_level' value='1' >
				<input type='hidden' name='ref' value='{{ref}}' >
				<textarea class="form-control" name="content"></textarea>
				<div class='row'>
					<div class='col-md-offset-11'>
						<input class="btn btn-primary" type='submit' value='답변 완료'>
					</div>
				</div>
			</form>
		</td>
	</tr>
</script>
<script src="/Jungkosta/resources/js/auction/jquery.star-rating-svg.js"></script>
<script>
	$(function() {
		$(".my-rating-9").each(function(index) {
			var star = parseFloat($(this).parent().first().text());

			$(this).starRating({
				starSize : 20,
				initialRating : star,
				readOnly : true,
				starShape : 'rounded',
				disableAfterRate : false
			});
		});
	});
</script>
