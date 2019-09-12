<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>前台导航列表管理</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/admin/js/jquery.min.js"></script>
</head>
<body class="layui-layout-body">
	<table class="layui-table"  id="NavTable" lay-filter="NavTable">
		<!-- 表头 -->
		
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'100',fixed:'left',align:'center',sort:'true'}">导航ID</th>
				<th lay-data="{field:'url',width:'250',align:'center',edit:'true'}">链接地址</th>
				<th lay-data="{field:'position',width:'150',align:'center'}">位置</th>
				<th lay-data="{field:'name',width:'150',align:'center',edit:'true'}">导航名称</th>
				<th lay-data="{field:'isShow',width:'100',align:'center'}">显示</th>
				<th lay-data="{field:'isNew',width:'100',align:'center'}">新窗口打开</th>
				<th lay-data="{field:'sort',width:'100',align:'center',sort:'true',edit:'true'}">排序</th>
				<th lay-data="{field:'tool',width:'200',fixed:'right',align:'center'}">操作</th>
			</tr>
			<tbody>
				<#list navigations as navigation>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}"></td>
						<td>${navigation.id}</td>
						<td>${navigation.url}</td>
						<td>${navigation.position}</td>
						<td>${navigation.name}</td>
						<td>
							<#if navigation.isShow==true>
								<i class="layui-icon layui-icon-ok-circle" style="color: #008B45;"> 是</i>
							<#else>
								<i class="layui-icon layui-icon-close" style="color: #8B8B7A;"> 否</i>
							</#if>
						</td>
						
						<td>
							<#if navigation.isNew==true>
								<i class="layui-icon layui-icon-ok-circle" style="color: #008B45;"> 是</i>
							<#else>
								<i class="layui-icon layui-icon-close" style="color: #8B8B7A;"> 否</i>
							</#if>
						</td>
						<td>${navigation.sort}</td>
						<td>
		  					<a href="/navigation/toNavEdit?id=${navigation.id}" class="layui-btn layui-btn-xs" ><i class="layui-icon " >&#xe642;</i>编辑</a>
		  					<a href="/navigation/deleteNavigation?id=${navigation.id}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" ><i class="layui-icon " >&#xe640;</i>删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/admin/lib/layui/layui.all.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
			<a href="/navigation/toNavAdd"><button type="button" class="layui-btn layui-btn-radius layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe61f;</i> 新增导航</button></a>
			<button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-sm" lay-event="getDeleteList"><i class="layui-icon " >&#xe640;</i>删除选中数据</button>
			<a href="/navigation/toNavList"><i class="layui-icon " style="color: #3CB371;">&#xe9aa;</i></a>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('NavTable',{
			  height:500,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  
		  /* table.on('edit(NavTable)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
	    	  console.log(obj.value); //得到修改后的值
	    	  console.log(obj.field); //当前编辑的字段名
	    	  console.log(obj.data); //所在行的所有相关数据  
	      }); */
		  
		  //监听单元格编辑
	      table.on('edit(NavTable)', function (obj) {
	        var value = obj.value //得到修改后的值
	          ,
	          data = obj.data //得到所在行所有键值
	          ,
	          field = obj.field; //得到字段
	          console.log(field)
	        var strData = '{"id":' + data.id + ',"' + field + '":"' + value + '"}';
	        var upData = JSON.parse(strData);
	        $.ajax({
	          type: 'post',
	          url: '/api/updateNavigation',
	          data: upData,
	          success: function (obj) {
	        	  console.log(obj);
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
		  
		  
		  
		  
		  table.on('toolbar(NavTable)', function(obj){
			    var checkStatus = table.checkStatus(obj.config.id);
			    switch(obj.event){
			      case 'getDeleteList':
			        var data = checkStatus.data;
			        var idList=[]
			        for(var item of data){
			        	idList.push(item.id)
			        };
			        if(data.length === 0){
			            layer.msg('请至少选择一行');
			         }
			        else{
			        layer.confirm('确认删除选中数据', function(index){
			        	$.ajax({
					    	  "url" : "/api/batchDeleteNavigation",
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
	
	/* $("#keyword").keyup(function(event){
            if(event.keyCode ==13){
             var newsKeyword=$("#keyword").val();
             var url="/news/selectNewsByNewsKeyword?newsKeyword="+newsKeyword
             window.location.href = url;  
            }
        });
    
    function serach(){
    	 var newsKeyword=$("#keyword").val();
         var url="/news/selectNewsByNewsKeyword?newsKeyword="+newsKeyword
         window.location.href = url;
    } */
    
    
    
	
	</script>
</body>
</html>