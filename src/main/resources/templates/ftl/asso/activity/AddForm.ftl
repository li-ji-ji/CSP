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
<form class="layui-form" method="post" action="${base}/csp/assoAct/insertActivity" style="margin-top:50px;"   >
  
 
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动编号</label>
    <div class="layui-input-block">
      <input type="text" name="activityId" readonly placeholder="系统自动生成" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动名称</label>
    <div class="layui-input-block">
      <input type="text" name="activityName" placeholder="请填写活动名称" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:150px;">活动状态</label>
    <div class="layui-input-block">
      <input type="radio" name="activityStatus" value="0" title="招募中" >
      <input type="radio" name="activityStatus" value="1" title="进行中" >
      <input type="radio" name="activityStatus" value="2" title="已结束" >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动所属社团</label>
    <div class="layui-input-block"style="width:46%;margin-left:180px;">
      <select name="activityAssoId" lay-verify="" lay-search>
		  <#list assoList as asso>
		  	<option value="${asso.assoId}">${asso.assoName}</option>
		  </#list>
	  </select>  
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动负责人</label>
    <div class="layui-input-block"style="width:46%;margin-left:180px;">
      <select name="activityOrganizerId" lay-verify="" lay-search>
		  <#list stuList as stu>
		  	<option value="${stu.sId}" >${stu.sName}</option>
		  </#list>
	  </select>  
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动最大人数</label>
    <div class="layui-input-block">
      <input type="text" name="activityNum" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
 <!--  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动开始时间</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input" name="activityStartTime"   id="activityStartTime" style="width: 50%;">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动开始时间</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input" name="activityFinishTime" id="activityFinishTime" style="width: 50%;">
    </div>
  </div> -->
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">活动简介</label>
    <div class="layui-input-block">
      <textarea name="activityIntro" required placeholder="请输入活动简介" lay-verify="required" class="layui-textarea" style="width: 50%;"></textarea>
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