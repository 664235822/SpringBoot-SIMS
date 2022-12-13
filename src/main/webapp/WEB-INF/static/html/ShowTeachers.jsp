<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/css/ShowTeachers.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet" media="all"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/table.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/laypage.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/TeacherManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>管理教师</title>
</head>
<body onload="ShowTeachers()" style="padding-top: 50px;">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 管理教师</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="row" style="margin-top: 10px">
        <div class="col-md-3">
            <div class="layui-form-item">
                <label class="layui-form-label">账号：</label>
                <div class="layui-input-block">
                    <input type="text" name="title" id="code" required="" lay-verify="" placeholder="请输入账号"
                           autocomplete="off" class="layui-input ">
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="layui-form-item">
                <label class="layui-form-label">姓名：</label>
                <div class="layui-input-block">
                    <input type="text" name="title" id="name" required="" lay-verify="" placeholder="请输入姓名"
                           autocomplete="off" class="layui-input ">
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="layui-form-item">
                <div class="layui-input-block Toleftbutton">
                    <button type="button" id="Select" class="layui-btn  layui-btn layui-btn-normal"><i
                            class="layui-icon">&#xe615;</i>查询
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!--          表格主体-->
    <div id="LAY_preview">
        <div class="layui-table-tool">
            <div class="layui-table-tool-temp">
                <div class="layui-inline" title="删除所有选中项" lay-event="delete" id="moveClassAll"><i
                        class="layui-icon layui-icon-delete"></i></div>
            </div>
        </div>
        <!--          表格-->
        <table class="layui-table" style="margin-top: 0px" id="table">
        </table>
        <div id="test1"></div>
    </div>
</div>
<!--表格-->
</body>

</html>