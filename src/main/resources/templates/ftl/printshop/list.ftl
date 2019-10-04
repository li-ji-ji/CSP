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
								<th lay-data="{field:'name', width:300}">打印店名</th>
								<th lay-data="{field:'location', width:300}">位置</th>
								<th lay-data="{field:'mobile', width:300}">商家电话</th>
								<th lay-data="{field:'status', width:100}">状态</th>
								<th lay-data="{field:'printerConfig', width:300}">打印机配置</th>
								<th lay-data="{field:'price', width:300}">价格</th>
								<th lay-data="{field:'shopImage', width:300}">打印机图片</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
									操作栏</th>
							</tr>
						</thead>
						<tbody>
							<#list printshops as printshop>
							<tr>
								<td></td>
								<td>${printshop.id}</td>
								<td>${printshop.name}</td>
								<td>${printshop.location}</td>
								<td>${printshop.mobile}</td>
								<td>${printshop.status}</td>
								<td>${printshop.printerConfig}</td>
								<td>${printshop.price}</td>
								<td>${printshop.shopImage}</td>
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
																		var link = "${base}/printshop/todelete?id="
																				+ id;
																		window.location.href = link;
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${base}/printshop/toupdate?id="
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