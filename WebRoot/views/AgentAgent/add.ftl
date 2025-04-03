
<#include "/common/include.ftl">
		<form method="post" action="${base}/?ckparam=${encryption("/${action}/save/")}" class="form-horizontal required-validate" onsubmit="return window.parent.validateCallback(this, 'dialogAjaxDone');">
		<div class="ibox-content" id="dialog">
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="id" value="${(agentAgent.id)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">所属业务代理</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="parent_no" value="${(agentAgent.parent_no)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">是否直接代理</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="is_direct" value="${(agentAgent.is_direct)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">代理层级</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="agent_level" value="${(agentAgent.agent_level)!}"/>
				    </div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">代理编号</label>
	                <div class="col-sm-4">
						<input class="required form-control" type="text" name="agent_no" value="${(agentAgent.agent_no)!}"/>
				    </div>
				</div>
				<input type="hidden" name="id" value="${(agentAgent.id)!}">
		</div>
		<div class="form-group navbar-fixed-bottom dialog_footer">
			<div class="col-sm-8 col-sm-offset-2" >
				<button type="submit" class="btn btn-primary btn-block">
					保存信息
				</button>
			</div>
		</div>
	</form>

