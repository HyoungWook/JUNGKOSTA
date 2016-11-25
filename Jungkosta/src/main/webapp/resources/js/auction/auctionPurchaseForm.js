$(function() {

	var $product_cost = $("#product_cost");// 총 상품 가격

	var $radio = $("input[type=radio]"); // radio button

	var total_cost = 0; // 총 가격

	var status = "deposit";

	// radio Button Event
	$radio.change(function() {

		$(".bank").find("div").removeClass("apper_phw");
		$(".bank").find("div").addClass("hide_phw");
		$("." + this.id).removeClass("hide_phw");
		$("." + this.id).addClass("apper_phw").fadeIn();

		status = this.id;

		var charge = getCharge(this.id);

		var product_cost = getNumber($product_cost.text());

		changeDoc(product_cost, charge);

	});

	// form submit event
	$("#auctoin_purchase")
			.submit(
					function(event) {

						event.preventDefault();

						var that = $(this);

						var bidding_id = $("#bidding_id").text();

						var html = "<input type='hidden' name='total_cost' value='"
								+ total_cost + "' >";
						html += "<input type='hidden' name='bidding_id' value='"
								+ bidding_id + "' >";

						that.append(html);

						if (status != deposit) {
							window
									.open("/Jungkosta/auction/aucPaymentForm", "newWindow",
											'width=550, height=500, menubar=yes, status=yes, scrollbar = yes');
						} else {
							that.get(0).submit();
						}

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
		$radio.checkboxradio({
			icon : false
		});

		$product_cost.text(numberAddComma($product_cost.text()));

		var num = getNumber($product_cost.text());

		changeDoc(num, getCharge("deposit"));

	}

	getStart();

});