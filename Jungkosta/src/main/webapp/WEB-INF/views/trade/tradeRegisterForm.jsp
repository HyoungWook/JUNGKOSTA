<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- jquery -->
<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/Jungkosta/resources/js/trade/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<!-- css -->
<link href="/Jungkosta/resources/css/trade/tradeRegisterForm.css" rel="stylesheet">
<!-- Font Awesome Icons -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />

<!-- javaScript -->
<script type="text/javascript" src="/Jungkosta/resources/js/trade/itemRegister.js"></script>
<script type="text/javascript" src="/Jungkosta/resources/js/trade/main.js"></script>
<script type="text/javascript" src="/Jungkosta/resources/js/trade/category.js"></script>
<script type="text/javascript" src="/Jungkosta/resources/js/trade/date.js"></script>

<!-- bootStrap -->
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- jquery-ui -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>일반 판매 등록 페이지</title>
</head>
<body>
	<h2>${test }</h2><br>
	
	 <form id="itemRegister" method="post"> <!-- enctype="multipart/form-data" -->
      <div class="container">
         <div id="section">
            <div class="row">
               <h1 class="saleTotal_ktw">님 판매물품 등록</h1>
               <div class="col-md-offset-3 col-md-9">
                  <h3 class="saleCategory_ktw">판매하실 물건의 카테고리를 선택해 주세요</h3>

                  <div class="form-group category_list_ktw">

                     <label for="sel1">카테고리</label> <select class="form-control cate_ktw"
                        id="category_ktw" name="category">
                        <option value="null" selected="selected"">카테고리 선택</option>
                        <option value="ele">전자제품</option>
                        <option value="child">유아동/출산</option>
                        <option value="sports">스포츠/레저</option>
                     </select>
                  </div>

                  <div class="form-group sub_category_list_ktw">
                     <label for="sel1">서브 카테고리</label> <select class="form-control cate_ktw"
                        id="sub_category_ktw" name="subca_id">
                        <option value="null" selected="selected">서브카테고리 선택</option>
                        <option class="ele" value="1">노트북</option>
                        <option class="ele" value="2">테블릿</option>
                        <option class="ele" value="3">PC</option>
                        <option class="child" value="4">의류</option>
                        <option class="child" value="5">용품</option>
                        <option class="sports" value="6">신발</option>
                        <option class="sports" value="7">장비</option>
                        <option class="ele" value="8">스마트폰</option>
                        <option class="ele" value="9">카메라</option>
                     </select>
                  </div>
                  <br>

                  <h3 class="saleCategory_ktw">판매하실 물건의 제품명을 입력해주세요</h3>
                  <div class="item_name form-group">
                     <input type="text" validation ="yes" class="form-control cate_ktw" name="item_name"
                        id="item_name_si" placeholder="예)갤럭시 노트5">
                  </div>
                  <br>

                  <h3 class="saleCategory_ktw">구매시기는 언제인가요?</h3>
                  <div class="buy_date form-group">
                     <input type="text" id="buy_date" name="buy_time"
                        class="form-control cate_ktw">
                  </div>
                  <br>

                  <h3 class="saleCategory_ktw">구매하신 경로는 어떻게 되나요?</h3>
                  <div class="buy_info form-group">
                  <input type="text" id='buy_info_si' class="form-control cate_ktw" name="buy_info"
                     placeholder="예)인터넷 쇼핑몰">
                  </div><br>

                  <h3 class="saleCategory_ktw">흠집은 있나요?</h3>
                  <select class="form-control cate_ktw" name="item_scratch" id="item_scratch_si">
                     <option value="null" selected="selected">선택해주세요</option>
                     <option>많음</option>
                     <option>양호</option>
                     <option>적음</option>
                     <option>없음</option>
                  </select> <br>

                  <h3 class="saleCategory_ktw">미개봉/미사용 제품인가요?</h3>
                  <select class="form-control cate_ktw" name="item_status" id="item_status_si">
                     <option value="null" selected="selected">선택해주세요</option>
                     <option>미개봉 : 박스를 개봉하지 않은 제품</option>
                     <option>미사용 : 박스를 개봉 후 사용하지 않은 제품</option>
                     <option>사용한 적이 있는 제품</option>
                  </select><br>

                  <h3 class="saleCategory_ktw">상품에 대한 추가정보를 입력해주세요</h3>
                  <div class="additional_info form-group">
                  <textarea rows="5" class="form-control cate_ktw" name="additional_info" id="additional_info_si"
                     placeholder="추가 정보를 입력해주세요"></textarea>
                  </div><br>

                  <h3 class="saleCategory_ktw">상품의 이미지를 올려주세요</h3>
                 <!--                     <div class="item_pic">
                     <input type="text" class="form-control" name="item_pic" disabled
                           placeholder= "제품 사진을 추가해주세요">
                     <button type="button" class="btn btn-default">사진 추가</button>
                  </div>
                  <img alt="" src="../image/gearfit01.jpg"><br>
                  <img alt="" src="../image/gearfit02.jpg"><br> <br> -->

                  <div class="form-group">

                     <!-- <input id="fileInput" filestyle="" type="file"
                        data-class-button="btn btn-default" name="item_pic"
                        data-class-input="form-control" data-button-text=""
                        data-icon-name="fa fa-upload" class="form-control" tabindex="-1"
                        style="position: absolute; clip: rect(0px, 0px, 0px, 0px);">

                     <div class="bootstrap-filestyle input-group">

                        <input type="text" id="userfile" class="form-control"
                           disabled=""> <span
                           class="group-span-filestyle input-group-btn" tabindex="0">

                           <label for="fileInput" class="btn btn-info "> <span
                              class="glyphicon fa fa-upload">업로드</span>

                        </label>

                        </span>

                     </div> -->
                     
                     <!-- Drag&Drop Image Upload -->
                     <div class="form-group">
						<label for="exampleInputEmail1" id="fileLabel">File DROP Here</label>
						<div class="fileDrop"></div>
					</div>
					<!-- Uploaded Images List -->
					<div>
						<ul class="mailbox-attachments clearfix uploadedList">
			
						</ul>
					</div>
                     

                  </div>
                  <br /> <br />
                  <h3 class="saleCategory_ktw">원하시는 상품의 가격을 입력해주세요</h3>
                  <div class="input-group form-group item_cost">
                     <input type="text" class="form-control" name="item_cost" id="item_cost_si">
                     <span class="input-group-addon"> 원 </span>
                  </div>
                  <br>

                  <h3 class="saleCategory_ktw">고객님의 계좌번호를 입력해주세요</h3>
                  <div class="col-md-3">
                     <div id="bankName">
                        <p>은행</p>
                        <select class="form-control" name="bank_name" id="bank_name_si">
                           <option value="null">은행을 선택해주세요</option>
                           <option>국민은행</option>
                           <option>신한은행</option>
                           <option>하나은행</option>
                           <option>우리은행</option>
                        </select>
                     </div>
                  </div>
                  <div class="col-md-9">
                     <div id="account">
                        <p>계좌번호</p>
                        <div class="form-group Account_no">
                         <input type="text" class="form-control" name="Account_no" id="Account_no_si"
                           placeholder="'-'은 제외하고 입력해주세요">
                           
                        </div>
                     </div>
                  </div>

                  <div class="bank_footer">
                     <input type="submit" class="btn btn-primary sub_ktw" value="등록">
                     <input type="reset" class="btn btn-danger can_ktw" value="취소">
                  </div>

               </div>

               <!-- section 우측 div 끝 -->

            </div>
         </div>
      </div>
   </form>
	
<script id="template" type="text/x-handlebars-template">
	<li>
		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			<a href="{{fullName}}" 
     		class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
		</span>
  		</div>
	</li>                
</script>

<script type="text/javascript">
var template = Handlebars.compile($('#template').html());

$('.fileDrop').on('dragenter dragover', function(event) {
	event.preventDefault();
});

$('.fileDrop').on('drop', function(event) {
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	var file = files[0];
	
	var formData = new FormData();
	formData.append("file", file);
	
	$.ajax({
		url: 'uploadAjax',
		type: 'POST',
		data: formData,
		dataType: 'text',
		processData: false,
		contentType: false,
		success: function(data) {
			alert('success');
			
			var fileInfo = getFileInfo(data);
			
			var html = template(fileInfo);
			
			$('.uploadedList').append(html);
		},
		error: function(error) {
			alert('fail');
		}
	});
});

$("#itemRegister").submit(function(event){
	event.preventDefault();
	
	var that = $(this);
	
	var str ="";
	$(".uploadedList .delbtn").each(function(index){
		 str += "<input type='hidden' name='item_pic["+ (index + 1) +"]' value='"+$(this).attr("href") +"'> ";
	});
	
	that.append(str);

	that.get(0).submit();
});
</script>
	
</body>
</html>