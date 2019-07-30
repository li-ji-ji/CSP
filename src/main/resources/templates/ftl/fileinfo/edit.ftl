<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件管理</title>
<link rel="stylesheet" href="../../js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑文件信息</legend>
		</fieldset>

		<form class="layui-form" name="fileInfo" action=""
			lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if fileInfo.id != 0> <label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${fileInfo.id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-inline" value="">
						<select name="type" lay-verify="required" lay-search="">
							<option value="${fileInfo.type}">${fileInfo.type}</option>
							<option value="image">image</option>
							<option value="vedio">vedio</option>
							<option value="file">file</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">folderId</label>
					<div class="layui-input-block">
						<input type="text" name="folderId" lay-verify="title"
							value="${fileInfo.folderId}" autocomplete="off"
							placeholder="请输入文件夹ID" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">name</label>
					<div class="layui-input-block">
						<input type="text" name="name" lay-verify="title"
							value="${fileInfo.name}" autocomplete="off"
							placeholder="请输入文件name" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">Keyword</label>
				<div class="layui-input-block">
					<input type="text" name="keyword" lay-verify="title"
						value="${fileInfo.keyword}" autocomplete="off"
						placeholder="请输入文件Keyword" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文件描述</label>
				<div class="layui-input-block">
					<input type="text" name="description" lay-verify="title"
						value="${fileInfo.description}" autocomplete="off"
						placeholder="请输入文件描述" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">文件路径</label>
				<div class="layui-input-block">
					<input type="text" name="url" lay-verify="title"
						value="${fileInfo.url}" autocomplete="off" placeholder="请输入文件路径"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">日期</label>
					<div class="layui-input-inline">
						<input type="text" name="date" id="date" lay-verify="datetime"
							value="${fileInfo.date}" class="layui-input"
							placeholder="yyyy-MM-dd 00:00:00">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">文件大小</label>
					<div class="layui-input-inline">
						<input type="title" name="size" lay-verify="title"
							value="${fileInfo.size}" autocomplete="off" placeholder="请输入文件大小"
							class="layui-input">
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
																					url : '${request.contextPath}/fileinfo/list?operation=${operation}',
																					method : 'post',
																					data : data.field,
																					dataType : 'JSON'
																				});
																		var link = '${request.contextPath}/fileinfo/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>