<#include "/common/include.ftl">
<#include "/common/include_citypicker.ftl">
    <title>个人中心-任务记录</title>
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
<div class="ibox-content bottom_reads navbar-fixed-top" style="background-color:#eeffff">
		<div class="col-xs-12">
             <div class="col-xs-3" style="margin-left:0px"><a href="my" class="btn btn-white" style="margin-left:-30px;margin-top:-7px"><i class="fa fa-chevron-left"></i>返回</a></div>  
             <div class="col-xs-8 text-center"><span style="font-size:12pt;line-height:20px;margin-left:-30px;">任务记录</span></div>     
        </div>
</div>
<#assign tos=getCache("task_order_status")>
<div class="ibox-content" style="margin-top:40px;margin-left:0px;border:none">
   <#list taskList as list>
	<div class="widget lazur-bg" style="padding: 5px 20px;">
                    <h2><strong>${(list.task_name)}</strong></h2>
                    <ul class="list-unstyled m-t-xs ">
                          <li>
                            <span class="fa fa-reorder m-r-xs"></span>
                            <label>任务号:</label>
                            ${(list.task_no)!}
                        </li>
                        <li>
                            <span class="fa fa-barcode m-r-xs"></span>
                            <label>任务单号:</label>
                            ${(list.task_order_no)!}
                        </li>
                        <li>
                            <span class="fa fa-clock-o m-r-xs"></span>
                            <label>任务时间:</label>
                             ${(list.start_date)!}&nbsp;<i class="fa fa-arrow-right m-r-xs"></i>${(list.end_date)!}
                        </li>
                        <li>
                            <span class="fa fa-map-pin m-r-xs"></span>
                            <label>任务区域:</label>
                             ${(list.task_province)!}&nbsp;&nbsp; ${(list.task_city)!}
                        </li>
                        <li>
                            <span class="fa fa-bank m-r-xs"></span>
                            <label>企业名称:</label>
                            ${(list.client_name)!}
                        </li>
                        <li>
                            <span class="fa fa-tags m-r-xs"></span>
                            <label>描述:</label>
                            ${(list.task_rim)!}
                        </li>
                          <li>
                            <span class="fa fa-tasks m-r-xs"></span>
                            <label>单状态:</label>
                            ${(tos["${list.task_order_status}"])!}
                        </li>
                    </ul>

     </div>
     </#list>
   
</div>


