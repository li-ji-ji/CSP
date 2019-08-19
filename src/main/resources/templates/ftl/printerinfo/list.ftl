<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>打印店信息管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">增加打印店信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">打印店信息</li>
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
								<th lay-data="{field:'printShopName', width:300}">printShopName</th>
								<th lay-data="{field:'printName', width:300}">printName</th>
								<th lay-data="{field:'status', width:100}">status</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
									操作栏</th>
							</tr>
						</thead>
						<tbody>
							<#list printers as printer>
							<tr>
								<td></td>
								<td>${printer.id}</td>
								<td>${printer.printShopName}</td>
								<td>${printer.printName}</td>
								<td>${printer.status}</td>
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
							//çå¬å·¥å·æ¡
							table
									.on(
											'tool(demo)',
											function(obj) {
												var data = obj.data;
												if (obj.event === 'del') {
													var id = data['id'];
													layer
															.confirm(
																	'确认删除吗',
																	function(
																			index) {
																		obj
																				.del();
																		layer
																				.close(index);
																		var link = "${base}/printerinfo/todelete?id="
																				+ id;
																		window.location.href = link;
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${base}/printerinfo/toupdate?id="
															+ id;
													window.location.href = link;
												}
											});

							var $ = layui.$, active = {
								insert : function() { //
									var link = "${base}/printerinfo/toinsert";
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