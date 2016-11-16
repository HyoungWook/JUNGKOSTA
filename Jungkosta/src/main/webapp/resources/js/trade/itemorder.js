$(function(){
	
	
	var telreg = /^\d{2,3}\d{3,4}\d{4}$/;
	var numReg = /^[0-9]+$/;
	var $havingpoint = $('#Havingpoint_tw').text();
	 $('.korean').keyup(function(event){
	      
	      if(!(event.keyCode >= 37 && event.keyCode <= 40)){
	         
	         var val = $(this).val();
	         
	         $(this).val(val.replace(/([^가-힣ㄱ-ㅎㅏ-ㅣ\x20])/gi,''));
	      }
	      
	   });
	
	$('.phone_num').keyup(function(event) {
		var result = telreg.test($(this).val());
		if(!result){
			$('.tel').removeClass("has-success");
			$('.tel').addClass("has-error");
			if($(this).val() == ''){
				$('.tel').removeClass("has-error");
				$('.tel').removeClass("has-success");
			}
		}
		else{
			$('.tel').removeClass("has-error");
			$('.tel').addClass("has-success");
		}
	});
	
		
		$('.point_tw').keyup(function(event) {
			
			var result2 = numReg.test($(this).val());
		
			if(!result2){
				$('.form_point').removeClass("has-success");
				$('.form_point').addClass("has-error");
				/*alert('숫자를 입력해주세요.');*/
			}
			else{
				$('.form_point').removeClass("has-error");
				$('.form_point').addClass("has-success");
			}
		
			
			
		})
			
		
	$('form').submit(function(event){
		var $name = $('.korean');
		var $phone_num = $('.phone_num');
		var $address = $('.address_ktw');
		var $point = $('.point_tw');
		if($name.val()==''){
			$('.korean').addClass('has-error');
			$('.korean').focus();
			alert('이름을 입력하세요.');
			
			return false;
		}
		
		if($address.val() ==''){
			$('.addressForm_ktw').addClass('has-error');
			$('.addressForm_ktw').focus();
			alert('주소를 입력하세요.');
			
			return false;
		}else{
			$('.addressForm_ktw').removeClass("has-error");
			$('.addressForm_ktw').addClass("has-success");
			
		}
		if($phone_num.val()=='' && telreg.test($phone_num.val())==false){
			$('.phone_num').focus();
			alert('전화번호 형식에 맞게 입력해주세요.');
			return false;
			
		}else{
			$('.tel').removeClass("has-error");
			$('.tel').addClass("has-success");
		}
		
	});
		 $('.radio_btn').checkboxradio();
		 $('.radio_btn').click(function(event){
			 var btn_radio = $(this).val();
			
			// alert($itemPrice);
			 
			 chargeType(this.id);
			 
				$('#orderButton_ktw').click(function(){
					if(btn_radio == "실시간계좌이체"){
						$('.modalBody').hide().load('withdraw.html', function() {
							$(this).fadeIn();
						});

					/*	return false;*/ 
					}
					else if(btn_radio =="무통장입금"){
						$('.modalBody').hide().load('ATM.html', function() {
							$(this).fadeIn();
						});

					}
				})
				
		 });
		 
		 function chargeType(id) {
			var $itemPrice = $('#itemcost').val();
			var type = "";
			var persent;
			

			if (id == "radio-2") {
				persent = 0.01;
				
			} else {
				persent = 0.03;
			
			}

			var charge = ($itemPrice * persent);
			var total = parseInt($itemPrice) + charge + 2500;
			var charge_str = addComma(charge);
			var total_str = addComma(total);

			
			 $('#extraPriceRst_ktw').text(charge_str + " 원"); 
			$("#total_Price_ktw").text(total_str + " 원");
			$("#cost").val(total);
			
			
		}
		
		function addComma(data_value) {
			return Number(data_value).toLocaleString('en');
		}
		
	
})