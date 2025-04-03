<#include "/common/include.ftl">
<link href="/partwechat/public/css/view/index.css?v=3.3.51112" rel="stylesheet">
<#if Session.agent?exists>
<div id="menu" class="menu boder-yinyin" style="padding-top:5px;">
	 	<div id="one" class="col-xs-3 text-center">
		 	<a href="/partwechat/FreeWorker/index">
	        	<div class="menu_name submenu_one<#if menu=="1">_select</#if>">
	        	<span>首页</span>
	        	</div>
	        </a>
   		</div>
   
	    <div id="two" class="col-xs-3 text-center">
	    <a href="/partwechat/Task/list">
	    	<div class="menu_name submenu_two<#if menu=="2">_select</#if>">
        	<span>任务</span>
        	</div>
        </a>
	    </div>


	    <div id="three" class="col-xs-3 text-center">
	       <a href="/partwechat/FreeWorker/my">
	    	<div class="menu_name submenu_three<#if menu=="3">_select</#if>">
        	<span>个人</span>
        	</div>
           </a> 
	    </div>
		 <div id="four" class="col-xs-3 text-center">
	       <a href="/partwechat/Agent/my">
	    	<div class="menu_name submenu_four<#if menu=="4">_select</#if>">
        	<span>代理</span>
        	</div>
           </a> 
	    </div>
</div>
<#else>
<div id="menu" class="menu boder-yinyin" style="padding-top:5px;">
	 	<div id="one" class="col-xs-4 text-center">
		 	<a href="/partwechat/FreeWorker/index">
	        	<div class="menu_name submenu_one<#if menu=="1">_select</#if>">
	        	<span>首页</span>
	        	</div>
	        </a>
   		</div>
   
	    <div id="two" class="col-xs-4 text-center">
	    <a href="/partwechat/Task/list">
	    	<div class="menu_name submenu_two<#if menu=="2">_select</#if>">
        	<span>任务</span>
        	</div>
        </a>
	    </div>
	    <div id="three" class="col-xs-4 text-center">
	       <a href="/partwechat/FreeWorker/my">
	    	<div class="menu_name submenu_three<#if menu=="3">_select</#if>">
        	<span>个人</span>
        	</div>
           </a> 
	    </div>

</div>

</#if>