<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>友情链接添加</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="${base}/admin/js/jquery.min.js"></script>
<script src="${base}/admin/lib/layui/layui.all.js"></script>
<script src="${base}/admin/lib/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

	<form class="layui-form " method="post"
		action="/friendlink/addFriendLink" style="margin-top: 50px;">



		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">链接名称</label>
			<div class="layui-input-inline">
				<input type="text" name="linkName"  required
					lay-verify="required" id="name" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux" id="linkName"
				style="color: red !important; display: none;">链接名称不能超过10个字符
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">链接地址</label>
			<div class="layui-input-inline">
				<input type="text" name="linkUrl" 
					lay-verify="url" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux" >
				<i class="layui-icon layui-icon-unlink"> 友情链接跳转地址,如:http://www.baidu.com,若无链接请填写'#'符号</i>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">链接LOGO</label>
			<div class="layui-input-block">
				<input type="text" name="linkLogo" 
					 autocomplete="off" class="layui-input"
					style="width: 30%;">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">排序</label>
			<div class="layui-input-inline">
				<input type="text" name="orderby"  required
					lay-verify="required" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux" >
				<i class="layui-icon layui-icon-face-smile-b"> 只能填写自然数哦</i>
			</div>
		</div>
		

		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">显示</label>
			<div class="layui-input-block">
				<input type="checkbox" name="isShow" 
					lay-skin="switch" lay-text="是|否" checked>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">新窗口打开</label>
			<div class="layui-input-block">
				<input type="checkbox" name="target" 
					lay-skin="switch" lay-text="是|否" checked>
			</div>
		</div>


		

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formSubmit"
					style="margin-left: 70px;">完成添加</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>





</body>
<script>
	
	$(document).ready(function(){
		//实时监听导航名称框是否超出规定字数
		$("#name").bind("input propertychange",function(event){
	    	var len = $('#name').val().length
	    	if(len>10){
	    		$('#linkName').css("display","block");
	    	}else{
	    		$('#linkName').css("display","none");
	    	}
		});
		
		//判断排序输入框只能为数值
		$('input[name="orderby"]').on('input propertychange', function(e) {
			var text = $(this).val().replace(/[^\d]/g, "");
			$(this).val(text)
		});

	});
	
</script>
<script>
	layui.use('form', function() {
		var form = layui.form;
		
		//监听提交
		  form.on('submit(formSubmit)', function(data){
			  if(data.field.linkName.length>10){
				  layer.msg('链接名称超过规定长度');
				  return false;
			  }
			
		  });
		
		  form.verify({
			  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
			  url: [
				  /(^$)|(^#)|(^http(s*):\/\/[^\s]+\.[^\s]+)/
			    ,'链接格式不正确'
			  ] 
			}); 
	});
</script>
</html>