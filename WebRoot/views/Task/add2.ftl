<#include "/common/include.ftl">
    <title>灵工任务-${task.task_name}</title>
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
<script>
	function saveTaskOrder(th){
		$this=$(th);
		$this.attr("disabled",true);
		var href=$this.attr("ajax_href");
		$.ajax({
			type:'POST',
			url:href,
			data:{},			
			dataType:"json",
			cache: false,
			success:function(json){
				if(json.statusCode==200){
					message=json.message||'操作成功';
					$("#task_order_buttton").text(message);
					layer.msg(message);	
				
				}else{
					message=json.message||'操作失败';
					$("#task_order_buttton").attr("disabled",false);
					layer.msg(message);	
				}
			},
			error:function(){
				layer.msg("请求失败，请联系管理员");
			}
		});
	}
</script>
<div class="ibox-content bottom_reads navbar-fixed-bottom" style="background-color:#eeffff">
		<div class="col-xs-12 text-center">
           <a href="#" ajax_href="saveTaskOrder?task_no=${(task.task_no)!}" type="button" class="btn btn-info btn-block" style="margin-top:-10px" id="task_order_buttton" onclick="saveTaskOrder(this);">报名参与该任务</a>
        </div>
</div>

<div class="ibox-content" style="margin-left:0px;border:none">  
	<div class="widget lazur-bg" style="padding: 5px 20px;">
                    <h2><strong>${(task.task_name)}</strong></h2>
                    <ul class="list-unstyled m-t-xs ">
                          <li>
                            <span class="fa fa-reorder m-r-xs"></span>
                            <label>任务号:</label>
                            ${(task.task_no)!}
                        </li>
                          <li>
                            <span class="fa fa-reorder m-r-xs"></span>
                            <label>任务预算:</label>
                            <strong>￥${(task.budget_amt)!}</strong>
                        </li>
                        <li>
                            <span class="fa fa-clock-o m-r-xs"></span>
                            <label>任务时间:</label>
                             ${(task.start_date)!}&nbsp;<i class="fa fa-arrow-right m-r-xs"></i>${(task.end_date)!}
                        </li>
                        <li>
                            <span class="fa fa-map-pin m-r-xs"></span>
                            <label>任务区域:</label>
                             ${(task.task_province)!}&nbsp;&nbsp; ${(task.task_city)!}
                        </li>
                     
                          <li>
                            <span class="fa fa-bank m-r-xs"></span>
                            <label>任务要求:</label>
                            ${(task.task_condition)!}
                        </li>
                          <li>
                            <span class="fa fa-bank m-r-xs"></span>
                            <label>任务描述:</label>
                            ${(task.task_rim)!}
                        </li>
                    </ul>

     </div>
   
   
</div>
