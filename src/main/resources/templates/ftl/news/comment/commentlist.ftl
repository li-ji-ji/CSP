<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>新闻评论列表管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="NewsCategoryTable" lay-filter="NewsCategoryTable">
		<!-- 表头 -->
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'250',fixed:'left',align:'center'}">ID</th>
				<th lay-data="{field:'newsId',width:'250',align:'center'}">评论新闻编号</th>
				<th lay-data="{field:'commentContent',width:'200',align:'center'}">评论内容</th>
				<th lay-data="{field:'commentTime',width:'150',align:'center'}">评论时间</th>
				<th lay-data="{field:'commentorId',width:'100',align:'center'}">评论者编号</th>
				<th lay-data="{field:'commentorName',width:'100',align:'center'}">评论者</th>
				<th lay-data="{field:'commentLikenum',width:'100',align:'center'}">评论点赞数</th>
				<th lay-data="{field:'commentStatus',width:'100',align:'center'}">评论状态</th>
				<th lay-data="{field:'tool',width:'120',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list comments as comment>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}"></td>
						<td>${comment.id}</td>
						<td>${comment.newsId}</td>
						<td>${comment.commentContent}</td>
						<td>${comment.commentTime}</td>
						<td>${comment.commentorId}</td>
						<td>${comment.commentorName}</td>
						<td>${comment.commentLikenum}</td>
						<td>
							<#if comment.commentStatus==1>
								开启
							<#else>
								关闭
							</#if>
						</td>
						
						
						<td>
		  					<a href="/comment/deleteOneComment?operation=del&id=${comment.id}" onClick="return confirm('确认删除吗？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/js/plugins/layui/layui.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
			<a href="/comment/toCommentList"><i class="layui-icon layui-icon-refresh-3" style="font-size: 20px;"></i></a>
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