$(function() {

	var $product_cost = $("#product_cost");// 총 상품 가격

	var $radio = $("input[type=radio]"); // radio button

	var total_cost = 0; // 총 가격

	var status = "deposit";

	var flag = false;

	// radio Button Event
	$radio.change(function() {

		$(".bank").find("div").removeClass("apper_phw");
		$(".bank").find("div").addClass("hide_phw");
		$("." + this.id).removeClass("hide_phw");
		$("." + this.id).addClass("apper_phw");

		status = this.id;

		var charge = getCharge(this.id);

		var product_cost = getNumber($product_cost.text());

		changeDoc(product_cost, charge);

	});

	$("#pur_btn").click(function() {
		flag = true;
	});

	// form submit event
	$("#auctoin_purchase").submit(
			function(event) {

				event.preventDefault();

				var that = $(this);

				var bidding_id = $("#bidding_id").text();

				var html = "<input type='hidden' name='total_cost' value='"
						+ total_cost + "' >";
				html += "<input type='hidden' name='bidding_id' value='"
						+ bidding_id + "' >";

				that.append(html);

				that.get(0).submit();

			});

	// cancel 버튼 이벤트
	$("#cancel").click(function() {
		var sale_id = $("#sale_id").val();
		var bidding_id = $("#bidding_id").val();
		flag = true;
		var data = "sale_id=" + sale_id + "&bidding_id=" + bidding_id;

		$.ajax({
			url : "purchaseCancel",
			type : "post",
			data : data,
			dataType : "text",
			success : function() {
				alert("주문 취소");
				self.location = "auctionList";
			},
			error : function() {
				alert("주문 취소 중 에러 발생!! -관리자에게 문의하세요-");
				self.location = "auctionList";
			}
		});

	});

	function getCharge(id) {
		if (id == "deposit") {
			return {
				type : "1%",
				ch_per : 0.01
			};
		} else {
			return {
				type : "3%",
				ch_per : 0.03
			};
		}
	}

	function changeDoc(product_cost, charge) {

		var $cost = $("#charge_cost");

		total_cost = Math.floor(product_cost + 2500
				+ (product_cost * charge.ch_per));

		var mailge = Math.floor(total_cost * 0.01);

		var charge_cost = numberAddComma(Math.floor(product_cost
				* charge.ch_per));

		$cost.text(charge_cost);
		$("#charge_type").text(charge.type);
		$("#total_cost").text(numberAddComma(total_cost));
		$("#mileage").text(numberAddComma(mailge));

	}

	function numberAddComma(number) {
		var value = "" + number;

		var result = "";
		var array = [];

		for (var i = value.length; i >= 3; i = i - 3) {
			array.push(value.substring(i - 3, i));
		}

		var last = value.length % 3;

		if (last != 0) {
			array.push(value.substr(0, last));
		}

		for (var i = array.length - 1; i >= 0; i--) {

			if (i == 0) {
				result += array[i] + " 원";
			} else {
				result += array[i] + ",";
			}
		}
		return result;
	}

	function getNumber(num) {

		var pattern = /,/g;

		var result = num.trim().replace("원", "").replace(pattern, "");

		result = Number(result);

		return result;
	}

	function getStart() {
		
		checkPur();
		
		$radio.checkboxradio({
			icon : false
		});

		$product_cost.text(numberAddComma($product_cost.text()));

		var num = getNumber($product_cost.text());

		changeDoc(num, getCharge("deposit"));

		// BackSpace 키 방지 이벤트
		$(document).keydown(
				function(e) {
					if (e.target.nodeName != "INPUT"
							&& e.target.nodeName != "TEXTAREA") {
						if (e.keyCode === 8) {
							return false;
						}
					}
				});

		window.history.forward();

	}

	// F5 등 새로고침 이벤트 제거
	$(document).keydown(function(e) {

		if (e.which === 116) {
			if (typeof event == "object") {
				event.keyCode = 0;
			}
			alert("'새로고침'이 금지되어 메인페이지로 이동합니다.");
			self.location = "auctionList";
			return false;
		} else if (e.which === 82 && e.ctrlKey) {
			alert("'새로고침'이 금지되어 메인페이지로 이동합니다.");
			self.location = "auctionList";
			return false;
		}
	});

	// 브라우저 종료시 발생하는 이벤트
	window.addEventListener("beforeunload", function(event) {

		var confirmationMessage = "\o/";

		var sale_id = $("#sale_id").val();
		var bidding_id = $("#bidding_id").val();

		var data = "sale_id=" + sale_id + "&bidding_id=" + bidding_id;

		if (flag == false) {
			$.ajax({
				url : "closePur",
				post : "post",
				data : data
			});

			(event || window.event).returnValue = confirmationMessage; // IE
			return confirmationMessage; // chrome and fireFox
		}

	});
	
	function checkPur(){
		var bidding_id = $("#bidding_id").val();
		
		$.ajax({
			url : "checkPur",
			type : "post",
			dataType : "text",
			data : "bidding_id=" + bidding_id,
			success : successHandler,
			error : function(){
				alert("불러오기 실패");
				self.location = "auctionList";
			}
		});
	}
	
	function successHandler(data){
		if(data == "exist"){
			alert("주문한 상품입니다.");
			self.location = "auctionList";
		}
	}

	getStart();

});
