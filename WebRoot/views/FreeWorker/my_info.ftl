<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">
    <title>个人中心-基本资料</title>

<div class="bottom_reads boder-yinyin navbar-fixed" >
	<div class="col-xs-12  span_title" >
          <div class="col-xs-1" style="margin-left:0px;"><a  onClick="javascript :history.back(-1);" class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-8px;">基本信息</span></div>     
     </div>
</div>

<div  class="margin-tb-sm flex boder-yinyin  distribution">
	<div class="userinfo_li" >
		<div class="funbtnitme">
			<span  style="font-size: 20rpx;">头像</span>
		</div>
		<div class="funbtnitme-r" >
			<img src="${(fw.wechat_head_img)!}" mode="aspectFit" width= "32px" height="36px" style="vertical-align:middle"></img>
		</div>
	</div>
	<div class="user_line"></div>
	<div class="userinfo_li">
		<div class="funbtnitme">
			<span  style="font-size: 20rpx;">手机号</span>
		</div>
		<div class="funbtnitme-r" >
			<span  style="font-size: 20rpx;">${(fw.worker_mobile)!}</span>
		</div>
	</div>
	<div class="user_line"></div>
		<div class="userinfo_li">
		<div class="funbtnitme">
			<span  style="font-size: 20rpx;">灵工编号</span>
		</div>
		<div class="funbtnitme-r" >
			<span  style="font-size: 20rpx;">${(fw.worker_no)!}</span>
		</div>
	</div>
	<div class="user_line"></div>
	<div class="userinfo_li">
		<div class="funbtnitme">
			<span  style="font-size: 20rpx;">姓名</span>
		</div>
		<div class="funbtnitme-r" >
			<span  style="font-size: 20rpx;">${(fw.worker_name)!}</span>
		</div>
	</div>
	<div class="user_line"></div>
	<div class="userinfo_li">
		<div class="funbtnitme" style="width:25%">
			<span  style="font-size: 20rpx;">身份证号</span>
		</div>
		<div class="funbtnitme-r" style="width:70%">
			<span  style="font-size: 20rpx;">${(fw.worker_cardno)?replace((fw.worker_cardno?substring(10,fw.worker_cardno?length-4)),"********")}</span>
		</div>
	</div>
	<div class="user_line"></div>
	<div class="userinfo_li">
		<div class="funbtnitme" style="width:25%">
			<span  style="font-size: 20rpx;">所在地区</span>
		</div>
		<div class="funbtnitme-r"  style="width:70%">
			<span  style="font-size: 20rpx;">${(fw.worker_province)!}.${(fw.worker_city)!}</span>
		</div>
	</div>
	<div class="user_line"></div>
	<div class="userinfo_li">
		<div class="funbtnitme">
			<span  style="font-size: 20rpx;">注册日期</span>
		</div>
		<div class="funbtnitme-r" >
			<span  style="font-size: 20rpx;">${(fw.worker_regedit_date)!}</span>
		</div>
	</div>
</div>

