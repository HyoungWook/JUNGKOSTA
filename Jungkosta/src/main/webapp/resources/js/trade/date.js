$(function() {
	   var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;
		var yyyy = today.getFullYear();
		
		if(dd < 10){
			dd = '0'+dd
		}

		if(mm < 10){
			mm = '0'+mm
		}

		today = yyyy+'/'+mm+'/'+dd; 
	var dateFormat = "dd/mm/yy",
	
	from = $("#from").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 3,
		dateFormat : "yy/mm/dd",
		

	})

	.on("change", function() {
		to.datepicker("option", "minDate", getDate(this));
	}),

	to = $("#to").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 3,
		dateFormat : "yy/mm/dd"
	}).on("change", function() {
		from.datepicker("option", "maxDate", getDate(this));
	});

	buy_date = $("#buy_date").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 3,
		dateFormat : "yy/mm/dd",
		maxDate : "d"
	}).on("change", function() {
		from.datepicker("option", "maxDate", getDate(this));
	});

	function getDate(element) {
		var date;
		try {
			date = $.datepicker.parseDate(dateFormat, element.value);
		} catch (error) {
			date = null;
		}
		return date;
	}
});