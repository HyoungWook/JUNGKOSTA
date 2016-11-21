$(function(){
	$('#cancel_button_ws').click(function(){
		history.go(-1);
	});
	
	$('#form_blacklist_ws').submit(function(event){
	
		event.preventDefault();
		
		var admin_ws = $('#admin_ws').val();
		var id_ws = $('#id_ws').val();
		var reason_ws = $('#reason_ws').val();
		
		var param = "admin="+admin_ws+"&id="+id_ws+"&reason="+reason_ws;
		
		$.ajax({
			
			url:"blackListProc",
			datatype:"text",
			type:"post",
			data:param,
			cache:false,
			success:function(data){
				if(data == 1){
					alert("해당 회원을 블랙리스트에 등록하였습니다.");
				}else{
					alert("블랙리스트 등록에 실패 하였습니다.");
				}
			},
			error:function(){
				
			}
			
		})
		
	})
	
})