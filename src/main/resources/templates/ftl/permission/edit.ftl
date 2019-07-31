<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>权限编辑</title>
   <link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
<style type="text/css">
.reset {
	margin-left: 60px;
	height: 40px;
	width: 50px;
	font-size: 20px;
	text-align: center;
	height: 40px;
}

.submit {
	margin-left: 100px;
	height: 40px;
	width: 100px;
	font-size: 20px;
	text-align: center;
	height: 40px;
}
</style>
</head>

<body>
	<form class="layui-form" action="/authority/permission/onedit" method="post">
		<input type="hidden" name="id" value="${(sysPermission.id)!}" />
		<div class="layui-form-item">
			<label class="layui-form-label">可获得</label>
			<div class="layui-input-block">
				<input type="text" name="available" required lay-verify="required"
					placeholder="是否可获得" autocomplete="off" class="layui-input"
					value="${((sysPermission.available)?string("1","0"))! }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" required lay-verify="required"
					placeholder="名称" autocomplete="off" class="layui-input"
					value="${(sysPermission.name)! }">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">父类id</label>
				<div class="layui-input-inline">
					<input type="text" name="parentId" required lay-verify="required"
						autocomplete="off" class="layui-input"
						value="${(sysPermission.parentId)!}" placeholder="父类id">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">父类ids</label>
				<div class="layui-input-inline">
					<input type="text" name="parentIds" required lay-verify="required"
						autocomplete="off" class="layui-input"
						value="${(sysPermission.parentIds)! }" placeholder="父类ids">
				</div>
			</div>
		</div>	
		<div class="layui-form-item">
			<label class="layui-form-label">权限</label>
			<div class="layui-input-block">
				<input type="text" name="permission" required
					lay-verify="required" placeholder="权限" autocomplete="off"
					class="layui-input" value="${(sysPermission.permission)! }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">资源类型</label>
			<div class="layui-input-block">
				<input type="text" name="resourceType" required
					lay-verify="required" placeholder="资源类型" autocomplete="off"
					class="layui-input" value="${(sysPermission.resourceType)! }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">url</label>
			<div class="layui-input-block">
				<input type="text" name="url" required lay-verify="required"
					placeholder="url" autocomplete="off" class="layui-input"
					value="${(sysPermission.url)! }">
			</div>
		</div>
		<input type="submit" class="submit" value="提交" /> <input type="reset"
			class="reset" value="重置" />
	</form>

	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;
			//çå¬æäº¤
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));
				return false;
			});
		});
	</script>
	<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#editor_id');
		});
	</script>
</body>

</html>