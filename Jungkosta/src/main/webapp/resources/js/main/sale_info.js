$(function() {

	var template = Handlebars.compile($("#template").html());

	$("#auction_list").on("click", ".goToDetail", function(event) {
		event.preventDefault();
		
		var sale_id = $(this).attr("href");
		
		self.location = "/Jungkosta/auction/auctionDetail?sale_id=" + sale_id;
	});

	Handlebars.registerHelper("money_format", function(money) {

		var result = "";

		if (typeof money == "number") {
			var value = "" + money;
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
		} else {
			result = money;
		}

		return result;
	});

	Handlebars.registerHelper("date_fomat", function(date) {

		var date = new Date(date);

		var time = date.getFullYear() + ". " + (date.getMonth() + 1) + ". "
				+ date.getDate();

		return time;

	});

	function getStart() {
		// 목록 가져오기
		$.getJSON("getAucSale", function(data) {
			$.each(data, function(index, entry) {
				var info = getObject(entry);
				var html = template(info);
				$("#auction_list").append(html);
			});
		});
	}

	function getObject(entry) {

		var bidding_cost = "입찰 없음";

		if (entry.auction_stcost != entry.bidding_cost) {
			bidding_cost = entry.bidding_cost;
		}

		var obj = {
			item_pic : getImage(entry.item_pic1),
			item_name : entry.item_name,
			sale_id : entry.sale_id,
			stcost : entry.auction_stcost,
			sale_date : entry.sale_date,
			end_date : entry.auction_end_date,
			status : entry.sale_status,
			bidding_cost : bidding_cost

		}
		return obj;
	}

	function getImage(src) {
		var path = "/Jungkosta/auction/displayFile?fileName=" + src;
		return path;
	}

	getStart();

});