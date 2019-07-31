<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>角色表编辑</title>
    <link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
    <style type="text/css">
        .reset {
            margin-left: 60px;
            height: 40px;
            width: 50px;
            font-size: 20px;
            text-align: center;
            height: 40px;
        }

        .submit {
            margin-left: 100px;
            height: 40px;
            width: 100px;
            font-size: 20px;
            text-align: center;
            height: 40px;
        }
    </style>
</head>

<body>
    <form class="layui-form" action="/authority/role/onedit" method="post">
        <input type="hidden" name="id" value="${(sysRole.id)!}" />
        <div class="layui-form-item">
            <label class="layui-form-label">可获得</label>
            <div class="layui-input-block">
                <input type="text" name="available" required lay-verify="required" placeholder="是否可获得" autocomplete="off"
                    class="layui-input" value="${((sysRole.available)?string("1","0"))! }">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">描述</label>
                <div class="layui-input-inline">
                    <input type="text" name="description" required lay-verify="required" autocomplete="off"
                        class="layui-input" value="${(sysRole.description)!}" placeholder="描述">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">角色</label>
                <div class="layui-input-inline">
                    <input type="text" name="role" required lay-verify="required" autocomplete="off"
                        class="layui-input" value="${(sysRole.role)! }" placeholder="角色">
                </div>
            </div>
        </div>
        <input type="submit" class="submit" value="提交" /> <input type="reset" class="reset" value="重置" />
    </form>

	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
    <script>
        //Demo
        layui.use('form', function () {
            var form = layui.form;
            //çå¬æäº¤
            form.on('submit(formDemo)', function (data) {
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    </script>
    <script>
        KindEditor.ready(function (K) {
            window.editor = K.create('#editor_id');
        });
    </script>
</body>

</html>