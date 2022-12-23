<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/ShowClass.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/laypage.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ClassManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>班级管理</title>
</head>
<body onload="ShowClass()">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 班级管理</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="row">
        <!--            表格-->
        <div class="demoTable" style="margin-top: 20px">
            <!--          模糊查询-->
            <div class="demoTable ">
                <div class="layui-inline">
                    <label class="layui-form-label">搜索：</label>
                </div>
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="code" autocomplete="off" placeholder="请输入班级编号">
                </div>
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="name" autocomplete="off" placeholder="请输入班级名称">
                </div>
                <div class="layui-inline">
                    <div class="layui-btn" id="Select" >搜索</div>
                </div>

            </div>
            <!--            工具(批量操作)-->
            <div class="layui-table-tool">
                <div class="layui-table-tool-temp">
                    <div class="layui-inline" title="删除所有选中项" lay-event="delete" id="moveClassAll"><i
                            class="layui-icon layui-icon-delete"></i></div>
                </div>
            </div>
            <!--           主体-->
            <table class="layui-table" id="table">
            </table>
            <div id="test1"></div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use('form', function(){
        var form = layui.form //获取form模块

        //…
    });
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</html>