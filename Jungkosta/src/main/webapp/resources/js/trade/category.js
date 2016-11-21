$(function() {

	var $category = $("#category_ktw"); // 카테고리
	var $sub_category = $("#sub_category_ktw");// 서브카테고리
	var $subCategory_list = $sub_category.find("option");// 서브카테고리 리스트

	var category_value = "ele";

	$category.change(function() {
		category_value = $category.val();

		setting($subCategory_list, category_value);

		$sub_category.val("null");

	});

	setting($subCategory_list, category_value);
	

});

function setting($subCategory_list, category_value) {
	$subCategory_list.each(function(index) {
		$(this).removeClass("hide");
		if (!$(this).hasClass(category_value)) {
			$(this).addClass("hide");
		}
	});
}