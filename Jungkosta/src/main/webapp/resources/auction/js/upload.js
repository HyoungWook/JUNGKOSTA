function checkImageType(fileName) {

	var pattern = /jpg|gif|png|jpeg/i;

	return fileName.match(pattern);

}

function getFileInfo(fullName) {

	var fileName, imgsrc, getLink;

	var fileLink;

	if (checkImageType(fullName)) {
		imgsrc = "/Jungkosta/auction/displayFile?fileName=" + fullName;
		fileLink = fullName.substr(14);

		var front = fullName.substr(0, 12); // /2015/07/01/
		var end = fullName.substr(14);

		getLink = "/Jungkosta/auction/displayFile?fileName=" + front + end;

	}
	fileName = fileLink.substr(fileLink.indexOf("_") + 1);

	return {
		fileName : fileName,
		imgsrc : imgsrc,
		getLink : getLink,
		fullName : fullName
	};

}

function getListInfo(entry) {
	
	var main_image = "/Jungkosta/auction/displayFile?fileName=" + entry.item_pic1;

	return {
		sale_id : entry.sale_id,
		main_image : main_image,
		auction_end_status : entry.auction_end_status,
		item_name : entry.item_name,
		item_cost : entry.item_cost
	}

}
