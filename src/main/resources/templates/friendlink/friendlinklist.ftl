<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>友情链接列表管理</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/admin/js/jquery.min.js"></script>
</head>
<body class="layui-layout-body">
	<table class="layui-table"  id="FriendLinkTable" lay-filter="FriendLinkTable">
		<!-- 表头 -->
		
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'linkId',width:'150',fixed:'left',align:'center',sort:'true'}">友情链接ID</th>
				<th lay-data="{field:'linkName',width:'150',align:'center',edit:'true'}">链接名称</th>
				<th lay-data="{field:'linkUrl',width:'300',align:'center',edit:'true'}">链接地址</th>
				<th lay-data="{field:'linkLogo',width:'150',align:'center'}">链接LOGO</th>
				<th lay-data="{field:'orderby',width:'100',align:'center',sort:'true',edit:'true'}">排序</th>
				<th lay-data="{field:'isShow',width:'100',align:'center'}">是否显示</th>
				<th lay-data="{field:'target',width:'100',align:'center'}">新窗口打开</th>
				<th lay-data="{field:'tool',width:'200',fixed:'right',align:'center'}">操作</th>
			</tr>
			<tbody>
				<#list friendLinks as friendLink>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}"></td>
						<td>${friendLink.linkId}</td>
						<td>${friendLink.linkName}</td>
						<td>${friendLink.linkUrl}</td>
						<td>
							<#if friendLink.linkLogo=="">
								<i class="layui-icon">&#xe64a; 暂无图片</i> 
							<#else>
								${friendLink.linkLogo}
							</#if>
						</td>
						<td>${friendLink.orderby}</td>
						<td>
							<#if friendLink.isShow==true>
								<input type="checkbox" name="isShow" data-id="${friendLink.linkId}" lay-skin="switch" lay-text="是|否" lay-filter="switchTest" checked>
							<#else>
								<input type="checkbox" name="isShow" data-id="${friendLink.linkId}" lay-skin="switch" lay-text="是|否" lay-filter="switchTest">
							</#if>
						</td>
						
						<td>
							<#if friendLink.target==true>
								<input type="checkbox" name="target" data-id="${friendLink.linkId}" lay-skin="switch" lay-text="是|否" lay-filter="switchTest" checked>
							<#else>
								<input type="checkbox" name="target" data-id="${friendLink.linkId}" lay-skin="switch" lay-text="是|否" lay-filter="switchTest" >
							</#if>
						</td>
						
						<td>
		  					<a href="/friendlink/toFriendLinkEdit?linkId=${friendLink.linkId}" class="layui-btn layui-btn-xs" ><i class="layui-icon " >&#xe642;</i>编辑</a>
		  					<a href="/friendlink/deleteFriendLink?linkId=${friendLink.linkId}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" ><i class="layui-icon " >&#xe640;</i>删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/admin/lib/layui/layui.all.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
			<a href="/friendlink/toFriendLinkAdd"><button type="button" class="layui-btn layui-btn-radius layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe61f;</i> 新增友情链接</button></a>
			<button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-sm" lay-event="getDeleteList"><i class="layui-icon " >&#xe640;</i>删除选中数据</button>
			<a href="/friendlink/toFriendLinkList"><i class="layui-icon " style="color: #3CB371;">&#xe9aa;</i></a>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table,form = layui.form;
		  table.init('FriendLinkTable',{
			  height:500,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  
		  //监听单元格编辑
	      table.on('edit(FriendLinkTable)', function (obj) {
	    	var old=$(this).prev().text();
	        var value = obj.value //得到修改后的值
	          ,
	          data = obj.data //得到所在行所有键值
	          ,
	          field = obj.field; //得到字段
	          
	          
	          if(field=="linkUrl"){//链接验证
	        	  var Expression = '(^#)|^((|https|http|ftp|rtsp|mms)?://)?'
	                  +'(([0-9a-z_!~*().&=+$%-]+: )?[0-9a-z_!~*().&=+$%-]+@)?' //ftp的user@
	                  +'(([0-9]{1,3}.){3}[0-9]{1,3}|'// IP形式的URL- 199.194.52.184
	                  +'([0-9a-z_!~*()-]+.)*'// 域名- www.
	                  +'[a-z]{2,6})'//域名的扩展名
	                  +'(:[0-9]{1,4})?'// 端口- :80
	                  +'((/?)|(/[0-9a-z_!~*().;?:@&=+$,%#-]+)+/?)$'; 
	              
	              var objExp=new RegExp(Expression);
	       		  if(value==""){
	       			  layer.msg("链接不能为空,请用'#'符号代替")
	       			  $(this).val(old);
	       			  return false;
	       		  }else if(objExp.test(value) != true){
	            	  layer.msg("链接格式不正确!")
	            	  $(this).val(old);
	            	  return false;
	              }
	           }
	          else if(field=="orderby"){//排序验证
	        	  var Expression = /^[1-9]\d*$/;
	        	  if(!Expression.test(value)){
	        		  layer.msg("排序值不合法,必须为正整数")
	        		  $(this).val(old);
	        		  return false;
	        	  }
	        	  else if(value>127){
	        		  layer.msg("排序值超出规定范围(1~127)")
	        		  $(this).val(old);
	        		  return false;
	        	  }
	          }
	          
	          
	        var strData = '{"linkId":' + data.linkId + ',"' + field + '":"' + value + '"}';
	        var upData = JSON.parse(strData);
	        $.ajax({
	          type: 'post',
	          url: '/api/updateFriendLink',
	          data: upData,
	          success: function (obj) {
	        	  //console.log(obj);
	            if (obj.code != 0) {
	              layer.msg("修改"+obj.msg)
	              setTimeout(function () {
	            	  window.location.reload();
				  }, 500);
	            } else {
	            	parent.layer.msg("修改"+obj.msg)
	            }
	          },
	          error: function (obj) {
	        	  parent.layer.msg("请求异常");
	          },
	          complete: function () {
	          }
	        });
	        return false;
	      });
	      
	      
	      //监听复选框选择
		  form.on('switch(switchTest)', function (data) {
	        
	          var id = $(this).attr('data-id') //当前行ID
	          var field = $(this).attr('name') //得到字段
	          var value = this.checked		   //得到选中状态
	          //console.log(id+"---"+value+"---"+field)
	          var strData = '{"linkId":' + id + ',"' + field + '":"' + value + '"}';
	          var upData = JSON.parse(strData);
	          $.ajax({
		          type: 'post',
		          url: '/api/updateFriendLink',
		          data: upData,
		          success: function (obj) {
		        	  //console.log(obj);
		            if (obj.code != 0) {
		              layer.msg("修改"+obj.msg)
		            } else {
		            	parent.layer.msg("修改"+obj.msg)
		            }
		          },
		          error: function (obj) {
		        	  parent.layer.msg("请求异常");
		          },
		          complete: function () {
		          }
		        });
		        return false;
	        
	      });
		  
		  
		  
		  table.on('toolbar(FriendLinkTable)', function(obj){
			   var checkStatus = table.checkStatus(obj.config.id);
			    switch(obj.event){
			      case 'getDeleteList':
			        var data = checkStatus.data;
			        var idList=[]
			        for(var item of data){
			        	idList.push(item.linkId)
			        };
			        if(data.length === 0){
			            layer.msg('请至少选择一行');
			         }
			        else{
			        layer.confirm('确认删除选中数据', function(index){
			        	$.ajax({
					    	  "url" : "/api/batchDeleteFriendLink",
					    	  "data" : "idList="+idList,
					    	  "type" : "post",
					    	  "success"	: function (obj) {
					    		  if (obj.code != 0) {
						              layer.msg("删除"+obj.msg)
						              setTimeout(function () {
						            	  window.location.reload();
									}, 500);
						          }else {
						              parent.layer.msg("删除"+obj.msg)
						          }
			    			  
							},
							  error: function (obj) {
					        	  parent.layer.msg("请求异常");
					          },
					          
					      });
			          });
			    	}
			      break;
			    };
			  });
		  
		  
		  
	})
    
    
	
	</script>
</body>
</html>