$(function() {
	$(".sub_filter_phw").find("input").checkboxradio({
		icon : false
	});

});

function sendDetail(id) {
	location.href = "/Jungkosta/auction/auctionDetail?sale_id=" + id;
}

function addComma(data_value) {
	return Number(data_value).toLocaleString('en');
}

$(function() {
	$("#radio_btn input").checkboxradio({
		icon : false
	});
	$("#radio_btn").controlgroup();
	
});