$(function(){
	
	var $form = $('#ms_form_ws');
	
	$form.on('submit',function(){
		
		
		var $div_title = $('#ms_div_title_ws');
		var $div_content = $('#ms_div_content_ws');
		
		if($('#ms_title_ws').val() == ''){
			
			alert("제목을 입력해주세요!");
			$div_title.removeClass("has-success");
			$div_title.addClass("has-error");
			
			return false;
		}else{
			
			$div_title.removeClass("has-error");
			$div_title.addClass("has-success");
		}
		
		if($('#ms_content_ws').val() ==''){
			
			alert("내용을 입력해주세요!");
			$div_content.removeClass("has-success");
			$div_content.addClass("has-error");
			
			return false;
		}else{
			
			$div_content.removeClass("has-error");
			$div_content.addClass("has-success");
		}
		
	})
	
})