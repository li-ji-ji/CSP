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
	<script type="text/javascript"
		src="https://res.wx.qq.com/open/js/jweixin-1.3.2.js"></script>
</body>
<script type="text/javascript">
	layui
			.use(
					[ 'form', 'layer', "jquery", 'element', 'laydate', "upload" ],
					function() {
						var $ = layui.jquery, upload = layui.upload, element = layui.element, layer = layui.layer;
						var fileName;
						var fileSize;
						var status;
						var path;
						var time;
						var page;


						//上传进度监听方法
						var xhrOnProgress = function(fun) {
						    xhrOnProgress.onprogress = fun; //绑定监听
						    //使用闭包实现监听绑
						    return function() {
						    //通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
						    var xhr = $.ajaxSettings.xhr();

						    //判断监听函数是否为函数
						    if(typeof xhrOnProgress.onprogress !== 'function'){
						        return xhr;
						    }

						    //如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
						    if(xhrOnProgress.onprogress && xhr.upload) {
						        xhr.upload.onprogress = xhrOnProgress.onprogress;
						    }
						    return xhr;
						    }
						}

						
						upload
								.render({
									elem : '#test3',
									url : 'http://qzimp.cn/api/file/print/upload',
									accept : 'file' //普通文件
									,
									exts : 'png|jpg|doc|docx|ppt|pptx|pdf',				
									before : function(obj) {
										obj.preview(function(index, file,
												result) {
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
										xhrOnProgress(function(e){
											layer.log(123);
											 var percent = e.loaded / e.total;//计算百分比
										      console.log(percent);
											});
									},
									xhr: xhrOnProgress(function(e) {
								        var percent = e.loaded / e.total;//计算百分比
								        console.log(percent);
								    }),
									done : function(res) {
										var time, year, month, date, hours, minutes, seconds;
										time = new Date();
										year = time.getFullYear();
										//对日期进行处理,小于10的数在前面加上0
										month = (time.getMonth() + 1) < 10 ? ("0" + (time
												.getMonth() + 1))
												: (time.getMonth() + 1);
										date = time.getDate() < 10 ? ("0" + time
												.getDate())
												: time.getDate();
										hours = time.getHours() < 10 ? ("0" + time
												.getHours())
												: time.getHours();
										minutes = (time.getMinutes() < 10 ? ("0" + time
												.getMinutes())
												: time.getMinutes());
										seconds = (time.getSeconds() < 10 ? ("0" + time
												.getSeconds())
												: time.getSeconds());

										//拼格式，如：2018-01-15 14:32:57
										time = year + "-" + month + "-" + date
												+ " " + hours + ":" + minutes
												+ ":" + seconds;
										var path = res.data.src;
										var page = res.data.page;
										status = "true";
										var upArray = '[{"fileName":"'
												+ fileName + '","path":"'
												+ path + '","time":"' + time
												+ '","fileSize":"' + fileSize
												+ '","page":"' + page
												+ '","status":"' + status
												+ '"}]';
										var upJson = JSON.parse(upArray);
										console.log(upArray);
										console.log(typeof (upJson));
										/* var fileinfo = encodeURIComponent(JSON
												.stringify(upArray));
										wx.miniProgram.navigateTo({
											url : '/pages/homePage/homePage?fileinfo='
													+ upArray
										}); */
										wx.miniProgram.postMessage({
											data : {
												fileName : upJson
											}
										})
										wx.miniProgram.navigateBack({})
									},
									error : function(index, upload) {
										if(page==0||fileSize>0){
												page=1;
											}
										status = "false";
										var upArray = '[{"fileName":"'
												+ fileName + '","path":"'
												+ path + '","time":"' + time
												+ '","fileSize":"' + fileSize
												+ '","page":"' + page
												+ '","status":"' + status
												+ '"}]';
										var upJson = JSON.parse(upArray);
										wx.miniProgram.postMessage({
											data : {
												fileName : upJson
											}
										})
										wx.miniProgram.navigateBack({})
									}
								});
						
					});


</script>
</html>