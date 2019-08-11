<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>配置分类管理</title>
<link rel="stylesheet"
	href="${request.contextPath}/js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑配置分类信息</legend>
		</fieldset>

		<form class="layui-form" name="configCategory" action=""
			lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if configCategory.id != 0> <label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${configCategory.id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">配置分类名</label>
				<div class="layui-input-inline">
					<input type="text" name="name" lay-verify="title"
						value="${configCategory.name}" autocomplete="off"
						placeholder="请输入配置分类名" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>

		<script src="${request.contextPath}/js/jquery-3.3.1.js"></script>
		<script src="${request.contextPath}/js/plugins/layui/layui.js"
			charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui
					.use(
							[ 'form', 'layedit', 'upload' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, upload = layui.upload;
								//自定义验证规则
								form.verify({
									title : function(value) {
										if (value.length < 1) {
											return '标题至少得1个字符啊';
										}
									}
								});
								form
										.on(
												'select(dataType)',
												function(data) {
													var dataType = data.value;
													layer.msg(dataType);
													var link = '${request.contextPath}/config/edit?operation=insert&dataType='
															+ dataType;
													window.location.href = link;
												})
								//监听提交
								form
										.on(
												'submit(demo)',
												function(data) {
													var id = data.field.id;
													var name = data.field.name;
													layer
															.confirm(
																	'真的提交么',
																	function(
																			index) {
																		$
																				.ajax({
																					url : '${request.contextPath}/api/configCategory/edit?operation=${operation}&editid='
																							+ id+'&name='+name,
																					method : 'get',
																					data : '',
																				});
																		var link = '${request.contextPath}/configCategory/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>