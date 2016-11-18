<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css" rel="stylesheet">
    <script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>
    
    
    
<title>Insert title here</title>
</head>
<body>
	
	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="body"/>
	
	<tiles:insertAttribute name="footer"/>
</body>
</html>