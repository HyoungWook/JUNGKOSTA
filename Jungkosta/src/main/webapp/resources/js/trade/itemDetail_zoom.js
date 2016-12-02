$(function() {

	var sale_id = $("#sale_id").val();
	var images = [];
	
	var curImageIdx = 1;
	var total = 0;
	var wrapper = $('#image-gallery');
	var curSpan = wrapper.find('.current');
	var viewer = ImageViewer(wrapper.find('.image-container'));

	$.getJSON("item_pic/" + sale_id, function(data) {
		$.each(data, function(index, item) {
			var str = "displayFile?fileName=" + getImagePath(item);

			var temp = {
				small : str,
				big : str
			}

			images.push(temp);

		});
		
		total = images.length;
		wrapper.find('.total').html(total);
		
		showImage();
	});

	function showImage() {
		var imgObj = images[curImageIdx - 1];
		viewer.load(imgObj.small, imgObj.big);
		curSpan.html(curImageIdx);
	}

	wrapper.find('.next').click(function() {
		curImageIdx++;
		if (curImageIdx > total)
			curImageIdx = 1;
		showImage();
	});

	wrapper.find('.prev').click(function() {
		curImageIdx--;
		if (curImageIdx < 0)
			curImageIdx = total;
		showImage();
	});


	function getImagePath(imagePath) {
		var front = imagePath.substring(0, imagePath.lastIndexOf("/") + 1);
		var end = imagePath.substring(imagePath.lastIndexOf("/") + 3);

		return front + end;
	}

});