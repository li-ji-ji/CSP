<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>配置管理</title>
	<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">添加配置信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">系统配置</li>
			<li>网站配置</li>
			<li>邮件配置</li>
			<li>短信配置</li>
			<li>腾讯云配置</li>
			<li>微信支付配置</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px;width:100%;">
			<!--系统配置 -->
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin:-30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'configKey', width:180}">配置key</th>
								<th lay-data="{field:'configValue', width:180}">配置内容</th>
								<th lay-data="{field:'dataType', width:180}">数据类型</th>
								<th lay-data="{field:'type', width:180}">类型</th>
								<th lay-data="{field:'enable', width:180,templet: '#switchTpl'}">是否使用</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list systems as system>
								<tr>
									<td></td>
									<td>${system.id}</td>
									<td>${system.configKey}</td>
									<td>${system.configValue}</td>
									<td>${system.dataType}</td>
									<td>${system.type}</td>
									<td>${system.enable}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 网站配置 -->
			<div class="layui-tab-item">
				<div class="layui-card-body" style="margin:-30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'configKey', width:180}">配置key</th>
								<th lay-data="{field:'configValue', width:180}">配置内容</th>
								<th lay-data="{field:'dataType', width:180}">数据类型</th>
								<th lay-data="{field:'type', width:180}">类型</th>
								<th lay-data="{field:'enable', width:180,templet: '#switchTpl'}">是否使用</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list websites as website>
								<tr>
									<td></td>
									<td>${website.id}</td>
									<td>${website.configKey}</td>
									<td>${website.configValue}</td>
									<td>${website.dataType}</td>
									<td>${website.type}</td>
									<td>${website.enable}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 邮件配置 -->
			<div class="layui-tab-item">
				<div class="layui-card-body" style="margin:-30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'configKey', width:180}">配置key</th>
								<th lay-data="{field:'configValue', width:180}">配置内容</th>
								<th lay-data="{field:'dataType', width:180}">数据类型</th>
								<th lay-data="{field:'type', width:180}">类型</th>
								<th lay-data="{field:'enable', width:180,templet: '#switchTpl'}">是否使用</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list mails as mail>
								<tr>
									<td></td>
									<td>${mail.id}</td>
									<td>${mail.configKey}</td>
									<td>${mail.configValue}</td>
									<td>${mail.dataType}</td>
									<td>${mail.type}</td>
									<td>${mail.enable}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>

			<!-- 短信配置 -->
			<div class="layui-tab-item">
				<div class="layui-card-body" style="margin:-30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'configKey', width:180}">配置key</th>
								<th lay-data="{field:'configValue', width:180}">配置内容</th>
								<th lay-data="{field:'dataType', width:180}">数据类型</th>
								<th lay-data="{field:'type', width:180}">类型</th>
								<th lay-data="{field:'enable', width:180,templet: '#switchTpl'}">是否使用</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list messages as message>
								<tr>
									<td></td>
									<td>${message.id}</td>
									<td>${message.configKey}</td>
									<td>${message.configValue}</td>
									<td>${message.dataType}</td>
									<td>${message.type}</td>
									<td>${message.enable}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			
			<!-- 腾讯云配置 -->
			<div class="layui-tab-item">
				<div class="layui-card-body" style="margin:-30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'configKey', width:180}">配置key</th>
								<th lay-data="{field:'configValue', width:180}">配置内容</th>
								<th lay-data="{field:'dataType', width:180}">数据类型</th>
								<th lay-data="{field:'type', width:180}">类型</th>
								<th lay-data="{field:'enable', width:180,templet: '#switchTpl'}">是否使用</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list tencentClouds as tencentCloud>
								<tr>
									<td></td>
									<td>${tencentCloud.id}</td>
									<td>${tencentCloud.configKey}</td>
									<td>${tencentCloud.configValue}</td>
									<td>${tencentCloud.dataType}</td>
									<td>${tencentCloud.type}</td>
									<td>${tencentCloud.enable}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
			
			
			<!-- 微信支付配置 -->
			<div class="layui-tab-item">
				<div class="layui-card-body" style="margin:-30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:180, sort:true}">ID</th>
								<th lay-data="{field:'configKey', width:180}">配置key</th>
								<th lay-data="{field:'configValue', width:180}">配置内容</th>
								<th lay-data="{field:'dataType', width:180}">数据类型</th>
								<th lay-data="{field:'type', width:180}">类型</th>
								<th lay-data="{field:'enable', width:180,templet: '#switchTpl'}">是否使用</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list wechats as wechat>
								<tr>
									<td></td>
									<td>${wechat.id}</td>
									<td>${wechat.configKey}</td>
									<td>${wechat.configValue}</td>
									<td>${wechat.dataType}</td>
									<td>${wechat.type}</td>
									<td>${wechat.enable}</td>
								</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="${base}/js/plugins/layui/layui.all.js"></script>
	<script src="${base}/js/jquery-3.3.1.js"></script>
	<script src="${base}/js/plugins/layui/layui.js"></script>
<script type="text/html" id="barDemo">
   <a class="layui-btn layui-btn-xs" lay-event="edit">编  辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删  除</a>
</script>

<script type="text/html" id="switchTpl">
  <!-- 这里的 checked 的状态只是演示 -->
{{#  if(d.enable === "使用"){ }}
<input type="checkbox" id="{{d.id}}" name="sex" value="未使用" lay-skin="switch" lay-text="使用|未使用" lay-filter="sexDemo" checked=""  {{ d.id == 10003 ? 'checked' : '' }}>
              {{#  } else { }}
              <input type="checkbox" id="{{d.id}}" name="sex" value="使用" lay-skin="switch" lay-text="使用|未使用" lay-filter="sexDemo" {{ d.id == 10003 ? 'checked' : '' }}>
              {{#  } }}
</script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui
			.use(
				'table',
				function () {
					var table = layui.table
					  ,form = layui.form;
					//监听表格复选框选择
					table.on('checkbox(demo)', function (obj) {
						console.log(obj)
					});
					//监听性别操作
					form.on('switch(sexDemo)', function(obj){
						var id = this.id;
						var enable = this.value;
						
						//layer.msg(id+enable);
						var link = "/config/list?id="
							+id+"&enable="+enable;
						window.location.href = link;
					   // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
					  });
					//监听工具条
					table.on('tool(demo)', function (obj) {
						var data = obj.data;
						if (obj.event === 'del') {
							var id = data['id'];
							layer
								.confirm(
									'真的删除行么',
									function (index) {
										obj.del();
										layer.close(index);
										var link = "/config/list?operation=delete&id="+id;
										window.location.href = link;
										/* $
											.ajax({
												url: 'http://92.68.10.197:8005/api/config/edit?operation=delete&id='
													+ id,
												method: 'post',
												data: data.field,
												dataType: 'JSON'
											}); */
									});
						} else if (obj.event === 'edit') {
							var id = data['id'];
							var link = "/config/edit?operation=update&id="
								+ id;
							window.location.href = link;
						}
					});

					var $ = layui.$, active = {
						insert: function () { //获取选中数据
							var link = "/config/edit?operation=insert";
							window.location.href = link;
						}
					};

					$('.demoTable .layui-btn').on('click', function () {
						var type = $(this).data('type');
						active[type] ? active[type].call(this) : '';
					});
				});
	</script>
</body>

</html>