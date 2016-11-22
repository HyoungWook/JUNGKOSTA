<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<title>입찰 페이지</title>

<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>


<!-- jQuery -->
<script type="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>


<script type="text/javascript">
	$(function() {

		$("#sendBidding_phw").click(function() {
			var email = "${auction.email}";//테스트를위해 수정
			var input_cost = Number($("#bidding_cost").val());
			var now_cost = Number("${auction.item_cost + 1000}");
			var immediate_cost = Number("${auction.immediate_bid_cost}");
			
			if (!email) {
				alert("로그인 해 주세요.");
				window.self.close();
				return false;
			} else {
				if (input_cost < now_cost) {
					alert("입찰가능한 가격을 적어주세요");
					$("#bidding_cost").val("");
					return false;
				} else if (input_cost > immediate_cost) {
					alert("즉시 입찰 가능한 가격을 적어주세요.");
					$("#bidding_cost").val("");
					return false;
				}
				
			}
	
		
		});
		
	});
</script>



<div class="container">
	<form action="bidRegister" method="post">
		<input type="hidden" name="email" value="${auction.email}"> <input
			type="hidden" name="auction_id" value="${auction.auction_id }"><!-- 테스트를위해 수정 -->
		<input type="hidden" name="sale_id" value="${auction.sale_id }">
		<table class="table table-bordered">
			<p>입찰 상품</p>
			<tbody>
				<tr>
					<td class="active">상품명</td>
					<td>${auction.item_name }</td>
				</tr>
				<tr>
					<td class="active">경매마감일자</td>
					<td><fmt:formatDate value="${auction.auction_end_date }"
							pattern="yyyy년 MM월 dd일 hh:mm" /> 까지</td>
				</tr>
				<tr>
					<td class="active">판매지역</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<br /> <br />
		<p>입찰하기</p>
		<table class="table table-bordered">
			<tr>
				<td class="active">현재가</td>
				<td><fmt:formatNumber value="${auction.item_cost }"
						pattern="#,###원" /></td>
				<td class="active">즉시구매가</td>
				<td><fmt:formatNumber value="${auction.immediate_bid_cost }"
						pattern="#,###원" /></td>
			</tr>
			<tr>
				<td class="active">입찰 금액</td>
				<td colspan="3">현재 <fmt:formatNumber
						value="${auction.item_cost + 1000 }" pattern="#,###원" /> 부터 구매할 수
					있습니다.<br> <br>
					<div class="input-group">
						<input type="text" style="text-align: right; z-index: 1"
							class="form-control" name="bidding_cost" id="bidding_cost">
						<span class="input-group-addon"> 원 </span>
					</div>
				</td>
			</tr>
			<tr>
			</tr>
		</table>
		<br />
		<div id="bid_btn_lsj">
			<button type="submit" class="btn btn-default btn-info"
				id="sendBidding_phw">입찰하기</button>
			<button type="button" class="btn btn-default btn-info"
				onclick="window.self.close()">닫기</button>
		</div>
	</form>
</div>












