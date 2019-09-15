<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>自提点信息管理</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">

</head>

<body>
	<div class="layui-form-item layui-form demoTable"
		style="margin: 1% 0 0 1.1%;">

		<div class="layui-input-inline">
			<input id="name" type="text" name="title" lay-verify="title"
				autocomplete="off" placeholder="请输入自提点名或者ID" class="layui-input">
		</div>
		<div class="demoTable">
			<button class="layui-btn" data-type="selectName">查询自提点</button>
			<button class="layui-btn" data-type="insert">添加自提点信息</button>
			<button class="layui-btn" data-type="bulkDelete">批量删除</button>
			<button class="layui-btn" data-type="refresh">刷新</button>
		</div>
	</div>
	<div class="layui-tab layui-tab-card">
		<ul class="layui-tab-title">
			<li class="layui-this">地区信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 495px; width: 100%;">
			<!--地区信息 -->
			<div class="layui-tab-item layui-show">
				<div class="layui-card-body" style="margin: -30px 0px 0px -25px;">
					<table class="layui-table" id="idTest"
						lay-data="{height:472, page:true}" lay-filter="demo">
						<thead>
							<tr>
								<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
								<th lay-data="{field:'pickupId', width:100, sort:true}">自提点Id</th>
								<th lay-data="{field:'pickupName', width:180}">自提点名字</th>
								<th lay-data="{field:'pickupAddress', width:100}">自提点地址</th>
								<th lay-data="{field:'pickupPhone', width:150}">自提点手机号</th>
								<th lay-data="{field:'pickupContact', width:180}">自提点联系人姓名</th>
								<th lay-data="{field:'provinceId', width:180}">省</th>
								<th lay-data="{field:'cityId', width:180}">市</th>
								<th lay-data="{field:'districtId', width:180}">区/县</th>
								<th lay-data="{field:'suppliersid', width:180}">供应者Id</th>
								<th
lay-data="{field:'操作栏',fixed: 'right', width:200, align:'center', toolbar: '#barDemo'}">
								</th>
							</tr>
						</thead>
						<tbody>
							<#list pickUps as pickUp>
							<tr>
								<td></td>
								<td>${pickUp.pickupId }</td>
								<td>${pickUp.pickupName}</td>
								<td>${pickUp.pickupAddress}</td>
								<td>${pickUp.pickupPhone}</td>
								<td>${pickUp.pickupContact}</td>
								<td>${pickUp.provinceName}</td>
								<td>${pickUp.cityName}</td>
								<td>${pickUp.districtName}</td>
								<td>${pickUp.suppliersid}</td>
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
	<script src="${base}/admin/js/jquery.min.js"></script>
	<script type="text/html" id="barDemo">
   <a class="layui-btn layui-btn-xs" lay-event="edit">编  辑</a>
   <a class="layui-btn  layui-btn-danger layui-btn-xs" lay-event="del">删  除</a>
</script>
	<script type="text/javascript">

	function delcommafy(num){//去除千分位中的‘，’
		　　if(num&&num!='undefined'&&num!='null'){
		　　　　let numS = num;
		　　　　numS = numS.toString();
		　　　　numS = numS.replace(/,/gi, '');
		　　　　return numS;
		　　}else {
		　　　　return num;
		　　}
		}

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
							table.on('tool(demo)', function(obj) {
								var data = obj.data;
								if (obj.event === 'del') {
									var id = data['pickupId'];
									layer.confirm('真的删除行么', function(index) {
										obj.del();
										layer.close(index);
										var link = "${base}/pickUp/list&id="
												+ delcommafy(id);
										window.location.href = link;
									});
								} else if (obj.event === 'edit') {
									var id = data['pickupId'];
									var link = "${base}/pickUp/toedit?id="
											+ delcommafy(id);
									window.location.href = link;
								}
							});

							var $ = layui.$, active = {
								insert : function() {
									var link = "${base}/pickUp/toinsert";
									window.location.href = link;
								},
								selectName : function() {
									var name = document.getElementById('name').value;
									var link = "${base}/pickUp/selectByName?name="
											+ name;
									window.location.href = link;
								},
								bulkDelete : function() {
									var checkStatus = table
											.checkStatus('idTest'), data = checkStatus.data;
									for (var i = 0; i < data.length; i++) {
										var pickupId = parseInt(data[i].pickupId);
										$
												.ajax({
													url : '${base}/api/pickUp/delete?id='
															+ delcommafy(pickupId),
													method : 'get',
												});
									}
									var link = "${base}/pickUp/list";
									window.location.href = link;
								},
								refresh : function() {
									var link = "${base}/pickUp/list";
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