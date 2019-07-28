<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body>
	<table id="MsgTable" lay-filter="MsgTable"></table>
	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/html" id="editTool">
		<!-- 工具栏 -->
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="toChild">查看下级菜单</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">保存修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="isHiddenCheck">
  		<!-- 启用状态CheckBox -->
  		<input type="checkbox" name="isHidden" id="{{d.id}}" value="{{d.isHidden}}" title="启用" lay-filter="isHiddenCheck" {{ d.isHidden == 1 ? 'checked' : '' }}>
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
		layui.use(['table','laypage','layer'] ,function(){
			  form = layui.form;
			  var table = layui.table;
			  var laypage = layui.laypage;
			  var $ = layui.jquery, layer = layui.layer;
			  table.render({
				    elem: '#MsgTable'
				    ,MinHeight: 500
				    ,url: '${base}/feign/adminMenu/getMenuLimit' //数据接口
				    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
				        layout: [ 'count', 'prev', 'page', 'next', 'skip','limit'] //自定义分页布局
				      //,curr: 5 //设定初始在第 5 页
				      ,groups: 5 //只显示 1 个连续页码
				      ,first: false //不显示首页
				      ,last: false //不显示尾页
				      
				    }//开启分页 */
				    ,cols: [[//表头
				  		{field: "id", title: "菜单ID",fixed:"left", align: "center",width: 90, sort: true}
				    	,{field: "name", title: "菜单名称",fixed:"left", align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "pId", title: "父级菜单ID",align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "pName", title: "父级菜单名称",align: "center", width: 150, sort: true}
				    	,{field:"isHidden", title:'是否启用', width:120, templet: '#isHiddenCheck', unresize: true}
				    	,{field: "mainurl", title: "菜单跳转页面链接",align: "center", width: 180, sort: true, edit: "text"}
				    	,{field: "icon", title: "终极菜单图标",align: "center", width: 150, sort: true, edit: "text"}
				    	,{field: "iconOpen", title: "非终极菜单开启图标",align: "center", width: 200, sort: true, edit: "text"}
				    	,{field: "iconClose", title: "非终极菜单关闭图标",align: "center", width: 200, sort: true, edit: "text"}
				    	,{field: "fontCss", title: "菜单字体样式",align: "center", width: 150, sort: true, edit: "text"}
				    	,{fixed: "right",title: "操作栏", width: 300, align: "center", toolbar: "#editTool"}
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
			  //监听锁定操作
			  form.on('checkbox(isHiddenCheck)', function(obj){
			    //layer.tips(this.value + ' ' + this.id + '：'+ obj.elem.checked, obj.othis);
			    //console.log(this.id)
			    //console.log("打印选中状态")
			    //console.log(obj.elem.checked)
			    menu=new Object()
			    menu["id"]=this.id
			    if(obj.elem.checked==true){
			    	menu["isHidden"]=1
			    }
			    else{
			    	menu["isHidden"]=0
			    }
			    //console.log("打印菜单数据")
			    //console.log(menu)
			    json=JSON.stringify(menu)
			    //console.log(json)
			    $.ajax({
			    	  "url" : "${base}/feign/adminMenu/updateOne",
			    	  "data" : "menu="+json,
			    	  "type" : "post",
			    	  "dataType" : "json",
			    	  "success"	: function (resultMsg) {
			    		  if(resultMsg==1){
			    			  layer.open({
			    				    type: 1 //不显示标题栏   title : false/标题
			    				    ,title: "修改成功，返回菜单"
			    				    ,btn: ['好的']
			    				    ,btnAlign: 'c'
			    				    ,success: function(layero){
			    				         var btn = layero.find('.layui-layer-btn');
			    				            btn.find('.layui-layer-btn0').attr({
			    				                 href: '${base}/csp/admin/toTable'
			    				            ,target: '_self'
			    				        });
			    				    }
			    				});
			    		  }else{
			    			  layer.open({
			    				    type: 1 //不显示标题栏   title : false/标题
			    				    ,title: "修改失败，返回菜单"
			    				    ,btn: ['好的']
			    				    ,btnAlign: 'c'
			    				    ,success: function(layero){
			    				         var btn = layero.find('.layui-layer-btn');
			    				            btn.find('.layui-layer-btn0').attr({
			    				                 href: '${base}/csp/admin/toTable'
			    				            ,target: '_self'
			    				        });
			    				    }
			    				});
			    		  }
	    			  
					}
			      });
			  });
			  //监听工具条
			  table.on('tool(MsgTable)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'toChild'){
			      layer.msg("查看下级菜单");
			      table.reload('MsgTable', {
	      				url: "${base}/feign/adminMenu/getLayUIJSONByPid"
	      				,where: {
	      					pid:data.id
	      				} //设定异步数据接口的额外参数
	      				//,height: 300
	    			  }); 
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        //console.log(data); //输出此行数据
			        $.ajax({
			        	"url" : "${base}/feign/adminMenu/delById",
			        	"data" : "id="+data.id,
			        	"type" : "post",
			        	"dataType" : "text",
			        	"success" : function (returnMsg) {
							if(returnMsg==1){
								layer.open({
			    				    type: 1 //不显示标题栏   title : false/标题
			    				    ,title: "删除成功，返回菜单"
			    				    ,btn: ['好的']
			    				    ,btnAlign: 'c'
			    				    ,success: function(layero){
			    				         var btn = layero.find('.layui-layer-btn');
			    				            btn.find('.layui-layer-btn0').attr({
			    				                 href: '${base}/csp/admin/toTable'
			    				            ,target: '_self'
			    				        });
			    				    }
			    				});
			        			obj.del();
							}else{
				    			  layer.open({
				    				    type: 1 //不显示标题栏   title : false/标题
				    				    ,title: "删除失败，返回菜单"
				    				    ,btn: ['好的']
				    				    ,btnAlign: 'c'
				    				    ,success: function(layero){
				    				         var btn = layero.find('.layui-layer-btn');
				    				            btn.find('.layui-layer-btn0').attr({
				    				                 href: '${base}/csp/admin/toTable'
				    				            ,target: '_self'
				    				        });
				    				    }
				    				});
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
			    	  "url" : "${base}/feign/adminMenu/updateOne",
			    	  "data" : "menu="+json,
			    	  "type" : "post",
			    	  "dataType" : "json",
			    	  "success"	: function (resultMsg) {
	    			  layer.open({
	    				    type: 1 //不显示标题栏   title : false/标题
	    				    ,title: "修改成功，返回菜单"
	    				    ,btn: ['好的']
	    				    ,btnAlign: 'c'
	    				    ,success: function(layero){
	    				         var btn = layero.find('.layui-layer-btn');
	    				            btn.find('.layui-layer-btn0').attr({
	    				                 href: '${base}/csp/admin/toTable'
	    				            ,target: '_self'
	    				        });
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
</body>
</html>