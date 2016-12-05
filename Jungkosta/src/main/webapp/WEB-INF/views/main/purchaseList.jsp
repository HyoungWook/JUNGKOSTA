<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<!-- bootstrap -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
 $(function(){
	
	//내가 입력한 금액
	
	$('form').submit(function(event){
		event.preventDefault();
		var that = $(this);
			var purchase_id = $('.purchase').val();
			var sale_id = $('.sale').val();
			alert(purchase_id + " " + sale_id);
			var form = $('#withdraw');
			var purchase_cost = Number($('.purchase_cost').val());
			var sendData = "purchase_id=" + purchase_id + "&sale_id=" + sale_id;
							
			$.ajax({
				url:"/Jungkosta/trade/tradeWithdraw",
				data: form.serialize(),
				dataType:"text",
				type:"POST",
				success:function(data){
					if(data=="success"){
						alert('성공');
						self.location = '/Jungkosta/trade/tradeDeposit'; 
					}else{
						alert('실패');
					}
				},
				error:function(data){
					alert('실패');
				}
			})
			if(cost==purchase_cost){
				alert('결제 완료');
				//that.get(0).submit();
				return false;
			}else{
				alert('결제 금액이 올바르지 않습니다.')
				return false;
			}
		
		
		
	})
	
	$('.payProc').on('click', function(){
		var purchaseid =$(this).next(); 
		var saleid =purchaseid.next(); 
		var input = "<input type='hidden' name='purchase_id' value='"+purchaseid.val()+"'>";
		var input2= "<input type='hidden' name='sale_id' value='"+saleid.val()+"'>";
		$('#payProc').append(input);
		$('#payProc').append(input2);
		
	})
	
}) 
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-primary">무통장 입금</h4>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>제 품</th>
							<th>상품명</th>
							<th>판매자</th>
							<th>무통장 입금</th>
							<th>기간</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td><img alt="제목없음" src="${item.item_pic1}"></td>
								<td><a href="/Jungkosta/trade/tradeDetail?sale_id=${item.sale_id}">${item.item_name}</a></td>
								<td>${item.email}</td>
								<td>${item.purchase_cost }</td>
								<td>${item.purchase_deadline }</td>
								
								<td><%-- <button class="btn btn-primary" value="무통장 입금" id="${item.sale_id}">무통장 입금</button> --%>
								    <button type="button" class="btn btn-primary payProc"
			data-target="#myModal" data-toggle="modal">무통장입금</button>
							<input type="hidden" class="purchase" name="purchase_id" value="${item.purchase_id}">
							<input type="hidden" class="sale" name="sale_id" value="${item.sale_id}">
							<input type="hidden" id="defaultcost" name="purchase_cost" value="${item.purchase_cost}">
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	<hr>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
	<form id="withdraw">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">무통장입금</h4>
				</div>
				<div class="modal-body modalBody">
			
				<div id="payProc">
					
				</div>
					<div class="tw_form">
						<table class="transfer">
							<tr>
								<td width="100" align="center"><label for="transfer_bank">은행명
										&nbsp; </label></td>
								<td><label>${admin.bank_name}</label></td>
							</tr>
						<tr>
						<td align="center"><label>입금계좌번호 &nbsp;</label></td>
						<td align="left">
						<%--  <input type="text" name="account_no" size="20"> <label>${member.account_num }</label> --%>
						<label>${admin.account_num }</label>
						</td>
					</tr>
					
							<tr>
								<td align="center"><label>금액</label></td>
								<td align="left"><input type="text" name="payment_cost" class="purchase_cost"></td>
								<!-- <td><input type="text" name="name" size="20" value=""></td> -->
							</tr>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="check">결제</button>
					<button type="button" class="btn btn-default"
						data-dismiss="modal">취소</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		</form>
	</div>
	<!-- /.modal -->

	

		
		
	</div>


</body>

</html>