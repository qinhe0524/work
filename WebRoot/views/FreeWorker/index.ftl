<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">

<title>会来活xx</title>
<body class="gray-bg">
<div class="contents">
	<div class="header text-center">
	     <div class="search_div">
			 <div class="input-group">
			      <input type="text" class="form-control" placeholder="海量任务任你搜"> 
			      <span class="input-group-btn"><button type="button" class="btn btn-white btn-xs">搜索</button> </span>
			 </div>
		 </div>
		 <div class="head_img_con">
			 <div class="head_img"></div>
		 </div>
	</div>
	<div class="task_type">
		<div class="col-xs-12">
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=2"><div class="task_btn shangmao"></div><span>商贸服务</span></a></div>
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=5"><div class="task_btn zimeiti"></div><span>自媒体</span></a></div>
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=3"><div class="task_btn bendishenghuo"></div><span>本地生活</span></a></div>
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=6"><div class="task_btn cangchuwuliu"></div><span>仓储物流</span></a></div>
		</div>
		<div class="col-xs-12">
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=1"><div class="task_btn hulianwang"></div><span>互联网</span></a></div>
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=0"><div class="task_btn guanggao"></div><span>广告文化</span></a></div>
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=7"><div class="task_btn jiazhengfuwu"></div><span>家政服务</span></a></div>
			<div class="col-xs-3"><a href="/partwechat/Task/list?task_type=4"><div class="task_btn qita"></div><span>其它行业</span></a></div>
		</div>
	</div>
	<div class="col-xs-12 m-t-md">
	<h5>为您推荐</h5>
	</div>
	<#assign tskt=getCache("task_type")>
	<div class="task_list col-xs-12">
		<#list taskList as list>
		<div class="task_li">
		<a href="/partwechat/Task/add?task_no=${(list.task_no)!}">
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

