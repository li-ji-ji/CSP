<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻添加</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<script src="${base}/js/plugins/layui/layui.js"></script>
</head>
<body>
<form class="layui-form " method="post" action="${base}/news/addNews" style="margin-top:50px;"   >
  
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">新闻标题</label>
    <div class="layui-input-block">
      <input type="text" name="newsTitle" required  placeholder="请填写新闻标题" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
  
   <div class="layui-form-item" hidden="true">
    <label  class="layui-form-label" style="width: 150px;">分类编号</label>
    <div class="layui-input-block">
      <input type="text" id="categoryId" name="categoryId" readonly value="0" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
 	<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">分类类型</label>
			
			<div class="layui-input-block" id="parentName" style="width:10%;margin-left:180px;">
				<select name="categoryType" required lay-filter="aihao" lay-search >
				<option value="0" ></option>
				<#list categories as item>
					<option value="${item.id}" >${item.categorytype}</option>
				</#list>
				</select>
			</div>
	</div>
	
	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">新闻发布者</label>
    	<div class="layui-input-block">
      		<input type="text" name="newsPublisher" required placeholder="请填写新闻发布者" autocomplete="off" class="layui-input" style="width: 20%;">
    	</div>
 	</div>
 	
	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">新闻关键字</label>
    	<div class="layui-input-block">
      		<input type="text" name="newsKeyword" placeholder="请填写新闻关键字" autocomplete="off" class="layui-input" style="width: 20%;">
    	</div>
 	</div>
 	
 	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">新闻发布时间</label>
    	<div class="layui-inline"> 
  			<input type="text" name="newsPubdate"   placeholder="请选择发布时间"  class="layui-input" id="time"  >
		</div>
 	</div>
 	
 	<div class="layui-form-item">
 		<label class="layui-form-label" style="width: 150px;">新闻图片</label>
 		<div class="layui-inline"> 
  			<input type="text" name="newsPicture" readonly id="newsPicture"  placeholder="图片地址"  class="layui-input" >
		</div>
    	<button type="button" class="layui-btn" id="uploadImage">
  			<i class="layui-icon">&#xe67c;</i>上传图片
		</button>
		
 	</div>
 	
 	
 	<div class="layui-form-item">
 		<label class="layui-form-label" style="width: 150px;">新闻内容</label>
 		<div class="layui-inline" style="width: 50%;"> 
 			<textarea id="newscontent"  name="newsContent"   style="display: none;"></textarea>
		</div>
 	</div>
  
  
  	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">是否引用</label>
    	<div class="layui-input-block"  >
      		<input type="checkbox" name="iscate"  id="isCate" lay-filter="yinyong"  lay-skin="switch" value="1" lay-text="引用|未引用" checked >
    	</div>
  	</div>
  	
  	
  	<div class="layui-form-item adress ">
    	<label class="layui-form-label" style="width: 150px;">引用地址</label>
    	<div class="layui-input-block">
      		<input type="text" name="citeAddress" placeholder="请填写引用地址" autocomplete="off" class="layui-input" style="width: 50%;">
    	</div>
 	</div>
 	
 	<div class="layui-form-item  author">
    	<label class="layui-form-label" style="width: 150px;">引用作者</label>
    	<div class="layui-input-block">
      		<input type="text" name="citeAuthor" placeholder="请填写引用作者" autocomplete="off" class="layui-input" style="width: 20%;">
    	</div>
 	</div>
  	
  	
  	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">是否审核</label>
    	<div class="layui-input-block">
      		<input type="checkbox" name="isaudit"  lay-skin="switch" value="0" lay-text="已审核|待审核"  >
    	</div>
  	</div>
  	
  
  	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">是否显示</label>
    	<div class="layui-input-block">
      		<input type="checkbox" name="isshow"  lay-skin="switch" value="1" lay-text="显示|未显示" checked >
    	</div>
  	</div>
  
  

  	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">是否为删除标记</label>
    	<div class="layui-input-block">
      		<input type="checkbox" name="isdelete"  lay-skin="switch" value="0" lay-text="是|否"  >
    	</div>
  	</div>
  
  	
 	
 	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">是否置顶</label>
    	<div class="layui-input-block">
      		<input type="checkbox" name="istop"  lay-skin="switch" value="0" lay-text="是|否"  >
    	</div>
  	</div>
  	
  	<div class="layui-form-item">
    	<label class="layui-form-label" style="width: 150px;">是否推荐</label>
    	<div class="layui-input-block">
      		<input type="checkbox" name="isrecommend"  lay-skin="switch" value="0" lay-text="是|否"  >
    	</div>
  	</div>
  	
  	<div class="layui-form-item" hidden="true">
    	<label  class="layui-form-label" style="width: 150px;">新闻点击次数</label>
    	<div class="layui-input-block">
      		<input type="text"  name="newsHits" readonly value="0" autocomplete="off" class="layui-input" style="width: 10%;">
    	</div>
  	</div>
  	
  	<div class="layui-form-item" hidden="true">
    	<label  class="layui-form-label" style="width: 150px;">新闻点赞数</label>
    	<div class="layui-input-block">
      		<input type="text"  name="newsLikenum" readonly value="0" autocomplete="off" class="layui-input" style="width: 10%;">
    	</div>
  	</div>
  	
  	<div class="layui-form-item" hidden="true">
    	<label  class="layui-form-label" style="width: 150px;">新闻评论数</label>
    	<div class="layui-input-block">
      		<input type="text"  name="newsCommentCount" readonly value="0" autocomplete="off" class="layui-input" style="width: 10%;">
    	</div>
  	</div>

  
  
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button  class="layui-btn" type="submit" >完成添加</button>
    </div>
  </div>
</form>
<script type="text/javascript">
	var status=$("#isCate").val()
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('select(aihao)', function(data){
			  //根据parentName绑定parentId
			  $("#categoryId").attr("value",data.value)
		  })
		  
		   //监听是否引用按钮
		  form.on('switch(yinyong)', function(data){
		  		if(status==0){
				  $(".adress").show();
				  $(".author").show();
				  status=1;
		  		}
		  		else{
					  $(".adress").hide();
					  $(".author").hide();
					  $(".adress input").attr("value","")
					  $(".author input").attr("value","")
					  status=0;
		  		}
		  })
		  
		});
	
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#time' //指定元素
		    ,format: 'yyyy-MM-dd HH:mm' //可任意组合
		  });
		});
	
	
	layui.use('upload', function(){
		  var upload = layui.upload;
		   
		  //执行实例
		  var uploadInst = upload.render({
		    elem: '#uploadImage' //绑定元素
		    ,url: 'http://qzimp.cn/api/file/phoneImageUpload' //上传接口
		    ,done: function(res){
		      //上传完毕回调
		      $("#newsPicture").attr("value",res.data.src);
		    }
		    ,error: function(){
		      //请求异常回调
		    }
		  });
		});
	
	
	layui.use('layedit', function(){
		  var layedit = layui.layedit;
		  
		  layedit.set({
			  uploadImage: {
			    url: 'http://qzimp.cn/api/file/phoneImageUpload' //接口url
			    ,type: 'post' //默认post
			    ,done: function(res){
					//上传完毕回调
				}
				,error: function(){
				 	//请求异常回调
				}
			    
			  }
			});
		  
		  layedit.build('newscontent',{
			  height: 300
		  }); //建立编辑器
		  
		});
	
	
	
</script>

</body>
</html>