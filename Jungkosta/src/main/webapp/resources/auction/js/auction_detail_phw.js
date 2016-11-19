$(function() {

	var template = Handlebars.compile($("#template").html());
	
	var $status = $("#status").val();
	var $end_date = $("#end_date").val();
	var $sale_id = $("#sale_id").val();
	var timeId = "";
	
	
	$("#auction_record")
			.click(
					function() {

						var listBid_page = window
								.open("listBidding_phw.jsp/", "newWindow",
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
									.open("bidRegisterForm/" + $sale_id, "newWindow",
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
				url : "replyRegister",
				type : "post",
				dataType : "text",
				data : $(this).serialize(),
				success : getRelyList,
				error : function(){
					alert("댓글 불러오기 실패");
				}
			});
		}

	});

	function getRelyList() {
		
		$.getJSON("replyList/" + $sale_id, function(data){

			$('#listReply').empty().hide();
			$.each(data, function(index, entry) {
				
				var date = new Date(entry.register_date);
				
				var time = date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
						+ date.getDate();
				
				var info = {
						index : data.length - (index),
						content : entry.content,
						email : entry.email,
						time : time,
						sale_id : entry.sale_id,
						item_qa_id : entry.item_qa_id,
						qa_level : entry.qa_level
				}
				
				var html = template(info);
	
				$('#listReply').append(html);
			});
			$('#listReply').fadeIn();
			$('#content').focus();
			$('#content').val("");
		});
	}
	
	
	
	
	// start 현우 추가 부분

	var sale_id = $("#sale_id").val();
	
	var $main = $("#item_main_phw");
	var $thumbs = $("#item_sub_imgs_phw img");
	
	$thumbs.eq(0).addClass("active_phw");
	
	var src = $thumbs.eq(0).attr("src");
	$main.attr("src", getImagePath(src));
	
	function getImagePath(imagePath){
		var front = imagePath.substring(0, imagePath.lastIndexOf("/") + 1);
		var end = imagePath.substring(imagePath.lastIndexOf("/") + 3 );
		
		return front + end;
	}
	
	$thumbs.click(function(){
		$thumbs.removeClass("active_phw");
		
		$(this).addClass("active_phw");
		
		src = $(this).attr("src");
		
		$main.hide();
		
		$main.attr("src", getImagePath(src)).fadeIn();
	});
	
	
	$.getJSON("item_pic/" + sale_id, function(data){
		var html = "";
		$.each(data, function(index, item){
			html += "<img alt='item_pic' src='displayFile?fileName=" + getImagePath(item) + "' > <br>";
		});
		
		$("#item_pic_list").html(html);
		
	});
	
	var templateReply = Handlebars.compile($("#templateReply").html());
	
	Handlebars.registerHelper("if_phw", function(qa_level, block) {
		var accum = "";

		if (qa_level != 1) {
			if(block.fn().lastIndexOf("button") != -1){
				accum += block.fn();
			}
		}else{
			if(block.fn().lastIndexOf("img") != -1){
				accum += block.fn();
			}
		}
		return accum;
	});

	// 답변 달기 버튼 이벤트
	$("#listReply").on("click", "button", function(){
		
		var $now_tag = $(this).parent().parent();
		var ref = $(this).parent().find("input[name=item_qa_id]").val();
		
		if($(this).hasClass("created_phw")){
			$(this).removeClass("created_phw");
			$now_tag.next().remove();
		}else{
			$(this).addClass("created_phw");
			
			var info = {
					sale_id : $(this).next().val(),
					ref : ref
				};
			
			var html = templateReply(info);
			
			$now_tag.after(html);

		}

	});
	
	// 답변 완료 버튼 이벤트
	$("#listReply").on("submit", "tr form", function(event){
		event.preventDefault();
		
		$.ajax({
			url : "replyRegister",
			type : "post",
			dataType : "text",
			data : $(this).serialize(),
			success : getRelyList,
			error : function(){
				alert("댓글 불러오기 실패");
			}
		});
		
		$(this).parent().parent().remove();
		
	});

	getRelyList();
	
});
// end 현우 추가 부분
