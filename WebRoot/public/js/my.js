$(function(){
	$(".date").each(function(){
		 $(this).datepicker({
			 language: "zh-CN",
	         autoclose: true
		 });
	});
	//解决table 错位问题
	$(window).resize(function () {
        $('#table').bootstrapTable('resetView');
    });

	$(document).on("click",".openWin",function(){
		window.parent.clickOpenWin($(this));
	})
     $('.i-checks').iCheck({
         checkboxClass: 'icheckbox_square-green',
         radioClass: 'iradio_square-green',
     });
    //下拉列表框选中
    $("select[selectvl]").each(function(){
        var selectvl=$(this).attr("selectvl");
        if($(this).is('[multiple]')){
        	$(this).val((selectvl.split(",")));
        }else{
        	$(this).val(selectvl);
        }
        if($(this).attr("selectvl_event")){   //如果需要触发选中事件。
            $(this).change();
        }
    });
	$(".select2").select2();

    $(document).on("click",".ajaxToDo",function(){
    	window.parent.ajaxToDo($(this));
     })
     
     $("[ptip]").each(function(){
         $this=$(this);
         var tip=$this.attr("ptip");
         var op = {
             content:tip,
             fade:true          
         };
         
         if($this.attr("type")=="text"){
             op["showon"]="focus";
         }
         var upAttrs = ["className","showOn","alignTo","alignX","alignY","offsetX","offsetY"];
         $(upAttrs).each(function(i){
             var true_op="ptip_"+upAttrs[i];//tip_showOn....都加上tip以免和别的冲突
             var op_name=upAttrs[i];
             if($this.attr(true_op)){
                 op[op_name]=$this.attr(true_op);
             }
         });
         $this.poshytip(op);
     });
})
var i=0
function after(){
    $("#codebt").empty().append(i+"秒");
    i=i-1;
    if(i>0){
	    setTimeout(function(){
	        after();
	    },1000);
    }else{
    	 $("#codebt").empty().append("获取验证码");
    	 $("#codebt").removeAttr("disabled");
    }
}
function getMobileCode(th){

	var mobile=$("#worker_mobile").val();
    var regmobile =/((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\d{8}$/;
    if (!regmobile.test(mobile) || !mobile.length==11){
    	layer.msg("请正确填写您的手机号");
    	return false;
    }

	$this=$(th);
	var href=$this.attr("href");
	
	href=href+"?mobile="+mobile;
	$this.attr("disabled",true);
	$.ajax({
		type:"GET",
		url:href,
		data:{},			
		dataType:"json",
		cache: false,
		success:function(json){
			if(json.statusCode==200){
				message=json.message||'操作成功';
				layer.msg(message);
				i=60;
				after();
			}else{
				message=json.message||'操作失败';
				layer.msg(message);
				$this.removeAttr("disabled");
			}
		},
		error:function(){
			$this.removeAttr("disabled");
			layer.msg("发送短信错误");
		}
	});
	
}

function checkMobileNum(form){
	var $form = $(form);
	var mobile=$("#worker_mobile").val();
	var smscode=$("#smscode").val();
	var agree=$("#agree").is(':checked');

	var regsms=/\d{6}/;
	var regmobile =/((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\d{8}$/;
    if (!regmobile.test(mobile) || !mobile.length==11){
    	layer.msg("请正确填写您的手机号");
    	return false;
    }
    if (!regsms.test(smscode) || !smscode.length==6){
    	layer.msg("请正确填写您的验证码");
    	return false;
    }
	if(!agree){
		layer.msg("必须同意协议后才能登录");
		return false;
	}
    var _submitFns = function(){
		$.ajax({
			type:$form.attr("method")|| 'POST',
			url:$form.attr("action"),
			data:$form.serializeArray(),			
			dataType:"json",
			cache: false,
			success:function(json){
				if(json.statusCode==200){
					if(json.freeworker=='1'){
						window.location.href='/partwechat/FreeWorker/my';
					}else{
						window.location.href='/partwechat/FreeWorker/reg';
					}
					
					message=json.message||'操作成功';
					layer.msg(message);	
				}else{
					message=json.message||'操作失败';
					layer.msg(message);		
				}
				
				
			},
			error:function(){
				layer.msg("请关注后再登陆，关注后失败请联系管理员");
			}
		});
	}
	_submitFns();
	return false;
}

/**
 * 普通ajax表单提交
 * @param {Object} form
 * @param {Object} callback
 * @param {String} confirmMsg 提示确认信息
 */
function validateCallback(form) {
	var $form = $(form);
	if (!$form.valid()) {
		return false;
	}
	var cardno=$("#cardno").val();
	var regcard=/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)/;
	
    if (!regcard.test(cardno) || (!cardno.length==15&&!cardno.length==18)){
    	layer.msg("请正确填写您身份证号");
    	return false;
    }
	var _submitFn = function(){
		$("#submit_reg").attr("disabled",true);
		$.ajax({
			type:$form.attr("method")|| 'POST',
			url:$form.attr("action"),
			data:$form.serializeArray(),			
			dataType:"json",
			cache: false,
			success:function(json){
				if(json.statusCode==200){
					message=json.message||'操作成功';
					$("#submit_reg").text(message);
					layer.msg(message);	
					setTimeout(function () {
						window.location.href='/partwechat/FreeWorker/my';
					}, 2000);
				}else{
					message=json.message||'操作失败';
					setTimeout(function(){
						$("#submit_reg").attr("disabled",false);
					},3000);
					layer.msg(message);
				}
			},
			error:function(){
				layer.msg("请求失败，请联系管理员");
			}
		});
	}
	
	_submitFn();
	return false;
}
function addAgentCallback(form) {
	var $form = $(form);
	if (!$form.valid()) {
		return false;
	}
	var parent_cps_num=$("#parent_cps_num").val();
	var cps_num=$("#cps_num").val();
	if(parent_cps_num>cps_num){
		layer.msg("下级代理结算点，不能低于你结算点");
		return false;
	}
	var _submitFn = function(){
		$("#submit_reg").attr("disabled",true);
		$.ajax({
			type:$form.attr("method")|| 'POST',
			url:$form.attr("action"),
			data:$form.serializeArray(),			
			dataType:"json",
			cache: false,
			success:function(json){
				if(json.statusCode==200){
					message=json.message||'操作成功';
					$("#submit_reg").text(message);
					layer.msg(message);	
					setTimeout(function () {
						window.location.href='/partwechat/Agent/my';
					}, 2000);
				}else{
					message=json.message||'操作失败';
					$("#submit_reg").attr("disabled",false);
				}
					
				
			},
			error:function(){
				$("#submit_reg").attr("disabled",false);
				layer.msg("请求失败，请联系管理员");
			}
		});
	}
	
	_submitFn();
	return false;
}


function check_add_idcard(form){
	var $form = $(form);
	if(!fs0){
		layer.msg("请上传清晰正确的【身份证-正面】");
		return false;
	}
	if(!fs1){
		layer.msg("请上传清晰正确的【身份证-反面】");
		return false;
	}
	var name=$("#name").val();
	var idcard_end_date=$("#idcard_end_date").val();
	var idcard=$("#idcard_end_date").val();
	if(name==""||idcard_end_date==""||idcard==""){
		layer.msg("姓名、身份证、有效期信息不能为空.<br>请上传本人身份证正反面进行信息识别");
		return false;
	}
	var _submitFns = function(){
		$.ajax({
			type:$form.attr("method")|| 'POST',
			url:$form.attr("action"),
			data:$form.serializeArray(),			
			dataType:"json",
			cache: false,
			success:function(json){
				if(json.statusCode==200){
					if(json.fw==0){
						window.location.href='/partwechat/FreeWorker/add';
					}else{
						window.location.href='/partwechat/FreeWorker/my';
					}
					
				}else{
					message=json.message||'操作失败';
					layer.msg(message);		
				}
			},
			error:function(){
				layer.msg("请求失败，请联系管理员");
			}
		});
	}
	_submitFns();
	return false;
}