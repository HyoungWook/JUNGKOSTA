$(function(){
	var flag = false;
	var payment = $('#payment').val();
	var purchase = $('#purchase').val();
	var sale = $('#sale').val();
	var email = $('#email_').val();
	var subca_id = $('#subcaId').val();
	$('.order_sure').on('click', function(){
			alert('dd');
			var sendData = "purchase_id=" + purchase + "&sale_id=" + sale + "&flag="+flag;
			$.ajax({
				url: "threadTest2",
				type:"POST",
				data: sendData,
				dataType:"text",
				success:function(data){
					if(data== "SUCCESS"){
						alert("성공");
						sendRedirect(subca_id);
					}
				},
				error:function(data){
					alert("에러발생");
				} 
			}) 
				
});
	function sendRedirect(subca_id){
		location.href="tradeList?subca_id=" +  subca_id;
	}	
	
});