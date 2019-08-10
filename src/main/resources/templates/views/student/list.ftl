
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>å­¦çç®¡ç</title>
    <link rel="stylesheet" href="${request.contextPath}/static/js/plugins/layui/css/layui.css" media="all">
</head>

<body>


    <div class="layui-btn-group demoTable">
        <button class="layui-btn" data-type="getCheckData">è·åéä¸­è¡æ°æ®</button>
        <button class="layui-btn" data-type="batchDelete">æ¹éå é¤</button>
        <button type="button" class="layui-btn" id="test3"><i class="layui-icon">î¼</i>excleæä»¶å¯¼å¥</button>
        <button class="layui-btn" data-type="getCheckLength">è·åéä¸­æ°ç®</button>
        <button class="layui-btn" data-type="isAll">éªè¯æ¯å¦å¨é</button>
        <button class="layui-btn" style="background: antiquewhite;">
            <a href="/bg/student/toedit">æ·»å  </a>
        </button>
    </div>

    <table class="layui-table" lay-data="{width: 1200, height:330, url:'/bg/student/all', page:true, id:'idTest'}"
        lay-filter="demo">
        <thead>
            <tr>
                <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
                <th lay-data="{field:'sn', width:100, sort: true, fixed: true}">å­¦å·</th>
                <th lay-data="{field:'name', width:80}">å§å</th>
                <th lay-data="{field:'dormitoryAdd', width:80, sort: true}">å®¿è</th>
                <th lay-data="{field:'phone', width:80}">çµè¯</th>
                <th lay-data="{field:'email', width:160}">é®ç®±</th>
                <th lay-data="{field:'college', width:80, sort: true}">å­¦é¢</th>
                <th lay-data="{field:'classes', width:80}">ç­çº§</th>
                <th lay-data="{field:'grade', width:80, sort: true}">å¹´çº§</th>
                <th lay-data="{field:'major', width:135, sort: true}">ä¸ä¸</th>
                <th lay-data="{field:'famillyAdd', width:80, sort: true,fixed: 'right'}">å®¶åº­å°å</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
        </thead>


    </table>

    <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">æ¥ç</a>
      <a class="layui-btn layui-btn-xs" lay-event="edit">ç¼è¾</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">å é¤</a>
    </script>


    <script src="${request.contextPath}/static/js/plugins/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <!-- æ³¨æï¼å¦æä½ ç´æ¥å¤å¶ææä»£ç å°æ¬å°ï¼ä¸è¿°jsè·¯å¾éè¦æ¹æä½ æ¬å°ç -->
    <script>
        layui.use('table', function () {
            var table = layui.table;
            //çå¬è¡¨æ ¼å¤éæ¡éæ©
            table.on('checkbox(demo)', function (obj) {
                console.log(obj)
            });
            //çå¬å·¥å·æ¡
            table.on('tool(demo)', function (obj) {
                var data = obj.data;
                if (obj.event === 'detail') {
                    layer.msg('snï¼' + data.sn + ' çæ¥çæä½');
                } else if (obj.event === 'del') {
                    layer.confirm('ççå é¤è¡ä¹', function (index) {
                        var xmlhttp;//åçajaxè¯·æ±
                        if (window.XMLHttpRequest) {
                            // code for IE7+, Firefox, Chrome, Opera, Safari
                            xmlhttp = new XMLHttpRequest();
                        } else {// code for IE6, IE5a
                            xmlhttp = new ActiveXObject(
                                "Microsoft.XMLHTTP");
                        }
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState == 4
                                && xmlhttp.status == 200) {
                                layer
                                    .msg('snï¼'
                                        + data.sn
                                        + ' çå é¤æä½æå');
                            }
                        }
                        xmlhttp
                            .open(
                                "get",
                                "/bg/student/delete?sn="
                                + data.sn,
                                true);
                        xmlhttp
                            .send();
                        obj.del();
                        layer.close(index);
                    });
                } else if (obj.event === 'edit') {
                    layer.alert('ç¼è¾è¡ï¼<br>' + JSON.stringify(data))
                    window.location.href = "/bg/student/toedit?sn="
                        + data.sn;
                }
            });

            var $ = layui.$, active = {
                getCheckData: function () { //è·åéä¸­æ°æ®
                    var checkStatus = table.checkStatus('idTest')
                        , data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                }
                , getCheckLength: function () { //è·åéä¸­æ°ç®
                    var checkStatus = table.checkStatus('idTest')
                        , data = checkStatus.data;
                    layer.msg('éä¸­äºï¼' + data.length + ' ä¸ª');
                }
                , isAll: function () { //éªè¯æ¯å¦å¨é
                    var checkStatus = table.checkStatus('idTest');
                    layer.msg(checkStatus.isAll ? 'å¨é' : 'æªå¨é')
                }
                , batchDelete: function () {
                    var checkStatus = table.checkStatus('idTest')
                        , data = checkStatus.data;
                    layer.alert(JSON.stringify(data));

                    $.ajax({
                        url: "/bg/student/batchdelete", type: "post", dataType: "json", data: { "jsonStr": JSON.stringify(data) }, success: function (e) {


                            alert("æåè¯·æ±");
                            console.log("chen");
                        }
                    });
                    window.location.reload();
                }
            };

            $('.demoTable .layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        });
    </script>

    <script>
        layui.use('upload', function () {
            var $ = layui.jquery
                , upload = layui.upload;


          //指定允许上传的文件类型
            upload.render({
                elem: '#test3'
                , url: '/bg/student/excelimport'
                , accept: 'file' //普通文件
                , done: function (res) {
                    console.log("hello")
                }
                , error: function (index, upload) {
                	//当上传失败时，你可以生成一个“重新上传”的按钮，点击该按钮时，执行 upload() 方法即可实现重新上传
                }
            });
            upload.render({ //允许上传的文件后缀
                elem: '#test4'
                , url: '/bg/student/excelimport'
                , accept: 'file' //普通文件
                , exts: 'zip|rar|7z' //只允许上传压缩文件
                , done: function (res) {
                    console.log(res)
                }
            });

            //绑定原始文件域
            upload.render({
                elem: '#test20'
                , url: '/upload/'
                , done: function (res) {
                    console.log(res)
                }
            });

        });
    </script>

</body>

</html>