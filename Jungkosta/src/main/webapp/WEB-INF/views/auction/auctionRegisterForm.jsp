<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/auction/css/auction_add_lsj.css" rel="stylesheet">

<title>경매물품 등록</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="./resources/auction/js/main.js"></script>
<script type="text/javascript" src="./resources/auction/js/category.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="./resources/auction/js/valid_check_lsj.js"></script>

<style>
.input_error_phw {
	display: none;
}

.fileDrop {
  width: 80%;
  height: 100px;
  border: 1px dotted gray;
  background-color: lightslategrey;
  margin: auto;
  
}
</style>
</head>
<body>
	<br />
	<br />
	<br />

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="./resources/auction/js/date.js"></script>

	<span id="top_lsj">경매 물품 등록</span>

	<div class="container">
		<form action="auctionRegister" method="post" enctype="multipart/form-data">
			
			<input type="hidden" name="flag" value="1">

			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div id="list_title_lsj">판매하실 물건의 카테고리를 선택해주세요.</div>

					<br /> <br />

					<div class="form-group category_list_phw">
						<label for="sel1">카테고리</label> <select class="form-control"
							id="category_phw" name="category">
							<option value="null">카테고리 선택</option>
							<option value="ele">전자제품</option>
							<option value="travel">여행/문화</option>
							<option value="global">해외/명품</option>
						</select>
					</div>

					<div class="form-group category_list_phw">
						<label for="sel1">서브 카테고리</label> <select class="form-control"
							id="sub_category_phw" name="subca_id">
							<option value="null">서브카테고리 선택</option>
							<option class="ele" value="1">노트북</option>
							<option class="ele" value="2">컴퓨터</option>
							<option class="ele" value="3">스마트폰</option>
							<option class="ele" value="4">테블릿</option>
							<option class="ele" value="5">노트북/pc 주변기기</option>
							<option class="ele" value="6">카메라</option>
							<option class="ele" value="7">음향 기기</option>
							<option class="ele" value="8">웨어러블</option>
							<option class="ele" value="9">영상 가전</option>
							<option class="ele" value="10">게임/타이틀</option>
							<option class="ele" value="11">자동차 기기</option>
							<option class="ele" value="12">기타 전자 기기</option>
							<option class="travel" value="13">지류 카드 상품권</option>
							<option class="travel" value="14">공연/티켓</option>
							<option class="travel" value="15">모바일쿠폰/상품권</option>
							<option class="travel" value="16">여행/항공권</option>
							<option class="global" value="17">명품 가방</option>
							<option class="global" value="18">명품 지갑</option>
							<option class="global" value="18">명품 시계</option>
							<option class="global" value="18">명품 신발</option>
							<option class="global" value="18">명품 악세사리</option>


						</select>
					</div>
					<br /> <br />

					<div class="item">
						<div id="list_title_lsj">판매하실 물건의 제품명을 입력하세요.</div>
						<br /> <input type="text" class="form-control"
							placeholder="내용을 입력해주세요." name="item_name" id="item_name">
					</div>
					<div class="input_error_phw" id="item_name_phw">
						<p style="color: red">제품명을 입력해주세요(ex: 노트북)</p>
					</div>

					<!-- /input-group -->
					<br /> <br />
					<h3>구매시기는 언제인가요?</h3>
					<input type="text" id="buy_date" name="buy_time"
						class="form-control"> <br>

					<div class="info">
						<h3>구매하신 경로는 어떻게 되나요?</h3>
						<input type="text" class="form-control" name="buy_info"
							placeholder="예)인터넷 쇼핑몰" id="buy_info">
					</div>
					<div class="input_error_phw" id="buy_info_phw">
						<p style="color: red">구매 경로를 입력해주세요(ex: 인터넷 쇼핑몰)</p>
					</div>
					<br>

					<h3>흠집은 있나요?</h3>
					<select class="form-control" name="item_scratch">
						<option>많음</option>
						<option>양호</option>
						<option>적음</option>
						<option>없음</option>
					</select> <br>
					<div id="list_title_lsj">미개봉/미사용 제품인가요?</div>
					<br />
					<div class="form-group">
						<select class="form-control" id="sel1" name="item_status">
							<option>미개봉:박스를 개봉하지 않은 상품</option>
							<option>미사용:개봉 후 사용하지 않은 상품</option>
							<option>사용한적이 있는 상품</option>
						</select>
					</div>
					<br /> <br />

					<div class="additional">
						<div id="list_title_lsj">상품에 대한 추가정보를 입력해주세요.</div>

						<br />
						<textarea class="form-control" rows="4" placeholder="내용을 입력해주세요."
							name="additional_info" id="additional_info"></textarea>
					</div>
					<div class="input_error_phw" id="add_info_phw">
						<p style="color: red">추가정보를 입력해주세요.</p>
					</div>
					<br /> <br />

					<div id="list_title_lsj">상품의 이미지를 올려주세요.</div>
					<br />
					<div class="form-group">
<!-- 						<label for="exampleInputEmail1">File DROP Here</label> -->
						<div class="fileDrop"></div>
					</div>
					<br /> <br />
					<div id="list_title_lsj">경매 종료날짜를 입력해 주세요.</div>
					<br />
					<div class="row">
						<div class="col-md-5">
							<label for="to">종료 날짜:</label> <input type="text" id="to"
								style="z-index: 2;" class="form-control" name="auction_end_date"
								placeholder="날짜를 선택해 주세요"> <br>
						</div>
						<div class="col-md-5">
							<label for="to">종료 시간:</label> <select class="form-control"
								name="time_sel">
								<option value="null">시간을 선택해 주세요.</option>
								<option>00:00</option>
								<option>06:00</option>
								<option>18:00</option>
							</select>
						</div>
					</div>
					<br />
					<div id="list_title_lsj">물품의 현재 가격과 즉시구매 가격을 입력해주세요.</div>
					<br>
					<div class="row">
						<div class="col-md-5 stcost">
							<div id="subtitle_lsj">현재 가격</div>
							<br>
							<div class="input-group">
								<input type="text" style="text-align: right; z-index: 1"
									class="form-control input_cost" name="auction_stcost"
									id="auction_stcost"> <span class="input-group-addon">
									원 </span>
							</div>
							<div class="input_error_phw" id="stcost_phw">
								<p style="color: red">시작가격을 입력해주세요.</p>
							</div>
						</div>

						<div class="col-md-5 immecost">
							<div id="subtitle_lsj">즉시구매 가격</div>
							<br>
							<div class="input-group">
								<input type="text" class="form-control input_cost"
									style="text-align: right; z-index: 1" name="immediate_bid_cost"
									id="immediate_bid_cost"> <span
									class="input-group-addon"> 원 </span>
							</div>
							<div class="input_error_phw" id="immediate_phw">
								<p style="color: red">즉시 구매가를 입력해 주세요.</p>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
					<br> <br> <br> <span id="last_btn_lsj">
						<button type="submit" class="btn btn-default btn-info">입력
							완료</button>
					</span>
				</div>
			</div>
		</form>
	</div>

</body>
</html>