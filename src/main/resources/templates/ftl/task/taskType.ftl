<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>任务类型数据表</title>
  <link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>

<body>

  <table class="layui-table layui-container"
    lay-data="{url:'${base}/taskAdmin/TypeAdmin', page:true, id:'item',toolbar:'#toolbarDemo'}"
    lay-filter="test" id="TablePage">
    <thead>
      <tr>
        <th lay-data="{type:'checkbox'}"></th>
        <th lay-data="{field:'tasktypeId',sort: true,align:'center'}">任务类型编号</th>
        <th lay-data="{field:'tasktypeName',edit: 'text'}">任务类型名称</th>
        <th lay-data="{field:'tasktypeWeight', sort: true,templet:'#sliderWeight',edit: 'text'}">权重(越小越靠前)</th>
        <!-- <th lay-data="{field:'finishTime'}">完成时间</th> -->
        <th lay-data="{field:'tasktypeStatus',templet: '#checkboxTpl', unresize: true}">是否隐藏</th>
        <th lay-data="{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}">操作</th>
      </tr>
    </thead>
  </table>

  <script src="${base}/js/plugins/layui/layui.js"></script>
  <script>
    layui.use('table', function () {

      var table = layui.table, //定义表格对象
        form = layui.form; //定义form表单对象
      var $ = layui.jquery;
      //头工具栏事件
      table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
          case 'add':
            var data = checkStatus.data;

            layui.use('layer', function () {
              layer = layui.layer; //独立版的layer无需执行这一句
              layer.open({
                type: 1 //此处以iframe举例
                  ,
                title: '添加任务',
                area: ['500px'],
                shade: 0,
                maxmin: true,
                content: $('#formAdd'),
                zIndex: layer.zIndex //重点      
              });
            });
            break;
          case 'delete':
            var data = checkStatus.data;
            if (data.length > 0) {
              layer.confirm('确定删除选中行么?', function (index) {
                var idList = []
                data.forEach(element => {
                  idList = idList.concat(element.tasktypeId);
                });
                var idListStr = JSON.stringify(idList);
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                  type: 'post',
                  url: '${base}/taskAdmin/deleteTaskTypeByid',
                  data: {
                    TypeId: idListStr
                  },
                  success: function (obj) {
                    if (obj == true) {
                      layer.msg("删除成功")
                    } else {
                      layer.msg("删除失败")
                      tableRefresh();
                    }
                  },
                  error: function (res) {
                    layer.msg("请求异常")
                  },
                  complete: function () {
                    tableRefresh();
                  }
                });
                return false;
              });
            } else {
              layer.msg("最少选中一行!");
            }
            break;
          case 'Refresh':
          tableRefresh()
            break;
        };
      });

      //监听工具条
      table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent === 'detail') { //查看
          //do somehing
        } else if (layEvent === 'del') { //删除
          layer.confirm('真的删除行么', function (index) {
            var id = [];
            id = id.concat(data.tasktypeId);
            obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
            layer.close(index);
            idList = JSON.stringify(id)
            //向服务端发送删除指令
            $.ajax({
              type: 'post',
              url: '${base}/taskAdmin/deleteTaskTypeByid',
              data: {
                TypeId: idList
              },
              success: function (obj) {
                if (obj == true) {
                  layer.msg("删除成功")
                } else {
                  layer.msg("删除失败")
                  tableRefresh();
                }
              },
              error: function (res) {
                layer.msg("请求异常")
              }
            });
            return false;
          });
        } else if (layEvent === 'edit') { //编辑
          //do something

          //同步更新缓存对应的值
          obj.update({
            username: '123',
            title: 'xxx'
          });
        }
      });
      //监听单元格编辑
      table.on('edit(test)', function (obj) {
        var value = obj.value //得到修改后的值
          ,
          data = obj.data //得到所在行所有键值
          ,
          field = obj.field; //得到字段
        // layer.msg("{taskId:"+data.taskId+","+field+":'"+value+"'}");
        var strTask = '{"tasktypeId":' + data.tasktypeId + ',"' + field + '":"' + value + '"}';
        var upTask = JSON.parse(strTask);
        $.ajax({
          type: 'post',
          url: '${base}/taskAdmin/updateTaskTypeByid',
          data: upTask,
          success: function (obj) {
            if (obj == true) {
              layer.msg("修改成功!");
            }
          }
        });
        return false;
      });
      //监听switch开关
      form.on('checkbox(hideCheck)', function (obj) {
        var tasktypeId = obj.elem.attributes.tasktypeId.value;
        var tasktypeStatus = obj.elem.value;
        if (tasktypeStatus == 0) {
          tasktypeStatus = 1;
        } else {
          tasktypeStatus = 0;
        }
        $.ajax({
          type: 'post',
          url: '${base}/taskAdmin/updateTaskTypeByid',
          data: {
            tasktypeId: tasktypeId,
            tasktypeStatus: tasktypeStatus
          },
          success: function (obj) {
            if (obj == true) {
              layer.msg("修改成功!");
            } else {
              layer.msg("修改失败!");
            }
          },
          error: function (obj) {
            layer.msg("请求异常!");
          }
        });
        return false;
      });
    });

    function tableRefresh() {
      var table=layui.table;
      table.refresh('item');
    }
  </script>
  <!-- checked 选中按钮  -->
  <script type="text/html" id="checkboxTpl">
    <input type="checkbox" tasktypeId="{{d.tasktypeId}}" name="tasktypeStatus" value="{{d.tasktypeStatus}}" title="隐藏"
      lay-filter="hideCheck" {{ d.tasktypeStatus==0 ? 'checked' : '' }}>
  </script>

  <!--工具条事件-->
  <script type="text/html" id="barDemo">
    <!-- <button class="layui-btn layui-btn-xs" lay-event="detail">查看</button>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> -->
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
  <!--头部工具条事件-->
  <script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
      <button type="button" class="layui-btn" lay-event="add"><i class="layui-icon">&#xe608;</i> 添加</button>
      <button type="button" class="layui-btn layui-btn-danger" lay-event="delete"><i
          class="layui-icon">&#xe640;</i>删除选中</button>
      <button class="layui-btn layui-btn-warm" lay-event="Refresh"><i class="layui-icon">&#xe9aa;</i>刷新表格当前页</button>
    </div>
  </script>

  <!-- <script>
layui.use('laypage', function(){
  var laypage = layui.laypage;
  
  //执行一个laypage实例
  laypage.render({
     title: '任务表'
    ,page: true //开启分页
    ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
    ,totalRow: true //开启合计行
    ,elem: document.getElementById('TablePage') //注意，这里的 test1 是 ID，不用加 # 号
    ,count:50//数据总数，从服务端得到
  });
});
</script> -->
  <form class="layui-form" action="" id="formAdd" style="display:none;padding-right: 75px;">
    <div class="layui-form-item">
      <label class="layui-form-label">类型名称:</label>
      <div class="layui-input-block">
        <input type="text" name="tasktypeName" required="" lay-verify="required" placeholder="请输入类型名称"
          autocomplete="off" class="layui-input layui-form-danger">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">权重:</label>
      <div class="layui-input-block">
        <input type="number" name="tasktypeWeight" min="0" required="" lay-verify="required" placeholder="请输入整数,越小越靠前"
          autocomplete="off" class="layui-input layui-form-danger">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">是否显示</label>
      <div class="layui-input-block">
        <input type="checkbox" name="tasktypeStatus" title="显示" value="1" checked>
      </div>
    </div>
    <div class="layui-form-item">
      <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
      </div>
    </div>
  </form>
  <script>
    //Demo表单监听
    layui.use('form', function () {
      var form = layui.form;
      var $ = layui.jquery;
      //监听提交
      form.on('submit(formDemo)', function (data) {
        $.ajax({
          type: 'post',
          url: '${base}/taskAdmin/addTaskType',
          data: data.field,
          success: function (obj) {
            if (obj == true) {
              layer.msg("添加成功!")
              window.tableRefresh();
            } else {
              layer.msg("添加失败!")
            }
          },
          error: function (obj) {
            layer.msg("请求异常");
          }
        });
        return false;
      })
    });
  </script>

</body>

</html>