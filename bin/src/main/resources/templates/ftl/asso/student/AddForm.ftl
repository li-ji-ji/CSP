<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${base}/js/plugins/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<script src="${base}/js/plugins/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" method="post" action="${base}/csp/asso/insertOne" style="margin-top:50px;"   >
  
<div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">社团ID</label>
    <div class="layui-input-block">
      <input type="text" name="id" readonly placeholder="系统自动分配" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">社团编号</label>
    <div class="layui-input-block">
      <input type="text" name="assoId" readonly placeholder="系统自动分配" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">社团名称</label>
    <div class="layui-input-block">
      <input type="text" name="assoName" placeholder="请输入社团名称" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:150px;">运营状态</label>
    <div class="layui-input-block" style="width:45%;margin-left: 180px;">
    	<input type="checkbox" name="assoStatus" value="1" title="运营中"  >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">审核状态</label>
    <div class="layui-input-block">
      <input type="checkbox" name="assoExamined" value="1" title="已通过">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">社团指导老师</label>
    <div class="layui-input-block"style="width:46%;margin-left:180px;">
      <select name="assoGuiderId" lay-verify="" lay-search>
		  <option value="" disabled selected>请选择社团指导老师</option>
		  <#list assoGuiders as guider>
		  	<option value="${guider.id}" >${guider.tName}</option>
		  </#list>
	  </select>  
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">社团负责人</label>
    <div class="layui-input-block">
      <input type="text" name="assoLeader" placeholder="请输入社团负责人名称" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">成立日期</label>
    <div class="layui-input-block">
      <input type="text" name="assoEstablishmentTime" readonly placeholder="系统自动分配" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button  class="layui-btn" type="submit" lay-submit="" lay-filter="MsgSubmit">立即提交</button>
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
  });
});
</script>
</body>
</html>