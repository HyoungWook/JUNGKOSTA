$(function(){
	
	var reg = /\+/g;
	
	$('#warning_cancel_button_ws').on('click',function(){
		
		history.go(-1);
		
	});
	
	$('#form_warning_ws').click(function(e){
		
		var title = $('#hidden_title_ws').val();
		var sender = $('#admin_ws').val();
		var receiver = $('#id_ws').val();
		var content = $('#reason_ws').val();
		var warning_num =$('#warning_num').val();
		
		var param =  "title="+title+"(경고 횟수 : "+warning_num+")&sender="+sender+"&receiver="
					+receiver+"&content="+content+"&warning_num="+warning_num;
			
		$.ajax({
			
			url : "/Jungkosta/warningProc",
			datatype:"text",
			cache:false,
			type:"post",
			data:param,
			success:function(data){
				
				var decodeData = decodeURIComponent(data.replace(reg," "));
				
				var result = decodeData.trim();
				
				alert(result);
			},
			error:function(){
				
			}
			
		})
		
	})
	
})