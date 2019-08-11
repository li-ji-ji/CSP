<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>文件信息管理</title>
<link rel="stylesheet" href="${request.contextPath}/js/plugins/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">添加配置分类信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">配置分类信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 100%;">
			<!--系统配置 -->
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}"
						lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:500, sort:true}">ID</th>
								<th lay-data="{field:'name', width:500}">配置分类名字</th>
							
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:288, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list configCategorys as configCategory>
							<tr>
								<td></td>
								<td>${configCategory.id}</td>
								<td>${configCategory.name}</td>		
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="${request.contextPath}/js/plugins/layui/layui.all.js"></script>
	<script src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${request.contextPath}/js/plugins/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
   <a class="layui-btn layui-btn-xs" lay-event="edit">编  辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删  除</a>
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
																				url: 'http://192.168.1.121:8005/api/config/edit?operation=delete&id='
																					+ id,
																				method: 'post',
																				data: data.field,
																				dataType: 'JSON'
																			}); */
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${request.contextPath}/configCategory/edit?operation=update&id="
															+ id;
													window.location.href = link;
												}
											});

							var $ = layui.$, active = {
								insert : function() { //获取选中数据
									var link = "${request.contextPath}/configCategory/edit?operation=insert";
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