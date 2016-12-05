<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<head>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>

<!-- javaScript -->
<script type="text/javascript" src="/Jungkosta/resources/js/trade/itemPayment.js"></script>

<!-- css  -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="/Jungkosta/resources/css/auction/paymentForm_phw.css">

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

	<div class=container>

		<div class="main">
			<h2>주문 상품 결제</h2>
			<hr>
			<div class="product_info">
				<div class="row">
					<div class="col-md-offset-2">
						<h4>상품 정보</h4>

						<br>

						<table id="payment_date">
							<tr>
								<td width="200px" align="center">구매일 : <b> <fmt:formatDate
								value="${purchase_ktw.purchase_date }" pattern="yyyy. MM. dd" />
					</b>
					</td>
					<td width="200px" align="center">구매 번호 : <b>${purchase_ktw.purchase_id }</b>
				</td>
			</table>

			<br>

			<table id="item_info">
				<tr>
					<th width="150"></th>
					<th width="450"></th>
				</tr>
				<tr>
					<td align="center">
						<%-- <c:set var="headName"
		value="${fn:substring(register.item_pic, 0, fn:length(register.item_pic)-4) }" />
	<c:set var="pattern"
		value="${fn:substringAfter(register.item_pic, headName) }" /> --%>
						<img alt="" src="displayFile?fileName=${register.item_pic1}">
					</td>
					<td>
						<div class="row">
							<div class="col-md-offset-2">${register.item_name }/ 1개</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

<br> <br>

<div class="member_info">
	<div class="row">
		<div class="col-md-offset-2">
			<h4>받는 사람 정보</h4>
			<br>
			<table>
				<tr height="50px">
					<td width="200">
						<div class="row">
							<div class="col-md-offset-3">수령인</div>
						</div>
					</td>
					<td width="600">
						<div class="row">
							<div class="col-md-offset-1">${member.name }</div>
						</div>
					</td>
				</tr>
				<tr height="50px">

					<td>
						<div class="row">
							<div class="col-md-offset-3">연락처</div>
						</div>
					</td>
					<td><div class="row">
							<div class="col-md-offset-1">${member.phone_num }</div>
						</div></td>
				</tr>
				<tr height="50px">
					<td>
						<div class="row">
							<div class="col-md-offset-3">주소</div>
						</div>
					</td>
					<td><div class="row">
							<div class="col-md-offset-1">${member.address }</div>
						</div></td>
				</tr>
			</table>
		</div>
	</div>
</div>

<br> <br> <br>

<div id="payment_info">
	<div class="row">
		<div class="col-md-offset-2">
			<h4>결제 정보</h4>
			<br>
			<table>
				<tr>
					<th width="400">
						<div class="row">
							<div class="col-md-offset-2">결제 수단</div>
						</div>
					</th>
					<th width="400"></th>
				</tr>
				<tr>
					<td><div class="row">
							<div class="col-md-offset-2">[${purchase_ktw.payment_method }]</div>
						</div></td>
					<td>
						<div class="row">
							<div class="col-md-offset-2 col-md-4">
								<p align="right">총 상품 가격 :</p>

							</div>
							<div class="col-md-6">
								<p align="right" id="product_cost">
									<fmt:formatNumber value="${register.item_cost }"
										pattern="#,###" />
									원

								</p>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="row">
							<div class="col-md-offset-2 col-md-3">은행명 :</div>
							<div class="">${member.bank_name }</div>
						</div>
					</td>
					<td>
						<div class="row">
							<div class="col-md-offset-2 col-md-4">
								<p align="right">배송료 :</p>
	<input type="hidden" id="sale_id" value="${register.sale_id }">
							</div>
							<div class="col-md-6">
								<p align="right">
									<fmt:formatNumber value="2500" pattern="#,###" />
									원
								</p>
							</div>
						</div>
					</td>
					
					
				</tr>
						<tr>
					<td>
						<div class="row">
							<div class="col-md-offset-2 col-md-3"></div>
							<div class=""></div>
						</div>
					</td>
					<td>
						<div class="row">
							<div class="col-md-offset-2 col-md-4">
								<p align="right">마일리지 :</p>

							</div>
							<div class="col-md-6">
								<p align="right">
									-<fmt:formatNumber value="${purchase_ktw.use_point }" pattern="#,###" />
									원
								</p>
							</div>
						</div>
					</td>
					
					
				</tr>
				
				<tr>
					<td></td>
					<td><div class="row">
							<div class="col-md-offset-2 col-md-4">
								<c:choose>
									<c:when test="${purchase_ktw.payment_method == '무통장입금' }">
										<c:set var="charge" value="0.01" />
									</c:when>
									<c:otherwise>
										<c:set var="charge" value="0.03" />
									</c:otherwise>

								</c:choose>
								<p align="right">
									수수료(
									<fmt:formatNumber value="${charge }" type="percent" />
									) :
								</p>

							</div>
							<div class="col-md-6">
								<p align="right">
									<fmt:formatNumber value="${register.item_cost * charge }"
										pattern="#,###" />
									원
								</p>
							</div>
						</div>
						<hr></td>
				</tr>

				<tr>
					<td></td>
					<td>
						<div class="row">
							<div class="col-md-offset-2 col-md-4">
								<p align="right">총 결제 금액 :</p>
							</div>
							<div class="col-md-6">
								<p align="right" id="total_cost">
									<c:set var="total_cost"
										value="${purchase_ktw.purchase_cost}" />
									<fmt:formatNumber value="${total_cost }" pattern="#,###" />
									원
								</p>

							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td></td>
					<td>
						<div class="row point">
							<div class="col-md-offset-2 col-md-4">
								<p align="right">적립금 :</p>
							</div>
							<div class="col-md-6">
								<p align="right">
									<fmt:formatNumber
										value="${purchase_ktw.purchase_cost * 0.01}"
										pattern="#,###" />
									원
								</p>
							</div>
						</div>
					</td>
				</tr>

			</table>
		</div>
	</div>

</div>

<form action="/Jungkosta/trade/tradepaymentProc" method="post">
	<hr>
	<input type="hidden" name="purchase_id" value="${purchase_ktw.purchase_id}" id="purchase_Id">
	<div align="right" id="payment_btn">
		<button type="button" class="btn btn-lg payProc"
			data-target="#myModal" data-toggle="modal" id="orderButton_ktw">결제하기</button>
		<button class="btn btn-lg" type="reset" id="cancel_btn" value="${purchase_ktw.purchase_id }">취소</button>
	</div>

	<input type="hidden" name="subca_id" value="${register.subca_id }"
		id="subca_id">

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">실시간계좌이체</h4>
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
									id="password2"></td>				
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

	

			</form>



		</div>

	</div>

</body>
<script type="text/javascript">

</script>
</html>