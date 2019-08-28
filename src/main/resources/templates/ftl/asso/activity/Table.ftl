<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>活动管理</title>
<link rel="stylesheet"
	href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="AssoStuTable" lay-filter="AssoStuTable">
		<!-- 表头 -->
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'50',fixed:'left',align:'center'}">ID</th>
				<th lay-data="{field:'activityId',width:'120',fixed:'left',align:'center'}">活动编号</th>
				<th lay-data="{field:'activityName',width:'150',fixed:'left',align:'center'}">活动名称</th>
				<th lay-data="{field:'activityStatus',width:'100',align:'center'}">活动状态</th>
				<th lay-data="{field:'activityAssoName',width:'100',align:'center'}">所属社团</th>
				<th lay-data="{field:'activityOrganizerName',width:'100',align:'center'}">活动负责人</th>
				<th lay-data="{field:'activityNum',width:'80',align:'center'}">人数上限</th>
				<th lay-data="{field:'activityPartNum',width:'80',align:'center'}">目前人数</th>
				<th lay-data="{field:'activityStartTime',width:'150',align:'center'}">活动开始时间</th>
				<th lay-data="{field:'activityFinishTime',width:'150',align:'center'}">活动结束时间</th>
				<th lay-data="{field:'activityIntro',width:'150',align:'center'}">活动内容</th>
				<th lay-data="{field:'tool',width:'250',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list activityList as act>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}">${act.id?c}</td>
						<td>${act.id?c}</td>
						<td>${act.activityId}</td>
						<td>${act.activityName}</td>
						<td>
							<#if act.activityStartTime?datetime gt .now?datetime>
								招募中
							<#elseif (act.activityStartTime?datetime lt .now?datetime)&&(act.activityFinishTime?datetime gt .now?datetime) >
								进行中
							<#elseif act.activityFinishTime?datetime lt .now?datetime>
								已结束
							</#if>
						</td>
						<td>${act.activityAssoName}</td>
						<td>${act.activityOrganizerName}</td>
						<td>${act.activityNum?c}</td>
						<td>${act.activityPartNum?c}</td>
						<td>${act.activityStartTime?date}</td>
						<td>${act.activityFinishTime?date}</td>
						<td>${act.activityIntro}</td>
						<td>
							<#if act.activityStatus==0>
								<a href="${base}/assoAct/updateActivityStatusOpen?id=${act.id?c}" class="layui-btn layui-btn-xs layui-btn-warm" lay-event="edit">开启活动</a>
							<#elseif act.activityStatus==1>
								<a href="${base}/assoAct/updateActivityStatusClose?id=${act.id?c}" class="layui-btn layui-btn-xs layui-btn-danger" lay-event="edit">关闭活动</a>
							<#else>
								<a href="#" enable class="layui-btn layui-btn-xs layui-btn-disabled" lay-event="edit">活动已结束</a>
							</#if>
		  					
		  					
		  					<a href="${base}/assoAct/toActEditForm?id=${act.id?c}" class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		  					<a href="${base}/assoAct/deleteActivityOneById?id=${act.id?c}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
    		<a href="${base}/assoAct/toActAddForm"><button class="layui-btn layui-btn-sm" lay-event="getCheckLength">添加活动</button></a>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('AssoStuTable',{
			  height:450,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  //头工具栏事件
		  table.on('toolbar(AssoStuTable)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
		    switch(obj.event){
		      case 'getDeleteList':
		        var data = checkStatus.data;
		        var idList=[]
		        for(var item of data){
		        	idList.push(item.id)
		        };
		        layer.confirm('确认删除选中数据', function(index){
		        	$.ajax({
				    	  "url" : "${base}/feign/assoAct/deleteActListById",
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
				    				                 href: '${base}/assoAct/toActTable'
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
				    				                 href: '${base}/assoAct/toActTable'
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
					    	  "url" : "${base}/asso/setCheckedAssoList",
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
					    				                 href: '${base}/assoAct/toActTable'
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
					    				                 href: '${base}/assoAct/toActTable'
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