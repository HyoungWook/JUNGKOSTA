$(function() {
	$("#content").on("click", "a", function(event) {
		event.preventDefault();
		
		var url = "/Jungkosta/auction/";
		url += $(this).attr("href");

		
		window.opener.self.location = url;
		window.self.close();
		
	});
})