<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.1" rel="stylesheet">

<title>灵工任务</title>
<body class="gray-bg">
<div class="contents">
	<div class="task_head text-center navbar-fixed-top">
		<div class="search_div" style="padding-left:0px;padding-right:0px;padding-bottom:10px">
			<div class="input-group">
				<!-- 为输入框添加 id -->
				<input type="text" class="form-control" id="search-input" placeholder="海量任务任你搜">
				<span class="input-group-btn"><button type="button" class="btn btn-white btn-xs" id="search-button">搜索</button> </span>
			</div>
		</div>
	</div>
	<#assign tskt=getCache("task_type")>
	<div class="task_list col-xs-12" style="margin-top:50px">
		<#list taskList as list>
			<div class="task_li" data-task-name="${(list.task_name)!}">
				<a href="add?task_no=${(list.task_no)!}">
					<span class="task_block">${(list.task_name)}</span> <span style="float:right;font-size:8pt;margin-top:-15px;">${(tskt["${list.task_type}"])!}</span>
					<div class="task_info text-limited">${(list.task_rim)!}</div>
					<div class="task_li_hr"></div>
					<div class="task_li_bot">
						<span class="col-xs-5 text-left"><i class="fa fa-map-marker"></i>&nbsp;&nbsp; ${(list.task_province)!}. ${(list.task_city)!}</span>
						<span class="col-xs-4 text-left"><i class="fa fa-calendar"></i>&nbsp;&nbsp;${(list.start_date)!}</span>
						<span class="money_right">￥${(list.budget_amt)!}</span>
					</div>
				</a>
			</div>
		</#list>
		<div  style="margin-bottom:68px"></div>
	</div>
</div>

<#include "../common/footer.ftl">

<script>
	document.addEventListener('DOMContentLoaded', function() {
		// 获取搜索输入框和搜索按钮
		const searchInput = document.getElementById('search-input');
		const searchButton = document.getElementById('search-button');

		// 为搜索按钮添加点击事件监听器
		searchButton.addEventListener('click', function() {
			const searchTerm = searchInput.value.toLowerCase();
			const taskItems = document.querySelectorAll('.task_li');

			taskItems.forEach(function(taskItem) {
				const taskName = taskItem.getAttribute('data-task-name').toLowerCase();
				if (taskName.includes(searchTerm)) {
					taskItem.style.display = 'block';
				} else {
					taskItem.style.display = 'none';
				}
			});
		});
	});
</script>