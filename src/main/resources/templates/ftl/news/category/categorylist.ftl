<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>新闻分类列表管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="NewsCategoryTable" lay-filter="NewsCategoryTable">
		<!-- 表头 -->
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'250',fixed:'left',align:'center'}">ID</th>
				<th lay-data="{field:'categorytype',width:'100',align:'center'}">分类类型</th>
				<th lay-data="{field:'category_pname',width:'100',align:'center'}">上级分类</th>
				<th lay-data="{field:'isleaf',width:'100',align:'center'}">是否为叶子</th>
				<th lay-data="{field:'categoryicon',width:'100',align:'center'}">分类图标</th>
				<th lay-data="{field:'categorystatus',width:'100',align:'center'}">分类状态</th>
				<th lay-data="{field:'categorylevel',width:'100',align:'center'}">分类等级</th>
				<th lay-data="{field:'tool',width:'300',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list categories as category>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}"></td>
						<td>${category.id}</td>
						<td>${category.categorytype}</td>
						<td>${category.category_pname}</td>
						<td>
							<#if category.isleaf==1>
								是
							<#else>
								否
							</#if>
						</td>
						<td>
							<#if category.categoryicon==''>
								无
							<#else>
								${category.categoryicon}
							</#if>
						</td>
						<td>
							<#if category.categorystatus==1>
								启用
							<#else>
								未启用
							</#if>
						</td>
						<td>${category.categorylevel}</td>
						<td>
							<a href="/category/toCategoryList?operation=toChild&id=${category.id}" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="toChild">查看子级分类</a>
		  					<a href="/category/toCategoryEdit?operation=edit&id=${category.id}" class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		  					<a href="/category/deleteCategory?operation=del&id=${category.id}" onClick="return confirm('其所有子集分类将会一并删除,真的要删除吗？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/js/plugins/layui/layui.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
    		<a href="/category/toCategoryAdd"><button class="layui-btn layui-btn-warm layui-btn-sm" >添加分类</button></a>
    		<a href="/category/toCategoryList?operation=isNotLeaf"><button class="layui-btn layui-btn-sm" >查看非叶子分类</button></a>
			<a href="/category/toCategoryList?operation=isLeaf"><button class="layui-btn layui-btn-sm" >查看叶子分类</button></a>
			<a href="/category/toCategoryList"><i class="layui-icon layui-icon-refresh-3" style="font-size: 20px;"></i></a>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('NewsCategoryTable',{
			  height:500,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  
	})
	</script>
</body>
</html>