<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<script src="/Jungkosta/resources/js/main/blackListForm.js" charset="utf-8"></script>

<style type="text/css">
#blacklist_button_ws{
text-align: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<h3 class="text-primary">블랙리스트 등록</h3>
				<form class="form-horizontal" role="form" action="/Jungkosta/main/blackListProc" id="form_blacklist_ws">
					<div class="form-group">
						<label for="admin_ws" class="col-xs-3 col-lg-3 control-label">관리자 이름</label>
						<div class="col-xs-8 col-lg-8">
							<input type="text" class="form-control" name="admin" placeholder="이름" readonly="readonly" id="admin_ws" value="${email }">
						</div>
					</div>
					<div class="form-group">
						<label for="id_ws" class="col-xs-3 col-lg-3 control-label">회원 이메일</label>
						<div class="col-xs-8 col-lg-8">
							<input type="email" class="form-control" placeholder="이메일" value ="${param.id }"readonly="readonly" id="id_ws" name="id">
						</div>
					</div>
					<div class="form-group">
						<label for="reason_ws" class="col-xs-3 col-lg-3 control-label">사유</label>
						<div class="col-xs-8 col-log-8">
							<textarea rows="5" class="form-control" placeholder="사유" id="reason_ws" name="reason_ws"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-8 col-lg-offset-3 col-lg-8 " id="blacklist_button_ws">
							<button type="submit" class="btn btn-primary">확인</button>
							<button type="button" class="btn btn-danger" id="cancel_button_ws">취소</button>
						</div>
					</div>

				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>