$(function(){
	
	var $name_ws = $('#name_ws');
	
	$name_ws.on('keyup',function(event){
	var reg = /\+/g;	
		var name = $(this).val();
		
			$.ajax({

				type : "post",
				datatype : "json",
				cache : false,
				data : "name="+name,
				url : "customSearchProc",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data) {
					
					var decodeData = decodeURIComponent(data.replace(reg," "));
					                 
					var jsonArray = $.parseJSON(decodeData);
					var $table = $('#search_table_ws');
					var number = 1;
					
					$table.html("");
					
					$.each(jsonArray,function(index,item){
						
						var $tr = $('<tr/>');
						var $td_name = $('<td/>',{
							'class':'popover-options'
						});
						var $td_number = $('<td/>');
						var $td_email = $('<td/>');
						
						
						var $a_custom = $('<a/>', {
							'href' : '#',
							'title' : item.name+' 정보',
							'data-container' : "body",
							'data-toggle' : "popover",
							'data-placement' : "right",
							'data-content' : "<a href='/Jungkosta/blackListForm?id="+item.email+"'>블랙리스트 등록</a><br>" +
									"<a href='#'>회원 정보 관리</a><br>" + "<a href='/Jungkosta/warningForm?id="+item.email+"'>회원 경고</a><br>",
							'class' : 'dynamic_a_tag_ws'
						});
						
						$a_custom.html(item.name);
			
						$td_name.append($a_custom);
						$td_number.html(number);
						$td_email.html(item.email);
						
						number = number+1;
						
						$table.append($tr);
						$tr.append($td_number);
						$tr.append($td_email);
						$tr.append($td_name);
						
						$(".popover-options a").popover({html : true });
						
					})
					
				},
				error : function() {

				}

			})
	});
	
})