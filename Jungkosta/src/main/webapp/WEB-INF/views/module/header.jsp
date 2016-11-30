<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#span_header {
	font-size: 1.8em;
	text-shadow: 3px 3px 3px gray;
	font-family: "Helvetica Neue", Helvetica, Arial, "맑은 고딕",
		"Malgun gothic", sans-serif;
	font-weight: bold;
	margin-right: 1.1em;
	margin-left: 1.1em;
}

#header {
	margin-top: 4.0em;
}

.a_header {
	text-decoration: none;
	color: gray;
}

.button_header {
	margin-top: 2.0em;
}

.button_div_header {
	text-align: right;
	margin-right: 1.1em;
}

.find_header_ws {
	font-size: 0.9em;
}

#last_find_header_ws {
	margin-right: 11.0em;
}
</style>
	<!-- 2016/11/19 우성 라이브러리 충돌로 인해 삭제함 -->
	<script src="/Jungkosta/resources/js/main/header.js"></script>
</head>
<body>
	<input type="hidden" value="${email }" id="hidden_email_ws">
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Login</h4>
				</div>
					<div class="modal-body">
					<!-- 2016/11/19 우성 수정 form action 삭제-->
					<form>
						<div class="form-group">
							<label for="email" class="col-xs-2 col-lg-2 control-label">이메일</label>
							<div class="col-xs-10 col-lg-10">
								<input type="email" class="form-control" placeholder="이메일"
									name="email" id="email_ws">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-xs-2 col-lg-2 control-label">비밀번호</label>
							<div class="col-xs-10 col-lg-10">
								<input type="password" class="form-control" placeholder="비밀번호"
									name="password" id="password_ws">
							</div>
						</div>
						<!--2016/11/19 우성 button type button으로 수정  -->
						<div class="form group button_div_header">
							<a href="/Jungkosta/findEmailForm" class="find_header_ws">이메일 찾기</a>
							<a href="/Jungkosta/findPasswordForm" class="find_header_ws" id="last_find_header_ws">비밀번호 찾기</a>
							<button type="button" class="btn btn-primary col-md-offset-0 button_header" id="form_header_ws">Log-in</button>
							<button type="button" class="btn btn-default button_header"
								data-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>

					<div class="modal-footer">
					</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">my page 확인창</h4>
					<h4 class="modal-title" id="myModalLabel">LOGIN</h4>
				</div>
					<div class="modal-body">
					<form action="memberInfoForm" method="post">
						<div class="form-group">
							<label for="email" class="col-xs-2 col-lg-2 control-label">이메일</label>
							<div class="col-xs-10 col-lg-10">
								<input type="email" class="form-control" placeholder="이메일"
									name="email">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-xs-2 col-lg-2 control-label">비밀번호</label>
							<div class="col-xs-10 col-lg-10">
								<input type="password" class="form-control" placeholder="비밀번호"
									name="password">
							</div>
						</div>
						
						<div class="form group button_div_header">
							<button type="submit" class="btn btn-primary col-md-offset-8 button_header">Log-in</button>
							<button type="button" class="btn btn-default button_header"
								data-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>

					<div class="modal-footer">
					</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">my page 확인창</h4>
				</div>
					<div class="modal-body">
					<form action="../main/information_action.jsp" method="post">
						<div class="form-group">
							<label for="email" class="col-xs-2 col-lg-2 control-label">이메일</label>
							<div class="col-xs-10 col-lg-10">
								<input type="email" class="form-control" placeholder="이메일"
									name="email">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-xs-2 col-lg-2 control-label">비밀번호</label>
							<div class="col-xs-10 col-lg-10">
								<input type="password" class="form-control" placeholder="비밀번호"
									name="password">
							</div>
						</div>
						
						<div class="form group button_div_header">
							<button type="submit" class="btn btn-primary col-md-offset-8 button_header">Log-in</button>
							<button type="button" class="btn btn-default button_header"
								data-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>

					<div class="modal-footer">
					</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div id="header">
			<div class="row">
				<div class="col-md-9">
					<form role="form" class="form-inline">
						<div class="form-group">
							<label for="Name"><span id="span_header">JUNGKOSTA</span></label>
							<input type="text" class="form-control" placeholder="검색">

							<button type="submit" class="btn btn-primary"
								data-toggle="button">검색</button>
						</div>
					</form>
				</div>
				<div class="col-md-3">
					<c:if test="${email == null }">
						<a href="#myModal1" class="a_header" data-toggle="modal">Log-in</a>
						<a href="/Jungkosta/mainSignupForm" class="a_header">Sign-up</a>
					</c:if>
					<c:if test="${email != null }">
						
						<div class="dropdown">
							<a href="/Jungkosta/logout" class="a_header" >Log-out</a>
							<a id="a_header" href="#" class="a_header" data-toggle="dropdown">information</a>
							<ul class="dropdown-menu" role="menu">
								<li role="presentation" class="dropdown-header">message</li>
								<!-- 2016/11/19 우성 메시지 a태그 수정 -->
								<li role="presentation"><a href='/Jungkosta/messageSendForm' role="menuitem" tabindex="-1">메시지 발신</a></li>
								<li role="presentation"><a href='/Jungkosta/messageReceiveForm' role="menuitem" tabindex="-1" id="a_message_ws">메시지 수신</a></li>
								<li role="presentation" class="divider"></li>
								<c:choose>
									<c:when test="${email != 'admin@admin.com' }">
										<li role="presentation" class="dropdown-header">information</li>
										<li role="presentation"><a href='#myModal2' data-toggle='modal' role="menuitem" tabindex="-1">회원 정보 수정</a></li>
										<li role="presentation"><a href='#' role="menuitem" tabindex="-1">회원 탈퇴</a></li>
										<li role="presentation" class="divider"></li>
										<li role="presentation" class="dropdown-header">list</li>
										<li role="presentation"><a href='/Jungkosta/purchaseList' role="menuitem" tabindex="-1">구매 내역</a></li>
										<li role="presentation"><a href='/Jungkosta/saleList' role="menuitem" tabindex="-1">판매 내역</a></li>
										<li role="presentation"><a href='/Jungkosta/aucList' role="menuitem" tabindex="-1">경매 내역</a></li>
									</c:when>
									<c:otherwise>
										<li role="presentation" class="dropdown-header">Manage</li>
										<li role="presentation"><a href='/Jungkosta/customSearchForm' role="menuitem" tabindex="-1">회원 검색</a></li>
										<li role="presentation"><a href='#' role="menuitem" tabindex="-1">물품 판매 검색</a></li>
										<li role="presentation"><a href='#' role="menuitem" tabindex="-1">물품 경매 검색</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>

					</c:if>
	
				</div>
			</div>
		</div>
	</div>
</body>
</html>