<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/StuInfo.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/StuMoveClass.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/StuManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>管理学生</title>
</head>
<body onload="StuMoveClass()">

<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 管理学生</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="layui-row leaveTop">
        <!--          模糊查询-->
        <div class="layui-col-md3">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="name" required="" lay-verify="required" placeholder="请输入姓名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-col-md3">
            <label class="layui-form-label">学号：</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="code" required="" lay-verify="required" placeholder="请输入学号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="layui-input-block moveleft">
                <button type="button" id="Select" class="layui-btn pull-left  layui-btn-normal"><i class="layui-icon">&#xe615;</i>查询
                </button>
            </div>
        </div>
    </div>
    <!--          表格主体-->
    <div id="LAY_preview" style="margin-top: 10px">
        <!--          批量操作-->
        <div class="layui-table-tool">
            <div class="layui-table-tool-temp">
                <div class="layui-inline" title="批量删除" id="DeleteAll" lay-event="delete"><i
                        class="layui-icon layui-icon-delete"></i></div>
                <div class="layui-inline" title="转班" id="moveClassAll" lay-event="LAYTABLE_EXPORT"><i
                        class="layui-icon layui-icon-edit"></i></div>
            </div>
        </div>
        <!--          表格-->
        <table class="layui-table" style="margin-top: 0px" id="table">
        </table>
        <div id="test1"></div>
    </div>
</div>
</body>
</html>