<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<head>
<meta charset="UTF-8">
<title>新闻内容列表管理</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
	<table class="layui-table" id="NewsDetailTable" lay-filter="NewsDetailTable">
		<!-- 表头 -->
		
		<div class="demoTable" style="margin-top:10px;margin-left:20px;">
    	<span style="font-weight: bold;">新闻搜索:</span>
    		<div class="layui-inline">
        		<input class="layui-input" required lay-verify="required" id="keyword" placeholder="根据新闻关键字模糊查询" >
    		</div>
    		<button class="layui-btn" onclick="serach()" >搜索</button>

		</div>
		

		
		<thead>
			<tr>
				<th lay-data="{field:'id',checkbox:true,fixed:'left',align:'center'}"></th>
				<th lay-data="{field:'id',width:'250',fixed:'left',align:'center'}">ID</th>
				<th lay-data="{field:'newsTitle',width:'250',align:'center'}">新闻标题</th>
				<th lay-data="{field:'categoryId',width:'250',align:'center'}">分类编号</th>
				<th lay-data="{field:'categoryType',width:'100',align:'center'}">分类类型</th>
				<th lay-data="{field:'newsPubdate',width:'200',align:'center'}">新闻发布时间</th>
				<th lay-data="{field:'newsPublisher',width:'150',align:'center'}">新闻发布者</th>
				<th lay-data="{field:'newsKeyword',width:'100',align:'center'}">新闻关键字</th>
				<th lay-data="{field:'iscate',width:'100',align:'center'}">是否引用</th>
				<th lay-data="{field:'isaudit',width:'100',align:'center'}">是否审核</th>
				<th lay-data="{field:'newsContent',width:'200',align:'center'}">新闻内容</th>
				<th lay-data="{field:'newsPicture',width:'200',align:'center'}">新闻图片</th>
				<th lay-data="{field:'isshow',width:'100',align:'center'}">是否显示</th>
				<th lay-data="{field:'isdelete',width:'150',align:'center'}">是否删除标记</th>
				<th lay-data="{field:'citeAddress',width:'200',align:'center'}">引用地址</th>
				<th lay-data="{field:'citeAuthor',width:'100',align:'center'}">引用作者</th>
				<th lay-data="{field:'istop',width:'100',align:'center'}">是否置顶</th>
				<th lay-data="{field:'isrecommend',width:'100',align:'center'}">是否推荐</th>
				<th lay-data="{field:'newsHits',width:'100',align:'center'}">新闻点击数</th>
				<th lay-data="{field:'newsLikenum',width:'100',align:'center'}">新闻点赞数</th>
				<th lay-data="{field:'newsCommentCount',width:'100',align:'center'}">新闻评论数</th>
				<th lay-data="{field:'tool',width:'150',fixed:'right',align:'center'}">操作栏</th>
			</tr>
			<tbody>
				<#list newses as news>
					<tr>
						<td  lay-data="{checkbox:true,fixed:'left',align:'center'}"></td>
						<td>${news.id}</td>
						<td>${news.newsTitle}</td>
						<td>${news.categoryId}</td>
						<td>${news.categoryType}</td>
						<td>${news.newsPubdate}</td>
						<td>${news.newsPublisher}</td>
						<td>${news.newsKeyword}</td>
						<td>
							<#if news.iscate==1>
								引用
							<#else>
								未引用
							</#if>
						</td>
						<td>
							<#if news.isaudit==1>
								已审核
							<#else>
								待审核
							</#if>
						</td>
						<td>${news.newsContent}</td>
						<td>${news.newsPicture}</td>
						<td>
							<#if news.isshow==1>
								显示
							<#else>
								未显示
							</#if>
						</td>
						
						<td>
							<#if news.isdelete==1>
								是
							<#else>
								否
							</#if>
						</td>
						
						<td>${news.citeAddress}</td>
						<td>${news.citeAuthor}</td>
						<td>
							<#if news.istop==1>
								是
							<#else>
								否
							</#if>
						</td>
						
						<td>
							<#if news.isrecommend==1>
								是
							<#else>
								否
							</#if>
						</td>
						<td>${news.newsHits}</td>
						<td>${news.newsLikenum}</td>
						<td>${news.newsCommentCount}</td>
						
						<td>
		  					<a href="/news/toNewsEdit?operation=edit&id=${news.id}" class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
		  					<a href="/news/deleteOneNewsInRecycle?operation=delInRecycle&id=${news.id}" onClick="return confirm('确认删除？') " class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delInRecycle">删除</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</thead>
	</table>
	
	<script src="${base}/js/plugins/layui/layui.js"></script>
	
	<script type="text/html" id="toolbar">
  		<div class="layui-btn-container">
    		<a href="/news/toNewsAdd"><button class="layui-btn layui-btn-warm layui-btn-sm" >添加新闻</button></a>
    		<a href="/news/toNewsList?operation=isAudit"><button class="layui-btn layui-btn-sm" >查看已审核新闻</button></a>
			<a href="/news/toNewsList?operation=isNotAudit"><button class="layui-btn layui-btn-sm" >查看待审核新闻</button></a>
			<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getDeleteList">删除选中数据</button>
			<a href="/news/toNewsList?operation=isDelete"><button class="layui-btn layui-btn-sm" >新闻回收站</button></a>
			<a href="/news/toNewsList"><i class="layui-icon layui-icon-refresh-3" style="font-size: 20px;"></i></a>
  		</div>
	</script>
	<script>
	layui.use(['laypage','table'],function(){
		  var table = layui.table;
		  table.init('NewsDetailTable',{
			  height:500,
			  toolbar: '#toolbar',
			  page:true,
			  limit:10
		  });
		  
		  
		  table.on('toolbar(NewsDetailTable)', function(obj){
			    var checkStatus = table.checkStatus(obj.config.id);
			    switch(obj.event){
			      case 'getDeleteList':
			        var data = checkStatus.data;
			        var idList=[]
			        for(var item of data){
			        	idList.push(item.id)
			        };
			        if(data.length === 0){
			            layer.msg('请至少选择一行');
			         }
			        else{
			        layer.confirm('确认删除选中数据', function(index){
			        	$.ajax({
					    	  "url" : "/news/deleteNewsListInRecycle",
					    	  "data" : "idList="+idList,
					    	  "type" : "post",
					    	  "dataType" : "json",
					    	  "success"	: function (resultMsg) {
					    		  if(resultMsg==1){
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "删除成功"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '/news/toNewsList'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }else{
					    			  layer.open({
					    				    type: 1 //不显示标题栏   title : false/标题
					    				    ,title: "删除失败"
					    				    ,btn: ['好的']
					    				    ,btnAlign: 'c'
					    				    ,success: function(layero){
					    				         var btn = layero.find('.layui-layer-btn');
					    				            btn.find('.layui-layer-btn0').attr({
					    				                 href: '/news/toNewsList'
					    				            ,target: '_self'
					    				        });
					    				    }
					    				});
					    		  }
			    			  
							}
					      });
			          });
			    	}
			      break;
			    };
			  });
		  
	})
	
	$("#keyword").keyup(function(event){
            if(event.keyCode ==13){
             var newsKeyword=$("#keyword").val();
             if(newsKeyword.length>0){
             	var url="/news/selectNewsByNewsKeyword?newsKeyword="+newsKeyword
             	window.location.href = url;  
             }
             else{
            	 layer.msg("搜索条件不能为空");
             }
            }
        });
    
    function serach(){
    	 var newsKeyword=$("#keyword").val();
    	 if(newsKeyword.length>0){
          	var url="/news/selectNewsByNewsKeyword?newsKeyword="+newsKeyword
          	window.location.href = url;  
          }
          else{
        	  layer.msg("搜索条件不能为空");
          }

    }
    
    
    

    
	
	</script>
</body>
</html>