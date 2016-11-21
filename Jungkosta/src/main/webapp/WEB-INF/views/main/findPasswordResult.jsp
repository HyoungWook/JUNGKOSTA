<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%
	
%>
<style type="text/css">
#find_password_result_ws{
		height : 20.0em;
		border: 5px solid #DDDDDD;
	}
	.password_result_if_ws{
		margin-top:8.0em;
		margin-bottom:7.0em;
	}
	.password_content_ws{
		text-align:right;
	}
	</style>
<%
		
%>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<c:if test="${member =='' }">
					<div class="row password_result_if_ws">
						<div class="col-md-1"></div>
						<div class="col-md-8 password_content_ws">입력하신 정보는 존재 하지 않습니다.</div>
						<div class="col-md-3"></div>
					</div>
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<a href="../main/password_email.jsp">돌아가기</a>
						</div>	
					</div>
				</c:if>
				<c:if test="${member != '' }">
					<div class="row password_result_if_ws">
						<div class="col-md-1"></div>
						<div class="col-md-8 password_content_ws">비밀번호는 ${member.email }로 전송 하였습니다.</div>
						<div class="col-md-3"></div>
					</div>
					<div class="row">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<a href="/">돌아가기</a>
						</div>	
					</div>
				</c:if>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

</body>
</html>