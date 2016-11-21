<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script src="/Jungkosta/resources/js/main/warningForm.js"></script>
<style type="text/css">
#warning_button_ws{
text-align: right;
}
</style>
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h3 class="text-primary">경고 횟수 등록</h3>
				<form class="form-horizontal" role="form">
					<input type="hidden" value="경고!!" name="title" id="hidden_title_ws">
					<div class="form-group">
						<label for="admin_ws" class="col-xs-3 col-lg-3 control-label">관리자
							이름</label>
						<div class="col-xs-8 col-lg-8">
							<input type="text" class="form-control" name="sender"
								placeholder="이름" readonly="readonly" id="admin_ws"
								value="${email }">
						</div>
					</div>
					<div class="form-group">
						<label for="id_ws" class="col-xs-3 col-lg-3 control-label">회원
							이메일</label>
						<div class="col-xs-8 col-lg-8">
							<input type="email" class="form-control" placeholder="이메일"
								value="${param.id }" readonly="readonly" id="id_ws"
								name="receiver">
						</div>
					</div>
					<div class="form-group">
						<label for="reason_ws" class="col-xs-3 col-lg-3 control-label">사유</label>
						<div class="col-xs-8 col-log-8">
							<textarea rows="5" class="form-control" placeholder="사유"
								id="reason_ws" name="content"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="warning_num_ws"
							class="col-xs-3 col-lg-3 control-label">경고 횟수</label>
						<div class="col-xs-8 col-log-8">
							<select class="form-control" name="warning_num" id="warning_num">
								<c:if test="${member.warning_num == 0 }">
									<option selected="selected">0</option>
									<option>1</option>
									<option>2</option>
								</c:if>
								<c:if test="${member.warning_num == 1 }">
									<option>0</option>
									<option selected="selected">1</option>
									<option>2</option>
								</c:if>
								<c:if test="${member.warning_num == 2 }">
									<option>0</option>
									<option>1</option>
									<option selected="selected">2</option>
								</c:if>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-8 col-lg-offset-3 col-lg-8 "
							id="warning_button_ws">
							<button type="button" class="btn btn-primary" id="form_warning_ws">확인</button>
							<button type="button" class="btn btn-danger"
								id="warning_cancel_button_ws">취소</button>
						</div>
					</div>

				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

</body>
</html>