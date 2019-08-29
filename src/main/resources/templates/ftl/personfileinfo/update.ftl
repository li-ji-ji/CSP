<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人文件信息管理</title>
<link rel="stylesheet"
	href="${request.contextPath}/js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑个人文件信息</legend>
		</fieldset>

		<form class="layui-form" name="personFileInfo" action=""
			lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${personFileInfo.id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">学生ID</label>
				<div class="layui-input-block">
					<input type="text" name="studentId" lay-verify="title"
						value="${personFileInfo.studentId}" autocomplete="off"
						placeholder="请输入学生ID" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件图片</label>
				<div class="layui-input-block">
					<input type="text" name="fileImage" lay-verify="title"
						value="${personFileInfo.fileImage}" autocomplete="off"
						placeholder="请输入文件图片" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件名字</label>
				<div class="layui-input-block">
					<input type="text" name="fileName" lay-verify="title"
						value="${personFileInfo.fileName}" autocomplete="off"
						placeholder="请输入文件名字" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">路径</label>
				<div class="layui-input-block">
					<input type="text" name="path" lay-verify="title"
						value="${personFileInfo.path}" autocomplete="off"
						placeholder="请输入路径" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">下单时间</label>
				<div class="layui-input-inline">
					<input type="text" name="time" id="date" lay-verify="datetime"
						value="${personFileInfo.time}" class="layui-input"
						placeholder="yyyy-MM-dd 00:00:00">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件大小</label>
				<div class="layui-input-block">
					<input type="text" name="fileSize" lay-verify="title"
						value="${personFileInfo.fileSize}" autocomplete="off"
						placeholder="请输入文件大小" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件页数</label>
				<div class="layui-input-block">
					<input type="text" name="page" lay-verify="title"
						value="${personFileInfo.page}" autocomplete="off"
						placeholder="请输入文件页数" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<#if personFileInfo.status == "true"> <input type="radio"
						name="status" value="true" title="上传成功" checked=""> <input
						type="radio" name="status" value="falue" title="上传失败">
					<#elseif personFileInfo.status == "falue"> <input type="radio"
						name="status" value="true" title="上传成功"> <input
						type="radio" name="status" value="falue" title="上传失败" checked="">
					<#else> <input type="radio" name="status" value="true" title="上传成功"
						checked=""> <input type="radio" name="status" value="falue"
						title="上传失败"> </#if>
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
							[ 'form', 'layedit', 'upload', 'laydate' ],
							function() {
								var laydate = layui.laydate, form = layui.form, layer = layui.layer, layedit = layui.layedit, upload = layui.upload;
								//表单初始赋值

								//自定义验证规则
								form.verify({
									title : function(value) {
										if (value.length < 1) {
											return '标题至少得1个字符啊';
										}
									}
								});
								//日期
								laydate.render({
									elem : '#date',
									type : 'datetime'
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
																					url : '${request.contextPath}/api/personFileInfo/update',
																					method : 'post',
																					contentType : "application/json;charset=UTF-8",
																					data : JSON
																							.stringify(data.field),
																					dataType : 'json',
																				});
																		var link = '${request.contextPath}/personFileInfo/list';
																		window.location.href = link;
																	});
													return false;
												});
							});
		</script>
</body>
</html>