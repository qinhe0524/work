<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">

<title>合作伙伴</title>
<body class="gray-bg">
<div class="contents">
	<div class="navbar-fixed-top">
	<div class="bottom_reads boder-yinyin" >
		<div class="col-xs-12  span_title" >
	          <div class="col-xs-1" style="margin-left:0px;"><a  onClick="window.location.href='my'" class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
	          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-5px;">合作伙伴</span></div>     
	     </div>
	</div>
	
   </div>
	<div class="task_list col-xs-12" style="margin-top:40px;">
	         <#list agentList as list>
			<div class="task_li" style="height:80px;padding-left:0px;padding-right:0px">
				 <div class="col-xs-3">
				 	<div style="text-align:center;width:100%;padding-left:0px;margin-top:5px">
				    <img alt="image" class="img-circle" src="${(list.wechat_head_img)!}" onerror="this.src='/partwechat/public/viewimg/agent/touxiang.jpg'" style="width:50px;height:50px;margin-bottom:3px;,">
				    <div style="font-size:7pt;white-space:nowrap;text-overflow:ellipsis;word-break:break-all;overflow:hidden;">${(list.wechat_nickname)!'未登陆'}</div>
				    </div>
				 </div>
		         <div class="col-xs-8" style="font-size:15pt;padding-left:0px;padding-right:5px">
		         	<div style="font-size:12pt;font-weight:700;white-space:nowrap;text-overflow:ellipsis;word-break:break-all;overflow:hidden;">${(list.agent_name)!}</div>
		         	 <div style="font-size:9pt;">
		         	 <span style="color:#ccc">结算点:</span><span class="money_right" style="float:none;margin-left:10px">${(list.cps_num)!}</span>
		         	 <span style="float:right"><span style="color:#ccc;">商户数:</span><span class="money_right" style="float:none;margin-left:10px">${(list.client_nums)!0}</span>
		         	 </span>
		         	 </div>
				     <div class="task_li_hr"></div>
			        <div class="task_li_bot">
				        <span class="col-xs-6 text-left" style="padding-right:0px"><i class="fa fa-map-marker"></i> ${(list.province)!}. ${(list.city)!}</span>
				        <span class="col-xs-6 text-left"><i class="fa fa-calendar"></i>${(list.addtime)?substring(0,10)}</span>
				       
			        </div>
		         </div>
		    </div>
		    </#list>
	   
	    <div  style="margin-bottom:68px"></div>

		 <div class="task_status navbar-fixed-bottom bottom_reads boder-yinyin" style="height:50px;padding-top:5px;padding-bottom:10px;margin-top:0px;padding-left:10px;padding-right:10px">
		  
		 	    <button type="button" class="btn btn-primary btn-block" style="margin-top:3px;" onclick="document.location.href='my_add'">
					添加新合作伙伴
				</button>
		 </div>
   </div>
</div>


