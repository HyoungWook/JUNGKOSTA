<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>


<!-- style -->
<link href="/Jungkosta/resources/auction/css/auction_main_phw.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<div class="container">

	<br> <br>

	<script type="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript"
		src="/Jungkosta/resources/auction/js/auction_main_phw.js"></script>

	<div class="main_phw">
		<div class="top_phw">
			<h1>경매</h1>
			<br> <br>
			<div class="row">
				<div class="col-md-offset-1">
					<b id="today_phw">Today's Pick</b> &nbsp;&nbsp;&nbsp; <span
						id="talk_phw">중코스타 MD가 강력 추천하는 오늘의 추천 상품입니다.</span>
				</div>
			</div>

			<br> <br>

			<div class="filter_phw">

				<div class="sub_filter_phw">

					<br>

					<div class="row">
						<div class="col-md-offset-1 col-md-1">
							<label>카테고리</label>
						</div>

						<div class="col-md-10">
							<label for="category_phw_1">모든 상품<input type="checkbox"
								id="category_phw_1" checked="checked">
							</label> <label for="category_phw_2">기타 전자기기 <input
								type="checkbox" id="category_phw_2">
							</label> <label for="category_phw_3">지류/카드상품권<input
								type="checkbox" id="category_phw_3">
							</label> <label for="category_phw_4">스마트폰<input type="checkbox"
								id="category_phw_4">
							</label> <label for="category_phw_5">음향/학습기기<input
								type="checkbox" id="category_phw_5">
							</label> <label for="category_phw_6">태블릿PC<input type="checkbox"
								id="category_phw_6">
							</label> <label for="category_phw_7">캠핑<input type="checkbox"
								id="category_phw_7">
							</label> <label for="category_phw_8">안전용품<input type="checkbox"
								id="category_phw_8">
							</label> <label for="category_phw_9">웨어러블<input type="checkbox"
								id="category_phw_9">
							</label> <label for="category_phw_10">카메라<input type="checkbox"
								id="category_phw_10">
							</label> <label for="category_phw_11">유모차/카시트<input
								type="checkbox" id="category_phw_11">
							</label> <label for="category_phw_12">노트북/PC<input
								type="checkbox" id="category_phw_12">
							</label> <label for="category_phw_13">생활/주방/미용가전<input
								type="checkbox" id="category_phw_13">
							</label> <label for="category_phw_14">게임/타이틀<input
								type="checkbox" id="category_phw_14">
							</label>
						</div>
					</div>

					<br>


					<div class="row">
						<div class="col-md-offset-1 col-md-1">
							<label>상품상태</label>
						</div>

						<div class="col-md-10">
							<label for="item_status_phw_1">모든 상품<input
								type="checkbox" id="item_status_phw_1" checked="checked">
							</label> <label for="item_status_phw_2"> 새상품 <input
								type="checkbox" id="item_status_phw_2">
							</label> <label for="item_status_phw_3">미사용<input type="checkbox"
								id="item_status_phw_3">
							</label> <label for="item_status_phw_4">중고<input type="checkbox"
								id="item_status_phw_4">
							</label>
						</div>
					</div>

					<br>


					<div class="row">
						<div class="col-md-offset-1 col-md-1">
							<label>통신사</label>
						</div>

						<div class="col-md-10">
							<label for="connect_phw_1">모든 상품<input type="checkbox"
								id="connect_phw_1" checked="checked">
							</label> <label for="connect_phw_2">KT<input type="checkbox"
								id="connect_phw_2">
							</label> <label for="connect_phw_3">WiFi<input type="checkbox"
								id="connect_phw_3">
							</label> <label for="connect_phw_4">Unlock 모델<input
								type="checkbox" id="connect_phw_4">
							</label>
						</div>
					</div>

					<br>

					<div class="row">
						<div class="col-md-offset-1 col-md-1">
							<label>제조사</label>
						</div>

						<div class="col-md-10">
							<label for="made_phw_1">모든 상품<input type="checkbox"
								id="made_phw_1" checked="checked">
							</label> <label for="made_phw_2">힐링쉴드<input type="checkbox"
								id="made_phw_2">
							</label> <label for="made_phw_3">테블리스<input type="checkbox"
								id="made_phw_3">
							</label> <label for="made_phw_4">자브라<input type="checkbox"
								id="made_phw_4">
							</label> <label for="made_phw_5">소니<input type="checkbox"
								id="made_phw_5">
							</label> <label for="made_phw_6">다이치<input type="checkbox"
								id="made_phw_6">
							</label> <label for="made_phw_7">잉글레시나<input type="checkbox"
								id="made_phw_7">
							</label> <label for="made_phw_8">머큐리<input type="checkbox"
								id="made_phw_8">
							</label> <label for="made_phw_9">조본<input type="checkbox"
								id="made_phw_9">
							</label> <label for="made_phw_10">리안<input type="checkbox"
								id="made_phw_10">
							</label> <label for="made_phw_11">카카오<input type="checkbox"
								id="made_phw_11">
							</label> <label for="made_phw_12">기타<input type="checkbox"
								id="made_phw_12">
							</label>

						</div>
					</div>


				</div>

			</div>
		</div>

		<div class="mid_phw">

			<br> <br>

			<h3 id="realTime_item_phw">실시간 상품</h3>
			&nbsp;&nbsp;
			<fieldset id="radio_btn">

				<label for="radio-1">신규 등록순</label> <input type="radio"
					name="radio-1" class="button_radio" checked="checked" id="radio-1"
					value="add_sort"> <label for="radio-2">마감 임박순</label> <input
					type="radio" name="radio-1" class="button_radio" id="radio-2"
					value="end_sort">
			</fieldset>
		</div>

		<hr>

		<div class="item_container_phw">

			<div id="loading_phw">
				<img alt="" src="/Jungkosta/resources/auction/images/loading.gif">
			</div>

			<div class="row item_list_phw">

				<c:forEach var="temp" items="${ listAuction}" varStatus="index">
					<div class="col-md-3 item_info_phw"
						onclick="sendDetail(${temp.sale_id})">

						<br> <b>무료배송</b> <img id="icon_auc_phw" alt=""
							src="/Jungkosta/resources/auction/images/icon_auc.png">


						<div class="item_img_phw">
							<img id="item_main_img" alt="" src="c:/upload/${temp.item_pic1 }">

							<c:if test="${temp.auction_end_status == true }">
								<img id="close_auc_phw" alt=""
									src="./images_phw/auction_close.png">
							</c:if>
						</div>
						<div>
							<a>관심상품 담기</a> | <a>미리 보기</a>
						</div>
						<br> <br> <b class="item_name_phw">${temp.item_name }</b>
						<br> <br> <span>현재가 </span> &nbsp;&nbsp; <strong
							class="product_price_phw"> <fmt:formatNumber
								value="${temp.item_cost }" pattern="#,###" />원
						</strong> <br> <br>

					</div>

				</c:forEach>
			</div>
		</div>
	</div>


	<br> <br> <br>

</div>