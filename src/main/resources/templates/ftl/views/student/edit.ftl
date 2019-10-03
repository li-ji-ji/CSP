<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>ç¼è¾å­¦çä¿¡æ¯</title>
<link rel="stylesheet" href="${request.contextPath}/static/js/plugins/layui/css/layui.css"
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
	<form class="layui-form" action="/bg/student/onedit" method="post">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">学号</label>
				<div class="layui-input-inline">
					<input type="text" name="sn" required lay-verify="required"
						autocomplete="off" class="layui-input" value="${(student.sn)!}"
						placeholder="请输入学号">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">å§å</label>
				<div class="layui-input-inline">
					<input type="text" name="name" required lay-verify="required"
						autocomplete="off" class="layui-input" value="${(student.name)!}"
						placeholder="è¯·è¾å¥å§å">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">å®¿èå°å</label>
				<div class="layui-input-inline">
					<input type="text" name="dormitoryAdd" required
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${(student.dormitoryAdd)! }"
						placeholder="è¯·è¾å¥å®¿èå°å">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">çµè¯</label>
			<div class="layui-input-block">
				<input type="text" name="phone" required lay-verify="required"
					placeholder="è¯·è¾å¥title" autocomplete="off" class="layui-input"
					value="${(student.phone)! }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">é®ç®±</label>
			<div class="layui-input-block">
				<input type="text" name="email" required lay-verify="required"
					placeholder="è¯·è¾å¥ç®ä»" autocomplete="off"
					class="layui-input" value="${(student.email)! }">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">å­¦é¢</label>
				<div class="layui-input-inline">
					<input type="tel" name="college" placeholder="è¯·è¾å¥å­¦é¢"
						autocomplete="off" class="layui-input"
						value="${(student.college)!}">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">ä¸ä¸</label>
				<div class="layui-input-inline">
					<input type="text" name="major" placeholder="è¯·è¾å¥ä¸ä¸"
						autocomplete="off" class="layui-input" value="${(student.major)!}">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">å¹´çº§</label>
				<div class="layui-input-inline">
					<input type="tel" name="grade" placeholder="è¯·è¾å¥å¹´çº§"
						autocomplete="off" class="layui-input" value="${(student.grade)!}">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">ç­çº§</label>
				<div class="layui-input-inline">
					<input type="tel" name="classes" placeholder="è¯·è¾å¥ç­çº§"
						autocomplete="off" class="layui-input"
						value="${(student.classes)!}">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">å®¶åº­ä½å</label>
			<div class="layui-input-block">
				<input type="text" name="famillyAdd"
					placeholder="è¯·è¾å¥å®¶åº­ä½å" autocomplete="off"
					class="layui-input" value="${(student.famillyAdd)! }">
			</div>
		</div>
		<input type="submit" class="submit" value="ç«å³æäº¤" /> <input
			type="reset" class="reset" value="éç½®" />
	</form>

	<script src="${request.contextPath}/static/js/plugins/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="/static/js/jquery-3.2.1.min.js"></script>
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