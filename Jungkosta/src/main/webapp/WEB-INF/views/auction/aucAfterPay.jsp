<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript"
	src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {

		var $sale_id = $("#sale_id").val();
		
		
		$("button").click(function() {
			$.ajax({
				url : "completeToSale",
				type : "post",
				dataType : "text",
				data : "sale_id=" + $sale_id,
				success : successHandler,
				error : function() {
					alert("실패");
				}
			});
		});

		function successHandler() {
			alert("거래 완료닷");
		}

	});
</script>

</head>
<body>

	<form>
		<input type="hidden" id="sale_id" value="${sale_id }">
	</form>
	<button>구매 확정</button>

</body>
</html>