<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>打印机信息管理</title>
<link rel="stylesheet"
	href="${request.contextPath}/js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑打印机信息</legend>
		</fieldset>

		<form class="layui-form" name="printer" action="" lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline"></div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">打印店名字</label>
				<div class="layui-input-block">
					<input type="text" name="printShopName" lay-verify="title" value=""
						autocomplete="off" placeholder="请输入打印店名字" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">打印机名字</label>
				<div class="layui-input-block">
					<input type="text" name="printName" lay-verify="title" value=""
						autocomplete="off" placeholder="请输入打印机名字" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<input type="radio" name="status" value="正在运营" title="正在运营" checked="">
					<input type="radio" name="status" value="未运营" title="未运营">
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