$(function(){

	$(".sub_filter_ktw").find("input").checkboxradio({
		icon : false
	});
	

	$(".radio_btn input").checkboxradio({
		icon : false
	});
	$("#radio_btn").controlgroup();
	
	function successHandler(data) {
		$('.item_list_ktw').empty().hide();
		$.each(data,function(index, entry) {
							var html = "<div class='col-md-3 item_info_ktw' onclick='sendDetail("
									+ entry.sale_id + ")'>";
							/*html += "<b>무료배송</b>";*/
							/*html += "<img id='icon_auc_phw' alt='' src='./images_phw/icon_auc.png'>";*/
							html += "<div class='item_img_ktw'>";
							html += "<img id='item_main_img' alt='' src='../upload/"
									+ entry.item_pic + "'>";
/*							if (entry.auction_end_status == "true") {
								html += "<img id='close_auc_phw' alt='' src='./images_phw/auction_close.png'>";
							}*/

							html += "</div>";
							html += "<div>";
						/*	html += "	<a>관심상품 담기</a> | <a>미리 보기</a>";*/
							html += "</div>";
							html += "<br> <br> <b class='item_name_ktw'>"
									+ entry.item_name + "</b>";
							/*html += "<br> <br> <span>현재가 </span> &nbsp;&nbsp; <strong class='product_price_phw'>";*/
							html += addComma(entry.item_cost) + " 원";
							html += "</strong>";
							html += "</div>";

							$('.item_list_ktw').append(html);
						});

		$('.item_list_ktw').fadeIn();
	/*	$('#loading_phw').fadeOut();*/
	}
	
	function addComma(data_value) {
		return Number(data_value).toLocaleString('en');
	}

/*	$('.item_info_ktw').on('click', function(){
		
		$.ajax({
			url:""
		    type:
		    data:
		    dataType:
		    success:
		    error:
		})	
	})*/
	
	$(".button_radio").each(function() {
		$(this).change(function() {
			/*$('#loading_phw').stop();
			$('#loading_phw').fadeIn();*/
			
			if ($(this).is(":checked")) {
				var sort = $(this).val();
				/*var data = "sort=" + sort;*/
				$.ajax({
					url : "/tradeAndList",
					type : "POST",
					dataType : "text",
					data : sort,
					success : successHandler,
					error : function() {
						alert("실패");
					}
				});
			}

		});

	});

});