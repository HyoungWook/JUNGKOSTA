<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/auction/css/auction_add_lsj.css" rel="stylesheet">

<title>��Ź�ǰ ���</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="./resources/auction/js/main.js"></script>
<script type="text/javascript" src="./resources/auction/js/category.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="./resources/auction/js/valid_check_lsj.js"></script>

<style>
.input_error_phw {
	display: none;
}

.fileDrop {
  width: 80%;
  height: 100px;
  border: 1px dotted gray;
  background-color: lightslategrey;
  margin: auto;
  
}
</style>
</head>
<body>
	<br />
	<br />
	<br />

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="./resources/auction/js/date.js"></script>

	<span id="top_lsj">��� ��ǰ ���</span>

	<div class="container">
		<form action="auctionRegister" method="post" enctype="multipart/form-data">
			
			<input type="hidden" name="flag" value="1">

			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div id="list_title_lsj">�Ǹ��Ͻ� ������ ī�װ��� �������ּ���.</div>

					<br /> <br />

					<div class="form-group category_list_phw">
						<label for="sel1">ī�װ�</label> <select class="form-control"
							id="category_phw" name="category">
							<option value="null">ī�װ� ����</option>
							<option value="ele">������ǰ</option>
							<option value="travel">����/��ȭ</option>
							<option value="global">�ؿ�/��ǰ</option>
						</select>
					</div>

					<div class="form-group category_list_phw">
						<label for="sel1">���� ī�װ�</label> <select class="form-control"
							id="sub_category_phw" name="subca_id">
							<option value="null">����ī�װ� ����</option>
							<option class="ele" value="1">��Ʈ��</option>
							<option class="ele" value="2">��ǻ��</option>
							<option class="ele" value="3">����Ʈ��</option>
							<option class="ele" value="4">�׺�</option>
							<option class="ele" value="5">��Ʈ��/pc �ֺ����</option>
							<option class="ele" value="6">ī�޶�</option>
							<option class="ele" value="7">���� ���</option>
							<option class="ele" value="8">�����</option>
							<option class="ele" value="9">���� ����</option>
							<option class="ele" value="10">����/Ÿ��Ʋ</option>
							<option class="ele" value="11">�ڵ��� ���</option>
							<option class="ele" value="12">��Ÿ ���� ���</option>
							<option class="travel" value="13">���� ī�� ��ǰ��</option>
							<option class="travel" value="14">����/Ƽ��</option>
							<option class="travel" value="15">���������/��ǰ��</option>
							<option class="travel" value="16">����/�װ���</option>
							<option class="global" value="17">��ǰ ����</option>
							<option class="global" value="18">��ǰ ����</option>
							<option class="global" value="18">��ǰ �ð�</option>
							<option class="global" value="18">��ǰ �Ź�</option>
							<option class="global" value="18">��ǰ �Ǽ��縮</option>


						</select>
					</div>
					<br /> <br />

					<div class="item">
						<div id="list_title_lsj">�Ǹ��Ͻ� ������ ��ǰ���� �Է��ϼ���.</div>
						<br /> <input type="text" class="form-control"
							placeholder="������ �Է����ּ���." name="item_name" id="item_name">
					</div>
					<div class="input_error_phw" id="item_name_phw">
						<p style="color: red">��ǰ���� �Է����ּ���(ex: ��Ʈ��)</p>
					</div>

					<!-- /input-group -->
					<br /> <br />
					<h3>���Žñ�� �����ΰ���?</h3>
					<input type="text" id="buy_date" name="buy_time"
						class="form-control"> <br>

					<div class="info">
						<h3>�����Ͻ� ��δ� ��� �ǳ���?</h3>
						<input type="text" class="form-control" name="buy_info"
							placeholder="��)���ͳ� ���θ�" id="buy_info">
					</div>
					<div class="input_error_phw" id="buy_info_phw">
						<p style="color: red">���� ��θ� �Է����ּ���(ex: ���ͳ� ���θ�)</p>
					</div>
					<br>

					<h3>������ �ֳ���?</h3>
					<select class="form-control" name="item_scratch">
						<option>����</option>
						<option>��ȣ</option>
						<option>����</option>
						<option>����</option>
					</select> <br>
					<div id="list_title_lsj">�̰���/�̻�� ��ǰ�ΰ���?</div>
					<br />
					<div class="form-group">
						<select class="form-control" id="sel1" name="item_status">
							<option>�̰���:�ڽ��� �������� ���� ��ǰ</option>
							<option>�̻��:���� �� ������� ���� ��ǰ</option>
							<option>��������� �ִ� ��ǰ</option>
						</select>
					</div>
					<br /> <br />

					<div class="additional">
						<div id="list_title_lsj">��ǰ�� ���� �߰������� �Է����ּ���.</div>

						<br />
						<textarea class="form-control" rows="4" placeholder="������ �Է����ּ���."
							name="additional_info" id="additional_info"></textarea>
					</div>
					<div class="input_error_phw" id="add_info_phw">
						<p style="color: red">�߰������� �Է����ּ���.</p>
					</div>
					<br /> <br />

					<div id="list_title_lsj">��ǰ�� �̹����� �÷��ּ���.</div>
					<br />
					<div class="form-group">
<!-- 						<label for="exampleInputEmail1">File DROP Here</label> -->
						<div class="fileDrop"></div>
					</div>
					<br /> <br />
					<div id="list_title_lsj">��� ���ᳯ¥�� �Է��� �ּ���.</div>
					<br />
					<div class="row">
						<div class="col-md-5">
							<label for="to">���� ��¥:</label> <input type="text" id="to"
								style="z-index: 2;" class="form-control" name="auction_end_date"
								placeholder="��¥�� ������ �ּ���"> <br>
						</div>
						<div class="col-md-5">
							<label for="to">���� �ð�:</label> <select class="form-control"
								name="time_sel">
								<option value="null">�ð��� ������ �ּ���.</option>
								<option>00:00</option>
								<option>06:00</option>
								<option>18:00</option>
							</select>
						</div>
					</div>
					<br />
					<div id="list_title_lsj">��ǰ�� ���� ���ݰ� ��ñ��� ������ �Է����ּ���.</div>
					<br>
					<div class="row">
						<div class="col-md-5 stcost">
							<div id="subtitle_lsj">���� ����</div>
							<br>
							<div class="input-group">
								<input type="text" style="text-align: right; z-index: 1"
									class="form-control input_cost" name="auction_stcost"
									id="auction_stcost"> <span class="input-group-addon">
									�� </span>
							</div>
							<div class="input_error_phw" id="stcost_phw">
								<p style="color: red">���۰����� �Է����ּ���.</p>
							</div>
						</div>

						<div class="col-md-5 immecost">
							<div id="subtitle_lsj">��ñ��� ����</div>
							<br>
							<div class="input-group">
								<input type="text" class="form-control input_cost"
									style="text-align: right; z-index: 1" name="immediate_bid_cost"
									id="immediate_bid_cost"> <span
									class="input-group-addon"> �� </span>
							</div>
							<div class="input_error_phw" id="immediate_phw">
								<p style="color: red">��� ���Ű��� �Է��� �ּ���.</p>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
					<br> <br> <br> <span id="last_btn_lsj">
						<button type="submit" class="btn btn-default btn-info">�Է�
							�Ϸ�</button>
					</span>
				</div>
			</div>
		</form>
	</div>

</body>
</html>