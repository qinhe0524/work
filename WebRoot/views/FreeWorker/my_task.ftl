<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">

<title>灵工任务</title>
<body class="gray-bg">
<div class="contents">
	<div class="bottom_reads boder-yinyin navbar-fixed-top" >
		<div class="col-xs-12  span_title" >
	          <div class="col-xs-1" style="margin-left:0px;"><a  onClick="javascript :history.back(-1);" class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
	          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-10px;">接单中心</span></div>     
	     </div>
	</div>
	<div class="task_head text-center" style="padding-top:3px;padding-bottom:3px;margin-top:35px;">
		 <div class="task_status">
		 	<span class="col-xs-3 task_status_span_active"><a href="" class="">全部</a></span>
			<span class="col-xs-2 task_status_span"><a href="">待确认</a></span>
			<span class="col-xs-2 task_status_span"><a href="">服务中</a></span>
			<span class="col-xs-2 task_status_span"><a href="">已完成</a></span>
			<span class="col-xs-3 task_status_span"><a href="">已结算</a></span>
		 </div>
	</div>
	<#assign tos=getCache("task_order_status")>
	<div class="task_list col-xs-12">
	    <#list taskList as list>
		<div class="task_li">
	        <span class="task_block">${(list.task_name)}(${(tos["${list.task_order_status}"])!})</span> 
	        <div class="task_info text-limited">${(list.task_rim)!}</div>
	        <div class="task_li_hr"></div>
	        <div class="task_li_bot">
		        <span class="col-xs-5 text-left"><i class="fa fa-map-marker"></i>&nbsp;&nbsp; ${(list.task_province)!}. ${(list.task_city)!}</span>
		        <span class="col-xs-4 text-left"><i class="fa fa-calendar"></i>&nbsp;&nbsp;${(list.start_date)!}</span>
		        <span class="money_right">￥${(list.order_amt)!}</span>
	        </div>
	    </div>
	   </#list>
	   
	    <div  style="margin-bottom:68px"></div>
   </div>
</div>


