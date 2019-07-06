
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<style type="text/css">
	.menagement-table{
		width: 100%;
	}
</style>
<link rel="stylesheet"
	href="../../js/plugins/layui/css/layui.css" media="all">
	<script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
	<script src="../../js/Ztree/jquery.ztree.core.js"></script>
	<script src="../../js/Ztree/jquery.ztree.excheck.js"></script>
	<script src="../../js/Ztree/jquery.ztree.exedit.js"></script>
	<link rel="stylesheet" href="../../css/ZTree/metroStyle/metroStyle.css">
</head>
<script type="text/javascript">
		var zNodes	//菜单节点数据
		var fontCss	//字体css样式数据
		var menuLevel=0	//菜单等级，用于设置字体
		var menu
		$.ajax({
			"url": "http://192.168.1.126:8004/csp/api/fontCss/getCssById",
			"data": "",
			"type": "post",
			"dataType": "text",
			"success": function (returnMsg) {
				fontCss=JSON.parse(returnMsg)
				//console.log(fontCss.fontStyle)
				fontCss["font-style"]=fontCss.fontStyle	//设置正确属性用于存放font-style
				fontCss["font-weight"]=fontCss.fontWeight	//设置正确属性用于存放font-weight
			}
		});
		$.ajax({
			"url": "http://192.168.1.126:8004/feign/adminMenu/getAll",
			"data": "",
			"type": "post",
			"dataType": "text",
			"success": function (returnMsg) {
				zNodes = JSON.parse(returnMsg)
				//console.log(returnMsg)
				//console.log("得到数据：")
				
				//console.log( zNodes)//打印拿到的菜单数据
				var setting = {
					view: {
						fontCss :fontCss,
						dblClickExpand: false,
						showLine: true
					},
					/* edit: {
						enable: true //是否允许直接编辑
					}, */
					data: {
						simpleData: {
							enable: true
						}
					},
					callback: {
						onClick: onClick
					}
				};
				/* function setFontCss(treeId, treeNode) {
					return treeNode.level == menuLevel ? fontCss : {"color":"white"};
				}; */
				function onClick(e, treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					zTree.expandNode(treeNode);
					console.log(treeNode)//拿到预设数据
					console.log(treeNode.mainurl)//拿到预设数据
					menu=treeNode
					if(treeNode.mainUrl!="javascript:void(0)"){
						$("#data-table").attr("src", treeNode.mainurl);
					}
				}
				$(document).ready(function () {
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				});
			}
		});
</script>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">CSP后台管理界面</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		
		</div>
		<div class="layui-body">
			<iframe id="data-table" src="" width="100%" height="100%"></iframe>

			<!-- <table class="layui-table"
				lay-data="{width: 1150, height:500, url:'http://92.68.10.110:8080/back/getMenuUrlById', page:true, id:'idTest'}"
				lay-filter="demo">
				<thead>
					<tr>
						<th lay-data="{type:'checkbox'}">ID</th>
						<th lay-data="{field:'id', width:80, sort: true}">ID</th>
						<th lay-data="{field:'pid', width:120, sort: true, edit: 'text'}">上级菜单ID</th>
						<th lay-data="{field:'value', edit: 'text', minWidth: 150}">菜单名称</th>
						<th lay-data="{field:'url', width:80, edit: 'text'}">菜单跳转链接</th>
						<th lay-data="{field:'status', edit: 'text', minWidth: 100}">菜单状态</th>
						<th lay-data="{field:'weixin', sort: true, edit: 'text'}">微信</th>
						<th lay-data="{field:'phone', sort: true, edit: 'text'}">电话</th>
						<th lay-data="{field:'email', sort: true, edit: 'text'}">邮箱</th>
						<th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					</tr>
				</thead>
			</table> -->
			<!-- <table class="layui-table"
				lay-data="{url:'/Holding/user/getUserList.do', id:'test3'}"
				lay-filter="test3">
				<thead>
					<tr>
						<th lay-data="{type:'checkbox'}">ID</th>
						<th lay-data="{field:'id', width:80, sort: true}">ID</th>
						<th
							lay-data="{field:'userno', width:120, sort: true, edit: 'text'}">用户编号</th>
						<th lay-data="{field:'name', edit: 'text', minWidth: 150}">用户名</th>
						<th lay-data="{field:'password', width:80, edit: 'text'}">密码</th>
						<th lay-data="{field:'imgurl', edit: 'text', minWidth: 100}">头像</th>
						<th lay-data="{field:'weixin', sort: true, edit: 'text'}">微信</th>
						<th lay-data="{field:'phone', sort: true, edit: 'text'}">电话</th>
						<th lay-data="{field:'email', sort: true, edit: 'text'}">邮箱</th>
					</tr>
				</thead>
			</table> -->
		</div>
	</div>

	<script src="../../js/plugins/layui/layui.js"></script>


	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script>
		//JavaScript代码区域
		//var menu;
		/* function getid(id) {
			//console.log(id);
			$.ajax({
				"url": "http://92.68.10.110:8080/back/getMenuUrlById",
				"data": "menuid="+id,
				"type": "POST",
				"dataType": "JSON",
				"success": function (getMsg) {
					menu=getMsg;
					//console.log(getMsg.tableName);
					$("#data-table").attr("src", getMsg.url+"?tableName="+getMsg.tableName);
					
				}
			});
		}
		 */
		layui.use('element', function() {
			var element = layui.element;
			element.on('nav(test)', function(data){
				   //得到当前点击的DOM对象
				  
				});
		});		
	</script>
</body>
</html>