<#include "/common/include.ftl">
<#include "/common/include_citypicker.ftl">
    <title>会来活用户注册</title>
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
</style>
	<form method="post" action="/partwechat/FreeWorker/save" class="form-horizontal required-validate" id="regform" onsubmit="return validateCallback(this);">
		<div class="ibox-content" >
				<div class="form-group">
					<label class="col-xs-3 control-label">真实姓名</label>
					<div class="col-xs-7">
						<input class="required form-control" type="text" name="worker_name" value="${(cardinfo.worker_name)!}" readonly="true"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">手机号</label>
					<div class="col-xs-7">
						<input class="required form-control " type="text" name="worker_mobile" id="worker_mobile" value="${mobile}" readonly="true"/>
				    </div>
				</div>
				<div class="hr-line-dashed"></div>
				<div class="form-group">
				    <label class="col-xs-3 control-label">身份证号</label>
					<div class="col-xs-7">
						<input class="required form-control" type="text" name="worker_cardno" id="cardno" value="${(cardinfo.worker_cardno)!}" readonly="true"/>
				    </div>
				</div>
				<div class="form-group">
				    <label class="col-xs-3 control-label">证件有效期</label>
					<div class="col-xs-7">
						<input class="required form-control" type="text" name="worker_carddate" id="cardno" value="${(cardinfo.worker_carddate)!}" readonly="true"/>
				    </div>
				</div>
				
				<div class="hr-line-dashed"></div>
				<div class="form-group">
				    <label class="col-xs-3 control-label">所在地区</label>
					<div class="col-xs-9">
						<input  name="areas" class="form-control required" readonly type="text"  data-toggle="city-picker" city_level="city" city_placeholder="请选择您所在的省/市">
				    </div>
				</div>
				<div class="hr-line-dashed"></div>
				<div class="form-group">
				    <label class="col-xs-3 control-label">开户银行</label>
					<div class="col-xs-7">
						<input class="required form-control" type="text" name="worker_bank_name" value=""/>
				    </div>
				</div>
				<div class="form-group">
				  <label class="col-xs-3 control-label">银行卡号</label>
					<div class="col-xs-9">
						<input class="required form-control" type="text" name="worker_bank_num" value=""/>
				    </div>
				</div>
				
				

		</div>
		<div class="form-group">
			<div class="col-xs-10 col-xs-offset-1" style="padding-left:20px">
				<button type="submit" class="btn btn-primary btn-block" id="submit_reg">
					注册会来活用户
				</button>
			</div>
		</div>
	</form>

<script type="text/javascript">
	$(function(){
		//表单去空格
		$("input").bind('blur keyup',function(){
			$(this).val($(this).val().replace(/\s*/g,''))
		})
	})
</script>