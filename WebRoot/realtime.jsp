<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
<link href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css"  rel="stylesheet" type="text/css">
<script src="/backzhzws/public/datatables/js/jquery.js" type="text/javascript"></script>
<script src="/backzhzws/public/datatables/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="/backzhzws/public/datatables/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script>
	var table;
	$(document).ready(function() {
    	table = $('#example').DataTable( {
              //跟数组下标一样，第一列从0开始，这里表格初始化时，第四列默认降序
               "order": [[ 6, "desc" ]],
               "iDisplayLength":15,
               language: {
		        "sProcessing": "处理中...",
		        "sLengthMenu": "显示 _MENU_ 项结果",
		        "sZeroRecords": "没有匹配结果",
		        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
		        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
		        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
		        "sInfoPostFix": "",
		        "sSearch": "搜索:",
		        "sUrl": "",
		        "sEmptyTable": "表中数据为空",
		        "sLoadingRecords": "载入中...",
		        "sInfoThousands": ",",
		        "oPaginate": {
		            "sFirst": "首页",
		            "sPrevious": "上页",
		            "sNext": "下页",
		            "sLast": "末页"
		        },
		        "oAria": {
		            "sSortAscending": ": 以升序排列此列",
		            "sortDescending": ": 以降序排列此列"
		        }
		    }
      	} );
      	//每秒读取后台数据
      	setInterval("insertRow()",1000);
      	//隐藏显示结果
       	$("#example_length",$(document)).hide();
       	//隐藏检索框
       	$("#example_filter",$(document)).hide();
} );
//添加一行
function insertRow(){
	$.post("/backzhzws/publicGetRealData",function(data){
      		if(data != ""){
      			data = $.parseJSON(data);
      			//金额
      			var amount = data["amount"]; 
      			amount = (parseInt(amount)/100);
      			//状态码
      			var status = data["status"];
      			if(status==0) status = "<span style = 'color:green;'>成功</span>";
      			else if(status==-1) status = "<span style = 'color:#ff6666;'>撤销</span>";
      			else if(status==-2) status = "<span style = 'color:#ff3300;'>待撤销</span>";
      			else if(status==-3) status = "<span style = 'color:#ccff66;'>冲正</span>";
      			else if(status==-4) status = "<span style = 'color:#99ffff;'>待冲正</span>";
      			else if(status==1) status = "<span style = 'color:#6666cc;'>补录</span>";
      			else if(status==2) status = "<span style = 'color:red;'>失败</span>";
      			else if(status==3) status = "<span style = 'color:#0099cc;'>异常</span>";
      			else if(status==6) status = "<span style = 'color:#6600ff;'>冻结</span>";
      			else status = "不明";
      			//卡类型
      			var cardtype = data["cardtype"];
      			if(cardtype==1) cardtype = "借记卡";
      			else if(cardtype==2) cardtype = "贷记卡";
      			else if(cardtype==3) cardtype = "预付费卡";
      			else cardtype = "不明";
      			//银行卡号加密
      			var pan = data["pan"];
      			pan = pan.substring(0,6)+"****"+pan.substring(pan.length-4);
	      		table.row.add( [
					data["posno"],
					data["client_no"],
					amount,
					pan,
					data["postype"],
					data["serial"],
					data["locadate"],
					status,
					cardtype
			   ] ).draw();
		   }
      	});
}
</script>
<html>
  <title>交易实时统计</title>
  <body>
<table id="example" class="table table-striped table-bordered" width="99%" cellspacing="0">
    <thead>
        <tr>
            <th width = "8%">终端号</th>
            <th width = "8%">平台商户号</th>
            <th width = "8%">交易金额</th>
            <th width = "8%">交易卡号</th>
            <th width = "8%">交易类型</th>
            <th width = "8%">交易流水号</th>
            <th width = "15%">交易日期</th>
            <th width = "8%">交易状态</th>
            <th width = "8%">卡类型</th>
        </tr>
    </thead>
</table>
 </body>
</html>
