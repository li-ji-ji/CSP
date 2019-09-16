<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>前台导航添加</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="${base}/admin/js/jquery.min.js"></script>
<script src="${base}/admin/lib/layui/layui.all.js"></script>
<script src="${base}/admin/lib/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

	<fieldset class="layui-elem-field">
		  <legend>前台导航添加</legend>
		  <div class="layui-field-box">
			<form class="layui-form " method="post"
				action="/navigation/addNavigation" style="margin-top: 50px;">
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">位置</label>
					<div class="layui-input-block">
						<input type="radio" name="position" value="top" title="顶部" checked>
						<input type="radio" name="position" value="bottom" title="底部" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">链接</label>
					<div class="layui-input-block">
						<input type="text" name="url"  
							autocomplete="off" class="layui-input" style="width: 30%;">
					</div>
				</div>
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">导航名称</label>
					<div class="layui-input-inline">
						<input type="text" name="name"  required lay-verify="required" id="name"
							autocomplete="off" class="layui-input" >
					</div>
					<div class="layui-form-mid layui-word-aux" id="navName" style="color: red!important;display:none;">导航名称不能超过10个字符</div>
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
						<input type="checkbox" name="isNew" 
							lay-skin="switch" lay-text="是|否" checked>
					</div>
				</div>
		
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">排序</label>
					<div class="layui-input-inline">
						<input type="text" name="sort" required lay-verify="required"
							autocomplete="off" class="layui-input" >
					</div>
					<div class="layui-form-mid layui-word-aux" id="navName" ><i class="layui-icon layui-icon-face-smile-b" > 只能填写自然数哦</i></div>
				</div>
		
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formSubmit" style="margin-left:70px;">完成添加</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				
			</form>
		  	 
		  </div>
	</fieldset>
	




</body>
<script>
	
	$(document).ready(function(){
		//实时监听导航名称框是否超出规定字数
		$("#name").bind("input propertychange",function(event){
	    	var len = $('#name').val().length
	    	if(len>10){
	    		$('#navName').css("display","block");
	    	}else{
	    		$('#navName').css("display","none");
	    	}
		});
		
		//判断排序输入框只能为数值
		$('input[name="sort"]').on('input propertychange', function(e) {
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
			  if(data.field.name.length>10){
				  layer.msg('导航名称超过规定长度');
				  return false;
			  }
			
		  });
	});
</script>
</html>