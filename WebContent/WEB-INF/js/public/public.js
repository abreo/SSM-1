function changeCenterGet(url) {
	var args = {
			"time":new Date()
	}
	$.get(url,args,function(data) {
		$("#center").html(data);
	});
}