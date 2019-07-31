<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>添加子地区</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">

</head>
<body>
<body>

	<form class="layui-form" action="/region/add" style="margin-top: 20px;">
   
 
		<div class="layui-form-item">
			<label class="layui-form-label">新增地区名 </label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="name" name="name" 
					lay-verify="title" autocomplete="off" 
					class="layui-input">
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">所属地区</label>
			<div class="layui-input-block" id="parentName" style="width: 50%;">
				 <input type="text" id="parentName" name="parentName" value="${region.name}"
					lay-verify="title" autocomplete="off" readonly="readonly" 
					class="layui-input"> 
				
			</div>
		</div>
		
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">所属地区ID</label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="parentId" name="parentId" value="${region.id?c}"
					lay-verify="title" autocomplete="off"  readonly="readonly" 
					class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">地区等级</label>
			<div class="layui-input-block" style="width: 50%;">
				<input type="text" id="level" name="level" value="${region.level+1}"
					lay-verify="title" autocomplete="off"  readonly="readonly" 
					class="layui-input">
			</div>
		</div>


		

		

		<div class="layui-form-item">
			<div class="layui-input-block">
				<a>
					<button type="submit" class="layui-btn" >完成添加</button>
				</a>
				
			</div>
		</div>
	</form>
	
	<script src="${base}/js/jquery-3.3.1.js"></script>
	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script src="${base}/js/plugins/layui/layui.all.js"></script>
	
	
</body>
</html>