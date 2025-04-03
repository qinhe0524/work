<#include "/common/include.ftl">
    <title>会来活用户注册&登陆</title>
<style>
#fieldset{
   background: rgba(255,255,255,.3);  
    border-color: rgba(239, 223, 223, 0.6);  
    border-style: solid;  
    border-width: 1px;  
    -moz-border-radius: 5px;  
    -webkit-border-radius: 5px;  
    -khtml-border-radius: 5px;  
    border-radius: 5px;  
    line-height: 30px;  
    list-style: none;  
    padding: 5px 10px;  
    margin-bottom: 2px;  

}
body{
	overflow-x:hidden;
	width:100%;
}
</style>
	<form method="post" action="/partwechat/FreeWorker/checkMobileCode" class="form-horizontal required-validate" id="regform" onsubmit="return checkMobileNum(this);">
		<div class="ibox-content" style="overflow-x:hidden;">
		<div class="form-group">
			<div class="col-xs-12" style="text-align:center;margin-top:20px;margin-bottom:20px">
				<img src="/partwechat/public/imgs/logo_s.png" style="width:100px">
			</div>
		</div>
		<fieldset id="fieldset" style="width:100%;height:100%;padding-left:25px">
				<div class="form-group" style="margin-top:15px;">
					<label class="col-xs-3 control-label" style="text-align:center;">手机号</label>
					<div class="col-xs-8">
						<input class="form-control " type="text" name="worker_mobile" id="worker_mobile" value=""/>
				    </div>
				</div>
				<div class="form-group" id="smscode_div">
					 <label class="col-xs-3 control-label" style="text-align:center;">验证码</label>
					 <div  class="col-xs-8">
						 <div class="input-group">
		                       <input type="text" class="form-control" name="smscode" id="smscode"> 
		                       <span class="input-group-btn"> 
		                       <button type="button" class="btn btn-warning" id="codebt" onclick="getMobileCode(this);" style="width:95px" href="/partwechat/FreeWorker/getMobileCode/">获取验证码 </button>
		                       </span>
		                  </div>
	                 </div>
                </div>
         </fieldset>
		</div>
		<div class="form-group">
			<div  style="width:100%;margin-top:20px;">
				<button type="submit" style="width:90%;margin-left:5%" class="btn btn-info btn-block" id="submit_reg">
					注册&登陆
				</button>
			</div>
		</div>
		<div class="col-sm-8 col-sm-offset-3"style="margin-left:5%">
			<div class="checkbox">
				<label>
					<input type="checkbox" class="checkbox" id="agree" name="agree" >
					我已阅读并同意<a href="/partwechat/FreeWorker/service_agreement/">《自由职业者服务协议》</a><a href="/partwechat/FreeWorker/privacy_agreement/">《隐私协议》</a>
				</label>
			</div>
		<div class="col-xs-12" style="text-align:center;color:#cccccc;">
		    <span>赣ICP备2022006767号</span>
		</div>
	</form>

