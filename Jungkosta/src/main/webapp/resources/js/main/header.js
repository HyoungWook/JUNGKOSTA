$(function() {
	var $form_header_ws = $('#form_header_ws');
	var reg = /\+/g;
	
	var id = setInterval(function() {
		if ($('#hidden_email_ws').val() != '') {
			$.ajax({

				type : "post",
				url : "/Jungkosta/messageCheck",
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


	$form_header_ws.on('click',function(event){
		
		var email = $('#email_ws').val();
		var password = $('#password_ws').val();
		
		
		$.ajax({
			
			url:"loginProc",
			type:"post",
			datatype:"text",
			cache:false,
			data:"email="+email+"&password="+password,
			success:function(data){
				
				var decodeData = decodeURIComponent(data.replace(reg," "));
				
				var result = decodeData.trim();
				
				alert(result);
				if(result != '아이디나 비밀번호가 틀렸습니다.'){
					
					location.reload();
				}
			},
			error:function(){
				
			}
			
			
		})
		
	});
});
