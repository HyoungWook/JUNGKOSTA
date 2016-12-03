<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/Jungkosta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/Jungkosta/resources/bootstrap/css/custom2.css" rel="stylesheet">
<link href="/Jungkosta/resources/css/main/signupcss.css" rel="stylesheet">


<script src="/Jungkosta/resources/lib/jquery-3.1.1.min.js"></script>
<script src="/Jungkosta/resources/js/main/signupform2.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/Jungkosta/resources/bootstrap/js/bootstrap.min.js"></script>

<title>!중고세끼!</title>
</head>
<body>
	<!-- 모달시작 -->
	<div class="modal fade" id="emailconfirm_khw" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">E-mail 인증</h4>
				</div>

				<div class="modal-body">
					<form method="post" id="mail_form">
						<div id="loading">
							<img alt="loading" src="../images/loading.gif">
						</div>
						<div class="form-group">
							<label for="email" class="col-xs-2 col-lg-2 control-label"
								for="receiver">이메일</label>
							<div class="col-xs-8 col-lg-8">
								<input type="email" class="form-control" id="conEmail"
									placeholder="이메일" name="receiver">
							</div>
							<button type="button" class="btn btn-primary" id="sendMail_khw">메일발송</button>
						</div>
					</form>
					<form method="post">


						<div class="form-group">
							<label for="password" class="col-xs-2 col-lg-2 control-label">인증번호</label>
							<div class="col-xs-8 col-lg-8">
								<input type="text" class="form-control" placeholder="인증번호"
									name="confirm_num" id="confirm_num_khw">
							</div>
							<button type="button" class="btn btn-primary" id="confirmOK_khw">확인</button>
						</div>

						<div class="form-group" id="expire_time_ws"></div>
						<div class="form group button_div_header">
							<button type="button" class="btn btn-danger btn-lg button_header"
								data-dismiss="modal" id="modalCancel_khw">Cancel</button>
						</div>
					</form>

				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!-- 모달 끝 -->

	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<br>
				<div>
					<span id="signup_khw">회원가입</span>
					<hr>
					<br> <br>
				</div>
				<form class="form-horizontal" role="form" action="mainSignupForm2"
					method="post">
					<div class="e form-group">
						<label for="emailaddress" class="col-xs-2 col-lg-2 control-label">E-Mail</label>
						<div class="col-xs-6 col-lg-6">
							<input type="email" name="email" id="email_khw"
								class="form-control" placeholder="E-Mail">
						</div>

						<div class="col-xs-3 col-lg-3">
							<a id="modalOpen_khw" class="btn btn-info">E-Mail 인증</a>
						</div>
					</div>

					<div class="p form-group">
						<label for="password" class="col-xs-2 col-lg-2 control-label">비밀번호</label>
						<div class="col-xs-9 col-lg-9">
							<input type="password" name="password" id="password_khw"
								class="form-control" placeholder="영어숫자 포함 8~12자리 ">
						</div>
					</div>

					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">이
							름</label>
						<div class="col-xs-9 col-lg-9">
							<input type="text" name="name" class="form-control korean"
								placeholder="이름(한글만 가능)">
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">주민번호</label>
						<div class="br col-xs-3 col-lg-3">
							<input type="text" name="resident_id" id="beforeresi_khw"
								class="number form-control" placeholder="숫자 6자리">
						</div>
						<label class="col-xs-1 col-lg-0 control-label">―</label>
						<div class="ar col-xs-3 col-lg-3">
							<input type="password" name="resident_id" id="afterresi_khw"
								class="number form-control" placeholder="숫자 7자리">
						</div>
					</div>

					<div class="form-group">
						<label for="address" class="col-xs-2 col-lg-2 control-label">주
							소</label>
						<div class="col-xs-3 col-lg-3">
							<input type="text" name="address" id="sample4_postcode"
								class="adr_khw form-control" placeholder="우편번호">
						</div>
						<div class="col-xs-3 col-lg-3">
							<input type="button" onclick="sample4_execDaumPostcode()"
								class="form-control btn btn-info" value="우편번호 찾기"><br>
							<br>
						</div>
						<br>

						<div class="ad_khw col-xs-9 col-lg-9">
							<input type="text" name="address" id="sample4_roadAddress"
								class="adr_khw  form-control" placeholder="도로명주소"><br>
							<input type="text" name="address" id="sample4_detailAddress"
								class="form-control" placeholder="상세주소">
						</div>
					</div>



					<div class="tel form-group">
						<label class="col-xs-2 col-lg-2 control-label">전화번호</label>
						<div class="col-xs-9 col-lg-9">
							<input type="text" name="phone_num" id="telnum_khw"
								class="number form-control" placeholder="'-'없이 입력">
						</div>
					</div>

					<div class="form-group">
						<label for="address" class="col-xs-2 col-lg-2 control-label">비밀번호
							질문</label>
						<div class="col-xs-9 col-lg-9">
							<select class="form-control" name="question">
								<option>비밀번호 힌트 선택</option>
								<option value="나의 아버지 성함은?">나의 아버지 성함은?</option>
								<option value="자신의 보물 제 1호는?">자신의 보물 제 1호는?</option>
								<option value="내가 나온 초등학교 이름은?">내가 나온 초등학교 이름은?</option>
								<option value="가장 기억에 남는 선생님 성함은?">가장 기억에 남는 선생님 성함은?</option>
								<option value="가장 친한 친구 이름은?">가장 친한 친구 이름은?</option>
								<option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">비밀번호 질문 답</label>
						<div class="col-xs-9 col-lg-9">
							<input type="text" name="answer" class="form-control"
								placeholder="답변 입력">
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">은행명</label>
						<div class="col-xs-4 col-lg-4">
							<select class="form-control" name="bank_name">
								<option value="국민은행">국민은행</option>
								<option value="신한은행">신한은행</option>
								<option value="하나은행">하나은행</option>
								<option value="우리은행">우리은행</option>
								<option value="농    협">농 협</option>
							</select>
						</div>

						<label class="col-xs-2 col-lg-2 control-label">계좌번호</label>
						<div class="ac col-xs-3 col-lg-3">
							<input type="text" name="account_num" id="accountnum_khw"
								class="number form-control number" placeholder="'-'없이 입력">
						</div>

					</div>


					<div class="form-group">
						<label class="interests_label_khw col-xs-2 col-lg-2 control-label"></label>&nbsp;&nbsp;&nbsp;
						<div class="interests_ca1_khw form-group">
							<label class="elec_label_khw col-xs-2 col-lg-2 control-label">전자제품</label>&nbsp;
							<label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="스마트폰">
								스마트폰
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="컴퓨터">
								컴퓨터
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="노트북">
								노트북
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="태블릿">
								태블릿
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="노트북/PC 주변기기">
								노트북/PC 주변기기
							</label>&nbsp;&nbsp; <label class="checkbox-inline"> <input
								type="checkbox" name="interests" class="inlineCheckbox_khw"
								value="카메라"> 카메라
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="웨어러블">
								웨어러블
							</label><br> &nbsp;&nbsp;<label class="checkbox-inline"> <input
								type="checkbox" name="interests" class="inlineCheckbox_khw"
								value="음향기기"> 음향기기
							</label>&nbsp;&nbsp;&nbsp; <label class="checkbox-inline"> <input
								type="checkbox" name="interests" class="inlineCheckbox_khw"
								value="영상가전"> 영상가전
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="게임/타이틀">
								게임/타이틀
							</label><br> &nbsp;&nbsp;<label class="checkbox-inline"> <input
								type="checkbox" name="interests" class="inlineCheckbox_khw"
								value="자동차 기기"> 자동차기기
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="기타 전자제품">
								기타 전자제품
							</label>
						</div>

						<div class="interests_ca2_khw form-group">
							<label
								class="interests_label_khw col-xs-2 col-lg-2 control-label">관심정보</label>
							<label
								class="interests_ca2_head_khw col-xs-2 col-lg-2 control-label">해외명품</label>&nbsp;
							<label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="지류카드 상품권">
								지류 카드 상품권
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="공연/티켓">
								공연/티켓
							</label><br> &nbsp;&nbsp;<label class="checkbox-inline"> <input
								type="checkbox" name="interests" class="inlineCheckbox_khw"
								value="여행/항공"> 여행/항공
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="모바일쿠폰/상품권">
								모바일쿠폰/상품권
							</label>
						</div>

						<div class="interests_ca3_khw form-group">
							<label
								class="interests_ca3_head_khw col-xs-2 col-lg-2 control-label">여행문화</label>&nbsp;
							<label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="지류카드 상품권">
								지류 카드 상품권
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="공연/티켓">
								공연/티켓
							</label><br> &nbsp;&nbsp;<label class="checkbox-inline"> <input
								type="checkbox" name="interests" class="inlineCheckbox_khw"
								value="여행/항공"> 여행/항공
							</label> <label class="checkbox-inline"> <input type="checkbox"
								name="interests" class="inlineCheckbox_khw" value="모바일쿠폰/상품권">
								모바일쿠폰/상품권
							</label>
						</div>

					</div>
					<div class="form-group" id="button_ws">
						<button type="submit" class="btn btn-primary btn-lg"
							id="signbutton_khw">확인</button>
						<a href="../main/main.jsp"><button type="button"
								class="btn btn-danger btn-lg" id="signbutton_khw">취소</button></a>
					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

	<script>
		function sample4_execDaumPostcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}
					// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
					if (fullRoadAddr !== '') {
						fullRoadAddr += extraRoadAddr;
					}
	
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('sample4_roadAddress').value = fullRoadAddr;
					document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
	
					// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
					if (data.autoRoadAddress) {
						//예상되는 도로명 주소에 조합형 주소를 추가한다.
						var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
						document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	
					} else if (data.autoJibunAddress) {
						var expJibunAddr = data.autoJibunAddress;
						document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	
					} else {
						document.getElementById('guide').innerHTML = '';
					}
				}
			}).open();
		}
	</script>

</body>
</html>
