$(document).ready(
		function() {

			$("#fileInput").on('change', function() { // 값이 변경되면

						if (window.FileReader) { // modern browser

							var filename = $(this)[0].files[0].name;
							//alert(filename);
							var pattern = filename.substring(filename.lastIndexOf(".") + 1);
							//alert(pattern);
							if (pattern=="jpg"|| pattern=="png" ||pattern =="gif") {
								$("#userfile").val(filename);
							} else {
								alert("이미지 파일만 업로드 해주세요.");
								$("#userfile").val("");
							}
						} else { // old IE

						var filename = $(this).val().split('/').pop().split('\\').pop(); 
						// 파일명만 추출
							alert(filename);
						}

						// 추출한 파일명 삽입

					});

		});