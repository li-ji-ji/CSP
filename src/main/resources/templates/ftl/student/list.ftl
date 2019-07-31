<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
</head>

<body>


	<div class="layui-btn-group demoTable">
		<button class="layui-btn" data-type="getCheckData">获取选中行的数据</button>
		<button class="layui-btn" data-type="batchDelete">批量删除</button>
		<button type="button" class="layui-btn" id="test3">
			<i class="layui-icon"></i>excle文件导入
		</button>
		<button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
		<button class="layui-btn" data-type="isAll">验证是否全选</button>
		<button class="layui-btn" style="background: antiquewhite;">
			<a href="/authority/student/toedit">添加</a>
		</button>
	</div>

	<table class="layui-table"
		lay-data="{width: 1200, height:330, url:'/authority/student/all', page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<th lay-data="{type:'checkbox', fixed: 'left'}"></th>
				<th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
				<th lay-data="{field:'sn', width:100}">学号</th>
				<th lay-data="{field:'name', width:80}">姓名</th>
				<th lay-data="{field:'dormitoryAdd', width:120}">宿舍地址</th>
				<th lay-data="{field:'phone', width:80}">私人电话</th>
				<th lay-data="{field:'email', width:160}">邮箱</th>
				<th lay-data="{field:'college', width:80}">学院</th>
				<th lay-data="{field:'classes', width:80}">班级</th>
				<th lay-data="{field:'grade', width:80, sort: true}">年级</th>
				<th lay-data="{field:'major', width:135}">专业</th>
				<th
					lay-data="{field:'famillyAdd', width:80, sort: true,fixed: 'right'}">家庭地址</th>
				<th
					lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
			</tr>
		</thead>


	</table>

	<script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>


	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
	<!-- Ã¦Â³Â¨Ã¦ÂÂÃ¯Â¼ÂÃ¥Â¦ÂÃ¦ÂÂÃ¤Â½Â Ã§ÂÂ´Ã¦ÂÂ¥Ã¥Â¤ÂÃ¥ÂÂ¶Ã¦ÂÂÃ¦ÂÂÃ¤Â»Â£Ã§Â ÂÃ¥ÂÂ°Ã¦ÂÂ¬Ã¥ÂÂ°Ã¯Â¼ÂÃ¤Â¸ÂÃ¨Â¿Â°jsÃ¨Â·Â¯Ã¥Â¾ÂÃ©ÂÂÃ¨Â¦ÂÃ¦ÂÂ¹Ã¦ÂÂÃ¤Â½Â Ã¦ÂÂ¬Ã¥ÂÂ°Ã§ÂÂ -->
	<script>
		layui
				.use(
						'table',
						function() {
							var table = layui.table;
							//Ã§ÂÂÃ¥ÂÂ¬Ã¨Â¡Â¨Ã¦Â Â¼Ã¥Â¤ÂÃ©ÂÂÃ¦Â¡ÂÃ©ÂÂÃ¦ÂÂ©
							table.on('checkbox(demo)', function(obj) {
								console.log(obj)
							});
							//Ã§ÂÂÃ¥ÂÂ¬Ã¥Â·Â¥Ã¥ÂÂ·Ã¦ÂÂ¡
							table
									.on(
											'tool(demo)',
											function(obj) {
												var data = obj.data;
												if (obj.event === 'detail') {
													layer
															.msg('id:'
																	+ data.id
																	+ '的查看操作');
												} else if (obj.event === 'del') {
													layer
															.confirm(
																	'真的删除行么',
																	function(
																			index) {
																		var xmlhttp;//Ã¥ÂÂÃ§ÂÂajaxÃ¨Â¯Â·Ã¦Â±Â
																		if (window.XMLHttpRequest) {
																			// code for IE7+, Firefox, Chrome, Opera, Safari
																			xmlhttp = new XMLHttpRequest();
																		} else {// code for IE6, IE5a
																			xmlhttp = new ActiveXObject(
																					"Microsoft.XMLHTTP");
																		}
																		xmlhttp.onreadystatechange = function() {
																			if (xmlhttp.readyState == 4
																					&& xmlhttp.status == 200) {
																				layer
																						.msg('id'
																								+ data.id
																								+ ' 的删除操作成功');
																			}
																		}
																		xmlhttp
																				.open(
																						"get",
																						"/authority/student/delete?id="
																								+ data.id,
																						true);
																		xmlhttp
																				.send();
																		obj
																				.del();
																		layer
																				.close(index);
																	});
												} else if (obj.event === 'edit') {
													layer
															.alert('Ã§Â¼ÂÃ¨Â¾ÂÃ¨Â¡ÂÃ¯Â¼Â<br>'
																	+ JSON
																			.stringify(data))
													window.location.href = "/authority/student/toedit?id="
															+ data.id;
												}
											});

							var $ = layui.$, active = {
								getCheckData : function() { //Ã¨ÂÂ·Ã¥ÂÂÃ©ÂÂÃ¤Â¸Â­Ã¦ÂÂ°Ã¦ÂÂ®
									var checkStatus = table
											.checkStatus('idTest'), data = checkStatus.data;
									layer.alert(JSON.stringify(data));
								},
								getCheckLength : function() { //Ã¨ÂÂ·Ã¥ÂÂÃ©ÂÂÃ¤Â¸Â­Ã¦ÂÂ°Ã§ÂÂ®
									var checkStatus = table
											.checkStatus('idTest'), data = checkStatus.data;
									layer.msg('Ã©ÂÂÃ¤Â¸Â­Ã¤ÂºÂÃ¯Â¼Â'
											+ data.length + ' Ã¤Â¸Âª');
								},
								isAll : function() { //Ã©ÂªÂÃ¨Â¯ÂÃ¦ÂÂ¯Ã¥ÂÂ¦Ã¥ÂÂ¨Ã©ÂÂ
									var checkStatus = table
											.checkStatus('idTest');
									layer
											.msg(checkStatus.isAll ? 'Ã¥ÂÂ¨Ã©ÂÂ'
													: 'Ã¦ÂÂªÃ¥ÂÂ¨Ã©ÂÂ')
								},
								batchDelete : function() {
									var checkStatus = table
											.checkStatus('idTest'), data = checkStatus.data;
									layer.alert(JSON.stringify(data));

									$.ajax({
										url : "/authority/student/batchdelete",
										type : "post",
										dataType : "json",
										data : {
											"jsonStr" : JSON.stringify(data)
										},
										success : function(e) {
											console.log("chen");
										}
									});
									window.location.reload();
								}
							};

							$('.demoTable .layui-btn').on('click', function() {
								var type = $(this).data('type');
								active[type] ? active[type].call(this) : '';
							});
						});
	</script>

	<script>
		layui.use('upload', function() {
			var $ = layui.jquery, upload = layui.upload;

			//æå®åè®¸ä¸ä¼ çæä»¶ç±»åÂÂ
			upload.render({
				elem : '#test3',
				url : '/authority/student/excelimport',
				accept : 'file' //æ®éæä»¶
				,done : function(res) {
					console.log("hello")
				},
				error : function(index, upload) {
					//å½ä¸ä¼ å¤±è´¥æ¶ï¼ä½ å¯ä»¥çæä¸ä¸ªâéæ°ä¸ä¼ âçæé®ï¼ç¹å»è¯¥æé®æ¶ï¼æ§è¡ upload() æ¹æ³å³å¯å®ç°éæ°ä¸ä¼ 
				}
			});
			upload.render({ //åè®¸ä¸ä¼ çæä»¶åç¼Â
				elem : '#test4',
				url : '/authority/student/excelimport',
				accept : 'file' //æ®éæä»¶
				,
				exts : 'zip|rar|7z' //åªåè®¸ä¸ä¼ åç¼©æä»¶
				,
				done : function(res) {
					console.log(res)
				}
			});

			//ç»å®åå§æä»¶åÂÂ
			upload.render({
				elem : '#test20',
				url : '/upload/',
				done : function(res) {
					console.log(res)
				}
			});

		});
	</script>

</body>

</html>