$(function() {

	var dateFormat = "dd/mm/yy",

	from = $("#from")

	.datepicker({

		defaultDate : "+1w",

		changeMonth : true,

		numberOfMonths : 3,
		dateFormat : "yy-mm-dd"

	})

	.on("change", function() {

		to.datepicker("option", "minDate", getDate(this));

	}),

	to = $("#to").datepicker({

		defaultDate : "+1w",

		changeMonth : true,

		numberOfMonths : 3,
		dateFormat : "yy-mm-dd"

	})

	.on("change", function() {

		from.datepicker("option", "maxDate", getDate(this));

	});

	buy_date = $("#buy_date").datepicker({

		defaultDate : "+1w",

		changeMonth : true,

		numberOfMonths : 3,
		dateFormat : "yy-mm-dd"

	})

	.on("change", function() {

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