$(function(){
	var $spaceTest = $('#spaceTest');
	
	$spaceTest.keyup(function(event) {
		console.log($(this));
		
		if($(this).val() == ""){
			$('.test').removeClass('has-success');
			$('.test').addClass('has-error');
		}
		else{
			$('.test').removeClass('has-error');
			$('.test').addClass('has-success');
		}
		
	})
})
