<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
#find_password_frame_ws{

	height : 20.0em;
	border: 5px solid #DDDDDD;

}
#find_password_form_ws{
	margin-top:5.0em;
}
#button_find_password_ws{
	text-align: right;
}
#manager_a_ws{
	margin-right:19.0em;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
					<h3 class="text-primary">Password 찾기</h3>
					<div class="col-md-12" id="find_password_frame_ws">
						<form class="form-horizontal" role="form" method="post"
							id="find_password_form_ws" action="/Jungkosta/findPasswordProc">
							<div class="form-group" id="find_email_first_input_ws">
								<label for="email_ws" class="col-xs-3 col-lg-3 control-label">E-mail</label>
								<div class="col-xs-9 col-lg-9">
									<input type="email" class="form-control" placeholder="e-mail"
										name="email" id="email_ws">
								</div>
							</div>
							<div class="form-group">         					
        					<label for="question_ws" class="col-xs-3 col-lg-3 control-label">비밀번호 질문</label>
        					<div class="col-xs-9 col-lg-9">
           						 <select class="form-control" name="question" id="question_ws">
           						 	<option>비밀번호 힌트 선택</option>
           						 	<option value="나의 아버지 성함은?">나의 아버지 성함은?</option>
           						 	<option value="자신의 보물 제 1호는?">자신의 보물 제 1호는?</option>
           						 	<option value="내가 나온 초등학교 이름은?">내가 나온 초등학교 이름은?</option>
           						 	<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
           						 	<option value="가장 친한 친구 이름은?">가장 친한 친구 이름은?</option>
           						 	<option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
           						 </select>
        					</div>
      					</div> 
      					
      					<div class="form-group">         					
        					<label for="answer_ws" class="col-xs-3 col-lg-3 control-label">비밀번호 질문 답</label>
        					<div class="col-xs-9 col-lg-9">
           						 <input type="text" name="answer" id="answer_ws" class="form-control" placeholder="답변 입력"> 
        					</div>
      					</div>
      					
							<div class="form-group">
								<div
									class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 "
									id="button_find_password_ws">
									<a href="../main/message_send_frame.jsp?flag=1" id="manager_a_ws">관리자에게 문의 하기</a>
									<button class="btn btn-primary" type="submit">확인</button>
									<a href="javascript:history.go(-1)" class="btn btn-danger">취소</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>