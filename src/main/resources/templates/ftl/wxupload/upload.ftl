<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="${base}/css/upload.css" media="all">
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
<title>上传文件</title>
</head>

<body>
	<div class="up-bg">
		<div class="up-buttom" id="test3">上传文件</div>
	</div>
	<script src="${request.contextPath}/js/plugins/layui/layui.all.js"></script>
	<script src="${request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script src="${request.contextPath}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.3.2.js"></script>
</body>
<script type="text/javascript">
	layui.use('upload', function() {
		var $ = layui.jquery, upload = layui.upload, layer = layui.layer;
		var fileName;
		var fileSize;
		var status;
		upload
				.render({
					elem : '#test3',
					url : 'http://qzimp.cn/api/file/print/upload',
					accept : 'file' //普通文件
					,exts: 'png|jpg|doc|docx|ppt|pptx|pdf',
					before : function(obj) {
						obj.preview(function(index, file, result) {
							fileName = file.name;
							fileSize = file.size;
							if (fileSize > 1048576) {
								fileSize /= 1048576;
								fileSize = fileSize.toFixed(2);
								fileSize = fileSize + "mb";
							} else if (fileSize > 1024) {
								fileSize /= 1024;
								fileSize = fileSize.toFixed(2);
								fileSize = fileSize + "kb";
							} else {
								fileSize = fileSize.toFixed(2);
								fileSize = fileSize + "b";
							}
						});
						layer.load();
					},
					done : function(res) {
						var time, year, month, date, hours, minutes, seconds;
						time = new Date();
						year = time.getFullYear();

						//对日期进行处理,小于10的数在前面加上0
						month = (time.getMonth() + 1) < 10 ? ("0" + (time
								.getMonth() + 1)) : (time.getMonth() + 1);
						date = time.getDate() < 10 ? ("0" + time.getDate())
								: time.getDate();
						hours = time.getHours() < 10 ? ("0" + time.getHours())
								: time.getHours();
						minutes = (time.getMinutes() < 10 ? ("0" + time
								.getMinutes()) : time.getMinutes());
						seconds = (time.getSeconds() < 10 ? ("0" + time
								.getSeconds()) : time.getSeconds());

						//拼格式，如：2018-01-15 14:32:57
						time = year + "-" + month + "-" + date + " " + hours
								+ ":" + minutes + ":" + seconds;
						var path = res.data.src;
						var page = res.data.page;
						status = "true";
						
						var upArray = '[{"fileName":"' + fileName
								+ '","path":"' + path + '","time":"' + time
								+ '","fileSize":"' + fileSize + '","page":"'
								+ page+'","status":"'+status+ '"}]';
						var upJson = JSON.parse(upArray);
						console.log(upArray);
						console.log(typeof(upJson));
						/* var fileinfo = encodeURIComponent(JSON
								.stringify(upArray));
						wx.miniProgram.navigateTo({
							url : '/pages/homePage/homePage?fileinfo='
									+ upArray
						}); */
						
						  wx.miniProgram.postMessage({
	                        	data:{
	                        		fileName:upJson
	                        	}
	                        })
	                    	wx.miniProgram.navigateBack({
	                    	})
					}, error: function (index, upload) {
						status = "false";
						var upArray = '[{"fileName":"' + fileName
								+ '","path":"' + path + '","time":"' + time
								+ '","fileSize":"' + fileSize + '","page":"'
								+ page+'","status":"'+status+ '"}]';
						var upJson = JSON.parse(upArray);
						  wx.miniProgram.postMessage({
	                        	data:{
	                        		fileName:upJson
	                        	}
	                        })
	                    	wx.miniProgram.navigateBack({
	                    	})        
				    }
					
				});
	});
</script>
</html>