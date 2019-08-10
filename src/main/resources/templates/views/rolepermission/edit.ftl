<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>角色权限编辑</title>
    <link rel="stylesheet" href="/static/js/plugins/layui/css/layui.css" media="all">
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
    <form class="layui-form" action="/bg/rolepermission/onedit" method="post">
        <input type="hidden" name="id" value="${(sysRolePermission.id)!}" />
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">角色ID</label>
                <div class="layui-input-inline">
                    <input type="text" name="roleId" required lay-verify="required" autocomplete="off"
                        class="layui-input" value="${(sysRolePermission.roleId)!}" placeholder="角色ID">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">权限ID</label>
                <div class="layui-input-inline">
                    <input type="text" name="permissionId" required lay-verify="required" autocomplete="off"
                        class="layui-input" value="${(sysRolePermission.permissionId)! }" placeholder="权限ID">
                </div>
            </div>
        </div>
        <input type="submit" class="submit" value="提交" /> <input type="reset" class="reset" value="重置" />
    </form>

    <script src="/static/js/plugins/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/js/jquery-3.2.1.min.js"></script>
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