<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>添加地域</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">

</head>
<body>
<body>

	<form class="layui-form" action="${base}/region/add" style="margin-top: 20px;">
	
   
 
		
		<div class="layui-form-item">
			<label class="layui-form-label">地区 </label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="name" name="name" 
					lay-verify="title" autocomplete="off" 
					class="layui-input">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">所属地区</label>
			<div class="layui-input-block" id="parentName" style="width: 50%;">
				
				<select name="parentName"  lay-filter="aihao" lay-search >
				<option value="0" label="0">中国</option>
				<#list regions as item>
					<option value="${item.id?c}" label="${item.level}">${item.name}</option>
				</#list>
				</select>
			</div>
		</div>
		
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">所属地区ID</label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="parentId" name="parentId" value="0"
					lay-verify="title" autocomplete="off"  readonly="readonly" 
					class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">地区等级</label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="level" name="level" value="1"
					lay-verify="title" autocomplete="off"  readonly="readonly" 
					class="layui-input">
			</div>
		</div>


		

		

		<div class="layui-form-item">
			<div class="layui-input-block">
				<a>
					<button type="submit" class="layui-btn" >完成添加</button>
				</a>
				<button onclick="resetPid()" type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	
	<script src="${base}/js/jquery-3.3.1.js"></script>
	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script src="${base}/js/plugins/layui/layui.all.js"></script>
	
	<script type="text/javascript">
	//输入框获取焦点清空
	$("#parentName input").focus(function(){
		$("#parentName input").attr("value","")
	})
	function resetPid(data){
		  $("#parentId").attr("value",$("#parentName option:first ").val())
		  var level=parseInt($("#parentName option:first ").attr("label"))
		  $("#level").attr("value",level+1)
		  
		  
		  
	}
	
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('select(aihao)', function(data){
			  //根据parentName绑定parentId
			  $("#parentId").attr("value",data.value)
			  
			  var level=parseInt($("#parentName select").find("option:selected").attr("label"))
			  $("#level").attr("value",level+1)
			  
		  })
		});
	</script>
	
</body>
</html>