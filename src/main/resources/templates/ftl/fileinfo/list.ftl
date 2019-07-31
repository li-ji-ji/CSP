<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>文件信息管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">添加文件信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">文件信息</li>
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
								<th lay-data="{field:'id', width:80, sort:true}">ID</th>
								<th lay-data="{field:'name', width:100}">文件名字</th>
								<th lay-data="{field:'keyword', width:100}">文件key</th>
								<th lay-data="{field:'description', width:180}">文件描述</th>
								<th lay-data="{field:'type', width:100}">类型</th>
								<th lay-data="{field:'folderId', width:100}">文件ID</th>
								<th lay-data="{field:'url', width:180}">路径</th>
								<th lay-data="{field:'date', width:150}">日期</th>
								<th lay-data="{field:'size', width:180}">大小</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list fileInfos as fileInfo>
							<tr>
								<td></td>
								<td>${fileInfo.id}</td>
								<td>${fileInfo.name}</td>
								<td>${fileInfo.keyword}</td>
								<td>${fileInfo.description}</td>
								<td>${fileInfo.type}</td>
								<td>${fileInfo.folderId}</td>
								<td>${fileInfo.url}</td>
								<td>${fileInfo.date}</td>
								<td>${fileInfo.size}</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="${base}/js/plugins/layui/layui.all.js"></script>
	<script src="${base}/js/jquery-3.3.1.min.js"></script>
	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
   <a class="layui-btn layui-btn-xs" lay-event="edit">编  辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删  除</a>
<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="download">下载</a>
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
																		var link = "${base}/fileinfo/list?operation=delete&id="
																				+ id;
																		window.location.href = link;
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${base}/fileinfo/edit?operation=update&id="
															+ id;
													window.location.href = link;
												}else if (obj.event === 'download') {
													var filePath = data['url'];
													var link = filePath;
													window.location.href = link;
												}
											});

							var $ = layui.$, active = {
								insert : function() { //获取选中数据
									var link = "${base}/fileinfo/edit?operation=insert";
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