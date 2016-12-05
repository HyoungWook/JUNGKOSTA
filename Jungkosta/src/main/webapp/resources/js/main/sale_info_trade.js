$(function() {

	var template = Handlebars.compile($("#template2").html());

	$("#sale_list").on("click", ".goToDetail", function(event) {
		event.preventDefault();
		
		var sale_id = $(this).attr("href");
		
		self.location = "/Jungkosta/trade/tradeDetail?sale_id=" + sale_id;
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
		$.getJSON("getTradeSale", function(data) {
			$.each(data, function(index, entry) {
				var info = getObject(entry);
				var html = template(info);
				$("#sale_list").append(html);
			});
		});
	}

	function getObject(entry) {

		var obj = {
			item_pic : getImage(entry.item_pic1),
			item_name : entry.item_name,
			sale_id : entry.sale_id,
			sale_date : entry.sale_date,
			status : entry.sale_status,
			item_cost : entry.item_cost
		}
		return obj;
	}

	function getImage(src) {
		var path = "/Jungkosta/trade/displayFile?fileName=" + src;
		return path;
	}

	getStart();

});