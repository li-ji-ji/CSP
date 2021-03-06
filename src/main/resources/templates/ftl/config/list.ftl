<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>配置管理</title>
<link rel="stylesheet" href="${request.contextPath}/js/plugins/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">添加配置信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<#assign i = 0> <#list configVms as configVm>
			<li>${configVms[i].type }</li> <#assign i++> </#list>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 100%;">
			<!--系统配置 -->
			<#assign i = 0> <#list configVms as configVm>
			<#if i==0>
				<div class="layui-tab-item layui-show">
			<#else>
				<div class="layui-tab-item">
			</#if>
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}"
						lay-filter="demo">
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
							<#assign j=0> <#list configVms[i].configs as x2>
							<tr>
								<td></td>
								<td>${configVms[i].configs[j].id}</td>
								<td>${configVms[i].configs[j].configKey}</td>
								<td>${configVms[i].configs[j].configValue}</td>
								<td>${configVms[i].configs[j].dataType}</td>
								<td>${configVms[i].configs[j].type}</td>
								<td>${configVms[i].configs[j].enable}</td>
							</tr>
							<#assign j++> </#list>
						</tbody>
					</table>
				</div>
			</div>
			<#assign i++> </#list>
		</div>
	</div>
	<script src="${request.contextPath}/js/plugins/layui/layui.all.js"></script>
	<script src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${request.contextPath}/js/plugins/layui/layui.js"></script>
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
						function() {
							var table = layui.table, form = layui.form;
							//监听表格复选框选择
							table.on('checkbox(demo)', function(obj) {
								console.log(obj)
							});
							//监听性别操作
							form
									.on(
											'switch(sexDemo)',
											function(obj) {
												var id = this.id;
												var enable = this.value;

												//layer.msg(id+enable);
												var link = "${request.contextPath}/config/list?id="
														+ id
														+ "&enable="
														+ enable;
												window.location.href = link;
												// layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
											});
							//监听工具条
							table
									.on(
											'tool(demo)',
											function(obj) {
												var data = obj.data;
												if (obj.event === 'del') {
													var id = data['id'];
													layer
															.confirm(
																	'真的删除行么',
																	function(
																			index) {
																		obj
																				.del();
																		layer
																				.close(index);
																		var link = "${request.contextPath}/config/list?operation=delete&id="
																				+ id;
																		window.location.href = link;
																		/* $
																			.ajax({
																				url: '${request.contextPath}/api/config/edit?operation=delete&id='
																					+ id,
																				method: 'post',
																				data: data.field,
																				dataType: 'JSON'
																			}); */
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${request.contextPath}/config/edit?operation=update&id="
															+ id;
													window.location.href = link;
												}
											});

							var $ = layui.$, active = {
								insert : function() { //获取选中数据
									var link = "${request.contextPath}/config/edit?operation=insert";
									window.location.href = link;
								}
							};

							$('.demoTable .layui-btn').on('click', function() {
								var type = $(this).data('type');
								active[type] ? active[type].call(this) : '';
							});
						});
	</script>
</body>

</html>