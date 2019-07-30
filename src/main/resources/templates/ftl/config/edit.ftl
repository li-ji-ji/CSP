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
			<legend>编辑配置信息</legend>
		</fieldset>

		<form class="layui-form" name="config" action="" lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if config.id != 0> <label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${config.id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">数据类型</label>
					<div class="layui-input-inline">
						<select name="dataType" lay-verify="required"
							lay-filter="dataType" lay-search="">
							<option value="${config.dataType}">${config.dataType}</option>
							<option value="text">text</option>
							<option value="number">number</option>
							<option value="file">file</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-inline">
						<select name="type" lay-verify="required" lay-search="">
							<option value="${config.type}">${config.type}</option>
							<option value="系统配置">系统配置</option>
							<option value="网站配置">网站配置</option>
							<option value="邮件配置">邮件配置</option>
							<option value="短信配置">短信配置</option>
							<option value="腾讯云配置">腾讯云配置</option>
							<option value="微信支付配置">微信支付配置</option>
						</select>
					</div>
				</div>

			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">是否使用</label>
				<div class="layui-input-block">
				<#if config.enable == "使用">
					<input type="radio" name="enable" value="使用" title="使用" checked="">
					<input type="radio" name="enable" value="未使用" title="未使用">
				<#elseif config.enable == "未使用">
					<input type="radio" name="enable" value="使用" title="使用" >
					<input type="radio" name="enable" value="未使用" title="未使用" checked="">
				<#else>
					<input type="radio" name="enable" value="使用" title="使用" checked="">
					<input type="radio" name="enable" value="未使用" title="未使用">
				</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">配置Key</label>
				<div class="layui-input-block">
					<input type="text" name="configKey" lay-verify="title"
						value="${config.configKey}" autocomplete="off"
						placeholder="请输入文件Key" class="layui-input">
				</div>
			</div>
			<#if config.dataType == "file">
			<div class="layui-form-item">
				<label class="layui-form-label">选择文件</label>
				<button type="button" class="layui-btn" id="test3">
					<i class="layui-icon"></i>上传文件
				</button>
				<button type="button" class="layui-btn layui-btn-primary" id="test4">
					<i class="layui-icon"></i>只允许压缩文件
				</button>
				<button type="button" class="layui-btn" id="test5">
					<i class="layui-icon"></i>上传视频
				</button>
				<button type="button" class="layui-btn" id="test6">
					<i class="layui-icon"></i>上传音频
				</button>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">文件路径</label>
				<div class="layui-input-block">
					<input type="text" name="configValue" lay-verify="title"
						value="${config.configValue}" autocomplete="off"
						placeholder="请输入文件路径" class="layui-input">
				</div>
			</div>
			<#else>

			<div class="layui-form-item">
				<label class="layui-form-label">配置内容</label>
				<div class="layui-input-block">
					<textarea name="configValue" placeholder="请输入内容"
						class="layui-textarea"></textarea>
				</div>
			</div>

			</#if>
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
							[ 'form', 'layedit', 'upload' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, upload = layui.upload;
								//表单初始赋值
								form.val('example', {
									"configValue" : "${config.configValue}"
								});
								//指定允许上传的文件类型
								upload.render({
									elem : '#test3',
									url : 'http://92.68.10.197:8005/upload/',
									accept : 'file' //普通文件
									,
									done : function(res) {
										console.log(res)
									}
								});
								upload.render({ //允许上传的文件后缀
									elem : '#test4',
									url : 'http://92.68.10.197:8005/upload/',
									accept : 'file' //普通文件
									,
									exts : 'zip|rar|7z' //只允许上传压缩文件
									,
									done : function(res) {
										console.log(res)
									}
								});
								upload.render({
									elem : '#test5',
									url : 'http://92.68.10.197:8005/upload/',
									accept : 'video' //视频
									,
									done : function(res) {
										console.log(res)
									}
								});
								upload.render({
									elem : '#test6',
									url : 'http://92.68.10.197:8005/upload/',
									accept : 'audio' //音频
									,
									done : function(res) {
										console.log(res)
									}
								});
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
													var link = 'http://92.68.10.197:8005/config/edit?operation=insert&dataType='
															+ dataType;
													window.location.href = link;
												})
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
																					url : 'http://92.68.10.197:8005/api/config/edit?operation=${operation}',
																					method : 'post',
																					data : data.field,
																					dataType : 'JSON'
																				});
																		var link = 'http://92.68.10.197:8005/config/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>