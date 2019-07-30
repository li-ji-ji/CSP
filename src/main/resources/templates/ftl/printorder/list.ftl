<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>打印订单管理</title>
<link rel="stylesheet" href="../../js/plugins/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-btn-group demoTable" style="margin: 1% 0 0 1.1%;">
		<button class="layui-btn" data-type="insert">添加打印订单信息</button>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">打印订单信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 100%;">
			<!--打印订单信息 -->
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" lay-data="{height:472, page:true}"
						lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'id', width:80, sort:true}">ID</th>
								<th lay-data="{field:'fileName', width:100}">文件名字</th>
								<th lay-data="{field:'printMode', width:100}">打印方式</th>
								<th lay-data="{field:'printCopy', width:100}">打印份数</th>
								<th lay-data="{field:'deliveryMode', width:100}">取货方式</th>
								<th lay-data="{field:'orderTime', width:100}">下单时间</th>
								<th lay-data="{field:'page', width:100}">页数</th>
								<th lay-data="{field:'isUrgent', width:100}">是否加急</th>
								<th lay-data="{field:'price', width:100}">价格</th>
								<th lay-data="{field:'note', width:100}">备注</th>
								<th lay-data="{field:'contact', width:100}">联系方式</th>
								<th lay-data="{field:'mobile', width:100}">商家电话</th>
								<th lay-data="{field:'storeAddress', width:100}">商家地址</th>
								<th lay-data="{field:'deliveryAddress', width:100}">送达地址</th>
								<th lay-data="{field:'status', width:100}">状态</th>
								<th lay-data="{field:'filePath', width:100}">文件入径</th>
								<th
									lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
									操作栏</th>
							</tr>
						</thead>
						<tbody>
							<#list printOrders as printOrder>
							<tr>
								<td></td>
								<td>${printOrder.id}</td>
								<td>${printOrder.fileName}</td>
								<td>${printOrder.printMode}</td>
								<td>${printOrder.printCopy}</td>
								<td>${printOrder.deliveryMode}</td>
								<td>${printOrder.orderTime}</td>
								<td>${printOrder.page}</td>
								<td>${printOrder.isUrgent}</td>
								<td>${printOrder.price}</td>
								<td>${printOrder.note}</td>
								<td>${printOrder.contact}</td>
								<td>${printOrder.mobile}</td>
								<td>${printOrder.storeAddress}</td>
								<td>${printOrder.deliveryAddress}</td>
								<td>${printOrder.status}</td>
								<td>${printOrder.filePath}</td>
							</tr>
							</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="../../js/plugins/layui/layui.all.js"></script>
	<script src="../../js/jquery-3.3.1.min.js"></script>
	<script src="../../js/plugins/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
   <a class="layui-btn layui-btn-xs" lay-event="edit">编  辑</a>
   <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删  除</a>
	<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="download">打印</a>
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
																		var link = "${request.contextPath}/fileinfo/list?operation=delete&id="
																				+ id;
																		window.location.href = link;
																	});
												} else if (obj.event === 'edit') {
													var id = data['id'];
													var link = "${request.contextPath}/printOrder/edit?operation=update&id="
															+ id;
													window.location.href = link;
												}else if (obj.event === 'download') {
													var filePath = data['filePath'];
													var link = filePath;
													window.location.href = link;
												}
											});

							var $ = layui.$, active = {
								insert : function() { //获取选中数据
									var link = "${request.contextPath}/printOrder/edit?operation=insert";
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