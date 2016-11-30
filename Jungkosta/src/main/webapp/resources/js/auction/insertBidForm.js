$(function() {
	var cost = Number($("#bidding_cost").val());
	$("#cost").val(cost * 0.01 + cost + 2500);
	
	$(".payment_phw").checkboxradio({
		icon : false
	});

	$("#deposit_bank").selectmenu();
	$("#transfer_bank").selectmenu();
	$("#card_company").selectmenu();
	
	

	$(".payment_phw").click(function() {
		var $div = $(".bank").find("div");
		$div.hide();
		$("." + this.id).fadeIn("slow");
		chargeType(this.id);
	});
	
	function chargeType(id) {
		var type = "";
		var persent;
		

		if (id == "deposit") {
			persent = 0.01;
			type = "(무통장 입금 : 1%)";
		} else {
			persent = 0.03;
			type = "(3%)";
		}

		var charge = Math.floor(cost * persent);
		var total = Math.floor(cost + charge + 2500);
		var charge_str = addComma(charge);
		var total_str = addComma(total);

		$("#charge_type").text(type);
		$("#charge").text(charge_str + " 원");
		$("#total_cost").text(total_str + " 원");
		$("#cost").val(total);
	}

});


function addComma(data_value) {
	return Number(data_value).toLocaleString('en');
}