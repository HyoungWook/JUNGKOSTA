$(function() {

	var $pay_btn = $(".pay_btn");
	var $deposit = $("#deposit_btn");
	var $sale_area = $("#sale_area");
	var $cost = $("#cost");

	$pay_btn.click(function(event) {
		var sale_id = $(this).next().val();

		var html = "<input type='hidden' name='sale_id' value='" + sale_id
				+ "'>";

		$sale_area.empty();
		$sale_area.append(html);
	});

	$deposit.click(function() {
		var $payForm = $("#payForm");

		$.ajax({
			url : "/Jungkosta/auction/deposit",
			type : "post",
			data : $payForm.serialize(),
			dataType : "text",
			success : successHandler,
			error : function() {
				alert("입금 실패 - 관리자에게 문의하세요. -");
				$cost.val("");
			}
		});

	});

	$cost.focus(function() {

		if ($cost.val() == "0") {
			$cost.val("");
		}
	});

	$cost.blur(function() {

		if ($cost.val() == "" || $cost.val() == "0") {
			$cost.val("0");
		}
	});

	function successHandler(data) {
		if (data == "success") {
			
			alert("정상 처리되었습니다.");
			
			self.location = "/Jungkosta/purchase_info";
		} else {
			alert("금액을 정확히 써주세요.");
		}

		$cost.val("");
	}

	function getStart() {
		$cost.val("0");
	}

	getStart();

});