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
	<button type="button" class="btn btn-lg payProc"
			data-target="#myModal" data-toggle="modal" id="orderButton_ktw">구매확정2</button>
			
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">판매자평</h4>
				</div>
				<div class="modal-body modalBody">

					<div class="tw_form">
						<table class="transfer">
						<!-- 	<tr>
								<td><strong>실시간계좌이체</strong></td>
							</tr> -->
							<tr>
								<td width="100" align="center"><label for="transfer_bank">은행명
										&nbsp; </label></td>
							<td width="300"><select name="bank" id="deposit_bank">
									<option>신한 은행</option>
									<option>국민 은행</option>
									<option>농협</option>
								</select></td>
							</tr>
						<tr>
						<td align="center"><label>내 계좌번호 &nbsp;</label></td>
						<td align="left">
						 <input type="text" name="account_no" size="20"><%--  <label>${member.account_num }</label> --%>
						</td>
					</tr>

						<tr>
						<td align="center"><label>비밀번호 &nbsp;</label></td>
						<td><input type="password" name="account_no" size="20"
									id="password2" value=""></td>				
						<td><input type="hidden" id="originPw" value="${member.password }">
			<input type="hidden" id="paymentCost" value="${purchase_ktw.purchase_cost}"></td>		
							</tr>
							<tr>
								<td align="center"><label>예금주  &nbsp;</label></td>
								<td align="left"><label>${admin.name }</label></td>
								<!-- <td><input type="text" name="name" size="20" value=""></td> -->
							</tr>
							<tr>
								<td align="center"><label>계좌번호  &nbsp;</label></td>
								<td>
									<!-- <input type="text" name="account_no" size="30"> --> <label>${admin.account_num }</label>
								</td>
							</tr>

						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="check">주문</button>
					<button type="button" class="btn btn-default"
						data-dismiss="modal">취소</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->		
</body>
</html>