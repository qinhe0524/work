<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.1" rel="stylesheet">
    <title>任务详情</title>
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
<div class="bottom_reads boder-yinyin navbar-fixed-top" >
		<div class="col-xs-12  span_title">
	          <div class="col-xs-1" style="margin-left:10px;"><a  onClick="javascript :history.back(-1);" class="title_return"><i class="fa fa-chevron-left"></i></a></div>  
	          <div class="col-xs-10 span-center"><span style="font-size:10pt;line-height:38px;margin-left:-10px;">任务详情</span></div>     
	     </div>
</div>

<div  class=" flex   distribution" style="margin-top:50px">
	<div style="height: 52px;line-height: 22px;">
			<p  class="btspan">${(task.task_name)!}</p>
			<p  style="font-size: 12px;color:#999999;">发布于<span>${(task.add_time)!}</span></p>
			
			<div class="dtb">
				<i class="fa fa-map-marker"></i>
				<span  style="font-size: 20rpx;">${(task.task_province)!}&nbsp;&nbsp; ${(task.task_city)!}</span>
			</div>
			<div class=" dtblast">
				<span class="fa fa-clock-o m-r-xs"></span>
				<span  style="font-size: 20rpx;"><span>${(task.end_date)!}</span>截止</span>
			</div>
			
	</div>
	
	
	<div style="height: auto;line-height: 22px;margin-top: 66px;">
		<p  class="btspan">接单条件</p>
		<p>${(task.task_condition)!}</p>
	</div>
	
	
	<div style="height: auto;line-height: 22px;margin-top: 66px;">
		<p  class="btspan">任务详情</p>
		
		<p>${(task.task_rim)!}</p>
	</div>

	<div style="height: auto;line-height: 22px;margin-top: 66px;">
		<p  class="btspan">结算方式</p>

		<p>${(task.settlement_method)!}</p>
	</div>
</div>
<div class="ibox-content bottom_reads navbar-fixed-bottom" style="background-color:#eeffff;height:40px">
		<div class="col-xs-12 text-center">
           <a href="#" ajax_href="saveTaskOrder?task_no=${(task.task_no)!}" type="button" class="btn btn-info btn-block" style="margin-top:-12px" id="task_order_buttton" onclick="saveTaskOrder(this);" >报名参与该任务</a>
        </div>
</div>
