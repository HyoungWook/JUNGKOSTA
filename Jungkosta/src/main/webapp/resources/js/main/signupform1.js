$(function(){
   var checkgroup = $('#checkboxgroup_khw');
   var check = checkgroup.find("input");

   $('#inlineCheckbox1').click(function(){
      check.each(function(){
         if($('#inlineCheckbox1').is(":checked") == true){
            $(this).prop("checked", true);
         }
         else{
            $(this).prop("checked", false);
         }
      })
   })
   
   $('#next_khw').click(function(){
      if($('#inlineCheckbox2').is(":checked") && $('#inlineCheckbox3').is(":checked") &&
            $('#inlineCheckbox4').is(":checked") == true){
         $(location).attr('href', 'mainSignupForm2');  
      }
      else
         alert('약관에 동의해주세요');
   })
});