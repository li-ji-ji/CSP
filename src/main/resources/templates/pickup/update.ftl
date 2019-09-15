<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改自提点信息</title>
<link rel="stylesheet" href="${base}/admin/lib/layui/css/layui.css"
	media="all">
</head>
<body>

		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>修改自提点信息</legend>
		</fieldset>

		<form class="layui-form" name="pickUp" action="" lay-filter="example">

			<div class="layui-form-item">
				<div class="layui-inline">
					<#if pickUp.pickupId != 0> <label class="layui-form-label">pickupId</label>
					<div class="layui-input-inline">
						<input type="tel" name="pickupId" value="${pickUp.pickupId }"
							id="id" readonly="readonly" lay-verify="title" autocomplete="off"
							class="layui-input">
					</div>
					</#if>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">自提点名字</label>
				<div class="layui-input-block">
					<input type="text" name="pickupName" lay-verify="title"
						value="${pickUp.pickupName}" autocomplete="off"
						placeholder="请输入自提点名字" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">自提点地址</label>
				<div class="layui-input-block">
					<input type="text" name="pickupAddress" lay-verify="title"
						value="${pickUp.pickupAddress}" autocomplete="off"
						placeholder="请输入自提点地址" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">自提点电话</label>
				<div class="layui-input-block">
					<input type="text" name="pickupPhone" lay-verify="title"
						value="${pickUp.pickupPhone}" autocomplete="off"
						placeholder="请输入自提点电话" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">自提点联系人</label>
				<div class="layui-input-block">
					<input type="text" name="pickupContact" lay-verify="title"
						value="${pickUp.pickupContact}" autocomplete="off"
						placeholder="请输入自提联系人姓名" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">省</label>
				<div class="layui-input-inline">
					<select name="provinceId" lay-filter="provinceId">
						<option value="">请选择省</option>
						<option value="${pickUp.provinceId }" selected="">${provinceName}</option>
						<#assign i = 0 > <#list region2s as region2s>
						<option value="${region2s.id}">${region2s.name}</option>
						<#assign i++ > </#list>
					</select>
				</div>
				<label class="layui-form-label">市</label>
				<div class="layui-input-inline">
					<select name="cityId" id="cityId" lay-filter="cityId">
						<option value="">请选择市</option>
						<option value="${pickUp.cityId }" selected="" id="test">${cityName}</option>
					</select>
				</div>
				<label class="layui-form-label">区/县</label>
				<div class="layui-input-inline">
					<select name="districtId" id="districtId">
						<option value="">请选择区/县</option>
						<option value="${pickUp.districtId }" selected="">${districtName}</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">供应者id</label>
				<div class="layui-input-block">
					<input type="text" name="suppliersid" lay-verify="title"
						value="${pickUp.suppliersid}" autocomplete="off"
						placeholder="请输入供应者id" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>

		<script src="${base}/admin/js/jquery.min.js"></script>
		<script src="${base}/admin/lib/layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui
					.use(
							[ 'form', 'layedit', 'upload' ],
							function() {
								var form = layui.form, layer = layui.layer, layedit = layui.layedit, upload = layui.upload;

								/*监听select框*/
							    form.on('select(provinceId)', function(data){
							         var provinceId = data.value;
							        //remove掉原来的html
							        if(provinceId==""){
								    }else{
								    	$.ajax({
								            url : "${base}/api/region2/subregion",
								            type : "post",
								            data : {
								                  id:provinceId
								                },
								            success : function(data) {
								                $("#cityId").empty();
								                $("#cityId")
												.append(
														"<option value=''>请选择市</option>");
								                for(var i=0;i<data.length;i++){
								                	$("#cityId")
													.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
								                }
								                form
												.render('select');
								            }
								      });
									      
									 }
							    });

							    form.on('select(cityId)', function(data){
							         var cityId = data.value;
							        //remove掉原来的html
							        if(cityId==""){
								    }else{
								    	$.ajax({
								            url : "${base}/api/region2/subregion",
								            type : "post",
								            data : {
								                  id:cityId
								                },
								            success : function(data) {
								                $("#districtId").empty();
								                $("#districtId")
												.append(
														"<option value=''>请选择区/县</option>");
								                for(var i=0;i<data.length;i++){
								                	$("#districtId")
													.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
								                }
								                form
												.render('select');
								            }
								      });
									      
									 }
							    });

								//表单初始赋值

								//自定义验证规则
								form.verify({
									title : function(value) {
										if (value.length < 1) {
											return '标题至少得1个字符啊';
										}
									}
								});
								//监听提交
								form
										.on(
												'submit(demo)',
												function(data) {
													layer
															.confirm(
																	'真的提交么',
																	function(
																			index) {
																		layer.alert(JSON
																				.stringify(data.field));
																		 $
																				.ajax({
																					url : '${base}/api/pickUp/update',
																					method : 'post',
																					contentType : "application/json;charset=UTF-8",
																					data : JSON
																							.stringify(data.field),
																					dataType : 'json',
																				});
																		var link = '${base}/pickUp/list';
																		window.location.href = link;
																	});
													return false;

												});
							});
		</script>
</body>
</html>