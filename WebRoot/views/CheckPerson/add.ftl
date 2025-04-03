
<#include "/common/include.ftl">
		<form method="post" action="${base}/?ckparam=${encryption("/${action}/save/")}" class="form-horizontal required-validate" onsubmit="return window.parent.validateCallback(this, 'dialogAjaxDone');">
		<div class="ibox-content" id="dialog">
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="id" value="${(checkPerson.id)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">渠道编号</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_channel" value="${(checkPerson.ck_channel)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">身份证号</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_cardno" value="${(checkPerson.ck_cardno)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">手机号</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_mobile" value="${(checkPerson.ck_mobile)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">姓名</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_name" value="${(checkPerson.ck_name)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">通道返回的状态</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_rtcode" value="${(checkPerson.ck_rtcode)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">日期</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="add_date" value="${(checkPerson.add_date)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">银行卡号</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_bankcard" value="${(checkPerson.ck_bankcard)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">是否成功</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_result" value="${(checkPerson.ck_result)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">时间</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="add_time" value="${(checkPerson.add_time)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">上送的IP</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="ck_ip" value="${(checkPerson.ck_ip)!}"/>
				    </div>
				</div>
				<input type="hidden" name="id" value="${(checkPerson.id)!}">
		</div>
		<div class="form-group navbar-fixed-bottom dialog_footer">
			<div class="col-sm-8 col-sm-offset-2" >
				<button type="submit" class="btn btn-primary btn-block">
					保存信息
				</button>
			</div>
		</div>
	</form>

