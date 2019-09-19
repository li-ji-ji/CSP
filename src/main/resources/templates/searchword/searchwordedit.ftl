<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索关键词编辑</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">
<script type="text/javascript" src="${base}/admin/js/jquery.min.js"></script>
<script src="${base}/admin/lib/layui/layui.all.js"></script>
<script src="${base}/admin/lib/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

	<fieldset class="layui-elem-field">
		  <legend>搜索关键词编辑</legend>
		  <div class="layui-field-box">
			<form class="layui-form " method="post"
				action="/searchword/updateSearchWord" style="margin-top: 50px;">
		
				<div class="layui-form-item" hidden="true">
					<label class="layui-form-label" style="width: 150px;">搜索关键词ID</label>
					<div class="layui-input-block">
						<input type="text" name="id" value="${searchWord.id}"
							autocomplete="off" readonly class="layui-input" style="width: 5%;">
					</div>
				</div>
		
				
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">关键词</label>
					<div class="layui-input-block">
						<input type="text" name="keywords" value="${searchWord.keywords}" 
							required lay-verify="required" autocomplete="off" class="layui-input"
							 style="width: 30%;">
					</div>
					
				</div>
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">拼音全拼</label>
					<div class="layui-input-inline">
						<input type="text" name="pinyinFull" value="${searchWord.pinyinFull}" 
							 autocomplete="off"
							class="layui-input">
					</div>
				
				</div>
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">拼音简写</label>
					<div class="layui-input-inline">
						<input type="text" name="pinyinSimple" value="${searchWord.pinyinSimple}" 
							 autocomplete="off"
							class="layui-input">
					</div>
				
				</div>
				
		
		
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">搜索次数</label>
					<div class="layui-input-inline">
						<input type="text" name="searchNum" value="${searchWord.searchNum}" 
							readonly autocomplete="off" class="layui-input">
					</div>
					
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 150px;">商品数量</label>
					<div class="layui-input-inline">
						<input type="text" name="goodsNum" value="${searchWord.goodsNum}" 
							readonly autocomplete="off" class="layui-input">
					</div>
					
				</div>
		
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formSubmit"
							style="margin-left: 70px;">完成修改</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		  </div>
	</fieldset>
	





</body>
<script>
	layui.use('form', function() {
		var form = layui.form;

		//监听提交
		form.on('submit(formSubmit)', function(data) {
			if (data.field.keywords.length<=0) {
				layer.msg('关键词不能为空!');
				return false;
			}

		});
		
	});
</script>
</html>