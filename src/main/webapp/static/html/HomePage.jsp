<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/css/HomePage.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet" media="all"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/HomePage.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>首页</title>

</head>
<body>
<div id="testx"></div>
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页</p>
    </div>
</nav>
<!--          内容区-->
<div id="bgbody" class="" style="width: 100%;margin-top: 15px">
    <div class="layui-container">
        <div class="layui-row layui-col-space15" id="modul">
            <div class="layui-col-md3">
                   <div class="box" name="addmodul">
                       <div class="icon-box">
                          <p class="iconp">
                              <i class="layui-icon layui-icon-add-1" style="font-size: 70px;"></i>
                          </p>
                       </div>
                       <div class="text-box">
                           <p class="text-t">添加快捷方式</p>
                       </div>
                   </div>
            </div>

        </div>

    </div>
</div>
</body>

</html>