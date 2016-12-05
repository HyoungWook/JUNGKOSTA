$(function(){
	var status = $('#status').val();
	var status2 =$('#status2').val();
	var purchase_email = $('#purchase_email').val();
	var email = $('#session_email').val();
	
/*	if(purchase_email == email){
		status2.hide();
	}else{
		status2.show();
	}*/
	$('.btn_check').on('click', function(){
		//alert('aa');
		if(purchase_email!=email){
			if(status=='거래중'){
				alert('본 상품은 거래중인 상품입니다.');
				return false;
			}else if(status=="거래완료"){
				alert('본 상품은 거래가 종료된 상품입니다.');
				return false;
			}
			
		}else{
			if(status=='거래중'){
				alert("마이페이지를 이용해주세요.");
				self.location="/Jungkosta/purchaseList";
				return false;
			}else if(status=="거래완료"){
				alert('본 상품은 거래가 종료된 상품입니다.');
				return false;
			}
		}
	})
})