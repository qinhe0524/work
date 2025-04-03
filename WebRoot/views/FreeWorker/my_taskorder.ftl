<#include "/common/include.ftl">
<title>个人中心-基本资料</title>
<link href="/partwechat/public/css/view/index.css?v=3.3.5" rel="stylesheet">

<div class="bottom_reads" >
	<div class="col-xs-12  span_title" >
          <div class="col-xs-1" style="margin-left:0px;"><a  onClick="javascript :history.back(-1);"  class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-10px;">服务收入</span></div>     
     </div>
</div>

<div class="shouru_topbg">
	<div class="shouru_top-txdv boder-yinyin">
			<div class="padding-left " style="span-align: center;color: #989898;margin-top: 14px;font-size: 9px;">
				累计到手服务收入
			</div>
			<div class="padding-left padding-bottom-sm" style="span-align: center;margin-top: 4px;font-weight: bold;">
				<span style="padding-top: 20px;font-size: 14px;color: #272B54;width: 100px;height: 60px;color: #656565;">￥</span>
				<span style="padding-top: 20px;font-size: 33px;color: #272B54;width: 100px;height: 60px;color: #343030;">${(order_amt)!}</span>
			</div>
	</div>
</div>
<span class="mxtitle">收入明细</span>
<#list orderList as list>
<div class="shouru_distribution ">
		<div class="shouruli">
			<div class="distribution-list">
				<div class="distribution-text-bt">${(list.task_name)!}</div>
				<div class="distribution-price-hy">+<text class="detext">￥</text><text class="detext">${(list.order_amt)!}</text></div>
			</div>
			<div class="distribution-list-detial distribution-list-bottom text-cut">
				  <span class="fa fa-barcode m-r-xs"></span>  ${(list.task_order_no)!}
			</div>
			<div class="distribution-list-detial distribution-list-bottom text-cut">
				  <span class="fa fa-bank m-r-xs"></span>${(list.client_name)!}
			</div>
			<div class="distribution-list-detial distribution-list-bottom text-cut">
				 <span class="fa fa-clock-o m-r-xs"></span>${(list.add_date)!}&nbsp;&nbsp; ${(list.add_time)!}
			</div>
		</div>
	
</div>
<div class="user_line"></div>
</#list>

		
		
