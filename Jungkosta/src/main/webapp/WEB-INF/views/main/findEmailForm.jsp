<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/js/main/findEmailForm.js"></script>
<style type="text/css">
#find_email_frame_ws{
	height : 20.0em;
	border: 5px solid #DDDDDD;

}
#find_email_first_input_ws{
	margin-top:6.0em;
}
#button_find_email_ws{
	text-align: right;
}
</style>
</head>
<body>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">모달 제목</h4>
				</div>
				<div class="modal-body">
					<p>여기는 내용이 들어 가는 곳</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div>
					<h3 class="text-primary">E-mail 찾기</h3>
				</div>
				<div class="col-md-12" id="find_email_frame_ws">
					<form class="form-horizontal" role="form" method="post" id="find_email_form_ws" action="/Jungkosta/findEmailProc">
						<div class="form-group" id="find_email_first_input_ws">
							<label for="name_ws" class="col-xs-2 col-lg-2 control-label">이름</label>
							<div class="col-xs-10 col-lg-10">
								<input type="text" class="form-control" placeholder="이름" name="name" id="name_ws">
							</div>
						</div>
						<div class="form-group" id="find_email_second_input_ws">
							<label for="resident_id_ws" class="col-xs-2 col-lg-2 control-label">주민번호</label>
							<div class="col-xs-10 col-lg-10">
								<input type="text" class="form-control" placeholder="주민번호" name="resident_id" id="resident_id_ws">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 " id="button_find_email_ws">
								
								<button class="btn btn-primary"type="submit">확인</button>
								<a href="javascript:history.go(-1)" class="btn btn-danger">취소</a>
							</div>
						</div>

					</form>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>