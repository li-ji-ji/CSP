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
<form class="layui-form" method="post" action="${base}/csp/asso/updateOne" style="margin-top:50px;"   >
  
<div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">ID</label>
    <div class="layui-input-block">
      <input type="text" name="id" readonly value="${stu.id}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">学号</label>
    <div class="layui-input-block">
      <input type="text" name="sId" readonly value="${stu.sId}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="sName" value="${stu.sName}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:150px;">性别</label>
    <div class="layui-input-block" style="width:45%;margin-left: 180px;">
    	<input type="radio" name="sSex" value="0" title="男" 
    		<#if stu.sSex==0>
    			checked
    		</#if>
    	>
		<input type="radio" name="sSex" value="1" title="女" 
    		<#if stu.sSex==1>
    			checked
    		</#if>
    	>
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">联系方式（手机）</label>
    <div class="layui-input-block">
      <input type="tel" name="sTel" value="${stu.sTel}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">联系方式（微信）</label>
    <div class="layui-input-block">
      <input type="text" name="sWechat" value="${stu.sWechat}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">联系方式（QQ）</label>
    <div class="layui-input-block">
      <input type="tel" name="sQq" value="${stu.sQq}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">联系方式（邮箱）</label>
    <div class="layui-input-block">
      <input type="text" name="sMail" readonly value="${stu.sMail}" autocomplete="off" class="layui-input" style="width: 50%;">
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