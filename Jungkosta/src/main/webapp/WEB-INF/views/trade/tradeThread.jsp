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

<!-- javaScript -->
<script src="/Jungkosta/resources/js/trade/threadList.js"></script>

<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
	<h2>쓰레드</h2>
	<h3>${msg }</h3>
	
	<button class="1order_sure" type="button">구매확정</button>
	
	<form action="/Jungkosta/trade/tradeSellerReview" method="post">
	<input type="hidden" name="email" id= "email_" value="${email }">
	<input type="hidden" name="purchase_id" id= "purchase" value="${purchase.purchase_id }">
	<input type="hidden" name="sale_id" id= "sale" value="${sale.sale_id }">
	<input type="hidden" name="subca_id" id="subcaId" value="${subca_id }">
		<input type="hidden" name="purchaser" value="${purchase.email }">
		<input type="hidden" name="seller" value="${sale.email }">
		
		<button type="button" class="btn btn-lg payProc" class="order_sure"
			data-target="#myModal" data-toggle="modal">구매확정2</button>
			
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">구매확정</h4>
				</div>
		
				<div class="modal-body modalBody">
					<div class="tw_form">
						<table class="transfer">
							<tr>
								<td width="100" align="center"><label for="transfer_bank">만족도
										&nbsp; </label></td>
							<td width="300"><select name="satisfaction" id="satisfaction_">
									<option>0</option>
									<option>0.5</option>
									<option>1</option>
									<option>1.5</option>
									<option>2</option>
									<option>2.5</option>
									<option>3</option>
									<option>3.5</option>
									<option>4</option>
									<option>4.5</option>
									<option>5</option>
								</select></td>
							</tr>
						<tr>
						<td align="center"><label>판매자평 &nbsp;</label></td>
						<td align="left">
						 <input type="text" name="content" size="20"><%--  <label>${member.account_num }</label> --%>
						</td>
					</tr>
						<tr>
						<td align="center"><label>구매자 &nbsp;</label></td>
						<td><label>${purchase.email}</label></td>					
							</tr>
						
							<tr>
								<td align="center"><label>판매자  &nbsp;</label></td>
								<td align="left"><label>${sale.email}</label></td>
								<!-- <td><input type="text" name="name" size="20" value=""></td> -->
							</tr>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="check">주문</button>
					<button type="button" class="btn btn-default"
						data-dismiss="modal">취소</button>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	</form>
</body>
</html>