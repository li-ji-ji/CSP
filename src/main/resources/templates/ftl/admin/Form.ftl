
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
      <select name="parentSelect" lay-filter="parentSelect" lay-search>
        <option value="">请选择父级菜单</option>
        <#list AdminMenuList as item>
        	<option value="${item.id}" >${item.name}</option>
		</#list>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">父级菜单ID</label>
    <div class="layui-input-block">
      <input type="number" name="pId" id="pId" placeholder="请输入父级菜单ID" autocomplete="off" class="layui-input" style="width: 50%;">
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
  
  form.on('select(parentSelect)',function(data){
	  $("#pId").attr("value",data.value)
  })
  //监听提交
  form.on('submit(MsgSubmit)', function(data){
	  console.log(data.field);
	  var menuJSON=JSON.stringify(data.field);
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
	    				                 href: 'http://192.168.1.126:8004/csp/admin/toIndex'
	    				            ,target: '_parent'
	    				        });
	    				    }
	    				});
	    		  }else{
	    			  layer.open({
	  				    type: 1 //不显示标题栏   title : false/标题
	  				    ,title: "添加 失败，返回菜单"
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
    return false;
  });
});
</script>
</body>
</html>