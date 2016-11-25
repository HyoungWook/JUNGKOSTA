<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style type="text/css">
#nav{ 
      
      height: 100px;
      background-color: #0092E0;
      margin:10px 0;
      text-align: center;
      padding-top:2.5em;
      border-radius:1.2em;
      }

.a_nav{
   font-family: "Helvetica Neue", Helvetica, Arial,"맑은 고딕","Malgun gothic",  sans-serif;
   font-size: 1.3em;
   color: white;
   text-decoration: none;
   margin-left:1.2em;
}
#more_nav_ws{
   margin-top: 3.0em;
   border : 1px solid #DDDDDD;
   border-radius:1.2em;
}
.category_nav_ws{
   border-right: 1px solid #DDDDDD;
   height: 25.0em;
}
#last_category_ws{
   border-right: 0px;
}
.title_nav_ws{
   color : #0092E0;
   font-weight: bold;
   margin-bottom:2.0em;
   margin-top:2.0em;
   margin-left:2.0em;
   text-align:left;
   
}
.content_nav_ws{
   text-align:left;
   margin-left:2.0em;
   margin-bottom:1.1em;
}
.content_link_nav_ws{
   text-decoration:none;
   color : #4B4B4B;
   font-size: 0.8em;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div class="container">
      <div id="nav">
         <div class="row">
           <div class="col-md-12">
					<a href="#" class="a_nav" data-toggle="modal"
							data-target="#sale_Modal">판매하기</a>
					<a href="/Jungkosta/boardList/1" class="a_nav">커뮤니티</a>
					<a href="../main/main.jsp" class="a_nav">JUNGKOSTA 홈</a>
					<a href="../trade/itemlist.jsp?subca_id=8" class="a_nav">스마트폰</a>
					<a href="../trade/itemlist.jsp?subca_id=2" class="a_nav">태플릿 PC</a>
					<a href="../trade/itemlist.jsp?subca_id=1" class="a_nav">노트북/PC</a>
					<a href="../trade/itemlist.jsp?subca_id=9" class="a_nav">카메라</a>
					<a href="/Jungkosta/auction/auctionList" class="a_nav">경매</a>
					<a href="#" class="a_nav" data-toggle="collapse" data-target="#more_nav_ws">더보기▽</a>
					<div id="more_nav_ws" class="collapse">
          				<div class="row">
          					<div class="col-md-5 category_nav_ws">
          						<div class="row">
          							<div class="col-md-12 title_nav_ws">
          								전자제품
          							</div>
          						</div>
          						<div class="row">
          							<div class="col-md-6">
          								<div class="content_nav_ws">
          									<a href="../trade/itemlist.jsp?subca_id=8" class="content_link_nav_ws">스마트폰</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">컴퓨터</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="../trade/itemlist.jsp?subca_id=1" class="content_link_nav_ws">노트북</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="../trade/itemlist.jsp?subca_id=2" class="content_link_nav_ws">테블릿</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="../trade/itemlist.jsp?subca_id=3" class="content_link_nav_ws">노트북/pc 주변기기</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="../trade/itemlist.jsp?subca_id=9" class="content_link_nav_ws">카메라</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">음향 기기</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">웨어러블</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">영상가전</a>
          								</div>
          							</div>
          							<div class="col-md-6">
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">게임/타이틀</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">자동차 기기</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">기타 전자 기기</a>
          								</div>
          							</div>
          						</div>
          					</div>
          					<div class="col-md-3 category_nav_ws">
          						<div class="row">
          							<div class="col-md-12 title_nav_ws">
          								여행/문화
          							</div>
          						</div>
          						<div class="row">
          							<div class="col-md-12">
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">지류 카드 상품권</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">공연/티켓</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">모바일쿠폰/상품권</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">여행/항공권</a>
          								</div>
          							</div>
          						</div>
          					</div>
          					<div class="col-md-4 category_nav_ws" id="last_category_ws">
          						<div class="row">
          							<div class="col-md-12 title_nav_ws">
          								해외 명품
          							</div>
          						</div>
          						<div class="row">
          							<div class="col-md-12">
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">명품 가방</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">명품 지갑</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">명품 시계</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">명품 신발</a>
          								</div>
          								<div class="content_nav_ws">
          									<a href="#" class="content_link_nav_ws">명품 악세사리</a>
          								</div>
          							</div>
          						</div>
          					</div>
          				</div>
      				</div>
            </div>
         </div>
      </div>
   </div>
	
		<%-- <div class="modal fade" id="sale_Modal" tabindex="-1" role="dialog"
               aria-labelledby="saleModalLabel" aria-hidden="true">
               <div class="modal-dialog">
                  <div class="modal-content">
                     <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                           <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="saleModalLabel">판매 등록</h4>
                     </div>
                        <div class="modal-body">
                              <jsp:include page="../auction/sale_btn_lsj.jsp"/>
                     </div>
                  </div>
               
               </div>
               
            </div> --%>

</body>
</html>
