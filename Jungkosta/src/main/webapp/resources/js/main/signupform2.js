$(function() {

	var ereg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var preg = /^[A-Za-z0-9_-]{8,12}$/;
	var bresireg = /[0-9]{6}$/g;
	var aresireg = /[0-9]{7}$/g;
	var telreg = /^\d{2,3}\d{3,4}\d{4}$/;


	$('#email_khw').keyup(function(event) {
		var result = ereg.test($(this).val());
		if (!result) {
			$('.e').removeClass('has-success');
			$('.e').addClass('has-error');
			if ($(this).val() == '') {
				$('.e').removeClass('has-error');
			}
		} else {
			$('.e').removeClass('has-error');
			$('.e').addClass('has-success');
		}
	})

	$('#password_khw').keyup(function(event) {
		var result = preg.test($(this).val());

		if (!result && $(this).val().length < 8) {
			$('.p').removeClass("has-success");
			$('.p').addClass("has-error");
			if ($(this).val() == '') {
				$('.p').removeClass("has-error");
			}
		} else {
			$('.p').removeClass("has-error");
			$('.p').addClass("has-success");
		}

	})

	$('#beforeresi_khw').keyup(function(event) {
		var result = bresireg.test($(this).val());

		if (!result && $(this).val().length != 6) {
			$('.br').removeClass("has-success");
			$('.br').addClass("has-error");

			if ($(this).val() == '') {
				$('.br').removeClass("has-error");
				$('.br').removeClass("has-success");
			}
		} else {
			$('.br').removeClass("has-error");
			$('.br').addClass("has-success");
		}

	})

	$('#afterresi_khw').keyup(function(event) {
		var result = aresireg.test($(this).val());
		if (!result && $(this).val().length != 7) {
			$('.ar').removeClass("has-success");
			$('.ar').addClass("has-error");

			if ($(this).val() == '') {
				$('.ar').removeClass("has-error");
				$('.ar').removeClass("has-success");
			}
		} else {
			$('.ar').removeClass("has-error");
			$('.ar').addClass("has-success");
		}
	});

	$('#telnum_khw').keyup(function(event) {
		var result = telreg.test($(this).val());
		if (!result) {
			$('.tel').removeClass("has-success");
			$('.tel').addClass("has-error");
			if ($(this).val() == '') {
				$('.tel').removeClass("has-error");
				$('.tel').removeClass("has-success");
			}
		} else {
			$('.tel').removeClass("has-error");
			$('.tel').addClass("has-success");
		}
	})



	$('.korean').keyup(function(event) {

		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {

			var val = $(this).val();

			$(this).val(val.replace(/([^가-힣ㄱ-ㅎㅏ-ㅣ\x20])/gi, ''));
		}

	});

	$('.number').keyup(function(event) {

		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {

			var val = $(this).val();

			$(this).val(val.replace(/[^0-9]/gi, ''));
		}
	});

	var $checkbox = $(".inlineCheckbox_khw");
	var check_value = 0;
	$checkbox.on("click", function() {

		if ($(this).is(":checked")) {
			check_value++;
		} else {
			check_value--;
		}

		if (check_value >= 3) {

			$checkbox.each(function() {

				if (!$(this).is(":checked")) {
					$(this).attr("disabled", "disabled");
				}

			});
		} else {
			$checkbox.each(function() {

				$(this).removeAttr("disabled");
			})

		}

	})



	$('.container form').submit(function(event) {
		var $email = $('#email_khw');
		var $password = $('#password_khw');
		var $name = $('.korean');
		var $beforeresi = $('#beforeresi_khw');
		var $afterresi = $('#afterresi_khw');
		var $telnum = $('#telnum_khw');
		var $checkbox = $(".inlineCheckbox_khw");


		if ($email.val() == '' && ereg.test($email.val()) == false) {
			$('.e').focus();
			alert('이메일 형식에 맞게 입력해주세요.');

			return false;
		} else {
			$('.e').removeClass('has-error');
			$('.e').addClass('has-success');
		}

		if ($password.val() == '' && preg.test($password.val()) == false) {
			$('.p').focus();
			alert('비밀번호 형식에 맞게 입력해주세요.');

			return false;
		} else {
			$('.p').removeClass("has-error");
			$('.p').addClass("has-success");
		}

		if ($name.val() == '') {
			$('.korean').addClass('has-error');
			$('.korean').focus();
			alert('이름을 입력해주세요.');

			return false;
		}

		if ($beforeresi.val() == '' && bresireg.test($beforeresi.val()) == false) {
			$('#beforeresi_khw').focus();
			alert('주민등록번호 형식에 맞게 입력해주세요.');

			return false;
		} else {
			$('.br').removeClass("has-error");
			$('.br').addClass("has-success");
		}

		if ($afterresi.val() == '' && aresireg.test($afterresi.val()) == false) {
			$('#afterresi_khw').focus();
			alert('주민등록번호 형식에 맞게 입력해주세요');
			return false;
		} else {
			$('.ar').removeClass("has-error");
			$('.ar').addClass("has-success");
		}

		if ($telnum.val() == '' && telreg.test($telnum.val()) == false) {
			$('#telnum_khw').focus();
			alert('전화번호 형식에 맞게 입력해주세요.');

			return false;
		} else {
			$('.tel').removeClass("has-error");
			$('.tel').addClass("has-success");
		}

		if ($checkbox.val().length < 3) {
			$('.inlineCheckbox_khw').focus();
			alert('관심사항을 체크해주세요');

			return false;
		}



	})

	

	$('#sendMail_khw').click(function() {

		var receiver = $('#conEmail').val();


		$.ajax({
			type : "post",
			url : "mainMailSendProc",
			datatype : "text",
			data : "receiver=" + receiver,
			cache : false,
			success : function(data) {

				var id = 0;
				var time = 30;
				var result = data.trim();

				if (result == 'success') {
					alert('메일 발송 완료');
					var $label = $('<label/>', {
						'class' : 'col-xs-2 col-lg-2 control-label'
					});

					$label.html("제한시간");

					var $h4 = $('<h4/>', {
						"id" : 'time_sign_ws'
					});

					$('#expire_time_ws').html("");

					$('#expire_time_ws').append($label).append($h4);

					id = setInterval(function() {

						var minute = parseInt(time / 60);
						var second = time % 60;

						var timer = minute + "분 " + second + "초";

						time--;

						$h4.html("");
						$h4.html(timer);

						if (time < 0) {
							$.ajax({
								url : "expire_number",
								cache : false,
								datatype : "text",
								type : "post",
								success : function(data) {},
								error : function() {}
							})

							clearInterval(id);
						}
					}, 1000);
				}
				if(result == 0){
					alert("중복된 E-Mail입니다.");
				}
			},
			error : function() {}
		})

	})
	
	$('#confirmOK_khw').click(function() {

		var receiver = $('#conEmail').val();

		var confirm_num_khw = $('#confirm_num_khw').val();

		$.ajax({
			url : "confirmnumProc",
			datatype : "text",
			data : "number=" + confirm_num_khw,
			type : "post",
			cache : false,
			success : function(data) {
				if (data == 1) {
					alert('인증 확인 되셨습니다.');

					$('#email_khw').val(receiver);

					$('#emailconfirm_khw').modal('hide');
				} else {
					alert('인증 실패 하셨습니다.');
				}
			},
			error : function() {}
		})

	});

	$('.adr_khw').keyup(function() {
		var $input = $(this).val();
		if ($(this).val() != null) {
			$(this).val("");
		}
	})

	$('#conEmail').val("");
	$('#confirm_num_khw').val("");

	$('#modalCancel_khw').click(function() {
		var conEmail = $('#conEmail').val();
		var confirm_num = $('#confirm_num_khw').val();

		if ($('#conEmail').val() != "" && $('#confirm_num_khw').val() != "") {
			$('#conEmail').val("");
			$('#confirm_num_khw').val("");
		}
	})

	$(document).ajaxStart(function() {
		$("#loading").fadeIn();
	}).ajaxStop(function() {
		$("#loading").fadeOut();
	})
	
	$('#modalOpen_khw').click(function() {
		$('#emailconfirm_khw').modal('show');
	});
	

})