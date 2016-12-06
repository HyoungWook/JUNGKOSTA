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

	var sort = "add_sort"; // 정렬 문자열
	var page = 1; // 현제 페이지

	$(".button_radio").each(function() {
		$(this).change(function() {

			$('.item_list_phw').empty().hide();
			$('#loading_phw').stop();
			$('#loading_phw').fadeIn();

			if ($(this).is(":checked")) {
				sort = $(this).val();
				getListData(sort);
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
				
				var obj = getCaAndSta();

				var data = "page=" + (++page) + "&";
				data += "sort=" + sort + "&",
				data += "categoryList=" + obj.category + "&",
				data += "statusList=" + obj.status;

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

	// checkbox event start
	var $all_item = $(".all_item");
	var $checkbox = $(".check_phw input:checkbox:not(.all_item)");

	$all_item.click(function(event) {
		var type = (this.id).substring(0, (this.id).indexOf("_"));
	
		$(this).prop("checked", true);
		
		$("." + type).each(function(index) {
			$(this).prop("checked", false);
			checkLabelClass($(this), false);
		});
		
		getListData(sort);

	});

	$checkbox.click(function(event) {
		var type;

		if ($(this).hasClass("category")) {
			type = "category";
		} else if ($(this).hasClass("status")) {
			type = "status";
		}

		checkedAll_item(type);
		getListData(sort);
	});

	function checkedAll_item(type) {

		var $all = $("#" + type + "_all");

		if ($("." + type + ":checked").length == 0) {
			$all_item.prop("checked", true);
			checkLabelClass($all, true);
		} else {
			$all_item.prop("checked", false);
			checkLabelClass($all, false);
		}
	}

	function checkLabelClass(obj, flag) {
		if (flag) {
			obj.parent().addClass("ui-checkboxradio-checked");
			obj.parent().addClass("ui-state-active");
		} else {
			obj.parent().removeClass("ui-checkboxradio-checked");
			obj.parent().removeClass("ui-state-active");
		}
	}
	// end checkbox event

	function getListData(sort) {
		page = 1;

		var obj = getCaAndSta();

		$('.item_list_phw').empty().hide();

		var data = "sort=" + sort + "&";
		data += "categoryList=" + obj.category + "&";
		data += "statusList=" + obj.status;

		$.getJSON("auctionListSort?" + data, function(data) {
			$.each(data, function(index, entry) {
				var listInfo = getListInfo(entry);
				var html = template(listInfo);
				$(".item_list_phw").append(html);
			});
		});

		$('.item_list_phw').fadeIn();
	}

	function getCaAndSta() {
		var categoryList = [];
		var statusList = [];

		$checkbox.each(function(index) {
			if ($(this).prop("checked")) {
				if ($(this).hasClass("category")) {
					categoryList.push($(this).val());
				} else if ($(this).hasClass("status")) {
					statusList.push($(this).val());
				}
			}
		});

		return {
			category : categoryList,
			status : statusList
		}
	}

	checkedAll_item("category");
	checkedAll_item("status");
	getListData(sort);

});
