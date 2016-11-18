<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css" rel="stylesheet">
    <script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
    <script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
    
<title>Insert title here</title>
</head>
<body>
	
	<!-- 우성 header 수정 -->
	<tiles:insertAttribute name="header"/>
	
	<!-- 우성 nav 부분 추가 -->
	<tiles:insertAttribute name="nav"/>

	<tiles:insertAttribute name="body"/>
	
	<tiles:insertAttribute name="footer"/>
	
</body>
</html>