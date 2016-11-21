<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<style type="text/css">
	#find_email_result_ws{
	
		height : 20.0em;
		border: 5px solid #DDDDDD;
	
	}
	.email_result_if_ws{
		margin-top:8.0em;
		margin-bottom:7.0em;
	}
	.email_content_ws{
		text-align:right;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6" id="find_email_result_ws">
				<c:if test="${member == '' }">
					<div class="row email_result_if_ws">
						<div class="col-md-2"></div>
						<div class="col-md-6 email_content_ws">입력하신 정보는 존재 하지 않습니다.</div>
						<div class="col-md-4"></div>
					</div>
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<a href="/Jungkosta/findEmailForm">돌아가기</a>
						</div>	
					</div>
				</c:if>
				<c:if test="${member != '' }">
					<div class="row email_result_if_ws">
						<div class="col-md-2"></div>
						<div class="col-md-6 email_content_ws">이메일은 : ${member.email } 입니다</div>
						<div class="col-md-4"></div>
					</div>
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<a href="../main/main.jsp">돌아가기</a>
							<a href="../main/find_password.jsp">비밀번호 찾기</a>
						</div>	
					</div>
				</c:if>
			</div>
			<div class="col-md-6"></div>
		</div>
	</div>

</body>
</html>