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
<#--引入alert的css文件-->
    <script type="text/javascript" charset="utf-8" src="${base}/js/ueditor/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/js/ueditor/utf8-jsp/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${base}/js/ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

</head>
<body>
<form class="layui-form" method="post" action="${base}/asso/insertOne" style="margin-top:50px;"   >
  
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
    <label class="layui-form-label" style="width: 150px;">挂靠部门</label>
    <div class="layui-input-block"style="width:46%;margin-left:180px;">
      <select name="assoAffiliateNo" lay-verify="" lay-search>
		  <option value="none" disabled selected></option>
		  <#list schoolUnit as unit>
		  	<option value="${unit.unitNo}" >${unit.unitName}</option>
		  </#list>
	  </select>  
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label" style="width: 150px;">社团指导老师</label>
    <div class="layui-input-block" id="asso" style="width:46%;margin-left:180px;">
      <select name="assoGuiderId" lay-verify="" lay-search>
		  <option value="none" disabled selected></option>
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
      <input type="text" name="assoEstablishmentTime" id="DateTimeInput"   autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">成立日期</label>
    <div class="layui-input-block">
      <input type="text" name="assoEstablishmentTime" readonly placeholder="系统自动分配" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  <!-- <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">申请理由</label>
    <div class="layui-input-block" style="float:left;width:80%;">
      <button type="button" class="layui-btn" id="imageUpload">
  		<i class="layui-icon">&#xe67c;</i>上传图片
	  </button>
    </div>
  </div> -->
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button  class="layui-btn" type="submit" lay-submit="" lay-filter="MsgSubmit">立即提交</button>
    </div>
  </div>
</form>
<script type="text/javascript">
</script>
<script>

var status;
layui.use(['upload','form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  var upload = layui.upload;
  form.on('select(parentSelect)',function(data){
	  $("#pId").attr("value",data.value)
  });

  laydate.render({
	    elem: '#DateTimeInput' //指定元素
		,position: 'absolute'
		,value: new Date()
		,isInitValue: false
	    ,type: 'datetime'
	    ,format: 'yyyy-MM-dd HH:mm:ss'
	  });
  //执行实例
  var uploadInst = upload.render({
    elem: '#imageUpload' //绑定元素
    ,url: 'http://92.68.10.197:8010/upload' //上传接口
    ,done: function(res){
    	layer.alert(res.data.src)
    }
    ,error: function(){
      //请求异常回调
    }
  });
});
</script>
</body>
</html>