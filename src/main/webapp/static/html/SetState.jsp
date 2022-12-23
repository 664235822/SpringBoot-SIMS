<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/css/SetState.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet" media="all"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/StateManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <title>更改权限</title>
</head>
<body>
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left" style="margin: 0px;height: 50px;line-height: 50px">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 更改权限</p>
    </div>
</nav>
<!--权限列表-->
<div class="container">
    <div id="LAY_preview" style="margin-top: 10px">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <ul class="layui-tab-title">
                <li class="layui-this">教师权限</li>
                <li>学生权限</li>
            </ul>
            <div class="layui-tab-content"></div>
        </div>
        <table class="layui-table " id="table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col width="200">
                <col width="200">
            </colgroup>
            <thead>
            <tr>
                <th>ID</th>
                <th>权限主菜单</th>
                <th>权限子菜单</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>教师用户管理</td>
                <td>修改教师账号信息</td>
                <td>
                    <div class="layui-form">
                <input type="checkbox" name="" lay-skin="switch" lay-text="开启|关闭">
                    </div>
                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>教师用户管理</td>
                <td>查看教师所带班级</td>
                <td>
                    <div class="layui-form">
                        <input type="checkbox" name="" lay-skin="switch" lay-text="开启|关闭">
                    </div>
                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>教师用户管理</td>
                <td>修改教师账号信息</td>
                <td>
                    <div class="layui-form">
                        <input type="checkbox" name="" lay-skin="switch" lay-text="开启|关闭">
                    </div>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>教师用户管理</td>
                <td>修改教师账号信息</td>
                <td>
                    <div class="layui-form">
                        <input type="checkbox" name="" lay-skin="switch" lay-text="开启|关闭">
                    </div>
                </td>
            </tr>
            </tbody>

        </table>
<!--        分页框-->
        <div id="test1"></div>
    </div>
</div>
</body>

</html>