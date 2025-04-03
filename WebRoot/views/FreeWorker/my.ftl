<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">
    <title>个人中心</title>
<body class="gray-bg">
<div class="topbg">
	<div class="top-txdv">
			<img alt="image" class="img-circle" src="${(fw.wechat_head_img)!}" style="width:80px;height:80px;margin-bottom:5px;">
			<div>${(fw.worker_name)!}</div>
	</div>
</div>
<div class="user_div">
		<div  class="boder-yinyin distribution"  >
			<div class="userinfo_li">
				<a href="my_info" > 
					<div class="funbtnitme">
						<img src="/partwechat/public/viewimg/user/u_gr.png" mode="aspectFit"  style="vertical-align:middle">
						<span  >个人信息</span>
					</div>
					<div class="funbtnitme-r" >
						<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
					</div>
				</a>
			</div>
		</div>
	
	<div  class="margin-tb-sm flex  boder-yinyin distribution">
		
			<div class="userinfo_li">
				<a href="my_bankcard"> 
				<div class="funbtnitme">
					<img src="/partwechat/public/viewimg/user/u_yhk.png" mode="aspectFit"  style="vertical-align:middle">
					<span  style="font-size: 20rpx;">银行卡</span>
				</div>
				<div class="funbtnitme-r" >
					<span  style="font-size: 20rpx;color:#cccccc"></span>
					<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
				</div>
			   </a>
			</div>
		<div class="user_line"></div>
			<div class="userinfo_li">
			<a href="my_taskorder"> 
				<div class="funbtnitme">
					<img src="/partwechat/public/viewimg/user/u_qb.png" mode="aspectFit"  style="vertical-align:middle">
					<span  style="font-size: 20rpx;">服务收入</span>
				</div>
				<div class="funbtnitme-r" >
					<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
				</div>
			</a>
			</div>
	</div>
	
	
	<div  class="margin-tb-sm flex  boder-yinyin distribution">
		<div class="userinfo_li">
		   <a href="my_task"> 
			<div class="funbtnitme">
				<img src="/partwechat/public/viewimg/user/u_jd.png" mode="aspectFit"  style="vertical-align:middle">
				<span  style="font-size: 20rpx;" >接单中心</span>
			</div>
			<div class="funbtnitme-r" >
				<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
			</div>
			</a>
		</div>

		<div class="user_line"></div>
		<div class="userinfo_li">
			<a href="look_reg">
				<div class="funbtnitme">
					<img src="/partwechat/public/viewimg/user/u_jdsz.png" mode="aspectFit"  style="vertical-align:middle">
					<span  style="font-size: 20rpx;" >服务协议</span>
				</div>
				<div class="funbtnitme-r" >
					<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
				</div>
			</a>
		</div>

		<div class="user_line"></div>

	</div>


	<div  class="margin-tb-sm flex  boder-yinyin distribution">
		<div class="userinfo_li">
			<div class="funbtnitme">
				<img src="/partwechat/public/viewimg/user/u_lxwm.png" mode="aspectFit"  style="vertical-align:middle">
				<span  style="font-size: 20rpx;">联系我们</span>
			</div>
			<div class="funbtnitme-r" >
				<span  style="font-size: 20rpx;color:#ccc">02227305808</span>
			</div>
		</div>
		<div class="user_line"></div>

		<#--<div class="userinfo_li">
			<a href="loginOut">

			<div class="funbtnitme">
				<img src="/partwechat/public/viewimg/user/tip_round@3x.png" mode="aspectFit"  style="vertical-align:middle">
				<span  style="font-size: 20rpx;">退出登录</span>
			</div>
			</a>
		</div>-->
		<div class="userinfo_li">
			<a href="loginOut">
			<div class="funbtnitme">
				<img src="/partwechat/public/viewimg/user/tip_round@3x.png" mode="aspectFit"  style="vertical-align:middle">
				<span  style="font-size: 20rpx;">退出登录</span>
			</div>
			<div class="funbtnitme-r" >
				<img src="/partwechat/public/viewimg/user/next.png" mode="aspectFit"  style="vertical-align:middle">
			</div>
		</a>
	</div>
</div>
</div>

<#include "/common/footer.ftl">
</body>