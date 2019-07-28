<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>学校管理</title>
<link rel="stylesheet"
	href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="AssoStuTable" lay-filter="AssoStuTable">
		<!-- 表头 -->
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'100',fixed:'left',align:'center'}">ID</th>
				<th lay-data="{field:'schoolNo',width:'100',fixed:'left',align:'center'}">学校编号</th>
				<th lay-data="{field:'schoolName',width:'150',fixed:'left',align:'center'}">学校名称</th>
				<th lay-data="{field:'schoolAddress',width:'150',align:'center'}">学校所在省市</th>
				<th lay-data="{field:'schoolAddressProvince',width:'150',align:'center'}">学校所在省份</th>
				<th lay-data="{field:'schoolAddressProvinceId',width:'150',align:'center'}">学校所在省份编号</th>
				<th lay-data="{field:'schoolAddressCity',width:'150',align:'center'}">学校所在城市</th>
				<th lay-data="{field:'schoolAddressCityId',width:'150',align:'center'}">学校所在城市编号</th>
				<th lay-data="{field:'tool',width:'200',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list schoolList as school>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}">${school.id}</td>
						<td>${school.id}</td>
						<td>${school.schoolNo}</td>
						<td>${school.schoolName}</td>
						<td>${school.schoolAddress}</td>
						<td>${school.schoolAddressProvince}</td>
						<td>${school.schoolAddressProvinceId}</td>
						<td>${school.schoolAddressCity}</td>
						<td>${school.schoolAddressCityId}</td>
						<td>
		  					<a href="${base}/csp/schoolUnit/toUnitOfSchoolTable?schoolNo=${school.schoolNo}" class="layui-btn layui-btn-xs" lay-event="edit">查看附属部门</a>
		  					<a href="${base}/csp/assoSchool/toEditForm?id=${school.id}" class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		  					<a href="${base}/csp/assoSchool/deleteOneFromTable?id=${school.id}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
    		<a href="${base}/csp/assoSchool/toAddSchool"><button class="layui-btn layui-btn-sm" lay-event="getCheckLength">添加学校</button></a>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('AssoStuTable',{
			  height:500,
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
				    	  "url" : "${base}/csp/assoSchool/deleteSchoolList",
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
				    				                 href: '${base}/csp/assoSchool/toSchoolTbale'
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
				    				                 href: '${base}/csp/assoSchool/toSchoolTbale'
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
					    				                 href: '${base}/csp/assoStu/toStuTable'
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
					    				                 href: '${base}/csp/assoStu/toStuTable'
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