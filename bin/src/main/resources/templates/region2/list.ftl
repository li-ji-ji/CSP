<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>地区信息管理</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">添加地区信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">地区信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 100%;">
			<!--地区信息 -->
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}"
						lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:80, sort:true}">ID</th>
								<th lay-data="{field:'name', width:100}">地区名字</th>
								<th lay-data="{field:'parentId', width:100}">父id</th>
								<th lay-data="{field:'level', width:180}">等级</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list region2s as region2>
							<tr>
								<td></td>
								<td>${region2.id}</td>
								<td>${region2.name}</td>
								<td>${region2.parentId}</td>
								<td>${region2.level}</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="${base}/admin/lib/layui/layui.all.js"></script>
	<script src="${base}/admin/lib/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
 <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="subregion">查看子地区</a>
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
																		var link = "${base}/region2/list&id="
																				+ id;
																		window.location.href = link;
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${base}/region2/toedit?id="
															+ id;
													window.location.href = link;
												} else if(obj.event === 'subregion'){
													var id = data['id'];
													var link = "${base}/region2/subregion?id="
														+ id;
													window.location.href = link;
													layer.alert(id);
												}
											});

							var $ = layui.$, active = {
								insert : function() { //获取选中数据
									var link = "${base}/region2/toinsert";
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