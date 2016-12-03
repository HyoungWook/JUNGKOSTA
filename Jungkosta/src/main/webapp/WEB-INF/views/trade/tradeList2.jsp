<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



<!-- Bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css" rel="stylesheet">




<!-- jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- javascript -->
<script src="/Jungkosta/resources/js/trade/itemlist_main_ktw.js"></script>

<!-- css -->
<link href="/Jungkosta/resources/css/trade/tradeList.css" rel="stylesheet">


<style type="text/css">
#good_ktw {
	width: 30px;
	height: 30px;
}

#check_ktw {
	width: 30px;
	height: 30px;
}
</style>

<script type="text/javascript">
   function sendDetail(id) {
      location.href = "itemDetail.jsp?sale_id=" + id;
   }
</script>

</head>
<body>



	<div class="container">



		<%--    <div class="header_ktw">
         <jsp:include page="../header&footer/header.jsp" />
      </div> --%>

		<br> <br>

		<%--    <div class="menu_ktw">
         <jsp:include page="../header&footer/nav.jsp" />
      </div> --%>

		<br> <br>
		<div class="main_ktw">
			<div class="top_ktw">
				<h1>카테고리</h1>
				<br> <br>
				<div class="row">
					<div class="col-md-offset-1">
						<b id="today_ktw">Today's Pick</b> &nbsp;&nbsp;&nbsp; <span
							id="talk_ktw">중코스타 MD가 강력 추천하는 오늘의 추천 상품입니다.</span>
					</div>
				</div>

				<br> <br>

				<div class="filter_ktw">

					<div class="sub_filter_ktw">
						<br>
						<div class="row">
							<div class="col-md-offset-1 col-md-1">
								<label>카테고리</label>
							</div>
							<div class="col-md-10">
								<label for="category_ktw_1">모든 상품<input type="checkbox"
									id="category_ktw_1" checked="checked">
								</label> <label for="category_ktw_2">기타 전자기기 <input
									type="checkbox" id="category_ktw_2">
								</label> <label for="category_ktw_3">지류/카드상품권<input
									type="checkbox" id="category_ktw_3">
								</label> <label for="category_ktw_4">스마트폰<input type="checkbox"
									id="category_ktw_4">
								</label> <label for="category_ktw_5">음향/학습기기<input
									type="checkbox" id="category_ktw_5">
								</label> <label for="category_ktw_6">태블릿PC<input type="checkbox"
									id="category_ktw_6">
								</label> <label for="category_ktw_7">캠핑<input type="checkbox"
									id="category_ktw_7">
								</label> <label for="category_ktw_8">안전용품<input type="checkbox"
									id="category_ktw_8">
								</label> <label for="category_ktw_9">웨어러블<input type="checkbox"
									id="category_ktw_9">
								</label> <label for="category_ktw_10">카메라<input type="checkbox"
									id="category_ktw_10">
								</label> <label for="category_ktw_11">유모차/카시트<input
									type="checkbox" id="category_ktw_11">
								</label> <label for="category_ktw_12">노트북/PC<input
									type="checkbox" id="category_ktw_12">
								</label> <label for="category_ktw_13">생활/주방/미용가전<input
									type="checkbox" id="category_ktw_13">
								</label> <label for="category_ktw_14">게임/타이틀<input
									type="checkbox" id="category_ktw_14">
								</label>
							</div>
						</div>

						<br>


						<div class="row">
							<div class="col-md-offset-1 col-md-1">
								<label>상품상태</label>
							</div>

							<div class="col-md-10">
								<label for="item_status_ktw_1">모든 상품<input
									type="checkbox" id="item_status_ktw_1" checked="checked">
								</label> <label for="item_status_ktw_2"> 새상품 <input
									type="checkbox" id="item_status_ktw_2">
								</label> <label for="item_status_ktw_3">미사용<input
									type="checkbox" id="item_status_ktw_3">
								</label> <label for="item_status_ktw_4">중고<input type="checkbox"
									id="item_status_ktw_4">
								</label>
							</div>
						</div>

						<br>


						<div class="row">
							<div class="col-md-offset-1 col-md-1">
								<label>통신사</label>
							</div>

							<div class="col-md-10">
								<label for="connect_ktw_1">모든 상품<input type="checkbox"
									id="connect_ktw_1" checked="checked">
								</label> <label for="connect_ktw_2">KT<input type="checkbox"
									id="connect_ktw_2">
								</label> <label for="connect_ktw_3">WiFi<input type="checkbox"
									id="connect_ktw_3">
								</label> <label for="connect_ktw_4">Unlock 모델<input
									type="checkbox" id="connect_ktw_4">
								</label>
							</div>
						</div>

						<br>

						<div class="row">
							<div class="col-md-offset-1 col-md-1">
								<label>제조사</label>
							</div>

							<div class="col-md-10">
								<label for="made_ktw_1">모든 상품<input type="checkbox"
									id="made_ktw_1" checked="checked">
								</label> <label for="made_ktw_2">힐링쉴드<input type="checkbox"
									id="made_ktw_2">
								</label> <label for="made_ktw_3">테블리스<input type="checkbox"
									id="made_ktw_3">
								</label> <label for="made_ktw_4">자브라<input type="checkbox"
									id="made_ktw_4">
								</label> <label for="made_ktw_5">소니<input type="checkbox"
									id="made_ktw_5">
								</label> <label for="made_ktw_6">다이치<input type="checkbox"
									id="made_ktw_6">
								</label> <label for="made_ktw_7">잉글레시나<input type="checkbox"
									id="made_ktw_7">
								</label> <label for="made_ktw_8">머큐리<input type="checkbox"
									id="made_ktw_8">
								</label> <label for="made_ktw_9">조본<input type="checkbox"
									id="made_ktw_9">
								</label> <label for="made_ktw_10">리안<input type="checkbox"
									id="made_ktw_10">
								</label> <label for="made_ktw_11">카카오<input type="checkbox"
									id="made_ktw_11">
								</label> <label for="made_ktw_12">기타<input type="checkbox"
									id="made_ktw_12">
								</label>

							</div>
						</div>


					</div>

				</div>
			</div>

			<div class="mid_ktw">

				<br> <br>

				<h3 id="realTime_item_ktw">실시간 상품</h3>
				&nbsp;&nbsp;

				<div class="btn-group radio_button" data-toggle="buttons">
					<label class="btn btn-info active"> <input type="radio"
						name="options" id="option1"> 신규등록순
					</label> <label class="btn btn-info"> <input type="radio"
						name="options" id="option2"> 마감임박순
					</label>
				</div>

				<hr>

				<div class="item_list_ktw">
					<div class="row">
						<c:forEach var="temp" items="${ listSalesub}">

							<div class="col-md-2 col-md-offset-2 item_info_ktw"
								onclick="sendDetail(${temp.sale_id})">
								<img id="good_ktw" src="/resources/images/trade/good.png" />&nbsp;
								<span name="email">중코스타</span>&nbsp; <img id="check_ktw"
									src="/resources/images/trade/check.jpg" />
								<div class="item_img_ktw">
									<c:if test="${temp.item_pic!=null }">
										<%--      <c:set var="head" value="${fn:substring(temp.item_pic, 0 ,fn:length(temp.item_pic)-4) }"></c:set>
            <c:set var="pattern" value="${fn:substringAfter(temp.item_pic,head) }"></c:set> --%>
										<img src="../upload/${head}_small${pattern}">
									</c:if>
								</div>
								<!-- <div>
                           <a>관심상품 담기</a> | <a>미리 보기</a>
                        </div> -->
								<br> <br> <b class="item_name_ktw">${temp.item_name }</b>
								<br> <br> <span></span> &nbsp;&nbsp; <b><strong
									class="product_price_ktw">${temp.item_cost } 원</strong></b><br>
								<br>
								<br>
								<br>

							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>

		<br> <br> <br>

		<div class="footer_ktw">
			<%--   <jsp:include page="../header&footer/footer.jsp" /> --%>
		</div>


	</div>
</body>
</html>