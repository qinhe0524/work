<#include "/common/include.ftl">
<#include "/common/include_citypicker.ftl">
    <title>个人中心</title>
<style>
.bottom_read{
	background-color:white;
    box-shadow:0px 1px 2px 3px rgba(0,0,0,.5);
    height:120px; 
}
</style>
<div class="ibox-content bottom_read" style="background-color:#eeffee">
		<div class="col-xl-12">
                        <div class="col-xs-4">
                            <div class="text-center">
                                <img alt="image" style="height:70px" class="img-circle m-t-xs img-responsive" src="${(fw.wechat_head_img)!}">                             
                            </div>
                        </div>
                        <div class="col-xs-7">
                            <span><span style="font-weight:500;font-size:13pt">${(fw.worker_name)!}</span>&nbsp;&nbsp;<span style="margin-top:-10px">(${(fw.wechat_nickname)!})</span></span> <br> 
                            <span style="padding-top:15px"><i class="fa fa-user" style="padding-right:10px;"></i>${(fw.worker_no)!}</span><br>
                            <span style="padding-top:15px"><i class="fa fa-map-marker" style="padding-right:10px;"></i>${(fw.worker_province)!}<strong>·</strong>${(fw.worker_city)!}</span><br>
                            <span style="padding-top:15px"><i class="fa fa-phone" style="padding-right:10px;"></i>${(fw.worker_mobile)!}</span><br>
                        </div>
                        <div class="clearfix"></div>
         </div>
</div>
<div class="row" style="margin-top:35px;">
 <div class="col-xs-4 text-center" >
    <a href="my_info">
	<button class="btn btn-primary btn-lg btn-circle" type="button"><i class="fa fa-user"></i>
	</button>
	<div style="padding-top:5px">基本资料</div>
	</a>
 </div>
 <div class="col-xs-4 text-center">
 	<a href="my_agree">
	<button class="btn btn-primary btn-lg btn-circle" type="button"><i class="fa fa-file"></i>
	</button>
	<div style="padding-top:5px">我的签约</div>
	</a>
 </div>
 <div class="col-xs-4 text-center">
 	<a href="my_taskorder">
	<button class="btn btn-primary btn-lg btn-circle" type="button"><i class="fa fa-credit-card"></i>
	</button>
	<div style="padding-top:5px">结算记录</div>
	</a>
 </div>
</div>
<div class="row" style="margin-top:35px;">
 <div class="col-xs-4 text-center">
 	<a href="my_task">
	<button class="btn btn-primary btn-lg btn-circle" type="button"><i class="fa fa-briefcase"></i>
	</button>
	<div style="padding-top:5px">任务记录</div>
	</a>
 </div>
 <div class="col-xs-4 text-center">
 	<a href="my_concat">
	<button class="btn btn-primary btn-lg btn-circle" type="button"><i class="fa fa-envelope"></i>
	</button>
	<div style="padding-top:5px">联系我们</div>
	</a>
 </div>

</div>


