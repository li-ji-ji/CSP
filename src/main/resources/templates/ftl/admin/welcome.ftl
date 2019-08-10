<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" type="text/css" href="${base}/js/assets/css/base.css" />
</head>
<body>
	<!-- COIDEA:header START -->
    <header class="coidea-header">
   
    </header>
    <!-- COIDEA:header END -->
    
    <!-- COIDEA:demo START -->
    <section id="ci-particles">
      <canvas id="canvas" style="width:100% !important;height:80% !important;overflow-y: hidden;"></canvas>
      <h1 id="headline" style="display:none;">${name}</h1>
    </section>   
    <!-- COIDEA:demo END -->
	
	<script src="${base}/js/assets/js/demo.js"></script>
</body>
</html>