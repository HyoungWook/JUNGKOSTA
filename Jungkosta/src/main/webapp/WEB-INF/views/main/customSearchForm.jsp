<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%
	String id = (String) session.getAttribute("email");

	if (id == null || !id.equals("admin@admin.com")) {
		response.sendRedirect("../main/main.jsp");
	}
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
#custom_search_form_ws {
	margin-top: 2.0em;
}

#search_table_ws {
	margin-top: 2.0em;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/Jungkosta/resources/js/main/customSearchForm.js" charset="utf-8"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="custom_search_form_ws">
				<form role="form" class="form-inline">
					<div class="form-group">
						<label for="name_ws" class="text-primary">회원 검색</label> <input
							type="text" class="form-control" placeholder="검색" id="name_ws"
							name="name">
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table table-hover" id="search_table_ws">
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>