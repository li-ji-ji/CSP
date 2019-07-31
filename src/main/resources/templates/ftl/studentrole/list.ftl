<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生角色中间表管理</title>
    <link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
</head>

<body>


    <div class="layui-btn-group demoTable">
        <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
        <button class="layui-btn" data-type="batchDelete">批量删除</button>
        <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
        <button class="layui-btn" data-type="isAll">验证是否全选</button>
        <button class="layui-btn" style="background: antiquewhite;">
            <a href="/authority/studentrole/toedit">添加 </a>
        </button>
    </div>

    <table class="layui-table" lay-data="{width: 1200, height:330, url:'/authority/studentrole/all', page:true, id:'idTest'}"
        lay-filter="demo">
        <thead>
            <tr>
                <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
                <th lay-data="{field:'id', width:100, sort: true, fixed: true}">ID</th>
                <th lay-data="{field:'sn', width:100}">学号</th>
                <th lay-data="{field:'roleId', width:80}">角色ID</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
        </thead>
    </table>

    <script type="text/html" id="barDemo">
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>


    <script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <script>
        layui.use('table', function () {
            var table = layui.table;
            //监听表格复选框选择
            table.on('checkbox(demo)', function (obj) {
                console.log(obj)
            });
            //监听工具条
            table.on('tool(demo)', function (obj) {
                var data = obj.data;
                if (obj.event === 'detail') {
                    layer.msg('id：' + data.id + ' 的查看操作');
                } else if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        var xmlhttp;//原生ajax请求
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
                                    .msg('id：'
                                        + data.id
                                        + ' 的删除操作成功');
                            }
                        }
                        xmlhttp
                            .open(
                                "get",
                                "/authority/studentrole/delete?id="
                                + data.id,
                                true);
                        xmlhttp
                            .send();
                        obj.del();
                        layer.close(index);
                    });
                } else if (obj.event === 'edit') {
                    layer.alert('编辑行：<br>' + JSON.stringify(data))
                    window.location.href = "/authority/studentrole/toedit?id="+data.id;
                }
            });

            var $ = layui.$, active = {
                getCheckData: function () { //获取选中数据
                    var checkStatus = table.checkStatus('idTest')
                        , data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                }
                , getCheckLength: function () { //获取选中数目
                    var checkStatus = table.checkStatus('idTest')
                        , data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                }
                , isAll: function () { //验证是否全选
                    var checkStatus = table.checkStatus('idTest');
                    layer.msg(checkStatus.isAll ? '全选' : '未全选')
                }
                , batchDelete: function () {
                    var checkStatus = table.checkStatus('idTest')
                        , data = checkStatus.data;
                    layer.alert(JSON.stringify(data));

                    $.ajax({
                        url: "/authority/studentrole/batchdelete", type: "post", dataType: "json", data: { "jsonStr": JSON.stringify(data) }, success: function (e) {
                            console.log("请求成功！");
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
</body>

</html>