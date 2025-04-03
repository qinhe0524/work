<#include "/common/include.ftl">
<script src="/partwechat/public/js/exif.js"></script>
    <title>实名认证</title>
<style>

	html, body {
	  height: 100%;
	  margin: 0;
	  background-color: #ffffff;
	}
	.boder-yinyin {
		-moz-box-shadow: 0 0 10px #c6c3e7;
		-webkit-box-shadow: 0 0 10px #c6c3e7;
		box-shadow: 0 0 10px #c6c3e7;
	}
	
	.topbg{
		height: 120px;
	    background-image: url(/partwechat/public/viewimg/user/utopbg.png);
	    background-repeat: no-repeat;
	    background-size: 100%;
	    color: #fff;
	    padding-top: 10px;
	}
	
	
	.top-txdv{
		width: 60px;
	    height: 60px;
	 	margin: 0px auto;
	 	color: #FFFFFF;
	 	font-size:15px;
	 	line-heigh:40px;
	}
	
	
	.top-tx{
		width: 60px;
	    height: 60px;
	    background-color: #FFFFFF;
	    border-radius: 50%;
	    -moz-border-radius: 50%;
	    -webkit-border-radius: 50%;
	   	margin-bottom: 7px;
	}
	
	
	.distribution {
	    background-color: #FFFFFF;
	    overflow: hidden;
	    border-radius: 11px;
	    width: 92%;
	    padding: 0px 20px;
	    margin: 20px auto;
	    height: auto;
	    
	}
	
	.funbtnitme {
	  font-size: 16px;
	  width:30%;
	  float:left;
	  line-heght:12px;
	  color:#666666;
	}
	.funbtnitme img {
	  width: 21px;
	  height: 21px;
	  vertical-align:middle;
	  margin-right:3px;
	  line-height: 56px;
	}

	.funbtnitme-r img {
	  width: 25px;
	  height: 25px;
	  vertical-align:middle;
	}
	
	 /*中间的过度的横线*/
     .link-buttom {
        width: 100%;
        height: 1px;
        border-bottom:1px solid #ccc
     }
	.ddiv{
		height: 52px;line-height: 52px;
	}

.mxtitles{
	margin-left: 16px;
    font-size: 11spx;
    margin-top: 6%;
    display: block;
    color: #4a4646;
    font-weight: bold;
}
.mxtitleaq{
	margin-left: 16px;
    font-size: 12px;
    margin-top: 2%;
    display: block;
    color: #4a4646;
    font-weight: bold;
}

.carddiv{
	width:100%;
    padding: 0 5%;
    margin-top:2px;
    height: 87px;
}
.rardl{
  width:48%;
  height:202px;
  float:left;
  background-image: url(/partwechat/public/viewimg/bank/rx.png);
  background-repeat: no-repeat;
	background-size: 100% 100%;
-moz-background-size:100% 100%;
  color: #316fff;
  height:auto;
  text-align: center;
  /* line-height: 40px; */
  font-size:9px;
}
.rardr{
  width:48%;
  height:202px;
  float:right;
  background-image: url(/partwechat/public/viewimg/bank/gh.png);
  background-repeat: no-repeat;
 background-size: 100% 100%;
-moz-background-size:100% 100%;
  color: #316fff;
  height:auto;
  text-align: center;
  /* line-height: 40px; */
  font-size:9px;
}
.conf-btna {
    width: 100%;
    padding: 10px 20px !important;
    border-radius: 50px !important;
    border: none;
    background: #4c82ff !important;
    color: #fff;
}

  .inpt-formtx {
    width: 100% !important;
    height: 30px !important;
    line-height: 30px !important;
    border-radius: 4px !important;
    box-shadow: none !important;
    font-size: 10pt;
    color: #666;
    font-weight:500;
    text-align: left;
  
}


.phoneck{
  width:100%;
  height:90px;
  border:1px solid red;
  width:100%;
  opacity:0;
}
.rardl p{
  margin-top:-30px;
}
.rardr p{
  margin-top:-30px;
}
</style>
<body>



<p class="mxtitles">为了保障您的账户安全，请进行实名认证</p>
<p class="mxtitleaq" ><img src="/partwechat/public/viewimg/bank/aq.png"  width= "12px" height="14px" style="vertical-align:middle"></img>
我们将严格保障您的信息安全</p>

<form name="idcard_form" id="idcard_form" action="#">
<div class="carddiv">
	<div class="rardl">
		<input type="file" class="phoneck" accept="image/*"  id="picFile1" onchange="readFile(this,0)" >
		<img src="/partwechat/public/viewimg/bank/xj.png" mode="aspectFit" width= "34px" height="34px" style="vertical-align:middle;margin-top: -64%;"></img>
		<p>拍摄/上传身份证正面</p>
	</div>
	<div class="rardr">
		<input type="file" class="phoneck" accept="image/*"  id="picFile" onchange="readFile(this,1)" >
		<img src="/partwechat/public/viewimg/bank/xj.png" mode="aspectFit" width= "34px" height="34px" style="vertical-align:middle;margin-top: -64%;"></img>
		<p>拍摄/上传身份证反面</p>
	</div>
</div>
</form>
<form method="post" action="/partwechat/FreeWorker/add_idcard_save" class="form-horizontal required-validate" id="regform" onsubmit="return check_add_idcard(this);">
<div  class="margin-tb-sm boder-yinyin distribution" style="margin-top:46px;">
    <div class="form-group" style="margin-top:20px;width:100%;padding-left:0px;padding-right:0px">
                    <div style="display:inline-block;width:100%">
						<label class="col-xs-3 control-label " style="margin-top:8px">姓名</label>
						<div class="col-xs-6">
							<input class="required form-control inpt-formtx" type="text" id="name" name="worker_name" style="margin-left:0px" value="" />
					    </div>
				    </div>
				    <div style="display:inline-block;width:100%">
					    <label class="col-xs-3 control-label " style="margin-top:8px">身份证</label>
						<div class="col-xs-9">
							<input class="required form-control inpt-formtx" type="text" id="idcard" name="worker_cardno" value=""/>
					    </div>
				    </div>
				    <div style="display:inline-block;width:100%">
					    <label class="col-xs-3 control-label " style="margin-top:8px">有效期</label>
						<div class="col-xs-8">
							<input class="required form-control inpt-formtx" type="text" id="idcard_end_date" name="worker_carddate" value="" />
					    </div>
				     </div>
				     <div style="display:inline-block;width:100%;padding-left:15px;font-size:8pt">如识别信息不对，请手动修改</div>
	</div>

</div>
<div  class="margin-tb-sm flex  distribution" style="margin-top:5px;width:100%;">
	<button type="submit" class="conf-btna"><#if fw=='0'>确定信息下一步<#else>补充身份证照片信息</#if></button>	
	<img src="/partwechat/public/viewimg/bank/ts.png" mode="aspectFit" width= "20px" height="20px" style="vertical-align:middle"></img>
	<span  style="font-size: 9px;color:#999999;margin-top:15px;">请使用本人身份证认证，认证通过后不允许更改</span>
</div>
</form>
<script type="text/javascript">
   var fs0=false;
   var fs1=false;
  function readFile(obj,fs){   
        var file = obj.files[0];      
        //判断类型是不是图片  不难发现这个检测是基于正则表达式的，因此可以进行各种复杂的匹配，非常有用。
        if(!/image\/\w+/.test(file.type)){     
                layer.msg("请确保文件为图像类型");   
                return false;   
        } 
        var rardClass=fs==0?".rardl":".rardr";
    	//读取File对象的数据
    	var reader = new FileReader();
        reader.readAsDataURL(file);   
        
        reader.onload = function(e) {            
            // 图片base64化
            var newUrl = this.result;
            var buffer=base64ToArrayBuffer(newUrl);            
            var Orientation=getOrientation(buffer);
            var image = new Image(); 
	        image.src = this.result; 
	        image.onload = function() { 
			        var expectWidth = this.naturalWidth; 
			        var expectHeight = this.naturalHeight; 
			        if (this.naturalWidth > this.naturalHeight && this.naturalWidth > 800) { 
			          expectWidth = 800; 
			          expectHeight = expectWidth * this.naturalHeight / this.naturalWidth; 
			        } else if (this.naturalHeight > this.naturalWidth && this.naturalHeight > 1200) { 
			          expectHeight = 1200; 
			          expectWidth = expectHeight * this.naturalWidth / this.naturalHeight; 
			        } 
			        var canvas = document.createElement("canvas"); 
			        var ctx = canvas.getContext("2d"); 
			        canvas.width = expectWidth; 
			        canvas.height = expectHeight; 
			        ctx.drawImage(this, 0, 0, expectWidth, expectHeight); 
			        var base64 = null; 
			    
			        //修复ios 
			        if (navigator.userAgent.match(/iphone/i)) { 
			          console.log('iphone'); 
			          //alert(expectWidth + ',' + expectHeight); 
			          //如果方向角不为1，都需要进行旋转 added by lzk 
			          if(Orientation != "" && Orientation != 1){ 
			            //alert('旋转处理'); 
			            switch(Orientation){ 
			              case 6://需要顺时针（向左）90度旋转 
			               // alert('需要顺时针（向左）90度旋转'); 
			                rotateImg(this,'left',canvas); 
			                break; 
			              case 8://需要逆时针（向右）90度旋转 
			              //  alert('需要顺时针（向右）90度旋转'); 
			                rotateImg(this,'right',canvas); 
			                break; 
			              case 3://需要180度旋转 
			                //alert('需要180度旋转'); 
			                rotateImg(this,'right',canvas);//转两次 
			                rotateImg(this,'right',canvas); 
			                break; 
			            }     
			          } 
			          base64 = canvas.toDataURL("image/jpeg", 0.8); 
			        }else if (navigator.userAgent.match(/Android/i)) {    // 修复android 
			        
			        
			          if(Orientation != "" && Orientation != 1){ 
			            //alert('旋转处理'); 
			            switch(Orientation){ 
			              case 6://需要顺时针（向左）90度旋转 
			               // alert('需要顺时针（向左）90度旋转'); 
			                rotateImg(this,'left',canvas); 
			                break; 
			              case 8://需要逆时针（向右）90度旋转 
			                //alert('需要顺时针（向右）90度旋转'); 
			                rotateImg(this,'right',canvas); 
			                break; 
			              case 3://需要180度旋转 
			                //alert('需要180度旋转'); 
			                rotateImg(this,'right',canvas);//转两次 
			                rotateImg(this,'right',canvas); 
			                break; 
			            }     
			          } 
			          base64 = canvas.toDataURL("image/jpeg", 0.8); 
			        } 
			        $(rardClass).css("background-image",'url(' + base64 + ')');
			        getResultbyOCR(base64,fs);
			        $('#idcard_form')[0].reset();
	      	}; 
            
        };
       $(rardClass+" img").css("display","none");
       $(rardClass+" p").css("display","none");
       
    }  

   
    function getResultbyOCR(imagesdata,fs) {
        var formData = new FormData();
        formData.append("datas", imagesdata);
        formData.append("fs", fs);
        $.ajax({
            type: "POST",
            cache: false,
            url:"/partwechat/FreeWorker/checkIdcard",
  			processData: false,
  			contentType: false,
            data:formData,
            dataType:"json",
            beforeSend: function () {
                this.layerIndex = layer.load(0, { shade: [0.5, '#393D49'],time: 60*1000});
            },    
            // 设置请求头信息
            success: function(data) {
            	layer.close(this.layerIndex);
                if(data.statusCode!=200){
              	  layer.msg(data.message);  
              	  if(fs==0){
              	  	fs0=false;
              	  }else{
              	  	fs1=false;
              	  }
              	  return false;
                }
                if(fs==1){
                	fs1=true;
                	$("#idcard_end_date").val(data.idcard_end_date);
                }else{
                	fs0=true;
                	$("#idcard").val(data.idcard);
                	$("#name").val(data.name);
                }           
            },
            error: function(res) {
                 layer.close(this.layerIndex);
                 
            }
        });
    }
    
   
    function rotateImg(img, direction,canvas) {
        //alert(img);
        //最小与最大旋转方向，图片旋转4次后回到原方向
        var min_step = 0;
        var max_step = 3;
        //var img = document.getElementById(pid);
        if (img == null)return;
        //img的高度和宽度不能在img元素隐藏后获取，否则会出错
        var height = img.height;
        var width = img.width;
        //var step = img.getAttribute('step');
        var step = 2;
        if (step == null) {
            step = min_step;
        }
        if (direction == 'right') {
            step++;
            //旋转到原位置，即超过最大值
            step > max_step && (step = min_step);
        } else {
            step--;
            step < min_step && (step = max_step);
        }
        //img.setAttribute('step', step);
        /*var canvas = document.getElementById('pic_' + pid);
        if (canvas == null) {
            img.style.display = 'none';
            canvas = document.createElement('canvas');
            canvas.setAttribute('id', 'pic_' + pid);
            img.parentNode.appendChild(canvas);
        }  */
        //旋转角度以弧度值为参数
        var degree = step * 90 * Math.PI / 180;
        var ctx = canvas.getContext('2d');
        switch (step) {
            case 0:
                canvas.width = width;
                canvas.height = height;
                ctx.drawImage(img, 0, 0);
                break;
            case 1:
                canvas.width = height;
                canvas.height = width;
                ctx.rotate(degree);
                ctx.drawImage(img, 0, -height);
                break;
            case 2:
                canvas.width = width;
                canvas.height = height;
                ctx.rotate(degree);
                ctx.drawImage(img, -width, -height);
                break;
            case 3:
                canvas.width = height;
                canvas.height = width;
                ctx.rotate(degree);
                ctx.drawImage(img, -width, 0);
                break;
        }
    }
    
   function base64ToArrayBuffer(base64) {
    base64 = base64.replace(/^data\:([^\;]+)\;base64,/gmi, '');
    var binary = atob(base64);
    var len = binary.length;
    var buffer = new ArrayBuffer(len);
    var view = new Uint8Array(buffer);
    for (var i = 0; i < len; i++) {
      view[i] = binary.charCodeAt(i);
    }
    return buffer;
  }
  
  function getStringFromCharCode(dataView, start, length) {
    var str = '';
    var i;
    for (i = start, length += start; i < length; i++) {
      str += String.fromCharCode(dataView.getUint8(i));
    }
    return str;
  }
  
  function getOrientation(arrayBuffer) {
    var dataView = new DataView(arrayBuffer);
    
    var length = dataView.byteLength;
    var orientation;
    var exifIDCode;
    var tiffOffset;
    var firstIFDOffset;
    var littleEndian;
    var endianness;
    var app1Start;
    var ifdStart;
    var offset;
    var i;
   
    if (dataView.getUint8(0) === 0xFF && dataView.getUint8(1) === 0xD8) {
      offset = 2;
      while (offset < length) {
        if (dataView.getUint8(offset) === 0xFF && dataView.getUint8(offset + 1) === 0xE1) {
          app1Start = offset;
          break;
        }
        offset++;
      }
    }
   
    if (app1Start) {
      exifIDCode = app1Start + 4;
      tiffOffset = app1Start + 10;
      if (getStringFromCharCode(dataView, exifIDCode, 4) === 'Exif') {
        endianness = dataView.getUint16(tiffOffset);
        littleEndian = endianness === 0x4949;

        if (littleEndian || endianness === 0x4D4D) {
          if (dataView.getUint16(tiffOffset + 2, littleEndian) === 0x002A) {
            firstIFDOffset = dataView.getUint32(tiffOffset + 4, littleEndian);

            if (firstIFDOffset >= 0x00000008) {
              ifdStart = tiffOffset + firstIFDOffset;
            }
          }
        }
      }
    }
  
    if (ifdStart) {
      length = dataView.getUint16(ifdStart, littleEndian);
		
      for (i = 0; i < length; i++) {
        offset = ifdStart + i * 12 + 2;
        if (dataView.getUint16(offset, littleEndian) === 0x0112) {

          // 8 is the offset of the current tag's value
          offset += 8;

          // Get the original orientation value
          orientation = dataView.getUint16(offset, littleEndian);
          // Override the orientation with its default value for Safari (#120)
          //if (IS_SAFARI_OR_UIWEBVIEW) {
            //dataView.setUint16(offset, 1, littleEndian);
         // }
          break;
        }
      }
    }
   
    return orientation;
  }
    </script>
</body>