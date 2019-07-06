
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="../../js/plugins/layui/css/layui.css" media="all">
<script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
<script src="../../js/plugins/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" style="margin-top:50px;" action="" lay-filter="example">
  
<div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">菜单ID</label>
    <div class="layui-input-block">
      <input type="number" name="id" placeholder="请输入菜单ID" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">菜单名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" placeholder="请输入菜单名称" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:150px;">父级菜单名称</label>
    <div class="layui-input-block" style="width:45%;margin-left: 180px;">
      <select name="interest" lay-filter="aihao">
        <option value="">请选择父级菜单</option>
        <option value="0">写作</option>
        <option value="1">阅读</option>
        <option value="2">游戏</option>
        <option value="3">音乐</option>
        <option value="4">旅行</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">父级菜单ID</label>
    <div class="layui-input-block">
      <input type="number" name="pId" placeholder="请输入父级菜单ID" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">菜单跳转链接</label>
    <div class="layui-input-block">
      <input type="text" name="mainurl" placeholder="请输入菜单跳转链接" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="MsgSubmit">立即提交</button>
    </div>
  </div>
</form>
<script>
var status;
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  /* form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  }); */
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
  //监听提交
  form.on('submit(MsgSubmit)', function(data){
	  console.log(data.field);
	  var menuJSON=JSON.stringify(data.field);
	  if(status==0){
		  $.ajax({
			  "url": "http://192.168.1.126:8004/feign/adminMenu/addOne",
			  "data":"menu="+menuJSON,
			  "type":"post",
	    	  "dataType" : "text",
	    	  "async" :false,
	    	  "success" : function (resultMsg) {
	    		  if(resultMsg==1){
	    			  layer.open({
	    				    type: 1 //不显示标题栏   title : false/标题
	    				    ,title: "修改成功，返回菜单"
	    				    ,closeBtn: false
	    				    ,area: '300px;'
	    				    ,shade: 0.8
	    				    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	    				    ,resize: false
	    				    ,btn: ['好的']
	    				    ,btnAlign: 'c'
	    				    ,moveType: 1 //拖拽模式，0或者1
	    				    ,success: function(layero){
	    				         var btn = layero.find('.layui-layer-btn');
	    				            btn.find('.layui-layer-btn0').attr({
	    				                 href: 'http://192.168.1.126:8004/csp/admin/toIndex'
	    				            ,target: '_parent'
	    				        });
	    				    }
	    				});
	    		  }else{
	    			  layer.open({
	  				    type: 1 //不显示标题栏   title : false/标题
	  				    ,title: "修改失败，返回菜单"
	  				    ,closeBtn: false
	  				    ,area: '300px;'
	  				    ,shade: 0.8
	  				    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	  				    ,resize: false
	  				    ,btn: ['好的']
	  				    ,btnAlign: 'c'
	  				    ,moveType: 1 //拖拽模式，0或者1
	  				    ,success: function(layero){
	  				         var btn = layero.find('.layui-layer-btn');
	  				            btn.find('.layui-layer-btn0').attr({
	  				                 href: 'http://192.168.1.126:8004/csp/admin/toIndex'
	  				            ,target: '_parent'
	  				        });
	  				    }
	  				});
	    		  }
				}
		  });
	  }else{
		  $.ajax({
			  "url": "http://92.68.10.110:8080/PageConfig/addPageConfig",
			  "data":"menu="+menuJSON,
			  "type":"post",
	    	  "dataType" : "text",
	    	  "async" :false,
	    	  "success" : function (resultMsg) {
	    		  if(resultMsg==1){
	    			  layer.open({
	    				    type: 1 //不显示标题栏   title : false/标题
	    				    ,title: "添加成功，返回菜单"
	    				    ,closeBtn: false
	    				    ,area: '300px;'
	    				    ,shade: 0.8
	    				    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	    				    ,resize: false
	    				    ,btn: ['好的']
	    				    ,btnAlign: 'c'
	    				    ,moveType: 1 //拖拽模式，0或者1
	    				    ,success: function(layero){
	    				         var btn = layero.find('.layui-layer-btn');
	    				            btn.find('.layui-layer-btn0').attr({
	    				                 href: 'http://192.168.1.126:8004/csp/admin/toTable'
	    				            ,target: '_self'
	    				        });
	    				    }
	    				});
	    		  }else{
	    			  layer.open({
	  				    type: 1 //不显示标题栏   title : false/标题
	  				    ,title: "添加失败，返回菜单"
	  				    ,closeBtn: false
	  				    ,area: '300px;'
	  				    ,shade: 0.8
	  				    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	  				    ,resize: false
	  				    ,btn: ['好的']
	  				    ,btnAlign: 'c'
	  				    ,moveType: 1 //拖拽模式，0或者1
	  				    ,success: function(layero){
	  				         var btn = layero.find('.layui-layer-btn');
	  				            btn.find('.layui-layer-btn0').attr({
	  				                 href: 'http://192.168.1.126:8004/csp/admin/toTable'
	  				            ,target: '_self'
	  				        });
	  				    }
	  				});
	    		  }
				}
		  });
	  }
	  
	 
	  
    return false;
  });
  
  /* $(function getMenu() {
		var menuMsg=eval('('+parent.json+')');
		status=1;
		if(menuMsg!=null){
			status=0;
			$("#menuid").val(menuMsg.menuid);
			$("#menuname").val(menuMsg.menuname);
			$("#menumid").val(menuMsg.menumid);
			$("#images").val(menuMsg.images);
			$("#url").val(menuMsg.url);
		} 
		});*/
  //表单初始赋值
  /* form.val('example', {
    "menuid": ""// "name": "value"
    ,"menuname": menuname
    ,"interest": 1
    ,"like[write]": true //复选框选中状态
    ,"close": true //开关状态
    ,"sex": "女"
    ,"desc": "我爱 layui"
  })  */
  
  
});
</script>

</body>
</html>