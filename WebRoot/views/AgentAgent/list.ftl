<#include "/common/include.ftl">
<body class="gray-bg">
<div class="search_panel">
	<form class="form-horizontal">
		<div class="form-group">
	    	<div class="col-sm-2">
	    		<div class="input-group m-b"><span class="input-group-addon">名称</span>
	    			<input type="text" name="agent_name"  class="form-control search_field input-small"  />
	    		</div>
	        </div>
	    	<div  class="col-sm-3">
	    		<button type="button" class="btn btn-primary btn-small" id="queryBtn">
	    			<span class="glyphicon glyphicon-search "></span>搜索
	    		</button>
	    		<button type="reset" class="btn btn-primary btn-small">
	    			<span class="glyphicon glyphicon-repeat"></span>重置
	    		</button>
	    	</div>
	    	<div  class="col-sm-3">
	    		<button type="button" class="btn btn-primary btn-small openWin" wwidth="800px" wheight="80%" whref="/partwork/?ckparam=${encryption("/Agent/add/")}" >
	    			<span class="glyphicon glyphicon-plus"></span>添加代理
	    		</button>
	    	</div>
		</div>
	</form>
</div>
<div class="ibox-content table_panel">
	<table id="table" total="0" data-url="/partwork/?ckparam=${encryption("/${action}/list_json/")}">
		<thead>
			<tr>
				<th data-sortable="true" data-field="Id"></th>
				<th data-sortable="true" data-field="parent_no">所属业务代理</th>
				<th data-sortable="true" data-field="is_direct">是否直接代理</th>
				<th data-sortable="true" data-field="agent_level">代理层级</th>
				<th data-sortable="true" data-field="agent_no">代理编号</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td >{ID}</td>
					<td >{PARENT_NO}</td>
					<td >{IS_DIRECT}</td>
					<td >{AGENT_LEVEL}</td>
					<td >{AGENT_NO}</td>
				</tr>
		</tbody>
	</table>
</div>
</body>
<script src="/partwork/public/js/plugins/bootstrap-table/init-table-css.js"></script>

