$(function(){
	
	var payment_method = $("#payment_method").val();
	var bid_id = $("#bid_id").val();
	
	$("#pay_btn").click(function(){
		if(payment_method == '무통장입금'){
			self.location = "auctionList"; //원래는 마이페이지로 이동
		}else{
			var bid_page = window
			.open("aucPaymentForm?bid_id=" + bid_id, "newWindow",
					'width=550, height=700, menubar=yes, status=yes, scrollbar = yes');
		}
	});
	
});