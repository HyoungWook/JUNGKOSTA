<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<style>
.menu {
	border: 1px solid #dcdcdc;
	border-radius: 20px;
}

.menu ul{
	padding-left: 0;
}

.menu li{
	list-style-type: none;
}

.menu li:not(.category){
	padding-top : 10px;
	padding-left: 60px;
	height: 40px;
	vertical-align: middle;
}

.category{
	margin-top : 20px;
	color : gray;
	padding-left: 30px;
}

.now{
	background: #DDDDDD;
	font-weight: bold;
	color: black;
}
</style>

<script type="text/javascript">
	$(function(){
		
		var $li = $(".menu").find("li");
		
		var now_url = location.href;
		now_url = now_url.substring(now_url.lastIndexOf("/"));
		
		$li.each(function(index){
			var a_url = $(this).find("a").attr("href");
			
			if(a_url != null){
				var url = a_url.substring(a_url.lastIndexOf("/"));
				
				if(url == now_url){
					
					$(this).addClass("now");
					return;
				}
			}
			
		});
		
	});
</script>

<br><br><br>
<div class="menu">
	<ul>
		<li class="category">message</li>
		<li><a href='/Jungkosta/messageSendForm' role="menuitem" tabindex="-1">메시지 발신</a></li>
		<li><a href='/Jungkosta/messageReceiveForm' role="menuitem" tabindex="-1" id="a_message_ws">메시지 수신</a></li>
		<li class="category">Information</li>
		<li><a href="/Jungkosta/sale_info" role="menuitem" tabindex="-1">판매 내역</a></li>
		<li><a href="/Jungkosta/purchase_info" role="menuitem" tabindex="-1">구매 내역</a></li>
		<li><a href='#myModal2' data-toggle='modal' role="menuitem" tabindex="-1">회원 정보 수정</a></li>
		<li><a href='#' role="menuitem" tabindex="-1">회원 탈퇴</a></li>
		<li class="category">List</li>
		<li><a href='/Jungkosta/purchaseList' role="menuitem" tabindex="-1">일반 무통장 입금</a></li>
		<li><a href='/Jungkosta/aucList' role="menuitem" tabindex="-1">경매 무통장 입금</a></li>
	</ul>
	
</div>