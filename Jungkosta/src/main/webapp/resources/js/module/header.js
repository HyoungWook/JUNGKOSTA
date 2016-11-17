$(function() {

	var $form_header_ws = $('#form_header_ws');
	
	var id = setInterval(function() {
		if ($('#hidden_email_ws').val() != '') {
			$.ajax({

				type : "post",
				url : "../main/message_check.jsp",
				dataType : "text",
				cache : false,
				success : function(data) {
						
					var value = '메시지 수신';

					$('#a_message_ws').html(value + ' (' + data + ')');

				},
				error : function() {
				}

			})
		}
	}, 1000);


	$form_header_ws.on('submit',function(){
		
		var email = $('#email_ws').val();
		var password = $('#password_ws').val();
		
		$.ajax({
			
			url:"../main/login_action.jsp",
			type:"post",
			datatype:"text",
			cache:false,
			async:false,
			data:"email="+email+"&password="+password,
			success:function(data){
				
				var result = data.trim();
				
				alert(result);
			},
			error:function(){
				
			}
			
			
		})
		
	});
});
