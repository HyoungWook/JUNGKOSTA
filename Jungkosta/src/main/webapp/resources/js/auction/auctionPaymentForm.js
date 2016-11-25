$(function() {

	var total_cost = $("#total_cost").val();

	$("#total_cost").submit(function(event) {
		event.preventDefault();
	});

	$(".payForm_btn").click(function() {

		var input_cost = $("#cost").val();

		var form = $(this).parent();

		if (this.id == "complete_btn") {
			if (input_cost != total_cost) {
				alert("금액을 정확히 입력하세요.");
				$("#cost").val("");
				return;
			} else {
				alert("결제가 완료되었습니다.");
			}
		} else {
			alert("결제를 취소 합니다.");
			alert(this.id);
		}

		var html = "<input type='hidden'";
		html += "name='form_btn' value='" + this.id + "'>";
		form.append(html);

		// form.submit();

		$.ajax({
			url : "aucPaymentForm",
			type : "post",
			data : form.serialize(),
			dataType : "text",
			success : function() {
				alert("성공");
				closeWindow();
			},
			error : function() {
				alert("실패");

			}
		});

	});

	function closeWindow() {

		window.opener.self.location = "auctionList"; // 원래는 마이페이지로 이동
		window.self.close();
	}

	// 페이지 뒤로가기 이벤트 막기
	// BackSpace 키 방지 이벤트
	$(document).keydown(function(e) {
		if (e.target.nodeName != "INPUT" && e.target.nodeName != "TEXTAREA") {
			if (e.keyCode === 8) {
				return false;
			}
		}
	});

	window.history.forward(0);

});