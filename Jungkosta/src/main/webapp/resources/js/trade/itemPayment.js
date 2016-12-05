$(function() {
	window.history.forward(1);
	
	var subca_id = $('#subca_id').val();
	var password2 = $('#password2');
	var originPw = $('#originPw').val();
	var payment = $('#paymentCost').val();
	var flag = false;
	$('#cancel_btn').on('click', function() {	
		var purchase_id = $('#purchase_Id').val();
		var sendData = "purchase_id=" + purchase_id;
		
		var cancel = confirm('주문을 취소하시겠습니까?');
		if (cancel == true) {
			alert("주문 취소");
			$.ajax({
				url: "DeletePurchase",
				type: "POST",
				data: sendData,
				dataType: "text",
				success: successHandler,
				error: function(data){
					alert('fail');
				}		
			})
		}
	})

		function successHandler(data){
			alert("성공");
			sendList(subca_id);
			
	}
	$('#orderButton_ktw').on('click', function(){
		flag = true;
	})
	
	
	$('#check').on('click', function(event) {
		var password = password2.val();
		flag = true;
		var sendData = "password=" + password;
		var paymentCost = Number(payment);
	
			$.ajax({
				url:"passCheck",
				data : sendData,
				type:'POST',
				dataType:"text",
				error:function(data){
					alert('에러');
					
				},
				success:function(data){
					if(data!= originPw){
						alert(data + '비밀번호가 올바르지 않습니다.');
						return false;
					}else if (data == originPw) {
						alert('비밀번호가 일치합니다.');

						var cost = prompt('결제할 금액을 입력하세요.', paymentCost);
						if (cost == paymentCost) {
							alert('결제 완료');
						} else {
							alert('결제할 금액이 올바르지 않습니다.');
							return false;
						}
					}
				
				}
			})
	});

	
	// F5 등 새로고침 이벤트 제거
   $(document).keydown(function(e) {

	      if (e.which === 116) {
	         if (typeof event == "object") {
	            event.keyCode = 0;
	         }
	         alert("'새로고침'이 금지되어 메인페이지로 이동합니다.");
	         self.location = "tradeList?subca_id=" +  subca_id;
	         return false;
	      } else if (e.which === 82 && e.ctrlKey) {
	         alert("'새로고침'이 금지되어 메인페이지로 이동합니다.");
	         self.location = "tradeList?subca_id=" +  subca_id;
	         return false;
	      }
	   });

	   // 브라우저 종료시 발생하는 이벤트
	   window.addEventListener("beforeunload", function(event) {
	    var confirmationMessage = "\o/";
	    var purchase_id = $('#purchase_Id').val();
	  	var sendData = "purchase_id=" + purchase_id;
	  	
	  	if(flag == false){
	         $.ajax({
	            url : "DeletePurchase2",
	            post : "post",
	        	data: sendData
	         });

	         (event || window.event).returnValue = confirmationMessage; // IE
	         return confirmationMessage; // chrome and fireFox
	  	}

	   });
	   
	function sendList(subca_id) {
		location.href = "/Jungkosta/trade/tradeList?subca_id=" + subca_id;
	}
});
