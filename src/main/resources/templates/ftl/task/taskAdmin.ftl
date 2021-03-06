<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>任务订单后台管理列表</title>
  <link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
</head>

<body>
  <table class="layui-table layui-container"
    lay-data="{url:'${base}/taskAdmin/index', page:true, id:'item',toolbar:'#toolbarDemo'}"
    lay-filter="test" id="TablePage">
    <thead>
      <tr>
        <th lay-data="{type:'checkbox'}"></th>
        <th lay-data="{field:'taskId',sort: true,align:'center'}">任务编号</th>
        <th lay-data="{field:'taskTitle',edit: 'text'}">任务标题</th>
        <th lay-data="{field:'taskType', sort: true}">任务类型</th>
        <!-- <th lay-data="{field:'finishTime'}">完成时间</th> -->
        <th lay-data="{field:'taskPublisher'}">发布者</th>
        <th lay-data="{field:'taskReceiver', sort: true}">接受者</th>
        <th lay-data="{field:'taskStatus', sort: true}">任务状态</th>
        <th lay-data="{field:'publishTime'}">发布时间</th>
        <!-- <th lay-data="{field:'isloop', sort: true}">是否循环发布</th> -->
        <th lay-data="{field:'taskReward', sort: true}">任务赏金(￥/元)</th>
        <th lay-data="{field:'taskContext', sort: true,edit: 'text'}">任务内容</th>
        <th lay-data="{field:'taskRemarks', sort: true,edit: 'text'}">备注</th>
        <th lay-data="{field:'orderId',sort: true,align:'center'}">订单编号</th>
        <th lay-data="{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}">操作</th>
      </tr>
    </thead>
  </table>


  <!--创建快递查看窗口-->
  <div id="ExpressWindow" style="display: none">
      <table class="layui-table layui-container"
      lay-data="{url:'', page:true, id:'ExpressWindow',toolbar:'true'}"
      lay-filter="ExpressWindow" >
      <thead>
        <tr>
          <th lay-data="{type:'checkbox'}"></th>
          <th lay-data="{field:'id',sort: true,align:'center'}">快递编号</th>
          <th lay-data="{field:'textcontent',edit: 'text'}">快递详情</th>
          <th lay-data="{field:'targetaddress', sort: true}">送达地址</th>
          <th lay-data="{field:'takeaddress'}">取件地址</th>
          <th lay-data="{field:'taskReceiver', sort: true}">接受者</th>
          <th lay-data="{field:'superiortaskId', sort: true}">所属任务id</th>
          <th lay-data="{fixed: 'right', width:150, align:'center', toolbar: '#toobarExpress'}">操作</th>
        </tr>
      </thead>
    </table>
  </div>


  <script src="${base}/js/plugins/layui/layui.js"></script>
  <script>
    //主页面task表单的事件监听
    layui.use('table', function () {

      var table = layui.table;
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
                  idList = idList.concat(element.taskId);
                });
                var idListStr = JSON.stringify(idList);
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                  type: 'post',
                  url: '${base}/taskAdmin/delete',
                  data: {
                    taskId: idListStr
                  },
                  success: function (obj) {
                    if (obj == true) {
                      layer.msg("删除成功!")
                    } else {
                      layer.msg("删除失败!")
                    }
                  },
                  error: function (obj) {
                    layer.msg("请求异常");
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
          if(data.taskType=="取快递"){
            var id = [];
            id = id.concat(data.taskId);
            idList = JSON.stringify(id);
          table.reload('ExpressWindow',{
            url:'${base}/taskAdmin/findExpressByPid',
            where:{
              pId:idList
            },
          })
          layui.use('layer', function () {
              layer = layui.layer; //独立版的layer无需执行这一句
              layer.open({
                type: 1,//此处以iframe举例
                title: '快递信息',
                area: ['1000px','300px'],
                shade: 0,
                maxmin: true,
                content: $('#ExpressWindow'),
                zIndex: layer.zIndex //重点      
              });
            });
          }else{
            layer.msg("无快递信息!")
          }
        } else if (layEvent === 'del') { //删除
          layer.confirm('真的删除行么', function (index) {
            var id = [];
            id = id.concat(data.taskId);
            obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
            layer.close(index);
            idList = JSON.stringify(id)
            //向服务端发送删除指令
            $.ajax({
              type: 'post',
              url: '${base}/taskAdmin/delete',
              data: {
                taskId: idList
              },
              success: function (obj) {
                if (obj == true) {
                  layer.msg("删除成功!")
                } else {
                  layer.msg("删除失败!")
                }
              },
              error: function (obj) {
                layer.msg("请求异常");
              },
              complete: function () {
                tableRefresh();
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
        var strTask = '{"taskId":' + data.taskId + ',"' + field + '":"' + value + '"}';
        var upTask = JSON.parse(strTask);
        $.ajax({
          type: 'post',
          url: '${base}/taskAdmin/updata',
          data: upTask,
          success: function (obj) {
            if (obj == true) {
              layer.msg("修改成功!")
            } else {
              layer.msg("修改失败!")
            }
          },
          error: function (obj) {
            layer.msg("请求异常");
          },
          complete: function () {
            tableRefresh();
          }
        });
        return false;
      });


    });
    //局部刷新数据表
    function tableRefresh() {
      var table = layui.table;
      table.refresh('item');
    }
  </script>
  <!--工具条事件 task任务主表-->
  <script type="text/html" id="barDemo">
     <button  lay-event="detail" {{d.taskType=="其他任务"?'class="layui-btn layui-btn-xs layui-btn-disabled"' : 'class="layui-btn layui-btn-xs"'}}><i class="layui-icon">&#xe615;</i>快递信息</button>
   <!-- <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> -->
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
  <!--工具条事件 task快递信息子表-->
  <script type="text/html" id="toobarExpress">
    <!-- <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a> -->
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
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
      <label class="layui-form-label">任务标题:</label>
      <div class="layui-input-block">
        <input type="text" name="taskTitle" required="" lay-verify="required" placeholder="请输入任务标题" autocomplete="off"
          class="layui-input layui-form-danger">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">发布者id:</label>
      <div class="layui-input-block">
        <input type="number" name="taskPublisher" min="0" required="" lay-verify="required" placeholder="请输入任务发布者id"
          autocomplete="off" class="layui-input layui-form-danger">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">任务类型:</label>
      <div class="layui-input-block">
        <select name="taskType" lay-verify="required">
          <option value=""></option>
          <option value="1">快递任务</option>
          <option value="2">其他任务</option>
        </select>
        <div class="layui-unselect layui-form-select">
          <div class="layui-select-title"><input type="text" placeholder="请选择" value="" readonly=""
              class="layui-input layui-unselect"><i class="layui-edge"></i></div>
          <dl class="layui-anim layui-anim-upbit">
            <dd lay-value="" class="layui-select-tips">请选择</dd>
            <dd lay-value="0" class="">北京</dd>
            <dd lay-value="1" class="">上海</dd>
            <dd lay-value="2" class="">广州</dd>
            <dd lay-value="3" class="">深圳</dd>
            <dd lay-value="4" class="">杭州</dd>
          </dl>
        </div>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">任务状态:</label>
      <div class="layui-input-block">
        <select name="taskStatus" lay-verify="required">
          <option value=""></option>
          <option value="0">就绪状态</option>
          <option value="1">新发布</option>
          <option value="2">被接单</option>
          <option value="3">已完成</option>
          <option value="4">已结算</option>
        </select>
        <div class="layui-unselect layui-form-select">
          <div class="layui-select-title"><input type="text" placeholder="请选择" value="" readonly=""
              class="layui-input layui-unselect"><i class="layui-edge"></i></div>
          <dl class="layui-anim layui-anim-upbit">
            <dd lay-value="" class="layui-select-tips">请选择</dd>
            <dd lay-value="0" class="">北京</dd>
            <dd lay-value="1" class="">上海</dd>
            <dd lay-value="2" class="">广州</dd>
            <dd lay-value="3" class="">深圳</dd>
            <dd lay-value="4" class="">杭州</dd>
          </dl>
        </div>
      </div>
    </div>
    <div class="layui-form-item">
      <div class="layui-form-item">
        <label class="layui-form-label">任务赏金:</label>
        <div class="layui-input-block">
          <input type="number" min="0" name="taskReward" required="" lay-verify="required" placeholder="请输入任务赏金 (￥/元)"
            autocomplete="off" class="layui-input layui-form-danger">
        </div>
      </div>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">任务内容:</label>
        <div class="layui-input-block">
          <textarea name="taskContext" placeholder="请输入任务内容" class="layui-textarea"></textarea>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>
          <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
      </div>
      <input type="hidden" name="publishTime" required=""
        value='{"year":2019,"month": 7,"date": 9,"hours": 9,"minutes": 38,"seconds":36}' lay-verify="required"
        placeholder="请输入任务标题" autocomplete="off" class="layui-input layui-form-danger">
  </form>


  <script>
    //监听添加窗口的表单提交按钮
    layui.use('form', function () {
      var form = layui.form;
      var $ = layui.jquery;
      //监听提交
      form.on('submit(formDemo)', function (data) {
        data.field.taskReward=(data.field.taskReward)*100;
        $.ajax({
          type: 'post',
          url: '${base}/taskAdmin/addTask',
          data: data.field,
          success: function (obj) {
            if (obj > 0) {
              layer.msg(obj + "号任务,添加成功!")
            } else {
              layer.msg("添加失败!")
            }
          },
          error: function (obj) {
            layer.msg("请求异常");
          },
          complete: function () {
            tableRefresh();
          }
        });
        return false;
      })
    });
  </script>

</body>

</html>