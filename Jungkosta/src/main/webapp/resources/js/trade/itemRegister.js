$(function(){
   
   var numReg = /^[0-9]+$/;
   
   //상품명 입력
   $('#item_name_si').keyup(function(event){
      if($(this).val().length == 0){
         $('.item_name').removeClass('has-success');
         $('.item_name').addClass('has-warning');
      }else{
         $('.item_name').removeClass('has-warning');
         $('.item_name').addClass('has-success');
      }
   })
   
   //구매시기
   $('#buy_date').keyup(function(event){
      if($(this).val().length == 0){
         $('.buy_date').removeClass('has-success');
         $('.buy_date').addClass('has-warning');
      }else{
         $('.buy_date').removeClass('has-warning');
         $('.buy_date').addClass('has-success');
      }
      
   })
   
   //구매정보
   $('#buy_info_si').keyup(function(event){
      if($(this).val().length == 0){
         $('.buy_info').removeClass('has-success');
         $('.buy_info').addClass('has-warning');
      }else{
         $('.buy_info').removeClass('has-warning');
         $('.buy_info').addClass('has-success');
      }
   })
   
   //추가정보 입력
   $('#additional_info_si').keyup(function(event){
      if($(this).val().length == 0){
         $('.additional_info').removeClass('has-success');
         $('.additional_info').addClass('has-warning');
      }else{
         $('.additional_info').removeClass('has-warning');
         $('.additional_info').addClass('has-success');
      }
   })
   
   //상품 가격 입력
   $('#item_cost_si').keyup(function(event){
      if($(this).val().length == 0  || numReg.test($(this).val())==false){
         $('.item_cost').removeClass('has-success');
         $('.item_cost').addClass('has-warning');
      }else{
         $('.item_cost').removeClass('has-warning');
         $('.item_cost').addClass('has-success');
      }
   })
   
   //계좌번호 입력
   $('#Account_no_si').keyup(function(event){
      if($(this).val().length == 0 || numReg.test($(this).val())==false){
         $('.Account_no').removeClass('has-success');
         $('.Account_no').addClass('has-warning');
      }else{
         $('.Account_no').removeClass('has-warning');
         $('.Account_no').addClass('has-success');
      }
   })
   
   $('form').submit(function(event){
      var $category = $('#category_ktw');
      var $sub_category = $('#sub_category_ktw');
      var $item_name = $('#item_name_si');
      var $buy_date = $('#buy_date');
      var $buy_info = $('#buy_info_si');
      var $item_scratch = $('#item_scratch_si');
      var $item_status = $('#item_status_si');
      var $additional_info = $('#additional_info_si');
      var $userfile = $('#userfile');
      var $item_cost = $('#item_cost_si');
      var $bank_name = $('#bank_name_si');
      var $Account_no = $('#Account_no_si');
      
      if($category.val() == 'null'){
         alert('카테고리를 선택해주세요');
         
         return false;
      }
      
      if($sub_category.val() == 'null'){
         alert('서브 카테고리를 선택해주세요');
         
         return false;
      }
      
      if($item_name.val().length == 0){
         alert('상품의 이름을 입력해주세요');
         
         return false;
      }
      
      if($buy_date.val().length == 0){
         alert('날짜를 입력해주세요');
         
         return false;
      }
      
      if($buy_info.val().length == 0){
         alert('구매 경로를 입력해주세요');
         
         return false;
      }
      
      if($item_scratch.val() == 'null'){
         alert('흠집 여부를 선택해주세요');
         
         return false;
      }
      
      if($item_status.val() == 'null'){
         alert('개봉/사용 여부를 선택해주세요');
         
         return false;
      }
      
      if($additional_info.val().length == 0){
         alert('상품의 추가정보를 입력해주세요');
         
         return false;
      }
      
      if($userfile.val().length == 0){
         alert('상품의 사진을 업로드해주세요');
         
         return false;
      }
      
      if(($item_cost.val().length == 0 || numReg.test($item_cost.val())==false)){
         alert('상품의 가격을 입력해주세요');
         
         return false;
      }
      
      if($bank_name.val() == 'null'){
         alert('은행을 선택해주세요');
         
         return false;
      }
      
      if(($Account_no.val().length == 0 || numReg.test($Account_no.val())==false)){
         alert('계좌번호를 입력해주세요');
         
         return false;
      }
      
   })
   
})