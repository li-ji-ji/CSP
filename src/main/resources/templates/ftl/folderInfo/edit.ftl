<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件夹管理</title>
<link rel="stylesheet" href="../../js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑文件夹信息</legend>
		</fieldset>

		<form class="layui-form" name="folderInfo" action=""
			lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if folderInfo.id != 0> <label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${folderInfo.id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">文件夹名字</label>
					<div class="layui-input-inline" value="">
						<input type="text" name="name" lay-verify="title"
							value="${folderInfo.name}" autocomplete="off"
							placeholder="请输入文件夹名字" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">文件夹图标</label>
					<div class="layui-input-block">
						<input type="text" name="icon" lay-verify="title"
							value="${folderInfo.icon}" autocomplete="off"
							placeholder="请输入文件夹图标" class="layui-input">
					</div>
				</div>

			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">文件夹id</label>
					<div class="layui-input-block">
						<input type="text" name="fid" lay-verify="title"
							value="${folderInfo.fid}" autocomplete="off"
							placeholder="请输入文件文件夹id" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>

		<script src="../../js/jquery-3.3.1.js"></script>
		<script src="../../js/plugins/layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui
					.use(
							[ 'form', 'layedit', 'laydate' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
								//日期
								laydate.render({
									elem : '#date',
									type : 'datetime'
								});
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
																					url : '${request.contextPath}/folderinfo/list?operation=${operation}',
																					method : 'post',
																					data : data.field,
																					dataType : 'JSON',
																				});
																		var link = '${request.contextPath}/folderinfo/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>