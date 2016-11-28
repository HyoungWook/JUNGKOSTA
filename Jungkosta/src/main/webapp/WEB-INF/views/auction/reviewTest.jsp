<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/Jungkosta/resources/css/auction/star-rating-svg.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/jquery-1.7.1.min.js"></script>
<script>
   $(function() {
      $(".my-rating-9").starRating({
         starSize: 20,
         initialRating : 1,
         starShape: 'rounded',
         hoverColor: 'skyblue',
         activeColor: 'skyblue',
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
		<form id="auctionReview" action="auctionComment" method="Post">
			내용:<input type="text" name="content"/><br/>
			별점 평가:<div class="content">
      			<span class="my-rating-9"></span> <span class="live-rating"></span>
   					</div><br/>
			구매자:<input type="text" name="purchaser"/><br/>
			판매자:<input type="text" name="seller"/><br/>
		<button type="submit" id="sub"/>
		</form>
</body>
<script type="text/javascript">
$('#auctionReview').submit(function(event){
	
	event.preventDefault();

	var html="<input type='hidden' name='satisfaction' value='"+$('.live-rating').text()+"'>";
	
	$('.content').append(html);
	
	$(this).get(0).submit();
});

</script>

</html>

