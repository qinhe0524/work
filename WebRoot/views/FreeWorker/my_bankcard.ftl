<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.51" rel="stylesheet">
    <title>我的银行卡</title>
 <div class="bottom_reads boder-yinyin" >
		<div class="col-xs-12  span_title" >
	          <div class="col-xs-1" style="margin-left:0px;"><a  onClick="javascript :history.back(-1);" class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
	          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-10px;">我的银行卡</span></div>     
	     </div>
</div>


<span class="bank_mxtitle">默认收款卡</span>
<div  class="margin-tb-sm flex align-center bg-white-detail padding-top-xss padding-bottom-sms flex boder-yinyin bg-user-gradual-green" >
	<div class="distribution"  style="padding-left:0px;padding-right:0px;">
		<div class="bank_distribution-list-detial" >
			<div class="bank_detil flex align-center ">
				<image src="../public/viewimg/bank/dfbank.png" mode="aspectFit" style="width: 40px;height: 40px;"></image> 
				<span style="font-size: 16px;margin-left:8px;">${(fw.worker_bank_name)!}</span>
			</div>
			<div class="bank_detil-r align-left" style="margin-top:-10px;margin-left:47px;padding-bottom:0px;">
				<div class="padding-left-sm " style="font-size: 20px;font-weight: bold;">${(fw.worker_bank_num)?replace((fw.worker_bank_num?substring(6,fw.worker_bank_num?length-4)),"********")}</div>
			</div>
		</div>
	</div>
</div>



		
