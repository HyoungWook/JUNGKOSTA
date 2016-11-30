$(function() {
		$('#pointbtn_tw').on('click', function(event) {
			var $point = Number($('.point_tw').val());//사용할 마일리지
			var hp = Number($('#havingpoint').val()); //보유 마일리지
			var backPoint = hp - $point;
			var $cost = Number($("#cost").val());
		
			if (hp >= $point) {
			  var usePoint =confirm($point + ' 마일리지를 사용하시겠습니까?');
			  if(usePoint == true){
				  alert('사용 성공!');
				var result = hp-$point;
				var change_result = addComma(result);
				$('#Havingpoint_tw').text(change_result + "원");
		
				$('.point_tw').val($point);
				var total = $cost - $point;
				var total_str = addComma(total);
			
				$("#total_Price_ktw").text(total_str + " 원");
				$("#cost").val(total);
			  }
				
			} else {
				alert('마일리지가 부족합니다.');
				return false;
			}
			
		})
		
		function addComma(data_value) {
			return Number(data_value).toLocaleString('en');
		}

});