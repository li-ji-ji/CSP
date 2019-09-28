<#assign base=request.contextPath />
<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>${config.logo_title}</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            // 是否开启刷新记忆tab功能
            // var is_remember = true;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="${config.logo_url}">
                <i class="iconfont layui-icon">${config.index_logo}</i>
                ${config.logo_title}
                </a>
                </div>
            <div class="left_open">
                <a><i title="${config.open_title}" class="iconfont layui-icon">${config.open_logo}</i></a>
            </div>
            <ul class="layui-nav left fast-add" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">${config.often_title}</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->       
                        <dd>
                            <a onclick="xadmin.open('最大化','${config.often_url}','','',true)">
                                <i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出自动宽高','${config.often_url}')">
                                <i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出指定宽高','${config.often_url}',500,300)">
                                <i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开','${config.often_url}')">
                                <i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开刷新','${config.often_url}',true)">
                                <i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">${user.userName}</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('${config.adminList1_title}','${config.adminList1_url}">个人信息</a></dd>
                        <dd>
                            <a onclick="xadmin.open('${config.adminList2_title}','${config.adminList2_url}">切换帐号</a></dd>
                        <dd>
                            <a href="${config.adminList3_url}" id="logout">${config.adminList3_title}</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="${config.right_url}">${config.right_title}</a></li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                    <#list model as item>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont layui-icon left-nav-li" lay-tips="${item.name}">${item.icon}</i>
                            <cite>${item.name}</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                            
                          <ul class="sub-menu">
                          <#list item.children as secondItem>
                          <#if (secondItem.children?size>0)>
                       
                            <li>
                                <a href="javascript:;">
                                    <i class="iconfont layui-icon">${secondItem.icon}</i>
                                    <cite>${secondItem.name}</cite>
                                    <i class="iconfont nav_right">&#xe697;</i></a>
                                
                                <ul class="sub-menu">
                                <#list secondItem.children as thirdItem>
                                    <li>
                                        <a onclick="xadmin.add_tab('${thirdItem.name}','${thirdItem.url}')">
                                            <i class="iconfont">&#xe6a7;</i>
                                            <cite>${thirdItem.name}</cite></a>
                                    </li>
                                    </#list>
                                </ul>
                                
                            </li>
                            <#else>
                            <li>
                                <a onclick="xadmin.add_tab('${secondItem.name}',${secondItem.url}')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>${secondItem.name}</cite></a>
                            </li>
                            
                            </#if>
                            </#list>
                        </ul>
                        
                    </li>
                    </#list>
                </ul>
            </div>
        </div>
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">${config.tabIndex_icon}</i>${config.tabIndex_title}</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">${config.rightClic_this}</dd>
                        <dd data-type="other">${config.rightClic_other}</dd>
                        <dd data-type="all">${config.rightClic_all}</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='${config.tabIndex_url}' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
          <script>
			layui.use(['form', 'layedit', 'laydate','element','jquery'], function() {
			layer = layui.layer,
			element=layui.element,
			$=layui.jquery;
			$(document).on('click','#logout',function(){
			$.ajax({
              type: 'post',
              url: '/api/logout',
              data: {},
              success: function (obj) {
            	  console.log(obj);
                if (obj.code != 1) {
                  layer.msg(obj.jsonData)
                } else {
                    window.location.href = 'logout'
                }
              },
              error: function (obj) {
            	  parent.layer.msg("请求异常");
              },
              complete: function () {
              }
            });
			});
			});
          </script>
    </body>

</html>