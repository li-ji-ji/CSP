<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>打印订单管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>编辑打印订单信息</legend>
		</fieldset>

		<form class="layui-form" name="PrintOrder" action=""
			lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if printOrder.id != 0> <label class="layui-form-label">id</label>
					<div class="layui-input-inline">
						<input type="tel" name="id" value="${printOrder.id }" id="id"
							readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">文件名字</label>
					<div class="layui-input-inline">
						<input type="tel" name="fileName" value="${printOrder.fileName }"
							lay-verify="title" autocomplete="off" class="layui-input" placeholder="请输入文件名字">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">打印方式</label>
					<div class="layui-input-inline">
						<select name="printMode" lay-verify="required" lay-search="">
							<option value="${printOrder.printMode}">${printOrder.printMode}</option>
							<option value="一般打印">一般打印</option>
							<option value="论文打印">论文打印</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">打印份数</label>
					<div class="layui-input-inline">
						<input type="tel" name="printCopy"
							value="${printOrder.printCopy }" lay-verify="title"
							autocomplete="off" class="layui-input" placeholder="请输入打印份数">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">送达方式</label>
					<div class="layui-input-inline" value="">
						<select name="deliveryMode" lay-verify="required" lay-search="">
							<option value="${printOrder.deliveryMode}">${printOrder.deliveryMode}</option>
							<option value="打印配送">打印配送</option>
							<option value="到店自取">到店自取</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">下单时间</label>
					<div class="layui-input-block">
						<input type="text" id="date" name="orderTime"
							lay-verify="datetime" value="${printOrder.orderTime}"
							autocomplete="off" class="layui-input"
							placeholder="yyyy-MM-dd 00:00:00">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">页数</label>
					<div class="layui-input-block">
						<input type="text" name="page" lay-verify="title"
							value="${printOrder.page}" autocomplete="off" placeholder="请输入页数"
							class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-block">
						<input type="text" name="contact" lay-verify="title"
							value="${printOrder.contact}" autocomplete="off"
							placeholder="请输入联系方式" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">商家电话</label>
					<div class="layui-input-block">
						<input type="text" name="mobile" lay-verify="title"
							value="${printOrder.mobile}" autocomplete="off"
							placeholder="请输入商家电话" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">价格</label>
					<div class="layui-input-block">
						<input type="text" name="price" lay-verify="title"
							value="${printOrder.price}" autocomplete="off"
							placeholder="请输入价格" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">送达地址</label>
					<div class="layui-input-block">
						<input type="text" name="deliveryAddress" lay-verify="title"
							value="${printOrder.deliveryAddress}" autocomplete="off"
							placeholder="请输入送达地址" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">商家地址</label>
					<div class="layui-input-block">
						<input type="text" name="storeAddress" lay-verify="title"
							value="${printOrder.storeAddress}" autocomplete="off"
							placeholder="请输入商家地址" class="layui-input">
					</div>
				</div>	
				<div class="layui-inline">
					<label class="layui-form-label">文件入径</label>
					<div class="layui-input-block">
						<input type="text" name="filePath" lay-verify="title"
							value="${printOrder.filePath}" autocomplete="off"
							placeholder="请输入文件入径" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">是否加急</label>
					<div class="layui-input-block">
						<#if printOrder.isUrgent=='加急'> <input type="radio"
							name="isUrgent" value="加急" title="加急" checked=""> <input
							type="radio" name="isUrgent" value="不加急" title="不加急">
						<#elseif printOrder.isUrgent=='不加急'><input type="radio"
							name="isUrgent" value="加急" title="加急"> <input
							type="radio" name="isUrgent" value="不加急" title="不加急" checked="">
						<#else> <input type="radio" name="isUrgent" value="加急" title="加急"
							checked=""> <input type="radio" name="isUrgent"
							value="不加急" title="不加急"> </#if>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
						<#if printOrder.status=='正在进行中'> <input type="radio" name="status"
							value="正在进行中" title="正在进行中" checked=""> <input
							type="radio" name="status" value="已确认收货" title="已确认收货">
						<#elseif printOrder.status=='已确认收货'><input type="radio"
							name="status" value="正在进行中" title="正在进行中"> <input
							type="radio" name="status" value="已确认收货" title="已确认收货" checked="">
						<#else> <input type="radio" name="status" value="正在进行中"
							title="正在进行中" checked=""> <input type="radio"
							name="status" value="已确认收货" title="已确认收货"> </#if>
					</div>
				</div>			
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<textarea name="note" placeholder="请输入备注" class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>

		<script src="${base}/js/jquery-3.3.1.js"></script>
		<script src="${base}/js/plugins/layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui
					.use(
							[ 'form', 'layedit', 'laydate' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
								//日期
								form.val('example', {
									"note" : "${printOrder.note}"
								});
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
																					url : '${base}/printOrder/list?operation=${operation}',
																					method : 'post',
																					data : data.field,
																					dataType : 'JSON'
																				});
																		var link = '${base}/printOrder/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>