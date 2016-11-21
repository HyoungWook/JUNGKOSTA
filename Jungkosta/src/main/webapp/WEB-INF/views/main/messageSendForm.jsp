<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/custom2.css" rel="stylesheet"> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/Jungkosta/resources/main/js/messageSendFrom.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function cancel(){
		history.go(-1);
	}
</script>
<style type="text/css">
#message_frame_button_ws{
	text-align: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">

				<h4 class="text-primary">메시지 작성</h4>
				<hr>
				<form id="ms_form_ws" class="form-horizontal" role="form" method="post" action="messageSendProc">
					<div class="form-group">
						<label for="reciever_ws" class="col-xs-2 col-lg-2 control-label">받는 사람</label>
						<div class="col-xs-10 col-lg-10">
							<c:choose>
								<c:when test="${param.flag == '1' }">
									<input type="email" class="form-control" placeholder="받는 사람" id="ms_reciever_ws" name="receiver" value="admin" readonly="readonly">
								</c:when>
								<c:otherwise>
									<input type="email" class="form-control" placeholder="받는 사람" id="ms_reciever_ws" name="receiver">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label for="sender_ws" class="col-xs-2 col-lg-2 control-label">보내는 사람</label>
						<div class="col-xs-10 col-lg-10">
							
							<c:choose>
								<c:when test="${param.flag == '1' }">
									<input type="email" class="form-control" placeholder="보내는 사람" id="ms_sender_ws" name="sender">
								</c:when>
								<c:otherwise>
									<input type="email" class="form-control" placeholder="보내는 사람" value = "${email }" readonly="readonly" id="ms_sender_ws" name="sender">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group" id="ms_div_title_ws">
						<label for="title_ws" class="col-xs-2 col-lg-2 control-label">제목</label>
						<div class="col-xs-10 col-lg-10">
							<input type="text" class="form-control" placeholder="제목" id="ms_title_ws" name="title">
						</div>
					</div>
					<div class="form-group" id="ms_div_content_ws">
						<label for="content_ws" class="col-xs-2 col-lg-2 control-label">내용</label>
						<div class="col-xs-10 col-lg-10">
							<textarea  rows="5" class="form-control" id="ms_content_ws" name="content" id=></textarea>
						</div>
					</div>
					<div class="form-group">
						<div id="message_frame_button_ws"class="col-xs-offset-2 col-xs-10 col-lg-offset-2 col-lg-10 ">
							<button type="submit" class="btn btn-primary">확인</button>
							<button type="reset" class="btn btn-danger" onclick="cancel()">취소</button>
						</div>
					</div>

				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>