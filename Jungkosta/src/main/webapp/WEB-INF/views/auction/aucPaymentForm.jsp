<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css"
	rel="stylesheet">
<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>



<div class="contianer">

	<h2>실시간 계좌 이체</h2>

	<div class="row">
		<div class="col-md-offset-3 col-md-3">은행 명 :</div>
		<div class="col-md-3 col-md-offset-3">
			<select>
				<option>국민은행</option>
				<option>신한은행</option>
				<option>농협</option>
			</select>
		</div>
	</div>

	<div class="row">
		<div class="col-md-offset-3 col-md-3">계좌번호 :</div>
		<div class="col-md-3 col-md-offset-3">
			<input type="text">
		</div>
	</div>



	<div class="row">
		<div class="col-md-offset-3 col-md-3">금액 :</div>
		<div class="col-md-3 col-md-offset-3">
			<input type="text">
		</div>
	</div>
	
	<div class="row">
		<div align="center">
			<button>완료</button>
		</div>
	</div>



</div>