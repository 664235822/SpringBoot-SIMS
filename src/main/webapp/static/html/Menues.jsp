<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet" media="all"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/HomePage.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>穿梭框组件</title>
</head>

<body>
<div class="layui-container">
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="100px">
                <col>
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>勾选</th>
                <th>菜单名名称</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-checkbox"><input
                            type="checkbox" name="layTableCheckbox" lay-skin="primary" checked="">
                        <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i
                                class="layui-icon layui-icon-ok"></i></div>
                    </div>
                </td>
                <td>管理教师</td>
            </tr>
            <tr>
                <td><div class="layui-table-cell laytable-cell-1-0-0 laytable-cell-checkbox"><input
                        type="checkbox" name="layTableCheckbox" lay-skin="primary" checked="">
                    <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary"><i
                            class="layui-icon layui-icon-ok"></i></div>
                </div></td>
                <td>添加教师用户</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>


</html>