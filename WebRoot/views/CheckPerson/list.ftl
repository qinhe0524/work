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
				<th data-sortable="true" data-field="ck_channel">渠道编号</th>
				<th data-sortable="true" data-field="ck_cardno">身份证号</th>
				<th data-sortable="true" data-field="ck_mobile">手机号</th>
				<th data-sortable="true" data-field="ck_name">姓名</th>
				<th data-sortable="true" data-field="ck_rtcode">通道返回的状态</th>
				<th data-sortable="true" data-field="add_date">日期</th>
				<th data-sortable="true" data-field="ck_bankcard">银行卡号</th>
				<th data-sortable="true" data-field="ck_result">是否成功</th>
				<th data-sortable="true" data-field="add_time">时间</th>
				<th data-sortable="true" data-field="ck_ip">上送的IP</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td >{ID}</td>
					<td >{CK_CHANNEL}</td>
					<td >{CK_CARDNO}</td>
					<td >{CK_MOBILE}</td>
					<td >{CK_NAME}</td>
					<td >{CK_RTCODE}</td>
					<td >{ADD_DATE}</td>
					<td >{CK_BANKCARD}</td>
					<td >{CK_RESULT}</td>
					<td >{ADD_TIME}</td>
					<td >{CK_IP}</td>
				</tr>
		</tbody>
	</table>
</div>
</body>
<script src="/partwork/public/js/plugins/bootstrap-table/init-table-css.js"></script>

