<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>地区信息管理</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑地区信息</legend>
		</fieldset>

		<form class="layui-form" name="region2" action="" lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline"></div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地区名字</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="title" value=""
						autocomplete="off" placeholder="请输入地区名字" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">父Id</label>
				<div class="layui-input-block">
					<input type="text" name="parentId" lay-verify="title" value=""
						autocomplete="off" placeholder="请输入父Id" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">等级</label>
				<div class="layui-input-block">
					<input type="text" name="level" lay-verify="title" value=""
						autocomplete="off" placeholder="请输入等级" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>

		<script src="${base}/admin/js/jquery.min.js"></script>
		<script src="${base}/admin/lib/layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui
					.use(
							[ 'form', 'layedit', 'upload' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, upload = layui.upload;
								//表单初始赋值
								//指定允许上传的文件类型

								//自定义验证规则
								form.verify({
									title : function(value) {
										if (value.length < 1) {
											return '至少得1个字符啊';
										}
									}
								});
								//监听提交
								form
										.on(
												'submit(demo)',
												function(data) {
													layer
															.confirm(
																	'真的提交么',
																	function(
																			index) {
																		$
																				.ajax({
																					url : '${request.contextPath}/api/printer/insert',
																					method : 'post',
																					contentType : "application/json;charset=UTF-8",
																					data : JSON
																							.stringify(data.field),
																					dataType : 'json',
																				});
																		var link = '${request.contextPath}/printerinfo/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>