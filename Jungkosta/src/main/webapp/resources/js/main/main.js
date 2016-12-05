$(function() {
 	
 	var $carousel_ws1 = $('#carousel_ws1');
 	
 	var $carousel_ws2 = $('#carousel_ws2');
 	
 	var $carousel_ws3 = $('#carousel_ws3');
 	
 	var $preferList_ws = $('#preferList_ws');
 	
 	var $hotItem_ws = $('#hotItem_ws');
 	
 	var template1 = Handlebars.compile($("#template1").html());
 	
 	var template2 = Handlebars.compile($("#template2").html());
 	
 	var reg = /\+/g;
 	
 	var json = $preferList_ws.val();
 	
 	var hotItemJson = $hotItem_ws.val();
 	
 	if(typeof json != "undefined"){
 		
 		var decodeJson = decodeURIComponent(json.replace(reg," "));
 		
 		var preferJsonArray = $.parseJSON(decodeJson);
 		
 		print(preferJsonArray,$carousel_ws3);
 	}
 	
 	var decodeHotItemJson = decodeURIComponent(hotItemJson.replace(reg," "));
 	
 	var hotItemJsonArray = $.parseJSON(decodeHotItemJson);
 	
 	print(hotItemJsonArray,$carousel_ws2);
 	
 	$.ajax({
 		
 		url:"/Jungkosta/newItem",
 		type:"get",
 		datatype:"json",
 		cache:false,
 		success:function(data){
 			
 			var decodeData = decodeURIComponent(data.replace(reg," "));
 			
 			var jsonArray = $.parseJSON(decodeData);
 			
 			print(jsonArray,$carousel_ws1);
 		}
 	
 	});
 	
 	
 function getFileName(fileName) {
 	
 
 	var front = fileName.substr(0, 12); // /2015/07/01/
 	var end = fileName.substr(14);
 
 	var main_image = "/Jungkosta/auction/displayFile?fileName=" + front + end;
 
 	return main_image
 }
 
 function money_Format(){
		
	 	Handlebars.registerHelper("money_fomat", function(money) {
	 
	 		var value = "" + money;
	 
	 		var result = "";
	 		var array = [];
	 
	 		for (var i = value.length; i >= 3; i = i - 3) {
	 			array.push(value.substring(i - 3, i));
	 		}
	 
	 		var last = value.length % 3;
	 
	 		if (last != 0) {
	 			array.push(value.substr(0, last));
	 		}
	 
	 		for (var i = array.length - 1; i >= 0; i--) {
	 
	 			if (i == 0) {
	 				result += array[i] + "원";
	 			} else {
	 				result += array[i] + ",";
	 			}
	 		}
	 		
	 		return result;
	 
	 	});
	 }
 
 function print(jsonArray,object){
	 var count = parseInt(jsonArray.length/4);
	 
	 var flag = 0;
		
	 var $div;
		
		$.each(jsonArray,function(index,item){
			
			if(index%4 == 0){
				
				if(flag == 0){
					
					flag = 1;
					
					$div = $('<div/>',{
						class:"item active"
					});
					
				}else{
					$div = $('<div/>',{
						class:"item"
					})
				}
				
				object.append($div);
				
			}
			
			if(item.flag == 1){
				
				Handlebars.registerHelper("if_phw", function(auction_end_status, block){
					
					var accum = "";

					if(auction_end_status == 'true'){
							accum += block.fn();
					}
							return accum;
					});
				
				
			}
			
			money_Format();
			
			item.item_pic1 = getFileName(item.item_pic1);
			
			if(item.flag == 1){
				
				var html = template1(item);
				
				$div.append(html);
				
			}else{
				
				var html = template2(item);
				
				$div.append(html);
				
			}
			
		});
 	}
});

 function sendDetailAuction(id) {
 	
 	location.href = "/Jungkosta/auction/auctionDetail?sale_id=" + id;
 }
 
 function sendDetailTrade(id) {
 	
 	location.href = "/Jungkosta/trade/tradeDetail?sale_id=" + id;
 }