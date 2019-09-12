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
	<table class="layui-table" id="NavTable" lay-filter="NavTable">
		<!-- 表头 -->
		
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'100',fixed:'left',align:'center',sort:'true'}">导航ID</th>
				<th lay-data="{field:'url',width:'250',align:'center'}">链接地址</th>
				<th lay-data="{field:'name',width:'150',align:'center'}">导航名称</th>
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
		  					<a href="/navigation/toNavEdit?id=${navigation.id}" class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		  					<a href="" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delInRecycle">删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/admin/lib/layui/layui.all.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
			<a href="/news/toNewsAdd"><button type="button" class="layui-btn layui-btn-radius layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe61f;</i> 新增导航</button></a>
    		<a href="/news/toNewsList?operation=isAudit"><button class="layui-btn layui-btn-sm" >查看已审核新闻</button></a>
			<a href="/news/toNewsList?operation=isNotAudit"><button class="layui-btn layui-btn-sm" >查看待审核新闻</button></a>
			<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getDeleteList">删除选中数据</button>
			<a href="/news/toNewsList?operation=isDelete"><button class="layui-btn layui-btn-sm" >新闻回收站</button></a>
			<a href="/news/toNewsList"><i class="layui-icon layui-icon-refresh-3" style="font-size: 20px;"></i></a>
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
		  
		  table.on('edit(NavTable)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
	    	  console.log(obj.value); //得到修改后的值
	    	  console.log(obj.field); //当前编辑的字段名
	    	  console.log(obj.data); //所在行的所有相关数据  
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
					    	  "url" : "/news/deleteNewsListInRecycle",
					    	  "data" : "idList="+idList,
					    	  "type" : "post",
					    	  "dataType" : "json",
					    	  "success"	: function (resultMsg) {
					    		  if(resultMsg==1){
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "删除成功"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '/news/toNewsList'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }else{
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "删除失败"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '/news/toNewsList'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }
			    			  
							}
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