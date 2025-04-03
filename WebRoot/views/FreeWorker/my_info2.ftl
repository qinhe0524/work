<#include "/common/include.ftl">
<#include "/common/include_citypicker.ftl">
    <title>个人中心-基本资料</title>
<style>
.bottom_reads{
	background-color:white;
    box-shadow:0px 1px 2px 3px rgba(0,0,0,.5);
    height:50px; 
}
.span_title{
	padding-right:10px;
	display:inline-block;
	width:80px;
	color:#cccccc;
}
</style>
<div class="ibox-content bottom_reads" style="background-color:#eeffff">
		<div class="col-xs-12">
             <div class="col-xs-3" style="margin-left:0px"><a href="my" class="btn btn-white" style="margin-left:-30px;margin-top:-7px"><i class="fa fa-chevron-left"></i>返回</a></div>  
             <div class="col-xs-8 text-center"><span style="font-size:12pt;line-height:20px;margin-left:-30px;">基本资料</span></div>     
        </div>
</div>
<div class="ibox-content" style="margin-top:20px;margin-left:10px;border:none">
 <div class="list-group col-xs-12">
        <a class="list-group-item" href="#"  style="background-color:#eeffff">
            <h3 class="list-group-item-heading"><span class="span_title">灵工编号</span><span>${(fw.worker_no)!}</span></h3>
        </a>
        <a class="list-group-item" href="#">
            <h3 class="list-group-item-heading"><span class="span_title">姓名</span><span>${(fw.worker_name)!}</span></h3>
        </a>
        <a class="list-group-item " href="#" style="background-color:#eeffff">
            <h3 class="list-group-item-heading"><span class="span_title">身份证 </span><span>${(fw.worker_cardno)!} </span></h3>
        </a>
        
        <a class="list-group-item " href="#">
            <h3 class="list-group-item-heading"><span class="span_title">手机号 </span><span>${(fw.worker_mobile)!} </span></h3>
        </a>
        <a class="list-group-item" href="#"  style="background-color:#eeffff">
            <h3 class="list-group-item-heading"><span class="span_title">开户行</span><span>${(fw.worker_bank_name)!}</span></h3>
        </a>

        <a class="list-group-item " href="#">
            <h3 class="list-group-item-heading"><span class="span_title">银行卡号 </span><span>${(fw.worker_bank_num)!} </span></h3>
        </a>
        <a class="list-group-item" href="#"  style="background-color:#eeffff">
            <h3 class="list-group-item-heading"><span class="span_title">所在地区</span><span>${(fw.worker_province)!}.${(fw.worker_city)!}</span></h3>
        </a>
        <a class="list-group-item " href="#">
            <h3 class="list-group-item-heading"><span class="span_title">注册日期</span><span>${(fw.worker_regedit_date)!} </span></h3>
        </a>
   </div>
</div>


