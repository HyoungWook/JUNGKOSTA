<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">

#board_button_ws{
	text-align:right;
}

</style>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h3 class="text-primary">커뮤니티 글쓰기</h3>
				<form method="post" action="boardWriteProc">
					<div class="form-group">
						<label for="email">이메일</label>
						<input type="email" name="email"class="form-control" placeholder="이메일" value="${email}" readonly="readonly">
					</div>
					<div class="form-group">

						<label for="title">제목</label> <input type="text" name="title" class="form-control" placeholder="제목">
					</div>
					<div class="form-group">
						<label for="content">내용</label>
						<textarea  rows="5" class="form-control" placeholder="내용" name="content"></textarea> 
					</div>     
					<div class="form-group">  
						<button type="submit" class="btn btn-primary">확인</button>
					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>