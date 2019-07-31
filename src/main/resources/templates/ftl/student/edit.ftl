<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>学生表编辑</title>
<link rel="stylesheet" href="${base}/js/plugins/layui/css/layui.css"
	media="all">
<style type="text/css">
.reset {
	margin-left: 60px;
	height: 40px;
	width: 50px;
	font-size: 20px;
	text-align: center;
	height: 40px;
}

.submit {
	margin-left: 100px;
	height: 40px;
	width: 100px;
	font-size: 20px;
	text-align: center;
	height: 40px;
}
</style>
</head>

<body>
	<form class="layui-form" action="/authority/student/onedit"
		method="post">
		<input type="hidden" name="id" value="${(student.id)!}" />
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">学号</label>
				<div class="layui-input-inline">
					<input type="text" name="sn" required lay-verify="required"
						autocomplete="off" class="layui-input" value="${(student.sn)!}"
						placeholder="请输入学号!">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline">
					<input type="text" name="name" required lay-verify="required"
						autocomplete="off" class="layui-input" value="${(student.name)!}"
						placeholder="请输入姓名">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">宿舍地址</label>
				<div class="layui-input-inline">
					<input type="text" name="dormitoryAdd" required
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${(student.dormitoryAdd)! }" placeholder="宿舍地址">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" required lay-verify="required"
					placeholder="输入手机号" autocomplete="off" class="layui-input"
					value="${(student.phone)! }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" name="email" required lay-verify="required"
					placeholder="请输入邮箱" autocomplete="off" class="layui-input"
					value="${(student.email)! }">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">学院</label>
				<div class="layui-input-inline">
					<input type="tel" name="college" placeholder="请输入学院"
						autocomplete="off" class="layui-input"
						value="${(student.college)!}">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">专业</label>
				<div class="layui-input-inline">
					<input type="text" name="major" placeholder="专业"
						autocomplete="off" class="layui-input" value="${(student.major)!}">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">年级</label>
				<div class="layui-input-inline">
					<input type="tel" name="grade" placeholder="年级" autocomplete="off"
						class="layui-input" value="${(student.grade)!}">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">班级</label>
				<div class="layui-input-inline">
					<input type="tel" name="classes" placeholder="班级"
						autocomplete="off" class="layui-input"
						value="${(student.classes)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">家庭地址</label>
			<div class="layui-input-block">
				<input type="text" name="famillyAdd" placeholder="家庭地址"
					autocomplete="off" class="layui-input"
					value="${(student.famillyAdd)! }">
			</div>
		</div>
		<input type="submit" class="submit" value="提交" /> <input type="reset"
			class="reset" value="重置" />
	</form>

	<script src="${base}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="${base}/js/jquery-3.3.1.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;
			//çå¬æäº¤
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));
				return false;
			});
		});
	</script>
	<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#editor_id');
		});
	</script>
</body>

</html>