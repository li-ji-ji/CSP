<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="${request.contextPath}/css/upload.css"
	media="all">
<link rel="stylesheet"
	href="${request.contextPath}/js/plugins/layui/css/layui.css"
	media="all">
<title>文件上传</title>
</head>

<body>
	<div class="up-bg">
		<div class="up-buttom" onclick="up()" id="test3">上传文件</div>
	</div>
	<script src="${request.contextPath}/js/plugins/layui/layui.all.js"></script>
	<script src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${request.contextPath}/js/plugins/layui/layui.js"></script>
</body>
<script type="text/javascript">
	layui.use('upload', function() {
		var $ = layui.jquery, upload = layui.upload;
		upload.render({
			elem : '#test3',
			url : 'http://qzimp.cn/api/print/upload',
			accept : 'file' //普通文件
			,
			done : function(res) {
				
			}
		});
	});
</script>
</html>