<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- jquery -->
<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>

<!-- javaScript -->
<script type="text/javascript" src="/Jungkosta/resources/js/trade/qna.js"></script>

<!-- css -->
<style type="text/css">

</style>
<link href="/Jungkosta/resources/css/trade/tradeDetail.css" rel="stylesheet"> 
<script type="text/javascript" src="/Jungkosta/resources/js/trade/qna.js"></script>



<!-- bootstrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/custom2.css" rel="stylesheet">
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	물품 상세 페이지

	<div id="section">
		<%-- <jsp:include page="../header&footer/header.jsp"></jsp:include>
		<jsp:include page="../header&footer/nav.jsp"></jsp:include> --%>
		<div class="container">

			<a href="#">${totalcategoryName}&nbsp;</a><img
				id="category_button_ktw" src="/Jungkosta/resources/images/trade/category_direct.png">
			<img src="/Jungkosta/resources/images/trade/direct_tw.png">&nbsp;<a href="#">&nbsp;${subcategory.subca_name}</a>
			<img id="category_button_ktw" src="/Jungkosta/resources/images/trade/category_direct.png">
			<div class="row">

				<div class="col-md-offset-1 col-md-4 left_ktw">
					 <img class="item_ktw" src="displayFile?fileName=${register.item_pic1 }" />
					<div class="row">
						<div id="item_sub_imgs">
						<hr id="imgs_line">
							<div class="col-md-2" id="item_sub_imgs_1">
								<img alt="" src="displayFile?fileName=${register.item_pic1 }">
							</div>
							<div class="col-md-2" id="item_sub_imgs_2">
								<img alt="" src="displayFile?fileName=${register.item_pic2 }">
							</div>
							<div class="col-md-2" id="item_sub_imgs_3">
								<img alt="" src="displayFile?fileName=${register.item_pic3 }">
							</div>
							<div class="col-md-2" id="item_sub_imgs_4">
								<img alt="" src="displayFile?fileName=${register.item_pic4 }">
							</div>
						</div>
						<br> <br> <br> <br> <br>

						<div class="row">
							<div class="col-md-6 col-md-offset-6">
								<div id="nav_ktw">
								<!-- 	<a href="#" id="prev_ktw"> <img alt=""
										src="/Jungkosta/resources/images/trade/prev_.png">
									</a> <a href="#" id="nav_dot_ktw"> <img alt=""
										src="/Jungkosta/resources/images/trade/dot_.png">
									</a> <a href="#" id="next_ktw"> <img alt=""
										src="/Jungkosta/resources/images/trade/next_.png">
									</a> -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-5 col-md-offset-2 right_ktw">
					<form action="/Jungkosta/trade/tradeOrder" method="get">
						<input type="hidden" name="sale_id" value="${register.sale_id }">
						<div class="row">
							<div class="col-md-12">
								<img id="good_ktw" src="/Jungkosta/resources/images/trade/good.png" />&nbsp;
								<span id="email">중코스타</span>&nbsp; <img id="check_ktw"
									src="/Jungkosta/resources/images/trade/check.jpg" />
								<hr id="line">
							</div>
							<br> <br> <br> <br>
							<div class="row">
								<div class="col-md-3">
									<span>상품명 : </span>
								</div>
								<div class="col-md-9">
									<span id="itemName_ktw" name="item_name">${register.item_name }</span>
								</div>
							</div>
							<br> <br>
							<div class="row">
								<div class="col-md-3">
									<span>상품번호 : </span>
								</div>
								<div class="col-md-9">
									<div id="item_num_name_ktw">
										<span id="itemNum_ktw" name="sale_id">${register.sale_id }</span>
										/ <span id="itemCategory_ktw" name="subca_id">${subcategory.subca_name}</span>
									</div>
								</div>
							</div>
							<br> <br>
							<div class="row">
								<div class="col-md-3">
									<span>상품가격 : </span>
								</div>
								<div class="col-md-9">

									<span id="itemPrice_ktw" name="item_cost"><fmt:formatNumber
											value="${register.item_cost }" pattern="#,###" />원</span>
								</div>
								<br>
								<hr>
							</div>
							<br> <br> <br> <br>

							<button type="submit" class="btn btn-primary btn-lg"
								>주문하기</button>

						</div>
					</form>
				</div>

			</div>
			<br> <br> <br>
			<div class="li_active">
				<ul class="nav nav-tabs detail_select_ktw">

					<li class="active"><a href="#product_info" data-toggle="tab">상품정보</a></li>
					<li><a href="#comment" data-toggle="tab">판매자가 받은 상품평</a></li>
					<li><a href="#qAnda" data-toggle="tab">상품문의</a></li>
				</ul>


				<div class="tab-content">
					<br> <br>
					<div class="tab-pane active" id="product_info">
						<div class="row">
							<div class="col-md-offset-1 col-md-1">
								<span id="BUY_TIME_ktw" class="item_info_Quest_ktw">구매시기</span>
							</div>
							<div class="col-md-offset-1 col-md-9">

								<span id="BUY_TIME_Result_ktw"><fmt:formatDate
										value="${register.buy_time }" pattern="yyyy-MM-dd" /></span>
							</div>
							<br> <br> <br>
							<div class="col-md-offset-1 col-md-1">
								<span id="ITEM_STATUS_ktw" class="item_info_Quest_ktw">상품상태</span>
							</div>
							<div class="col-md-offset-1 col-md-9">
								<span id="ITEM_STATUS_Result_ktw">${register.item_status}</span>
							</div>
							<br> <br> <br>
							<div class="col-md-offset-1 col-md-1">
								<span id="ITEM_SCRATCH_ktw" class="item_info_Quest_ktw">생활기스</span>
							</div>
							<div class="col-md-offset-1 col-md-9">
								<span id="ITEM_SCRATCH_Result_ktw">${register.item_scratch}</span>
							</div>

							<br> <br> <br>
							<div class="col-md-offset-1 col-md-1">
								<span id="ADDITIONAL_INFO_ktw" class="item_info_Quest_ktw">추가정보</span>
							</div>
							<div class="col-md-offset-1 col-md-9">
								<!-- 		<span class="ADDITIONAL_INFO_Result_ktw">1.액정에 기스가 있습니다.</span><br>
								<span class="ADDITIONAL_INFO_Result_ktw">2.상태가 좋습니다.</span><br> -->
								<label class="form-control" name="additional_info">
									${register.additional_info } </label>
							</div>
							<br> <br> <br>
							<div class="col-md-offset-1 col-md-1">
								<span id="BUY_INFO_ktw" class="item_info_Quest_ktw">구매경로</span>
							</div>
							<div class="col-md-offset-1 col-md-9">
								<span id="BUY_INFO_Result_ktw">${register.buy_info }</span>
							</div>
						</div>
					</div>

					<div class="tab-pane" id="comment">상품평</div>

					<div class="tab-pane" id="qAnda">
						<div class="row">
							<div class="reply_table_si">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>글번호</th>
											<th>내용</th>
											<th>글쓴이</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="seq" value="1" />
										<c:forEach var="temp" items="${reply }">
											<tr>
												<td>${seq }</td>
												<td>${temp.content }</td>
												<td>${temp.email }</td>
											</tr>

											<c:set var="seq" value="${seq+1 }" />
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<div class="row">
											<div class="col-md-10">
												<h4 id="reply_title_si">상품문의</h4>
											</div>
											<div class="col-md-2">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#collapseOne" class="sellerReply_si btn btn-default"
														role="button">글쓰기</a>
												</h4>
											</div>
										</div>
									</div>
									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<form id="reply">
												<input type='hidden' name="email" value="${email }">
												<input type="hidden" name="sale_id"
													value="${param.sale_id }">
												<div class="qAnda form-group">
													<textarea id="reply_contents_si" name="content"
														class="form-control" placeholder="로그인 후 이용 가능합니다."></textarea>
												</div>
												<div class="reply_button_si">
													<button type="submit" class="btn btn-default"
														name="reply_confirm_si">확인</button>
													<button type="reset" class="btn btn-default"
														id="reply_reset_si">취소</button>
												</div>
											</form>
										</div>
									</div>
									<!-- 상품문의 정보 입력 form 끝 -->
								</div>
							</div>
							<!-- 상품문의 collapse 끝 -->
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

<%-- 	<jsp:include page="../header&footer/footer.jsp"></jsp:include> --%>
	<script type="text/javascript">
		$(function() {
			$('#collapseFour').collapse({
				toggle : false
			})
		});
		$(function() {
			$('#collapseTwo').collapse('show')
		});
		$(function() {
			$('#collapseThree').collapse('toggle')
		});
		$(function() {
			$('#collapseOne').collapse('hide')
		});
	</script>

</body>
</html>