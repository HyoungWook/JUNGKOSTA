<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<script type="text/javascript">
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
</script>
<body>
	<h2>쓰레드</h2>
	<h3>${email }</h3>
	<h3>${purchase_id}</h3>
	<input type="hidden" name="email" id= "email_" value="${email }">
	<input type="hidden" name="purchase_id" id= "purchase" value="${purchase_id }">
	<input type="hidden" name="payment_id" id= "payment" value="${payment_id }">
	<input type="hidden" name="sale_id" id= "sale" value="${sale_id }">
	<input type="hidden" name="subca_id" id="subcaId" value="${subca_id }">
	<h3>${payment_id }</h3>
	<h3>${sale_id}</h3>
	<h3>${msg }</h3>
	<button class="order_sure" type="button">구매확정</button>
</body>
</html>