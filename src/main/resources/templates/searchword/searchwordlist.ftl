<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索关键词管理</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/admin/js/jquery.min.js"></script>
</head>
<body class="layui-layout-body">

	<div style="margin-top: 15px;margin-left: 1%;">
	    <span style="font-weight: bold;">请选择搜索类型：</span>
	    <select id="taskType">
  			<option value="keywords" selected="selected">关键词</option>
			<option value="pinyinFull">拼音全拼</option>
			<option value="pinyinSimple">拼音简写</option> 
		</select> 
	    <div style="height: 10px;"></div>
	    <span>
	    	<input type="text" class="layui-input-inline" style="height:20px;"  id="sear1" placeholder="请输入搜索内容"/>
	    </span>
	    <span>
	    	<button type="button" id="searchbutton" value="keywords" class="layui-btn layui-bg-cyan layui-btn-xs" style="width:80px;font-weight: bold;" onclick="serach()">
	  			搜一哈
			</button>
		</span>
		
	</div>

	<table class="layui-table"  id="SearchWordTable" lay-filter="SearchWordTable">
		<!-- 表头 -->
		
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'150',fixed:'left',align:'center',sort:'true'}">搜索关键词ID</th>
				<th lay-data="{field:'keywords',width:'250',align:'center',edit:'true'}">关键词</th>
				<th lay-data="{field:'pinyinFull',width:'150',align:'center',edit:'true'}">拼音全拼</th>
				<th lay-data="{field:'pinyinSimple',width:'150',align:'center',edit:'true'}">拼音简写</th>
				<th lay-data="{field:'searchNum',width:'100',align:'center',sort:'true'}">搜索次数</th>
				<th lay-data="{field:'goodsNum',width:'100',align:'center',sort:'true'}">商品数量</th>
				<th lay-data="{field:'tool',width:'200',fixed:'right',align:'center'}">操作</th>
			</tr>
			<tbody>
				<#list searchWords as searchWord>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}"></td>
						<td>${searchWord.id}</td>
						<td>${searchWord.keywords}</td>
						<td>${searchWord.pinyinFull}</td>
						<td>${searchWord.pinyinSimple}</td>
						<td>${searchWord.searchNum}</td>
						<td>${searchWord.goodsNum}</td>
						<td>
		  					<a href="/searchword/toSearchWordEdit?id=${searchWord.id}" class="layui-btn layui-btn-xs" ><i class="layui-icon " >&#xe642;</i>编辑</a>
		  					<a href="/searchword/deleteSearchWord?id=${searchWord.id}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" ><i class="layui-icon " >&#xe640;</i>删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/admin/lib/layui/layui.all.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
			<a href="/searchword/toSearchWordAdd"><button type="button" class="layui-btn layui-btn-radius layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe61f;</i> 新增搜索关键词</button></a>
			<button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-sm" lay-event="getDeleteList"><i class="layui-icon " >&#xe640;</i>删除选中数据</button>
			<a href="/searchword/toSearchWordList"><i class="layui-icon " style="color: #3CB371;">&#xe9aa;</i></a>
  		</div>
	</script>

	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table,form = layui.form;
		  table.init('SearchWordTable',{
			  height:500,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  
		  
		  //监听单元格编辑
	      table.on('edit(SearchWordTable)', function (obj) {
	    	var old=$(this).prev().text();
	        var value = obj.value //得到修改后的值
	          ,
	          data = obj.data //得到所在行所有键值
	          ,
	          field = obj.field; //得到字段
	          
	          if(field=="keywords"&&value==""){//排序验证
	        		  layer.msg("关键词不能为空!")
	        		  $(this).val(old);
	        		  return false;
	          }
	          
	          
	        var strData = '{"id":' + data.id + ',"' + field + '":"' + value + '"}';
	        var upData = JSON.parse(strData);
	        $.ajax({
	          type: 'post',
	          url: '/api/updateSearchWord',
	          data: upData,
	          success: function (obj) {
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
	      
	      
	     
		  
		  
		  
		  table.on('toolbar(SearchWordTable)', function(obj){
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
					    	  "url" : "/api/batchDeleteSearchWord",
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
	
    
    
	
    $('#taskType').change(function(){
		$('option[value='+this.value+']').attr("selected","selected").siblings().removeAttr("selected")
		$('#searchbutton').attr("value",$('#taskType option:selected').val())
    });
    
    $("#sear1").keyup(function(event){//监听键盘回车
        if(event.keyCode ==13){
         var field = $('#searchbutton').attr("value")
         var content=$("#sear1").val();
         var url="/searchword/findSearchWordByFieldLike?field="+field+"&content="+content
         window.location.href = url;  
        }
    });
    
    function serach(){
   	 var field = $('#searchbutton').attr("value")
   	 var content=$("#sear1").val();
     var url="/searchword/findSearchWordByFieldLike?field="+field+"&content="+content
     window.location.href = url;
   }
    
    
	
	</script>
</body>
</html>