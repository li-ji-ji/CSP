<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改地区信息</title>
<link rel="stylesheet"
	href="${base}/admin/lib/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>修改地区信息</legend>
		</fieldset>

		<form class="layui-form" name="region2" action="" lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if region2[0].id != 0> <label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${region2[0].id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地区名字</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="title"
						value="${region2[0].name}" autocomplete="off"
						placeholder="请输入文件Key" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">父ID</label>
				<div class="layui-input-block">
					<input type="text" name="parentId" lay-verify="title"
						value="${region2[0].parentId}" autocomplete="off"
						placeholder="请输入父ID" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">等级</label>
				<div class="layui-input-block">
					<input type="text" name="level" lay-verify="title"
						value="${region2[0].level}" autocomplete="off"
						placeholder="请输入等级" class="layui-input">
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
		<script src="${base}/admin/lib/layui/layui.js"
			charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui
					.use(
							[ 'form', 'layedit', 'upload' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, upload = layui.upload;
								//表单初始赋值

								//自定义验证规则
								form.verify({
									title : function(value) {
										if (value.length < 1) {
											return '标题至少得1个字符啊';
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
																					url : '${base}/api/region2/update',
																					method : 'post',
																					contentType : "application/json;charset=UTF-8",
																					data : JSON
																							.stringify(data.field),
																					dataType : 'json',
																				});
																		var link = '${base}/region2/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>