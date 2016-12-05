$(function() {

	var template = Handlebars.compile($("#template").html());

	var name = $("#name").val();
	var phoneNum = $("#phoneNum").val();
	var address = $('#address').val();
	// 경매 상품 상세 보기 event
	$("#salePurchase_list").on("click", ".detail_view", function(event) {
		event.preventDefault();

		var $target = $(this).parent().parent().next();

		if (!$target.hasClass("hide")) {
			$target.addClass("hide");
		} else {
			$target.removeClass("hide");

		}
	});

	var obj;

	// 구매확정 버튼 event
	$("#salePurchase_list").on(
			"click",
			".aucAfter",
			function() {
				var sale_id = $(this).next().val();
				obj = $(this);

				var itemName = $(this).next().next().val();

				$("#item_name").text(itemName);

				var str = "<input type='hidden' name='sale_id' value='"
						+ sale_id + "'>";

				$("#id_area").empty();
				$("#id_area").append(str);

				$.ajax({
					url : "/Jungkosta/trade/successTotrade",
					type : "post",
					dataType : "text",
					data : "sale_id=" + sale_id,
					success : successHandler,
					error : function() {
						alert("실패");
					}
				});
			});
	
	//item_name click Event
	$("#salePurchase_list").on("click", ".goToDetail", function(event){
		
		event.preventDefault();
		
		var sale_id = $(this).attr("href");
		
		self.location = "/Jungkosta/trade/tradeDetail?sale_id=" + sale_id;
		
	});
	
	function successHandler() {
		alert("상품평을 남겨주세요.");
		obj.remove();
	}

	Handlebars.registerHelper("check", function(st, block) {
		var accum = "";

		if (st.sale_status == '거래중' && st.bid_status == '배송 완료') {
			accum += block.fn();
		}
		return accum;
	});

	Handlebars.registerHelper("money_format", function(money) {

		var value = "" + money;

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
				result += array[i] + "원";
			} else {
				result += array[i] + ",";
			}
		}
		return result;
	});

	Handlebars.registerHelper("date_fomat", function(date) {

		var date = new Date(date);

		var time = date.getFullYear() + ". " + (date.getMonth() + 1) + ". "
				+ date.getDate();

		return time;

	});

	function getInfo(entry) {
		var info = {
			item_pic : getImage(entry.item_pic1),
			sale_id : entry.sale_id,
			item_name : entry.item_name,
			bid_id : entry.purchase_id,
			purchase_date : entry.purchase_date,
			cost : entry.purchase_cost,
			status : entry.purchase_status,
			receive_man : name,
			phoneNum : phoneNum,
			address : address,
			st : {
				sale_status : entry.sale_status,
				bid_status : entry.purchase_status
			}
		}

		return info;
	}

	function getImage(src) {

		var path = "/Jungkosta/trade/displayFile?fileName=" + src;

		return path;
	}

	function getStart() {
		$.getJSON("getTradePurList", function(data) {

			$.each(data, function(index, entry) {
				var info = getInfo(entry);

				var html = template(info);

				$("#salePurchase_list").append(html);
			});

		});
	}

	getStart();

});

// 별점 평가
$(function() {
	$(".my-rating-9").starRating({
		starSize : 20,
		initialRating : 1,
		starShape : 'rounded',
		hoverColor : 'skyblue',
		activeColor : 'skyblue',
		disableAfterRate : false,
		onHover : function(currentIndex, currentRating, $el) {
			$('.live-rating').text(currentIndex);
		},
		onLeave : function(currentIndex, currentRating, $el) {
			$('.live-rating').text(currentRating);
		}
	});
});

$(function() {
	var $form = $("#auctionReview");

	$form.submit(function(event) {
		event.preventDefault();

		var that = $(this);
		var star = $(".live-rating").text();
		var html = "<input type='hidden' name='satisfaction' value='" + star
				+ "'>";
		
		$("#id_area").append(html);

		$.ajax({
			url : "/Jungkosta/trade/tradeSellerReview",
			type : "post",
			data : that.serialize(),
			dataType : "text",
			success : reviewHandler,
			error : function() {
				alert("상품평 쓰기 실패 - 관리제에게 문의하세요 -");
			}
		});

	});
	function reviewHandler(data) {
		alert("상품평 쓰기 완료!!");
		$("#review_Modal").modal("hide");
	}

});