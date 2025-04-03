<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">

<title>交易查询</title>
<body class="gray-bg">
<div class="contents">
	<div class="navbar-fixed-top">
	<div class="bottom_reads boder-yinyin" >
		<div class="col-xs-12  span_title" >
	          <div class="col-xs-1" style="margin-left:0px;"><a  onClick="window.location.href='my'" class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
	          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-5px;">交易查询</span></div>     
	     </div>
	</div>
	<div class="task_head text-center" style="padding-top:2px;padding-bottom:2px;margin-top:0px;">
		 <div class="task_status">
		 	<span class="col-xs-4 <#if type=="0">task_status_span_active<#else>task_status_span</#if>"><a href="my_trade?type=0" class="">全部</a></span>
			<span class="col-xs-4 <#if type=="1">task_status_span_active<#else>task_status_span</#if>"><a href="my_trade?type=1">按客户汇总</a></span>
			<span class="col-xs-4 <#if type=="2">task_status_span_active<#else>task_status_span</#if>"><a href="my_trade?type=2">按代理汇总</a></span>
		 </div>
	</div>
   </div>
	<div class="task_list col-xs-12" style="margin-top:80px;">
	     <#if type=="0">
	        <#list dataList as list>
			<div class="task_li" style="height:50px">
		         <div class="col-xs-6" style="font-size:13pt;padding-left:0px;line-height:40px"><span>${(list.add_date)!}</span><span style="float:right;font-size:9pt">${(list.nums)!}笔</span></div>
		         <div class="col-xs-6 text-right" style="font-size:20pt;font-weight:700;">${(list.order_amt)!}</div>
		    </div>
		    </#list>
	    </#if>
	     <#if type=="1">
	     <#list dataList as list>
			<div class="task_li" style="height:60px">
		         <div class="col-xs-7" style="font-size:15pt;padding-left:0px;padding-right:5px;line-height:20px;margin-top:5px;">
		         	<span style="font-size:12pt;font-weight:500;display:block">${(list.client_short_name)!}</span>
		         	<span style="font-size:10pt;font-weight:500;">${(list.add_date)!}</span><span style="font-size:10pt;font-weight:500;float:right">${(list.nums)!}笔</span>
		         </div>
		         
		         <div class="col-xs-5 text-right" style="font-size:20pt;font-weight:700;padding-left:3px;padding-left:5px;line-height:50px;float:right">${(list.order_amt)!}</div>
		    </div>
		 </#list>
	    </#if>
	     <#if type=="2">
	     <#list dataList as list>
			<div class="task_li" style="height:60px">
		         <div class="col-xs-7" style="font-size:15pt;padding-left:0px;padding-right:5px;line-height:20px;margin-top:5px;">
		         	<span style="font-size:12pt;font-weight:500;display:block">${(list.short_name)!}</span>
		         	<span style="font-size:10pt;font-weight:500;">${(list.add_date)!}</span><span style="font-size:10pt;font-weight:500;float:right">${(list.nums)!}笔</span>
		         </div>
		         
		         <div class="col-xs-5 text-right" style="font-size:20pt;font-weight:700;padding-left:3px;padding-left:5px;line-height:50px;float:right">${(list.order_amt)!}</div>
		    </div>
		 </#list>
	    </#if>
	    <div  style="margin-bottom:68px"></div>
   </div>
</div>


