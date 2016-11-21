$(function(){
	
	
	$('.mr_a_ws').click(function(e){
		e.preventDefault();
		
		var uri = $(this).attr('href');
		
		console.log(uri);
		
		window.open(uri,'_blank','width=600,height=300');
		
		$(this).removeClass('mr_a_red_ws');
		$(this).addClass('mr_a_black_ws');
	});
})