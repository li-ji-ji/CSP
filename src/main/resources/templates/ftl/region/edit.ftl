<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>修改地域</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">

</head>
<body>
<body>

	<form class="layui-form" action="/region/edit" style="margin-top: 20px;">
	<#if region.id gt 0>
		<input type="hidden" name="id" value="${region.id?c}">
	</#if>
   
 
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">ID</label>
				<div class="layui-input-inline" >
					<input type="text" name="id" value="${region.id?c}" id="id"
						readonly="readonly" lay-verify="title" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地区 </label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="name" name="name" value="${region.name}"
					lay-verify="title" autocomplete="off" 
					class="layui-input">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">所属地区</label>
			<div class="layui-input-block" id="parentName" style="width: 50%;">
				<!-- <input type="text" id="parentName" name="parentName" value="${region.parentName}"
					lay-verify="title" autocomplete="off" 
					class="layui-input"> -->
				<select name="parentName"  lay-filter="aihao" lay-search >
				<option value="${region.parentId?c}"  label="${region.level-1}" disabled selected >当前所属地区:${region.parentName}</option>
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
				<input type="text" id="parentId" name="parentId" value="${region.parentId?c}"
					lay-verify="title" autocomplete="off"  readonly="readonly" 
					class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">地区等级</label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="level" name="level" value="${region.level}"
					lay-verify="title" autocomplete="off"  readonly="readonly" 
					class="layui-input">
			</div>
		</div>


		

		

		<div class="layui-form-item">
			<div class="layui-input-block">
				<a>
					<button type="submit" class="layui-btn" >保存修改</button>
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