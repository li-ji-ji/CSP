<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>地域管理</title>
  <link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body>
<div style="margin-top: 15px;margin-left: 1%;">
    <span style="font-weight: bold;">地区搜索：</span>
    <div style="height: 10px;"></div>
    <span>
    	<input type="text" class="layui-input-inline" style="height:20px;"  id="sear1" placeholder="请输入地区进行模糊查询"/>
    </span>
    <span>
    	<button type="button" class="layui-btn layui-bg-cyan layui-btn-xs" style="width:80px;font-weight: bold;" onclick="serach()">
  			搜一哈
		</button>
	</span>
	

	


</div>
<script src="${base}/js/jquery-3.3.1.js"></script>
<script src="${base}/js/plugins/layui/layui.js"></script>
<script src="${base}/js/plugins/layui/layui.all.js"></script>

<div class="layui-card-body">
    <table class="layui-hide" id="test" lay-filter="demo"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看子地区</a>
  <a class="layui-btn layui-btn-warm layui-btn-xs"  lay-event="add">添加子地区</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编  辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删  除</a>
</script>

<script type="text/html" id="toolbar">
	<a href="${base}/region/toedit?operation=addany" class="layui-btn">添加地区</a>
</script>


<script>
layui.use('table', function(){
    var kw='${base}/feign/region/areaParent';
    addData(kw);
});

function addData(kwx){
	
    var table = layui.table, form = layui.form;
	table.on('checkbox(demo)', function(obj) {
		console.log(obj)
	});
    table.render({
        elem: '#test'
        ,height: 515
        ,url: kwx//数据接口
        ,page: true //开启分页
        ,toolbar: '#toolbar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,cols: [[ //表头
         {type: 'checkbox', fixed: 'left'}
          ,{field: 'id', title: 'ID', width:180, sort: true, fixed: 'left'}
          ,{field: 'name', title: '地区', width:180}
          ,{field: 'parentName', title: '所属地区', width:180, sort: true}
          ,{field: 'level', title: '地区等级', width:180, sort: true} 
          ,{title: '操作栏', fixed: 'right',  align:'center', toolbar: '#barDemo'}
        ]]
    	,done:function(res, curr, count){
        //数据的回调用，可不写
      	}

      });
    
    table.on('tool(demo)',
			function(obj) {
				var data = obj.data;
				if (obj.event === 'edit') {
					var id = data['id'];
					
					var link = "${base}/region/toedit?operation=edit&id="+ id;
					window.location.href = link;
				} 
				
				else if(obj.event === 'detail'){
					var id = data['id'];
					var link = "${base}/feign/region/areaParamJSON2?id="+ id;
					addData(link);
				}
				
				else if(obj.event === 'add'){
					var id = data['id'];
					
					var link = "${base}/region/toedit?operation=add&id="+ id;
					window.location.href = link;
				}
				
				else if(obj.event === 'del'){
					var id = data['id'];
					
					var link = "${base}/region/delete?id="+ id;
					layer.confirm('其所有子地区将会一并删除,真的要删除吗？', function(index){
						 var link = "${base}/region/delete?id="+ id;
						window.location.href = link;  
						layer.msg('删除成功'); 
						/* layer.msg('对不起，您没有权限，删除无效');  */
				      });
					
				}
				
				
			});
    
    
}
    $("#sear1").keyup(function(event){
            if(event.keyCode ==13){
             var keyWord=$("#sear1").val();
             var url="${base}/feign/region/areaParamJSON?keyWord="+keyWord
                addData(url);
            }
        });
    
    function serach(){
    	 var keyWord=$("#sear1").val();
         var url="${base}/feign/region/areaParamJSON?keyWord="+keyWord
         addData(url);
    }


</script>
</body>
</html>