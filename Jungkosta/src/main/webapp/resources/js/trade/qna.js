$(function() {
	$("#reply").submit(function(event) {
		event.preventDefault();

		$.ajax({
			url : "insertQA.jsp",
			type : "post",
			data : $(this).serialize(),
			dataType : "json",
			success : successHandler,
			error : function() {
				alert("실패");
			}

		});

	});

	function successHandler(data) {
		$(".reply_table_si tbody").empty().hide();

		$.each(data, function(index, entry) {
			var html = "<tr>";
			html += "<td>" + (index + 1) + "</td>";
			html += "<td>" + entry.content + "</td>";
			html += "<td>" + entry.email + "</td>";
			html += "</tr>";

			$(".reply_table_si tbody").append(html);
		});
		$(".reply_table_si tbody").fadeIn();
		$(".reply_table_si textarea").focus();

	}
	
	$('#item_sub_imgs_ktw').find('img').on('click', function() {
		
		var that = $(this).attr('src');
		
		$('.item_ktw').attr('src', that);
	});

});
