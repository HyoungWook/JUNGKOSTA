<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/Jungkosta/resources/css/auction/paymentForm_phw.css">

<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css" rel="stylesheet">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(function(){
		var pointnum = ${payment_cost}*0.01;
		var point2 = Math.round(pointnum);
		$('#pointnum').val(point2);
	})

</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
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
							</tr>
						</table>

						<br>

						<table id="item_info">
							<tr>
								<th width="150"></th>
								<th width="450"></th>
							</tr>
							<tr>
								<td align="center"><c:set var="headName"
										value="${fn:substring(register.item_pic, 0, fn:length(register.item_pic)-4) }" />
									<c:set var="pattern"
										value="${fn:substringAfter(register.item_pic, headName) }" /> <img
									alt="" src="../upload/${headName }_small${pattern}"></td>
								<td>
									<div class="row">
										<div class="col-md-offset-2">${register.item_name } / 1개</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<br>
			<br>

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
										<div class="">신한 은행</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-md-offset-2 col-md-4">
											<p align="right">배송료 :</p>

										</div>
										<div class="col-md-6">
											<p align="right">
												<fmt:formatNumber value="2500" pattern="#,###" />원
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
													pattern="#,###" />원
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
													value="${payment_cost}" />
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
												<fmt:formatNumber value="${payment_cost * 0.01}"
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

			<form action="itempaymentCheck.jsp" method="post">
				<input type="hidden" name="payment_cost" value="${payment_cost}"> <input
					type="hidden" name="point" id = "pointnum" value="">
				<input type="hidden" name="payment_status" value="입금완료">
				<input type="hidden" name="purchase_id" value="${purchase_ktw.purchase_id }">

				<hr>


				<div align="right" id="payment_btn">
					<button class="btn btn-lg" type="submit">결제하기</button>
				</div>



			</form>

		</div>

	</div>

</body>
</html>