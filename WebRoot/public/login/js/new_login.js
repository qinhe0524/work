$(function () {
	document.onkeydown = function(e){
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	$('#login-button').click();	
	    }
	}

    $('#user_code').poshytip({
    	content: '用户名必须填写',
	    className: 'tip-yellowsimple',
		showOn: 'none',
		alignTo: 'target',
		alignX: 'right',
		alignY: 'center',
		offsetX: 5,
		offsetY: 0,
		showTimeout: 100
	});
	

})

function proName() {
	 var pathName=window.document.location.pathname;
	 return pathName.substring(1,pathName.substr(1).indexOf('/')+1);
}

$('#login-button').click(function(event){	
	
	var user_code=$("#user_code").val();
	var user_pass=$("#user_pass").val();
	if(user_code==""){
		$('#err').text("用户名不能为空");
		return false;
	}
	if(user_pass==""){
		$('#err').text("密码不能为空");
		return false;
	}
	$.post("/"+proName()+"/UserInfo/loginUser",{"user_code":user_code,"user_pass":user_pass},function(data){
	  	if(data.code=="error"||data.code=="stop"){
	  	     var mes=data.code=="error"?"您的账号或者密码错误":"您的账号已停用，请联系管理员启用"
	   		$("#err").text(mes);	
	   	}
	  	if(data.code=="mobile_err"){
	  	   var mes="您的手机号输入有误";
		   $("#err").text(mes);
	  	}
	   	if(data.code=="sucess"){
	   	    $("#login-button").text("登录成功，正在进入..");
	   		window.location.href = "/"+proName()+"/Index/index";
	   	}
	});
});
