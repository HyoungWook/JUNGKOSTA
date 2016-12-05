<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>경매 기록</title>

<!-- Bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>



<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<style type="text/css">
.auc_bid_info_phw table td {
	text-align: center;
	height: 30px;
}

.auc_bid_list span {
	font-size: 10px;
}

.auc_bid_list table {
	font-size: 12px;
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
	font-size: 12px;
}

#bid_able_phw {
	color: blue;
	font-size: 12px;
}

.button_phw {
	text-align: center;
}

#header{
	margin-top:3%;
	margin-bottom:3%;
}

#size{
	font-size: 12px;
	font-weight:bold;
}
</style>

<script type="text/javascript">
	var flag = "${auction.auction_end_status}";

	$(function() {

		if (flag == "true") {
			$("#list_info_phw").find(":first-child").find(":first-child").find(
					"b").css({
				'color' : 'red'
			});
		} else {
			$("#list_info_phw").find(":first-child").find(":first-child").find(
					"b").css({
				'color' : 'blue'
			});
		}

	}); 
</script>

</head>
<body>
	
	<div class="container">

		<div class="auc_bid_info_phw">
			<label id="header">입찰 상품</label>
			<table class="table table-bordered">
				<tr >
					<td width="150" class="active">상품명</td>
					<td width="250">${auction.item_name}</td>
				</tr>
				<tr>
					<td class="active">경매 마감일자</td>
					<td><fmt:formatDate value="${auction.auction_end_date }"
							pattern="yyyy년 MM월 dd일  aa hh시 mm분" /></td>
				</tr>
				<tr>
					<td class="active">최대 구매가능 수량</td>
					<td>1개</td>
				</tr>
			</table>
		</div>
		<br> <br>

		<div class="auc_bid_list">

			<div class="row">
				<div class="col-md-offset-3 col-md-3">
					<span id="size">구분 : <b id="bid_person_phw"> ● 낙찰자</b> <b
						id="bid_able_phw"> ● 낙찰 가능자</b>
					</span>
				</div>
			</div>

			<br>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>입찰자 이메일</th>
						<th>입찰 일자</th>
						<th>입찰 가격</th>
						<th>수량</th>
						<th>누적 수량</th>
					</tr>
				</thead>

				<tbody id="list_info_phw">
					<c:forEach var="temp" items="${listBidding }">

						<tr>
							<td><b>${temp.email }</b></td>
							<td><fmt:formatDate value="${temp.bidding_time }"
									pattern="yyyy-MM-dd aa hh:mm:ss" /></td>
							<td><fmt:formatNumber value="${temp.bidding_cost }"
									pattern="#,###" /> 원</td>
							<td>1개</td>
							<td>1개</td>
						</tr>

					</c:forEach>
				</tbody>

			</table>

		</div>

		<br> <br>

		<div class="button_phw">
			<button class="btn btn-primary" onclick="window.self.close()">닫기</button>
		</div>

	</div>
</body>
</html>