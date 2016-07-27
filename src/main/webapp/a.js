$(function(){
	$("#tijiao").click(function(){
			$.ajax({
			    url: 'user/test.action',
			    type: 'post',
			    cache: false,
			    "async" : false,
			    data: new FormData($('#user')[0]),
			    processData: false,
			    contentType: false,
			    "success" : function(json) {
			    	alert("上传成功");
				},
				"error":function(){
					alert("服务器异常");
				}
			});
	});
})