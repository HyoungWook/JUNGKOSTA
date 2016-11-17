$(function() {

	var $status = $("#status").val();
	var $end_date = $("#end_date").val();
	var timeId = "";

	$("#auction_record")
			.click(
					function() {

						var listBid_page = window
								.open("listBidding_phw.jsp", "newWindow",
										'width=550, height=500, menubar=yes, status=yes, scrollbar = yes');

						return false;
					});

	function getTime() {

		var now = new Date();

		var date = new Date($end_date);

		var dd = Math.floor((date - now) / 1000 / 60 / 60 / 24);

		var hour = Math.floor(((date - now) / 1000 / 60 / 60) - (dd * 24));

		var minute = Math.floor(((date - now) / 1000 / 60) - (dd * 24 * 60)
				- (hour * 60));

		var second = Math.floor(((date - now) / 1000) - (dd * 24 * 60 * 60)
				- (hour * 60 * 60) - (minute * 60));

		var time = dd + "일 " + hour + "시간 " + minute + "분 " + second + "초";

		$(function() {
			$("#remainning_time_phw").text(time);

		});

	}

	if ($status == "false") {
		timeId = setInterval(getTime, 1000);
	} else {
		clearInterval(timeId);
		$(function() {
			$("#remainning_time_phw").text("경매 종료");

		});
	}

	$("#bid_button_phw")
			.click(
					function() {
						if ($status == "false") {
							var bid_page = window
									.open("bidRegisterForm", "newWindow",
											'width=550, height=700, menubar=yes, status=yes, scrollbar = yes');
						} else {
							alert("해당 상품은 경매가 종료된 상품입니다.");
						}
					});

	$("#reply_phw").submit(function(event) {
		event.preventDefault();
		var email = $("#email").val();

		if (email == "" || email == null) {
			alert("로그인해 주세요.");
			$("#content").val("")
		} else {
			$.ajax({
				url : "reply_server_phw.jsp",
				type : "post",
				dataType : "json",
				data : $(this).serialize(),
				success : successHandler,
				error : function() {
					alert("실패");
				}
			});
		}

	});

	function successHandler(data) {
		$('#listReply').empty().hide();
		$.each(data, function(index, entry) {
			var html = "<tr>";
			var date = new Date(entry.register_date.time);

			var time = date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
					+ date.getDate();

			html += "<td align='center'>" + (data.length - (index)) + "</td>";
			html += "<td>" + entry.content + "</td>";
			html += "<td align='center'>" + entry.email + "</td>";
			html += "<td align='center'>" + time + "</td>";
			html += "</tr>"

			$('#listReply').append(html);
		});
		$('#listReply').fadeIn();
		$('#content').focus();
		$('#content').val("");

	}

});
