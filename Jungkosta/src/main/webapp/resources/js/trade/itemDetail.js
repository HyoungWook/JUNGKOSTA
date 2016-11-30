$(function(){
	var status = $('#status').val();
	
	$('.btn_check').on('click', function(){
		if(status=="거래완료"){
			alert('본 상품은 거래가 종료된 상품입니다.');
			return false;
		}
	})
})