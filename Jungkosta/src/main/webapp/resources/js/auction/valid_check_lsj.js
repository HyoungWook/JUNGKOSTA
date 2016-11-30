$(function() {

	var nameCheck = /[^\p{Space}]/;
	var infoCheck = /[^\p{Space}]/;
	var addiCheck = /[^\p{Space}]/;
	var stCheck = /^[0-9]+$/;
	var imedCheck = /^[0-9]+$/;

	function errorMessage(result, className, id) {
		if (!result) {
			$('.' + className).removeClass('has-success');
			$('.' + className).addClass('has-error');
			$("#" + id).fadeIn();

		} else {
			$('.' + className).removeClass('has-error');
			$('.' + className).addClass('has-success');
			$("#" + id).fadeOut();
		}
	}

	$('#item_name').keyup(function(event) {
		var result = nameCheck.test($(this).val());
		errorMessage(result, "item", "item_name_phw");

	})

	$('#buy_info').keyup(function(event) {
		var result = infoCheck.test($(this).val());
		errorMessage(result, "info", "buy_info_phw");
	})

	$('#additional_info').keyup(function(event) {
		var result = addiCheck.test($(this).val());
		errorMessage(result, "additional", "add_info_phw");
	})

	$('#auction_stcost').keyup(function(event) {
		var result = stCheck.test($(this).val());
		errorMessage(result, "stcost", "stcost_phw");
	})

	$('#immediate_bid_cost').keyup(function(event) {
		var result = imedCheck.test($(this).val());
		errorMessage(result, "immecost", "immediate_phw");
	})
	

	$('.input_cost').keyup(function(event) {

		if (!(event.keyCode >= 48 && event.keyCode <= 57)) {

			var val = $(this).val();

			$(this).val(val.replace(/[^0-9]/gi, ''));
		}
	});

	$('#add_btn').submit(
			function(event) {

				// start 현우 추가 부분
				var item_pic = $("input[name^=item_pic]").size();

				if (item_pic != 4) {
					$("#file_phw").fadeIn();
					event.preventDefault();
				}
				// end 현우 추가 부분

				var result1 = nameCheck.test($('#item_name').val());
				var result2 = infoCheck.test($('#buy_info').val());
				var result3 = addiCheck.test($('#additional_info').val());
				var result4 = stCheck.test($('#auction_stcost').val());
				var result5 = imedCheck.test($('#immediate_bid_cost').val());

				if (!result1) {
					$('.item').removeClass('has-success');
					$('.item').addClass('has-error');
					$("#item_name_phw").fadeIn();

				}
				if (!result2) {
					$('.info').removeClass('has-success');
					$('.info').addClass('has-error');
					$("#buy_info_phw").fadeIn();

				}
				if (!result3) {
					$('.additional').removeClass('has-success');
					$('.additional').addClass('has-error');
					$("#add_info_phw").fadeIn();

				}
				if (!result4) {
					$('.stcost').removeClass('has-success');
					$('.stcost').addClass('has-error');
					$("#stcost_phw").fadeIn();

				}
				if (!result5) {
					$('.immecost').removeClass('has-success');
					$('.immecost').addClass('has-error');
					$("#immediate_phw").fadeIn();
					return false;
				}
				

			});

});