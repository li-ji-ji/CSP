<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<meta charset="UTF-8" />
<head>
<title>文件上传</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet" href="${base}/css/upload.css" media="all">
<script src="${base}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://res.wx.qq.com/open/js/jweixin-1.3.2.js"></script>
</head>
<body class="container">
	<span id="time"></span>
	<div>
		<div class="up-bg d-flex flex-column center">
			<div>
				<input class="btn btn-info btn-xs" type="file" name="file"
					style="font-size: 38px;" /><br />
			</div>
			<br />
			<div style="width: 98%;">
				<div class="progress progress-striped active"
					style="display:; height: 100px;">
					<div id="progressBar" class="progress-bar progress-bar-success"
						role="progressbar" aria-valuemin="0" aria-valuenow="0"
						aria-valuemax="100" style="width: 20%"></div>
				</div>
				<!-- 显示文件信息 -->
				<div id="showFieInfo" style="font-size: 40px;">
					<label name="upfileName"></label><br /> <label name="upfileSize"></label><br />
					<label name="upfileType"></label><br />
				</div>
				<div class="">
					<input class="btn btn-success btn-xs" type="button" name="upload"
						value="上传" style="font-size: 50px;" /> <input
						class="btn btn-success btn-xs" type="button" name="cancelUpload"
						value="取消" style="font-size: 50px; margin-left: 68%;" />
				</div>
			</div>
			<!-- 显示上传速度 -->
			<div id="showInfo" class="" style="font-size: 50px;">0KB/s</div>
		</div>
	</div>

</body>
<script type="text/javascript">
    var fileBtn = $("input[name=file]");
    var processBar= $("#progressBar");
    var uploadBtn=$("input[name=upload]");
    var canelBtn=$("input[name=cancelUpload]");
    var ot;//上传开始时间
    var oloaded;//已上传文件大小
    var fileSize;//文件大小
    var fileName;//文件名字
    var status;
    fileBtn.change(function() {
        var fileObj = fileBtn.get(0).files[0]; //js获取文件对象
        if (fileObj) {
            fileSize = getSize(fileObj.size);
            fileName = fileObj.name;
            $("label[name=upfileName]").text('文件名：' + fileObj.name);
            $("label[name=upfileSize]").text('文件大小：' + fileSize);
            uploadBtn.attr('disabled', false);
        }
    });
    // 上传文件按钮点击的时候
    uploadBtn.click(function(){
        // 进度条归零
        setProgress(0);
        // 上传按钮禁用
        $(this).attr('disabled', true);
        // 进度条显示
       // showProgress();
        // 上传文件
        uploadFile();
    });
    function uploadFile(){
    	var url ="/csp/print/upload";
        //var url ="https://qzimp.cn/api/file/print/upload";
        var fileObj = fileBtn.get(0).files[0];
        if(fileObj==null){
            alert("请选择文件");
            return;
        }
        // FormData 对象
        var form = new FormData();
        form.append('file', fileObj); // 文件对象
        // XMLHttpRequest 对象
        var xhr = new XMLHttpRequest();
        //true为异步处理
        xhr.open('post', url, true);
        //上传开始执行方法
        xhr.onloadstart = function() {
             console.log('开始上传')
             ot = new Date().getTime();   //设置上传开始时间
             oloaded = 0;//已上传的文件大小为0
        };
       
        xhr.upload.addEventListener('progress', progressFunction, false);
        xhr.addEventListener("load", uploadComplete, false);
        xhr.addEventListener("error", uploadFailed, false);
        xhr.addEventListener("abort", uploadCanceled, false);
        xhr.send(form);
        
        function progressFunction(evt) {
            if (evt.lengthComputable) {
                var completePercent = Math.round(evt.loaded / evt.total * 80)
                        + '%';
                processBar.width(completePercent);
                processBar.text(completePercent);
                
                var time = $("#time");
                var nt = new Date().getTime();     //获取当前时间
                var pertime = (nt-ot)/1000;        //计算出上次调用该方法时到现在的时间差，单位为s
                ot = new Date().getTime();          //重新赋值时间，用于下次计算
                var perload = evt.loaded - oloaded; //计算该分段上传的文件大小，单位b       
                oloaded = evt.loaded;               //重新赋值已上传文件大小
            
                //上传速度计算
                var speed = perload/pertime;//单位b/s
                var bspeed = speed;
                var units = 'b/s';//单位名称
                if(speed/1024>1){
                    speed = speed/1024;
                    units = 'k/s';
                }
                if(speed/1024>1){
                    speed = speed/1024;
                    units = 'M/s';
                }
                speed = speed.toFixed(1);
                //剩余时间
                var resttime = ((evt.total-evt.loaded)/bspeed).toFixed(1);
                $("#showInfo").html(speed+units+'，进度百分比：'+completePercent+'');
            }
        }

        //上传成功后回调                                                                 
        function uploadComplete(evt) {
        	processBar.width(750);
        	$("#showInfo").html('0k/s'+'，进度百分比：100%');
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
        	var fileImage = "";
        	var index = fileName.lastIndexOf(".");
        	var suffix = fileName.substr(index+1);
        	console.log(suffix);
        	switch(suffix){
        		case 'png':
            		fileImage='../../images/im.png';
            		break;
        		case 'jpg':
        			fileImage='../../images/im.png';
        			break;
        		case 'ppt':
            		fileImage='../../images/ppt.png';
            		break;
        		case 'pptx':
            		fileImage='../../images/ppt.png';
            		break;
        		case 'doc':
        			fileImage='../../images/doc.png';
            		break;
        		case 'docx':
        			fileImage='../../images/doc.png';
            		break;
        		case 'pdf':
            		fileImage='../../images/pdf.png';
            		break;
        	}
    		//拼格式，如：2018-01-15 14:32:57
    		time = year + "-" + month + "-" + date
    				+ " " + hours + ":" + minutes
    				+ ":" + seconds;
            var returnString = evt.srcElement.response;
            var returnObject = JSON.parse(returnString);
            var path = returnObject.data.src;
            var page = Number(returnObject.data.page);
            if(page==0&&fileSize!='0KB'){
				page=1;
                }
            status = 'true';
        	var upArray = '[{"fileImage":"'+fileImage+'","fileName":"'
				+ fileName + '","path":"'
				+ path + '","time":"' + time
				+ '","fileSize":"' + fileSize
				+ '","page":"' + page
				+ '","status":"' + status
				+ '"}]';
        	var upJson = JSON.parse(upArray);
        	console.log(upArray);
            uploadBtn.attr('disabled', false);
            console.log('上传完成');
            wx.miniProgram.postMessage({
											data : {
												fileName : upJson
											}
										})
			wx.miniProgram.navigateBack({
				
				})
        };

        //上传失败回调            
        function uploadFailed(evt) {
            console.log('上传失败' + evt.target.responseText);
        }

        //终止上传      
        function cancelUpload() {
            xhr.abort();
        }
        
        //上传取消后回调             
        function uploadCanceled(evt) {
            console.log('上传取消,上传被用户取消或者浏览器断开连接:' + evt.target.responseText);
        }
        
        canelBtn.click(function(){
            uploadBtn.attr('disabled', false);
            cancelUpload();
        })
    }
    function getSize(size) {
        var fileSize = '0KB';
        if (size > 1024 * 1024) {
            fileSize = (Math.round(size / (1024 * 1024))).toString() + 'MB';
        } else {
            fileSize = (Math.round(size / 1024)).toString() + 'KB';
        }
        return fileSize;
    }
    function setProgress(w) {
        processBar.width(w + '%');
    }
    function showProgress() {
        processBar.parent().show();
    }
    function hideProgress() {
        processBar.parent().hide();
    }
</script>
</html>