<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/Jungkosta/resources/css/auction/star-rating-svg.css">
<script type="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$(".my-rating-9").starRating({
			starSize : 20,
			initialRating : 1,
			starShape : 'rounded',
			hoverColor : 'skyblue',
			activeColor : 'skyblue',
			disableAfterRate : false,
			onHover : function(currentIndex, currentRating, $el) {
				$('.live-rating').text(currentIndex);
			},
			onLeave : function(currentIndex, currentRating, $el) {
				$('.live-rating').text(currentRating);
			}
		});
	});
</script>
<script src="/Jungkosta/resources/js/auction/jquery.star-rating-svg.js"></script>
</head>
<body>

	<button class="btn btn-default btn-info" data-toggle="modal"
		data-target="#review_Modal">상품평 쓰기</button>

	<div class="modal fade" id="review_Modal" tabindex="-1" role="dialog"
		aria-labelledby="saleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="reviewModalLabel">내 상품평</h4>
				</div>
				<div class="modal-body" align="center">
					<form id="auctionReview" action="auctionComment" method="Post">
						<table class="table table-bordered">
							<tr>
								<td class="active">별점 평가</td>
							<td><div class="content">
									<span class="my-rating-9"></span> <span class="live-rating"></span>
								</div></td>
							</tr>
							<tr>
								<td class="active">상품명</td>
								<td>ddd</td>
							</tr>
							<tr>
								<td class="active">상품평</td>
							<td><textarea cols="60" rows="10" name="content">
								</textarea></td>
							</tr>
						</table>
						<button type="submit" class="btn btn-default btn-info">등록하기</button>
					</form>
				</div>
			</div>

		</div>

	</div>
</body>
<script type="text/javascript">
	$('#auctionReview').submit(
			function(event) {

				event.preventDefault();

				var html = "<input type='hidden' name='satisfaction' value='"
						+ $('.live-rating').text() + "'>";

				$('.content').append(html);

				$(this).get(0).submit();
			});
</script>

</html>

