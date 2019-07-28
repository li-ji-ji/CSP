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
<form class="layui-form" method="post" action="${base}/csp/assoSchool/updateSchoolOne" style="margin-top:50px;"   >
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">ID</label>
    <div class="layui-input-block">
      <input type="text" name="id" readonly value="${school.id}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">学校编号</label>
    <div class="layui-input-block">
      <input type="text" name="schoolNo" readonly value="${school.schoolNo}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">学校名称</label>
    <div class="layui-input-block">
      <input type="text" name="schoolName" value="${school.schoolName}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:150px;">学校地址</label>
    <div class="layui-input-block">
    	<input type="text" name="schoolAddress"  value="${school.schoolAddress}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">学校所在省份</label>
    <div class="layui-input-block">
      <input type="tel" name="schoolAddressProvince" value="${school.schoolAddressProvince}" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">学校所在城市</label>
    <div class="layui-input-block">
      <input type="text" name="schoolAddressCity" value="${school.schoolAddressCity}" autocomplete="off" class="layui-input" style="width: 50%;">
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