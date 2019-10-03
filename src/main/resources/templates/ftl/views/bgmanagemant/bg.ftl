<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>学生后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/static/js/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">layui åå°å¸å±</div>
            <!-- å¤´é¨åºåï¼å¯éålayuiå·²æçæ°´å¹³å¯¼èªï¼ -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="">æ§å¶å°</a></li>
                <li class="layui-nav-item"><a href="">ååç®¡ç</a></li>
                <li class="layui-nav-item"><a href="">ç¨æ·</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">å¶å®ç³»ç»</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">é®ä»¶ç®¡ç</a></dd>
                        <dd><a href="">æ¶æ¯ç®¡ç</a></dd>
                        <dd><a href="">ææç®¡ç</a></dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                        è´¤å¿
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="">åºæ¬èµæ</a></dd>
                        <dd><a href="">å®å¨è®¾ç½®</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">éäº</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- å·¦ä¾§å¯¼èªåºåï¼å¯éålayuiå·²æçåç´å¯¼èªï¼ -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">ææåå</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/bg/student/index" target="view-iframe">学生列表</a></dd>
                            <dd><a href="/bg/studentrole/index" target="view-iframe">学生角色中间表</a></dd>
                            <dd><a href="/bg/role/index" target="view-iframe">角色表</a></dd>
                            <dd><a href="/bg/rolepermission/index" target="view-iframe">角色权限</a></dd>
                            <dd><a href="/bg/permission/index" target="view-iframe">权限</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">è§£å³æ¹æ¡</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;">åè¡¨ä¸</a></dd>
                            <dd><a href="javascript:;">åè¡¨äº</a></dd>
                            <dd><a href="">è¶é¾æ¥</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="">äºå¸åº</a></li>
                    <li class="layui-nav-item"><a href="">åå¸åå</a></li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <!-- åå®¹ä¸»ä½åºå -->
            <iframe class="iframe-id" src="javascript:;" frameborder="0"
				id="demoAdmin" style="width: 95%; height: 100%;"
				name="view-iframe"></iframe>
        </div>

        <div class="layui-footer">
            <!-- åºé¨åºå®åºå -->
            Â© layui.com - åºé¨åºå®åºå
        </div>
    </div>
    <script src="/static/js/plugins/layui/layui.js" charset="utf-8"></script>
    <script>
        //JavaScriptä»£ç åºå
        layui.use('element', function () {
            var element = layui.element;
        });
    </script>
</body>

</html>