$(function(){
	var $name_ws = $('#name_ws');
	var $resident_id_ws = $('#resident_id_ws');
	var $find_email_form_ws = $('#find_email_form_ws');
	
	$name_ws.on('keyup',function(event){
		if(!(event.keyCode >= 37 && event.keyCode <= 40)){
			
			var val = $(this).val();
			
			$(this).val(val.replace(/[0-9]+$/gi,''));
		}
		
		var $find_email_first_input_ws = $('#find_email_first_input_ws');
		
		if($(this).val() == ""){
			
			$find_email_first_input_ws.removeClass("has-success");
			$find_email_first_input_ws.addClass("has-error");
			
		}else{
			
			$find_email_first_input_ws.removeClass("has-error");
			$find_email_first_input_ws.addClass("has-success");
			
		}
	})
	
	$resident_id_ws.on('keyup',function(event){
		if(!(event.keyCode >= 37 && event.keyCode <= 40)){
			
			var val = $(this).val();
			$(this).val(val.replace(/[^0-9]/gi,''));
		}
		var $find_email_second_input_ws = $('#find_email_second_input_ws');
		
		if($(this).val() == ""){
			
			$find_email_second_input_ws.removeClass("has-success");
			$find_email_second_input_ws.addClass("has-error");
			
		}else{
			
			$find_email_second_input_ws.removeClass("has-error");
			$find_email_second_input_ws.addClass("has-success");
			
		}
	})
	
	$find_email_form_ws.on('submit',function(event){
		if($name_ws.val() == ""){
			
			event.preventDefault();
			
			$('#find_email_first_input_ws').removeClass("has-success");
			$('#find_email_first_input_ws').addClass("has-error");
			
			$name_ws.focus();
			
			$('#myModalLabel').html("에러!!");
			$('.modal-body p').html("이름 부분이 잘 못 되셨습니다!!");
			$('#myModal').modal('show');
			
			
		}
		
		if($resident_id_ws.val() =="" || $resident_id_ws.val().length != 13){
			
			event.preventDefault();
			
			$('#find_email_second_input_ws').removeClass("has-success");
			$('#find_email_second_input_ws').addClass("has-error");
			
			$('#myModalLabel').html("에러!!");
			$('.modal-body p').html("주민번호 부분이 잘 못 되셨습니다!!");
			$('#myModal').modal('show');
			
			$name_ws.focus();
			
			
			
		}
		
	})
})