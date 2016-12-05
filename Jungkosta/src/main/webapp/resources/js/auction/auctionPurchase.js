$(function() {

	var total_cost = $("#total_cost").val();

	var flag = false;

	$("#cost").val("0");

	$("#cost").click(function() {
		$(this).val("");
	});

	$("input[type=text]").keyup(function(event) {
		var num_check = /[^0-9]/gi;
		var result = $(this).val();

		if (num_check.test(result)) {
			$(this).val(result.replace(num_check, ""));
		}
	});

	$(".payForm_btn").click(function() {

		flag = true;

		var input_cost = $("#cost").val();

		var form = $("#payForm");
		
		var sale_id = $("#sale_id").val();

		if (this.id == "complete_btn") {
			if (input_cost != total_cost) {
				alert("금액을 정확히 입력하세요.");
				$("#cost").val("0");
				return;
			}
		} else {
			alert("결제를 취소 합니다.");
		}

		var html = "<input type='hidden'";
		html += "name='form_btn' value='" + this.id + "'>";
		form.append(html);

		$.ajax({
			url : "aucPaymentForm",
			type : "post",
			data : form.serialize(),
			dataType : "text",
			success : function() {
				alert("처리가 완료되었습니다.");
				self.location = "/Jungkosta/purchase_info";
			},
			error : function() {
				alert("error - 관리자에게 문의하세요. -");

			}
		});

	});
	
	$("#check").click(function(event){
		
		event.preventDefault();
		
		flag = true;
		
		self.location = "/Jungkosta/aucList";
	});
	

	// F5 등 새로고침 이벤트 제거
	$(document).keydown(function(e) {

		if (e.which === 116) {
			if (typeof event == "object") {
				event.keyCode = 0;
			}
			alert("'새로고침'이 금지되어 있어 메인페이지로 이동합니다.");
			self.location = "auctionList";
			return false;
		} else if (e.which === 82 && e.ctrlKey) {
			alert("'새로고침'이 금지되어 있어 메인페이지로 이동합니다.");
			self.location = "auctionList";
			return false;
		}
	});

	// 브라우저 종료시 발생하는 이벤트
	window.addEventListener("beforeunload", function(event) {
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

	});

});