<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>个人文件信息管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">增加个人文件信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">个人文件信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 100%;">
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}"
						lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:80, sort:true}">ID</th>
								<th lay-data="{field:'studentId', width:100}">studentId</th>
								<th lay-data="{field:'fileImage', width:160}">fileImage</th>
								<th lay-data="{field:'fileName', width:100}">fileName</th>
								<th lay-data="{field:'path', width:182}">path</th>
								<th lay-data="{field:'time', width:160}">time</th>
								<th lay-data="{field:'fileSize', width:100}">fileSize</th>
								<th lay-data="{field:'page', width:100}">page</th>
								<th lay-data="{field:'status', width:100}">status</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
									操作栏</th>
							</tr>
						</thead>
						<tbody>
							<#list personFileInfos as personFileInfo>
							<tr>
								<td></td>
								<td>${personFileInfo.id}</td>
								<td>${personFileInfo.studentId}</td>
								<td>${personFileInfo.fileImage}</td>
								<td>${personFileInfo.fileName}</td>
								<td>${personFileInfo.path}</td>
								<td>${personFileInfo.time}</td>
								<td>${personFileInfo.fileSize}</td>
								<td>${personFileInfo.page}</td>
								<td>${personFileInfo.status}</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
	<script src="${base}/js/plugins/layui/layui.all.js"></script>
	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
   <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
   <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script>
		layui
				.use(
						'table',
						function() {
							var table = layui.table, form = layui.form;
							table.on('checkbox(demo)', function(obj) {
								console.log(obj)
							});
							//Ã§ÂÂÃ¥ÂÂ¬Ã¥Â·Â¥Ã¥ÂÂ·Ã¦ÂÂ¡
							table
									.on(
											'tool(demo)',
											function(obj) {
												var data = obj.data;
												if (obj.event === 'del') {
													var id = data['id'];
													layer
															.confirm(
																	"确定删除吗",
																	function(
																			index) {
																		obj
																				.del();
																		layer
																				.close(index);
																		var link = "${base}/personFileInfo/todelete?id="
																				+ id;
																		window.location.href = link;
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${base}/personFileInfo/toupdate?id="
															+ id;
													window.location.href = link;
												}
											});

							var $ = layui.$, active = {
								insert : function() { //
									var link = "${base}/printshop/toinsert";
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