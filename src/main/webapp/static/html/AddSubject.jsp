<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/AddSubject.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/SubjectManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>科目管理</title>
</head>
<body onload="Submanage()">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left" style="margin-top: 15px">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 科目管理</p>
    </div>
</nav>
<!--        内容区 -->
<div class="container">
    <div class="row" style="margin-top: 10px">
        <!--           模糊查询 -->
        <div class="demoTable ">
            <div class="layui-inline">
                <label class="layui-form-label">搜索：</label>
            </div>
            <div class="layui-inline">
                <input class="layui-input" name="id" id="code" autocomplete="off" placeholder="请输入科目编号">
            </div>
            <div class="layui-inline">
                <input class="layui-input" name="id" id="name" autocomplete="off" placeholder="请输入科目名称">
            </div>
            <div class="layui-inline">
                <button class="layui-btn" id="subsea1"><i class="layui-icon">&#xe615;</i>搜索</button>
                <!--        添加科目按钮 -->
                <button class="layui-btn" id="Addbut"><i class="layui-icon">&#xe61f;</i>添加科目</button>
            </div>

        </div>
    </div>
    <!--              表格主体-->
    <div id="LAY_preview" style="margin-top: 50px">
        <div class="layui-table-tool">
            <div class="layui-table-tool-temp">
                <div class="layui-inline" title="删除所有选中项" lay-event="delete" id="moveClassAll"><i
                        class="layui-icon layui-icon-delete"></i></div>
            </div>
        </div>
        <table class="layui-table" style="margin-top: 0px" id="subtable">
        </table>
        <div id="test1"></div>
    </div>
</div>
</body>
</html>