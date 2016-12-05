$(function() {

	var total_cost = $("#total_cost").val();
	var subca_id = $('#subca_id').val();
	
	$("#check").click(function(event){
		
		event.preventDefault();
		
		flag = true;
		
		self.location = "/Jungkosta/purchase_info";
	});
	

	// F5 등 새로고침 이벤트 제거
	$(document).keydown(function(e) {

		if (e.which === 116) {
			if (typeof event == "object") {
				event.keyCode = 0;
			}
			alert("'새로고침'이 금지되어 있어 메인페이지로 이동합니다.");
			self.location = "tradeList?subca_id="+subca_id;
			return false;
		} else if (e.which === 82 && e.ctrlKey) {
			alert("'새로고침'이 금지되어 있어 메인페이지로 이동합니다.");
			self.location = "tradeList?subca_id="+subca_id;
			return false;
		}
	});

	// 브라우저 종료시 발생하는 이벤트
/*	window.addEventListener("beforeunload", function(event) {
		var confirmationMessage = "\o/";

		var input_cost = $("#cost").val();
		var bid_id = $("#bid_id").val();
		var form_btn = "fail_btn";

		var data = "cost=" + input_cost + "&";
		data += "bid_id=" + bid_id;

		if (flag == false) {
			$.ajax({
				url : "closePay",
				post : "post",
				data : data
			});

			(event || window.event).returnValue = confirmationMessage; // IE
			return confirmationMessage; // chrome and fireFox
		}

	});*/

});