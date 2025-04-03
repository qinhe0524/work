<#include "/common/include.ftl">
<#include "/common/include_citypicker.ftl">

    <title>新增代理成员</title>
<style>
.city-select-wrap{
	margin-left:-50px;
	width:90%;
}
.control-label{
	margin-top:8px;
	text-align:right;
	font-weight:300;
}
.col-xs-1,.col-xs-2,.col-xs-3,.col-xs-4,.col-xs-5,.col-xs-6,.col-xs-7,.col-xs-8,.col-xs-9,.col-xs-10{
	padding-left:0px;
}
.bottom_reads{
	   background-color:white;
	    height:35px;
	    text-align:center;
	}
	.boder-yinyin {
		-moz-box-shadow: 0 0 10px #c6c3e7;
		-webkit-box-shadow: 0 0 10px #c6c3e7;
		box-shadow: 0 0 10px #c6c3e7;
	}
</style>
<script>
function iscompany_change(th){
   		var vl=$(th).val();
   		if(vl==0){
   			$(".div_agent_iscompany").hide();
   		    $("[name='company_name']").removeClass("required");
   		    $("[name='com_blis_no']").removeClass("required");
   		}else{
   			$(".div_agent_iscompany").show();
   			$("[name='company_name']").addClass("required");
   			$("[name='com_blis_no']").addClass("required");
   		}
}
function getMobile(){
    	var mobile=$("#worker_mobile").val();
	    var regmobile =/((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\d{8}$/;
	    if (!regmobile.test(mobile) || !mobile.length==11){
	    	layer.msg("请正确填写您的手机号");
	    	return false;
	    }
	    var url='${base}/Agent/getFreeMobile?mobile='+mobile;
		$.ajax({
			type:'GET',
			url:url,
			data:{},			
			dataType:'json',
			cache: false,
			success:function(json){
				if(json.statusCode==200){
					$("#worker_name").val(json.message);
				}else{
					layer.msg(json.message)
				}
			},
			error:function(){
				layer.msg("获取手机号请求出错<br>请稍后重试或联系运营方");
			}
		});
}
</script>
	<form method="post" action="save" class="form-horizontal required-validate" id="regform" onsubmit="return addAgentCallback(this);">
		<div class="ibox-content" >
				<div class="form-group">
					<label class="col-xs-3 control-label">代理名称</label>
					<div class="col-xs-7">
						<input type="text" class="form-control required" name="agent_name"/>
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-xs-3 control-label">代理简称</label>
					<div class="col-xs-7">
						<input type="text" class="form-control required" name="short_name"/>
				    </div>
				</div>
			   <div class="hr-line-dashed"></div>
				<div class="form-group">
					<label class="col-xs-3 control-label">业务手机</label>
					<div class="col-xs-9">
						<div class="input-group">
                                        <input type="text" name="con_mobile" id="worker_mobile" class="form-control" placeholder="必须先注册为自由职业者"> <span class="input-group-btn"> <button type="button" class="btn btn-primary" onclick="getMobile(this)">查询
                                        </button> </span>
                          </div>
				    </div>
				    			
				</div>
				
				<div class="form-group">
					<label class="col-xs-3 control-label">联系人</label>
					<div class="col-xs-7">
						<input class="required form-control " type="text" name="contact_name" id="worker_name" placeholder="输入手机号查询获得" readonly="true" />
				    </div>
				</div>
					<div class="hr-line-dashed"></div>
				<#assign trade_type=getCache("trade_type")>
				<div class="form-group">
				    <label class="col-xs-3 control-label">所在区域</label>
					<div class="col-xs-9">
						<input  name="areas" class="form-control required" readonly type="text"  data-toggle="city-picker" city_level="city" city_placeholder="请选择您所在的省/市">
				    </div>
				</div>
			
				<div class="form-group">
				    <label class="col-xs-3 control-label">资源行业</label>
					<div class="col-xs-9">
							 <select class="select2 form-control required" name="trade_type" multiple="multiple">
						        <#list trade_type?keys as key>
						        	<option value="${key}">${trade_type[key]}</option>
						        </#list>
						     </select>
				    </div>
				</div>
				<input type="hidden" value="cps_type" value="0">
				<div class="form-group">
				  <label class="col-xs-3 control-label">结算点</label>
					<div class="col-xs-5">
						<input type="text" class="form-control number required" name="cps_num" id="cps_num" placeholder="格式如:0.085"/>
						<input type="hidden" class="" name="parent_cps_num" id="parent_cps_num" value="${(a.cps_num)}">
				    </div>
				</div>
	            <div class="hr-line-dashed"></div>
	            <#assign iscompany=getCache("iscompany")>
	            <div class="form-group">
				  <label class="col-xs-3 control-label">代理性质</label>
					<div class="col-xs-9">
						 <select class="form-control" name="iscompany" id="agent_iscompany" selectvl="0" selectvl_event="true" onchange="iscompany_change(this);">
						        <#list iscompany?keys as key>
						        	<option value="${key}">${iscompany[key]}</option>
						        </#list>
						 </select>
				    </div>
				</div>
				<div  class="div_agent_iscompany" style="display:none">
						<div class="form-group">
							<label class="col-xs-3 control-label">企业全称</label>
					        <div class="col-xs-9">
								<input class="form-control" type="text" name="company_name"/>
						    </div>
						 
					   </div>
						<div class="form-group">
						    <label class="col-xs-3 control-label">营业执照号</label>
						        <div class="col-xs-8">
									<input class="form-control" type="text" name="com_blis_no"/>
							    </div>
					    </div>
				</div>

		</div>
	
		  <br>
		  <br>
		  <br>

		 <div class="task_status navbar-fixed-bottom bottom_reads boder-yinyin" style="height:50px;padding-top:5px;padding-bottom:10px;margin-top:0px;padding-left:10px;padding-right:10px">
		  
		 	    <button type="submit" class="btn btn-primary btn-block" style="margin-top:3px;" id="submit_reg">
					添加团队新成员
				</button>
		 </div>
	</form>

