<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
		alert("낙찰이 완료되었습니다.");
		window.self.close();
		window.opener.location.href = "auctionPurchaseForm?sale_id=${sale_id}&bidding_id=${bidding_id}";
</script>
</head>
<body>
</body>
</html>