$(function() {
	var template = Handlebars.compile($("#template").html());

	Handlebars.registerHelper("if_phw", function(auction_end_status, block) {
		var accum = "";

		if (auction_end_status == 'true') {
			accum += block.fn();
		}
		return accum;
	});

	Handlebars.registerHelper("money_fomat", function(money) {

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

	$.getJSON("auctionListSort?sort=null", function(data) {
		$.each(data, function(index, entry) {

			var listInfo = getListInfo(entry);
			var html = template(listInfo);

			$(".item_list_phw").append(html);
		});
	});

	var sort = "add_sort"; // 정렬 문자열
	var page = 1; // 현제 페이지

	$(".button_radio").each(function() {
		$(this).change(function() {

			page = 1;

			$('.item_list_phw').empty().hide();
			$('#loading_phw').stop();
			$('#loading_phw').fadeIn();

			$('#loading_phw').stop();
			$('#loading_phw').fadeIn();
			if ($(this).is(":checked")) {
				sort = $(this).val();
				$.getJSON("auctionListSort?sort=" + sort, function(data) {
					$.each(data, function(index, entry) {
						var listInfo = getListInfo(entry);
						var html = template(listInfo);

						$(".item_list_phw").append(html);
					});
				});
			}

			$('.item_list_phw').fadeIn();
			$('#loading_phw').fadeOut();
		});

	});

	var flag = true;
	$(document).scroll(function() {

		// 현재 화면의 위치
		var currentHeight = $(window).scrollTop() + window.innerHeight;
		// document 크기의 90%
		var height = Math.floor($(document).height() * 0.9);

		if (currentHeight >= height) {
			if (flag) {
				flag = false;

				var data = "page=" + (++page) + "&";
				data += "sort=" + sort;

				$.ajax({
					url : "auctionListSort",
					type : "get",
					data : data,
					dataType : "json",
					success : successHandler,
					error : function() {
						alert("목록 불러오기 실패");
					}
				});
			}
		}
	});

	// 무한 스크롤 ajax successHandler
	function successHandler(data) {

		if (data.length != 0) {
			$.each(data, function(index, entry) {
				var listInfo = getListInfo(entry);
				var html = template(listInfo);

				$(".item_list_phw").append(html);
			});
		}

		flag = true;
	}

	$('#categoryCheck input:checkbox').click(
			function() {

				var $check = $("#categoryCheck input:checked");
				var size = $check.size();
				var categoryList = [];
				var statusList = [];
				for (var i = 0; i < size; i++) {

					if ($check.eq(i).hasClass('category')) {
						categoryList.push($check.eq(i).val());
					} else if ($check.eq(i).hasClass('status')) {
						statusList.push($check.eq(i).val());
					}

				}
				alert(categoryList);
				alert(statusList);

				$.ajax({
					url : "auctionCategory",
					type : "POST",
					dataType : "text",
					data : "categoryList=" + categoryList + "&statusList="
							+ statusList,
					success : function() {
						alert("성공");
					},
					error : function() {
						alert("실패");
					}
				});
			});

});
