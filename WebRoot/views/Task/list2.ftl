<#include "/common/include.ftl">
    <title>灵工任务</title>
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
             <div class="col-xs-12 text-center"><img src="/partwechat/public/imgs/tt.png"></div>  
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
                            <span class="fa fa-reorder m-r-xs"></span>
                            <label>任务预算:</label>
                            <strong>￥${(list.budget_amt)!}</strong>
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
                        <li class="text-center">
                        	<a href="add?task_no=${(list.task_no)!}" type="button" class="btn btn-w-m btn-success">查看任务详细</a>
                        </li>
                    </ul>

     </div>
     </#list>
   
</div>


