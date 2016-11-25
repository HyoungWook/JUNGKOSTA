<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
<!-- Bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/kfonts2.css" rel="stylesheet">

<!-- jQuery -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- javascript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<!-- css -->
<link href="/Jungkosta/resources/css/trade/tradeList.css" rel="stylesheet">

<style type="text/css">
#good_ktw {
	width: 30px;
	height: 30px;
}

#check_ktw {
	width: 30px;
	height: 30px;
}
</style>

</head>
<body>
	<div class="btn-group" data-toggle="buttons">
        <label class="btn btn-primary">
          <input type="radio" name="sort" value="n" />신규등록순
        </label>
        <label class="btn btn-primary">
          <input type="radio" name="sort" value="l" />최저가격순
        </label>
      </div>
      
		<div class="item_list_ktw">
			<c:forEach var="temp" items="${list }">
				<div class="col-md-2 col-md-offset-2 item_info_ktw"
					onclick="sendDetail(${temp.sale_id})">
					<img id="good_ktw" src="/Jungkosta/resources/images/trade/good.png" />&nbsp;
					<span name="email">중코스타</span>&nbsp; 
					<img id="check_ktw" src="/Jungkosta/resources/images/trade/check.jpg" />
						<br> <br> 
							<b class="item_name_ktw">${temp.item_name }</b>
						<br> <br> 
							<span></span> &nbsp;&nbsp;
							<b><strong class="product_price_ktw">${temp.item_cost } 원</strong></b><br>
							<br>
							<br>
							<br>
							</div>
			</c:forEach>
		</div>
		
<script id="template" type="text/x-handlebars-template">
<c:forEach var="temp" items="{{list }}">
<div class="col-md-2 col-md-offset-2 item_info_ktw"
	onclick="sendDetail({{temp.sale_id}})">
	<img id="good_ktw" src="/Jungkosta/resources/images/trade/good.png" />&nbsp;
	<span name="email">중코스타</span>&nbsp; 
	<img id="check_ktw" src="/Jungkosta/resources/images/trade/check.jpg" />
		<br> <br> 
			<b class="item_name_ktw">{{temp.item_name }}</b>
		<br> <br> 
			<span></span> &nbsp;&nbsp;
			<b><strong class="product_price_ktw">{{temp.item_cost }} 원</strong></b><br>
			<br>
			<br>
			<br>
		</div>
	</c:forEach>
</script>

<script type="text/javascript">
$(function(){
	
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	}
	
	//핸들바 템플릿 컴파일, 가져오기
	var template = Handlebars.compile($("#template").html());
	
	//커스텀 헬퍼 등록
	
	
	$('.btn').click(function(){
		var sort = $(this).find('input:radio[name=sort]').val();
		var subca_id = $.urlParam('subca_id');
		
		console.log(subca_id);
		
		$.getJSON("/Jungkosta/trade/listSale/" + subca_id + "/" + sort, function(list) {
			console.log('list : ' + list);
			
			$(list).each(function() {
				
				console.log(this);
				
			});
		});
	});

	
});

	
	
</script>

</body>
</html>