<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>社团管理</title>
<link rel="stylesheet"
	href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="AssoTable" lay-filter="AssoTable">
		<!-- 表头 -->
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'100',fixed:'left',align:'center'}">社团ID</th>
				<th lay-data="{field:'assoName',width:'150',fixed:'left',align:'center'}">社团名称</th>
				<th lay-data="{field:'assoId',width:'150',align:'center'}">社团编号</th>
				<th lay-data="{field:'assoStatus',width:'150',align:'center'}">运营状态</th>
				<th lay-data="{field:'assoExamined',width:'150',align:'center'}">审核状态</th>
				<th lay-data="{field:'assoGuiderName',width:'150',align:'center'}">指导老师</th>
				<th lay-data="{field:'assoAffiliateName',width:'150',align:'center'}">挂靠部门</th>
				<th lay-data="{field:'assoLeader',width:'150',align:'center'}">学生负责人</th>
				<th lay-data="{field:'assoEstablishmentTime',width:'150',align:'center'}">
					<#if TableType=="ExistedTable">
						成立时间
					<#else>
						申请时间
					</#if>
				</th>
				<th lay-data="{field:'tool',width:'200',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list AssoList as asso>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}">${asso.id}</td>
						<td>${asso.id}</td>
						<td>${asso.assoName}</td>
						<td>${asso.assoId}</td>
						<td>
							<#if asso.assoStatus==1>
									运营中
								<#else>
									申请中
							</#if>
						</td>
						<td>
							<#if asso.assoExamined==1>
								已审核
								<#else>
								待审核
							</#if>
						</td>
						<td>${asso.assoGuiderName}</td>
						<td>${asso.assoAffiliateName}</td>
						<td>${asso.assoLeader}</td>
						<td>${asso.assoEstablishmentTime?date}</td>
						<td>
							<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="toChild">查看社团</a>
		  					<a href="${base}/csp/asso/toEdit?id=${asso.id}" class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		  					<a href="${base}/csp/asso/deleteOneFromTable?id=${asso.id}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	<div id="pageTool"></div>
	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/html" id="editTool">
		<!-- 工具栏 -->
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="toChild">查看下级菜单</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">保存修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
    		<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getDeleteList">删除选中数据</button>
    		<a href="${base}/csp/asso/toAdd"><button class="layui-btn layui-btn-sm" lay-event="getCheckLength">添加社团</button></a>
    		<#if TableType=="ExistedTable">
				<a href="${base}/csp/asso/toExamingAssoTable"><button class="layui-btn layui-btn-sm" lay-event="isAll">查看待审核社团</button></a>
			<#elseif TableType=="ExamingTable">
				<a href="${base}/csp/asso/toExistedAssoTable"><button class="layui-btn layui-btn-sm" lay-event="isAll">查看已成立社团</button></a>
				<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getCheckList">批量审核选中社团</button>
			</#if>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('AssoTable',{
			  height:450,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  //头工具栏事件
		  table.on('toolbar(AssoTable)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
		    switch(obj.event){
		      case 'getDeleteList':
		        var data = checkStatus.data;
		        var deleteList=[]
		        for(var item of data){
		        	deleteList.push(item.id)
		        };
		        layer.confirm('确认删除选中数据', function(index){
		        	$.ajax({
				    	  "url" : "${base}/csp/asso/deleteList",
				    	  "data" : "deleteList="+deleteList,
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
				    				                 href: '${base}/csp/asso/toExistedAssoTable'
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
				    				                 href: '${base}/csp/asso/toExistedAssoTable'
				    				            ,target: '_self'
				    				        });
				    				    }
				    				});
				    		  }
		    			  
						}
				      });
		          });
		      break;
		      case 'getCheckList':
		    	  var data = checkStatus.data;
			        var checkList=[]
			        for(var item of data){
			        	checkList.push(item.id)
			        };
			        layer.confirm('确认通过审核', function(index){
			        	$.ajax({
					    	  "url" : "${base}/csp/asso/setCheckedAssoList",
					    	  "data" : "checkList="+checkList,
					    	  "type" : "post",
					    	  "dataType" : "json",
					    	  "success"	: function (resultMsg) {
					    		  if(resultMsg==1){
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "审核成功"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '${base}/csp/asso/toExistedAssoTable'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }else{
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "审核失败"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '${base}/csp/asso/toExistedAssoTable'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }
			    			  
							}
					      });
			          });
		      break;
		      case 'isAll':
		        layer.msg(checkStatus.isAll ? '全选': '未全选');
		      break;
		    };
		  });
		  
	})
	</script>
</body>
</html>