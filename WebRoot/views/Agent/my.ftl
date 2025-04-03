<#include "/common/include.ftl">
<style>
.agent_top_span{
	color:#cccccc;
	font-size:9pt;
	display:block;
	margin-top:-5px;
	line-height:10px;

}
.agent_top_num{
	color:#989898;;
	font-size:15pt;
	font-weight:700;
	display:block;
	margin-top:8px;
}
</style>
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">
    <title>代理中心</title>
<body class="gray-bg">
<div class="shouru_topbg">
	<div class="shouru_top-txdv boder-yinyin">		
			<div style="float:center;margin-top:-40px;">
			<img alt="image" class="img-circle" src="${(fw.wechat_head_img)!}" style="width:70px;height:70px;margin-bottom:3px;,">
			</div>	
			<div>
			<div class="col-xs-6"><span class="agent_top_span">昨日交易</span><span class="agent_top_num">${(yesterDayAmt)!0}</span></div>
			<div class="col-xs-3" style="padding-left:20px;padding-right:0px;"><span class="agent_top_span">客户</span><span class="agent_top_num">${(ct.client_num)!0}</span></div>
			<div class="col-xs-3"  style="padding-left:0px"><span class="agent_top_span">代理</span><span class="agent_top_num">${(ct.agent_num)!0}</span></div>
			</div>
	</div>
</div>
<div class="user_div" style="margin-top:40px">
		<div  class="boder-yinyin distribution"  >
			<div class="userinfo_li">
				<a href="my_info" > 
					<div class="funbtnitme" style="width:70%;white-space:nowrap;text-overflow:ellipsis;word-break:break-all;overflow:hidden;padding-right:0px;">
						<img src="/partwechat/public/viewimg/agent/company.jpg" mode="aspectFit"  style="vertical-align:middle">
						<span >${(a.agent_name)!}</span>
					</div>
					<div class="funbtnitme-r" style="width:25%;">
						<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
					</div>
				</a>
			</div>
		</div>
	
	<div  class="margin-tb-sm flex  boder-yinyin distribution">
		
			<div class="userinfo_li">
				<a href="my_trade"> 
				<div class="funbtnitme">
					<img src="/partwechat/public/viewimg/agent/trade.jpg" mode="aspectFit"  style="vertical-align:middle">
					<span  style="font-size: 20rpx;">交易查询</span>
				</div>
				<div class="funbtnitme-r" >
					<span  style="font-size: 20rpx;color:#cccccc"></span>
					<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
				</div>
			   </a>
			</div>
		<div class="user_line"></div>
			<div class="userinfo_li">
			<a href="my_client"> 
				<div class="funbtnitme">
					<img src="/partwechat/public/viewimg/agent/touxiang.jpg" mode="aspectFit"  style="vertical-align:middle">
					<span  style="font-size: 20rpx;">签约客户</span>
				</div>
				<div class="funbtnitme-r" >
					<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
				</div>
			</a>
			</div>
		
	</div>
	
	
	<div  class="margin-tb-sm flex  boder-yinyin distribution">
		<div class="userinfo_li">
		   <a href="my_agent"> 
			<div class="funbtnitme">
				<img src="/partwechat/public/viewimg/agent/tuan.jpg" mode="aspectFit"  style="vertical-align:middle">
				<span  style="font-size: 20rpx;" >合作伙伴</span>
			</div>
			<div class="funbtnitme-r" >
				<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
			</div>
			</a>
		</div>
		<div class="user_line"></div>
		<div class="userinfo_li" onclick="layer.msg('《帮助&政策》该功能开发中..即将上线');">
			<div class="funbtnitme">
				<img src="/partwechat/public/viewimg/agent/wendang.jpg" mode="aspectFit"  style="vertical-align:middle">
				<span  style="font-size: 20rpx;">帮助&政策</span>
			</div>
			<div class="funbtnitme-r" >
				<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
			</div>
		</div>
	</div>
</div>

<#include "/common/footer.ftl">
</body>