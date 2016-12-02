$(function() {

	$("#buy_date").datepicker({
		numberOfMonths : 3,
		showButtonPanel : true,
		changeMonth : true,
		changeYear : true,
		dateFormat : 'yy-mm-dd',
		maxDate: "d"
	});
	

	$("#to").datepicker({
		numberOfMonths : 3,
		showButtonPanel : true,
		changeMonth : true,
		changeYear : true,
		dateFormat : 'yy-mm-dd',
		minDate:"+1d"
	});
	



});