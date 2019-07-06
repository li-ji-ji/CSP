<!DOCTYPE html>
<html>
<script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="../../js/plugins/layui/css/layui.css" media="all">
</head>
<body>
	<table id="MsgTable" lay-filter="MsgTable"></table>

	
	<script src="../../js/plugins/layui/layui.js"></script>
	<script type="text/html" id="editTool">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">保存修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script type="text/javascript">
	/* 废弃列渲染
	//定义对象
	colsData=new Array
	$.ajax({
    	"url" :"http://192.168.1.126:8007/getColumnName",<!--//http://92.68.10.110:8080/PageConfig/delPageConfigById-->
    	"data" : "",
    	"type" : "get",
    	"dataType" : "json",
    	"success" : function (returnMsg) {
    		//console.log(returnMsg)
    		for(var index in returnMsg){
    			colsDataItem={
    				field:"",
    				title:"",
    				minWidth:150,
    				sort:true,
    				edit: 'text'
    			}
    			//console.log("每一层JSON:")
    			//console.log(returnMsg[index])
    			
    			if(returnMsg[index].column_name=="icon_open"){
    				colsDataItem["field"]="iconOpen"
    			}
    			else if(returnMsg[index].column_name=="icon_close"){
    				colsDataItem["field"]="iconClose"
    			}
    			else{
        			colsDataItem["field"]=returnMsg[index].column_name
    			}
    			colsDataItem["title"]=returnMsg[index].column_comment
    			//console.log("打印出每个对象")
    			//console.log(colsDataItem)//打印对象
    			colsData[index]=colsDataItem
    			if(colsData[index].field=="inserturl"||
    					colsData[index].field=="deleteurl"||
    					colsData[index].field=="selecturl"||
    					colsData[index].field=="updateurl"){
    					colsData[index].hide=true
    			}
                //console.log(colsData[index])
    		}
            //console.log("打印出对象数组:")
            colsData[0].fixed="left"
            colsData[0].width=80
            colsData.push({fixed: 'right', width:200, align:'center',toolbar: '#editTool'})
            console.log(colsData)
		}
    }) */
	</script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
		layui.use('table', function(){
			  form = layui.form;
			  var table = layui.table;
			  table.render({
				    elem: '#MsgTable'
				    ,MinHeight: 500
				    ,url: 'http://192.168.1.126:8004/feign/adminMenu/getAllToLayUI' //数据接口
				    ,page: true //开启分页
				    ,cols: [[//表头
				  		{field: "id", title: "菜单ID", align: "center",width: 90, sort: true, edit: "text"}
				    	,{field: "name", title: "菜单名称",align: "center", width: 120, sort: true, edit: "text"}
				    	,{field: "pId", title: "父级菜单ID",align: "center", width: 120, sort: true, edit: "text"}
				    	,{field: "pId", title: "父级菜单名称",align: "center", width: 120, sort: true, edit: "text"}
				    	,{field: "mainurl", title: "菜单跳转页面链接",align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "icon", title: "终极菜单图标",align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "iconOpen", title: "非终极菜单开启图标",align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "iconClose", title: "非终极菜单关闭图标",align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "fong_css", title: "菜单字体样式",align: "center", width: 150, sort: true, edit: "text"}
				    	,{fixed: "right", width: 200, align: "center", toolbar: "#editTool"}
				    ]]
				  });
			  //表格重载
			  /* table.reload('idTest', {
  				url: getListUrl
  				,where: {} //设定异步数据接口的额外参数
  				//,height: 300
			  }); */
			  //监听表格复选框选择
			  table.on('checkbox(MsgTable)', function(obj){
			    //console.log(obj)
			  });
			  //监听启用状态操作
			  form.on('switch(statusCheck)', function(status_data){
				//console.log(status_data.elem);
			  	//console.log("获取父元素：");
			  	statu=0; //声明全局变量statu表示状态值
			  	if(status_data.elem.checked==true){
			  		statu=1;
			  	}else{
			  		statu=0;
			  	}
			    //console.log(status_data.elem.id);
			  });
			  //监听工具条
			  table.on('tool(MsgTable)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			      layer.msg('ID：'+ data.id + ' 的查看操作');
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        //console.log(data); //输出此行数据
			        $.ajax({
			        	"url" : "http://192.168.1.126:8004/feign/adminMenu/delById",
			        	"data" : "id="+data.id,
			        	"type" : "post",
			        	"dataType" : "text",
			        	"success" : function (returnMsg) {
							if(returnMsg==1){
								layer.alert("删除成功");
			        			obj.del();
							}else{
								layer.alert("删除失败");
							}
						}
			        })
			        layer.close(index);
			        
			      });
			    } else if(obj.event === 'edit'){
			      //data.status=statu;
			      //console.log("更改后的数据"+data.status);
			      //console.log(data);
			      json=JSON.stringify(data);
			      
			      $.ajax({
			    	  "url" : "http://192.168.1.126:8004/feign/adminMenu/updateOne",
			    	  "data" : "menu="+json,
			    	  "type" : "post",
			    	  "dataType" : "json",
			    	  "success"	: function (resultMsg) {
	    			  layer.open({
	    				    type: 1 //不显示标题栏   title : false/标题
	    				    ,title: "修改成功，返回菜单"
	    				    ,closeBtn: false
	    				    ,area: '300px;'
	    				    ,shade: 0.8
	    				    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	    				    ,resize: false
	    				    ,btn: ['好的']
	    				    ,btnAlign: 'c'
	    				    ,moveType: 1 //拖拽模式，0或者1
	    				    ,success: function(layero){
	    				    }
	    				});
					}
			      });
			      
			    }
			  });
			  
			  var $ = layui.$, active = {
			    getCheckData: function(){ //获取选中数据
			      var checkStatus = table.checkStatus('idTest')
			      ,data = checkStatus.data;
			      layer.alert(JSON.stringify(data));
			    }
			    ,getCheckLength: function(){ //获取选中数目
			      var checkStatus = table.checkStatus('idTest')
			      ,data = checkStatus.data;
			      layer.msg('选中了：'+ data.length + ' 个');
			    }
			    ,isAll: function(){ //验证是否全选
			      var checkStatus = table.checkStatus('idTest');
			      layer.msg(checkStatus.isAll ? '全选': '未全选')
			    }
			  };
			  
			  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			});
	</script>
	<script type="text/html" id="status_switch">
	<!--菜单状态显示-->
  		<input type="checkbox" id="{{d.id}}"  name="status" value="{{d.status}}" lay-skin="switch" lay-text="启用|停用" lay-filter="statusCheck" {{ d.status == false ? 'checked' : '' }}>
	</script>
</body>
</html>