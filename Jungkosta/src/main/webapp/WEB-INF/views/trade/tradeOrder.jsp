<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery -->
<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



<!-- Javascript -->
<script type="text/javascript" src="/Jungkosta/resources/js/trade/itemorder.js"></script>

<!-- Css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- Bootstrap -->
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
 <link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<!-- daum map api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	
<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, "맑은 고딕",
		"Malgun gothic", sans-serif;
}

.right_ktw {
	width: 40%;
	height: 100%;
	margin-left: 150px;
}

#item_sub_imgs_ktw {
	width: 30px;
	height: 30px;
}

#layer {
	display: none;
	position: fixed;
	overflow: hidden;
	z-index: 1;
	-webkit-overflow-scrolling: touch;
}

#btnCloseLayer {
	cursor: pointer;
	position: absolute;
	right: -3px;
	top: -3px;
	z-index: 1;
}
</style>
	
<script type="text/javascript">
$(function() {

	$('#pointbtn_tw').on('click', function(event) {
		var $point = $('.point_tw').val();//사용할 마일리지
		var hp = $('#havingpoint').val(); //보유 마일리지
		alert(hp);
		alert($point);

		if (hp >= $point) {
			var result = hp - $point; //보유 마일리지 - 마일리지

			alert('남은 마일리지 : ' + result);
			$('#havingpoint').val(result);

			$('#Havingpoint_tw').text(result); //나머지 마일리지

		} else {
			alert('보유 마일리지가 부족합니다.');
			$('.point_tw').val("");
			//$('#Havingpoint_tw').text(hp);
		}
		$('#cancelbtn_tw').on('click', function(event) {
			alert(hp);
			$('#Havingpoint_tw').text(hp);
			$('#havingpoint').val(hp);

		})
	})
});
/* 	 $('.radio_btn').checkboxradio();
 $('.radio_btn').click(function(event){
 var btn_radio = $(this).val();

 // alert($itemPrice);
 alert(btn_radio);

 chargeType(this.id);
 });

 function chargeType(id) {
 var $itemPrice = ('#itemcost').val();
 var type = "";
 var persent;


 if (id == "radio-2") {
 persent = 0.01;

 } else {
 persent = 0.03;

 }

 var charge = ($itemPrice * persent);
 var total = $itemPrice + charge + 2500;
 var charge_str = addComma(charge);
 var total_str = addComma(total);


 $('#extraPriceRst_ktw').text(charge_str + " 원"); 
 $("#total_Price_ktw").text(total_str + " 원");
 $("#cost").val(total);


 }

 function addComma(data_value) {
 return Number(data_value).toLocaleString('en');
 } */
</script>
	
<title>Insert title here</title>

<script>
function sample4_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('sample4_roadAddress').value = fullRoadAddr;
					document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

					// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
					if (data.autoRoadAddress) {
						//예상되는 도로명 주소에 조합형 주소를 추가한다.
						var expRoadAddr = data.autoRoadAddress
								+ extraRoadAddr;
						document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
								+ expRoadAddr + ')';

					} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
								+ expJibunAddr + ')';

					} else {
						document.getElementById('guide').innerHTML = '';
					}
				}
			}).open();
}
</script>

</head>
<body>
	<div class="container">
		<form action="/Jungkosta/trade/tradeOrderProc" method="post">
			<h2>주문하기</h2>
			<input type="hidden" name="item_name" value="${register.item_name} ">
			<input type="hidden" name="item_status" value="${register.item_status} ">
			<input type="hidden" name="item_scratch" value="${register.item_scratch} ">
			<input type="hidden" name="additional_info" value="${register.additional_info} ">
			<input type="hidden" name="buy_info" value="${register.buy_info} ">
			
			<input type="hidden" name="subca_id" value="${register.subca_id} ">
	
			<input type="hidden" name="sale_status" value="${register.sale_status} ">
			<input type="hidden" name="item_pic1" value="${register.item_pic1} ">
			<input type="hidden" name="item_pic2" value="${register.item_pic2} ">
			<input type="hidden" name="item_pic3" value="${register.item_pic3} ">
			<input type="hidden" name="item_pic4" value="${register.item_pic4} ">
	<div class="row">
		<div class="col-md-offset-1 col-md-4 left_ktw">
			<h3>배송 정보</h3>
			<br> <br>

			<h4>이름</h4>
			<h4>
				<input type="text" class="form-control korean"
					placeholder="이름(한글만 가능)" value="${member.name }" name="name">
			</h4>
			<br>
			<h4>전화번호</h4>
			<h5 class="tel form-group">
				<input type="text" class="form-control phone_num"
					placeholder="'-'없이 입력" value="${member.phone_num }"
					name="phone_num">
			</h5>
			<br>
			<div class="addressForm_ktw form-group">
				<h4>주소</h4>

				<div class="row">
					<div class="col-md-9 addressForm_ktw">
						<input type="text" class="form-control address_ktw"
							id="sample4_postcode" name="postCode" placeholder="우편번호"
							value="${address1}" />


					</div>
					<div class="col-md-3">
						<input type="button" id="sample4_postcode"
							class="btn btn-primary" value="우편번호 찾기"
							onClick="sample4_execDaumPostcode()">

					</div>
				</div>

				<!----------------------------------------------------------------  -->
				<h4>상세주소</h4>
				<h5>
					<input type="text" class="form-control" id="sample4_roadAddress"
						name="address" placeholder="도로명주소" value="${address2}" /><br>
					<input type="text" class="form-control" id="sample4_jibunAddress"
						name="address" placeholder="상세주소" value="${address3}" /><br>
				</h5>
				<div id="layer">
					<img
						src="//i1.daumcdn.net/localimg/localimage_ktws/07/postcode/320/close.png"
						id="btnCloseLayer" alt="닫기 버튼">
				</div>
			</div>
			<br>
			<hr>

			<h4>결제수단</h4>
			<!-- 	<br> <br>
			 -->
			<div class="row">
				<div class="col-md-6">

					<label for="radio-1">실시간 계좌이체</label> <input type="radio"
						name="payment_method" id="radio-1" class="radio_btn"
						value="실시간계좌이체"> &nbsp;&nbsp;&nbsp;&nbsp;수수료 : 3%<br>
					<h5 id="extraPrice_ktw"></h5>
				</div>

				<div class="col-md-6">
					<label for="radio-2">무통장입금</label> <input type="radio"
						name="payment_method" id="radio-2" class="radio_btn"
						value="무통장입금"> <br> &nbsp;&nbsp;수수료 : 1%
				</div>




				<input type="hidden" value="500" id="havingpoint">
			</div>
			<br>
		</div>
		<div class="col-md-offset-1 col-md-6 right_ktw">
			<h3>결제 상품</h3>
			<br>
			<div class="row">
				<div class="col-md-offset-1 col-md-2">
					<div id="item_sub_imgs_ktw">
						<img alt="" src="displayFile?fileName=${register.item_pic1}">
					</div>
					<br>
				</div>
				<div class="col-md-offset-2 col-md-7">
					<div id="item_num_name_ktw">${register.sale_id }/
						${register.item_name }</div>
				</div>
				<input type="hidden" name="sale_id" value="${register.sale_id }">
				<br>

			</div>
			<br> <br> <br>
			<hr>
			<div class="row">
				<div class="col-md-offset-1 col-md-4">
					<h4>상품 금액</h4>
					<br>
					<h5 id="extraprice_ktw">수수료 :</h5>
					<br>
					<h4>마일리지</h4>
					<br>
					<h5>보유 마일리지</h5>
					<br> <br>
					<h4>배송료</h4>
					<br> <br>
					<h4 class="text-primary">총 결제 금액</h4>
					<br>
				</div>
				<div class="col-md-offset-2 col-md-5">
					<h4 id="item_Price_ktw">
						<fmt:formatNumber value="${register.item_cost }" pattern="#,###" />
						원
					</h4>
					<input type="hidden" id="itemcost" value="${register.item_cost }" name="item_cost">
					<br>
					<h5 id="extraPriceRst_ktw">
						<fmt:formatNumber value="${register.item_cost*0.01 }"
							pattern="#,###" />
						원
					</h5>
					<br>
					<div class="row">
						<div class="col-md-5 form_point">
							<h4>
								<input type="text" size="3" class="form-control point_tw"
									name="point">

							</h4>
						</div>
						<div class="col-md-7">
							<!-- 	<h4>
								<button type="button" class="btn btn-primary"
									name="mileage_button_ktw" id="pointbtn_tw">사용</button>
								<button type="button" class="btn btn-primary"
									name="mileage_button_ktw" id="cancelbtn_tw">취소</button>
							</h4> -->
						</div>
						<br> <br> <br>
					</div>
					<h5 id="Havingpoint_tw">
						<fmt:formatNumber value="100" pattern="#,###" />
						원
					</h5>
					<br> <br>
					<h4 id="delivery_Price_ktw">
						<fmt:formatNumber value="${deliveryPrice}" pattern="#,###" />
						원
						<input type="hidden" name="delivery_cost" value="${deliveryPrice }">
					</h4>
					<input type="hidden" name="delivery_cost"
						value="${deliveryPrice}"> <input type="hidden"
						name="email" value="xodhks77@naver.com"> <br> <br>


					<%-- <h4 id="total_Price_ktw">${deliveryPrice + register.item_cost}원</h4> --%>
					
					<h4 id="total_Price_ktw">
					<fmt:formatNumber value="${deliveryPrice + register.item_cost 
					+ register.item_cost*0.01}" pattern="#,###"/>원</h4>
					<br> <input type="hidden" name="purchase_cost" id="cost"
						value="${deliveryPrice + register.item_cost + register.item_cost*0.01}">
							<br>
						</div>
					</div>
					<br>
					<hr>	

					<button type="submit" class="btn btn-primary btn-lg">주문하기</button>
					<a href="/Jungkosta/trade/tradeList?subca_id=${register.subca_id }"><button type="button"
							class="btn btn-danger btn-lg" id="signbutton_khw">취소</button></a>
				<!-- 	<button type="button" class="btn btn-primary btn-lg payProc"
						data-target="#myModal" data-toggle="modal" id="orderButton_ktw">주문하기</button> -->
					


				</div>
			</div>

	<!-- 		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">주문하기</h4>
						</div>
						<div class="modal-body modalBody">
						
	
	<div class="tw_form">
		<table class="deposit">
			<tr><td><strong>무통장입금</strong></td></tr>
		<tr>
		<td width="100" align="right"><label for="deposit_bank">은행
				: </label></td>
		<td width="300"><select name="bank" id="deposit_bank">
				<option>신한 은행</option>
				<option>국민 은행</option>
				<option>농협</option>
		</select></td>
	</tr>
	<tr>
		<td align="right"><label>예금주 : </label></td>
		<td align="left"><label>중코스타</label></td>
	</tr>
	<tr>
		<td align="right"><label>계좌번호 : </label></td>
		<td><input type="text" name="account_no" size="30"></td>
	</tr>
</table>	
			
	</div>
	<div class="tw_form">
	<table class="transfer">
	<tr><td><strong>실시간계좌이체</strong></td></tr>
	<tr>
		<td width="100" align="right"><label for="transfer_bank">은행
				: </label></td>
		<td width="300"><select name="bank" class="bank"
			id="transfer_bank">
				<option>신한 은행</option>
				<option>국민 은행</option>
				<option>농협</option>
		</select></td>
	</tr>
	<tr>
		<td align="right"><label>예금주 : &nbsp;</label></td>
		<td align="left"><label>중코스타</label></td>
		<td><input type="text" name="name" size="20" value=""></td>
	</tr>
	<tr>
		<td align="right"><label>내 계좌번호 :</label></td>
		<td><input type="text" name="account_no" size="30"></td>
	</tr>

	<tr>
		<td align="right"><label>비밀번호 : &nbsp;</label></td>
		<td><input type="password" name="account_no" size="30"></td>
	</tr>

	<tr>
		<td align="right"><label>계좌번호 : &nbsp;</label></td>
		<td><input type="text" name="account_no" size="30"></td>
	</tr>
</table>
	</div>
						 </div>
						<div class="modal-footer">

							<button type="submit" class="btn btn-primary">주문</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>
					</div>
					/.modal-content
		</div>
		/.modal-dialog
	</div>
	/.modal -->
		</form>
	

	</div>
</body>
</html>