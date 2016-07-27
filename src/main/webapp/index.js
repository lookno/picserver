$(function(){
	/*$("#login .submit").click(function(){
	 var userName=$("input[name='user']").val();
	 var passWord=$("input[name='pass']").val();
	 alert($.md5(passWord));
	});*/
	
	$("#login .submit").click(function(){
		
		 var userName=$("input[name='user']").val();
		 var passWord=$.md5($("input[name='pass']").val());
		 var d={"name":userName,"password":passWord};
		$.ajax({
			type:"post",
			url:"user/login.action",
			async : false,
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify(d),
			success:function(result){
				if(result.success==200){
					alert("success");	
				}else{
					alert("失败");
				}	
			}

		});

	  });
		
		
		});
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  