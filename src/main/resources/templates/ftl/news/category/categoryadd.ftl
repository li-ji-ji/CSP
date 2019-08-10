<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分类添加</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css" media="all">
<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
<script src="${base}/js/plugins/layui/layui.js"></script>
</head>
<body>
<form class="layui-form"  action="${base}/category/addCategory" style="margin-top:50px;"   >
  
  
  
    
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">分类类型</label>
    <div class="layui-input-block">
      <input type="text" name="categorytype" placeholder="请填写分类名称" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
  
   <div class="layui-form-item" hidden="true">
    <label  class="layui-form-label" style="width: 150px;">上级分类ID</label>
    <div class="layui-input-block">
      <input type="text" id="categorypid" name="categorypid" readonly value="0" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
 	<div class="layui-form-item">
			<label class="layui-form-label" style="width: 150px;">上级分类</label>
			
			<div class="layui-input-block" id="parentName" style="width:46%;margin-left:180px;">
				<select name="category_pname"  lay-filter="aihao" lay-search >
				<option value="0" label="0">无</option>
				<#list categories as item>
					<option value="${item.id}" label="${item.categorylevel}">${item.categorytype}</option>
				</#list>
				</select>
			</div>
		</div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">是否为叶子</label>
    <div class="layui-input-block">
      <input type="checkbox" name="isleaf"  lay-skin="switch" value="1" lay-text="叶子|非叶子" checked >
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">分类图标</label>
    <div class="layui-input-block">
      <input type="text" name="categoryicon" placeholder="请填写分类图标" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">分类状态</label>
    <div class="layui-input-block">
      <input type="checkbox" name="categorystatus" value="1"  lay-skin="switch"  lay-text="启用|未启用" checked >
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="width: 150px;">分类等级</label>
    <div class="layui-input-block">
      <input type="text" id="categorylevel" name="categorylevel" readonly value="1" autocomplete="off" class="layui-input" style="width: 50%;">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button  class="layui-btn" type="submit"  >完成添加</button>
    </div>
  </div>
</form>
<script type="text/javascript">
	
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('select(aihao)', function(data){
			  //根据parentName绑定parentId
			  $("#categorypid").attr("value",data.value)
			  
			  var categorylevel=parseInt($("#parentName select").find("option:selected").attr("label"))
			  $("#categorylevel").attr("value",categorylevel+1)
			  
		  })
		  
		 
		});
</script>

</body>
</html>