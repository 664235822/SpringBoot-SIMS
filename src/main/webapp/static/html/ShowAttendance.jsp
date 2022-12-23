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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/AttendanceManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>查看考勤</title>
</head>
<body onload="ShowAttendance()">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 查看考勤</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="row">
        <!--            表格-->
        <div class="demoTable" style="margin-top: 20px">
            <!--        内联搜索框-->
            <form class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">搜索：</label>
                    <div class="layui-input-inline">
                        <select name="quiz1" id="Grades" lay-filter="test">
                            <option value="0" selected="">请选择年级</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="quiz2" id="Class" lay-filter="quiz">
                            <option value="0" selected="">请选择班级</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="quiz3" id="Subjects" lay-filter="Subjects">
                            <option value="0" selected="">请选择科目</option>
                        </select>
                    </div>
                    <div class="layui-input-inline" style="width: 170px">
                        <input type="text" name=""  id="code"
                               placeholder="请输入学号"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width: 170px">
                        <input type="text" name="title"  id="name"
                               placeholder="请输入姓名"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-btn" id="Select" data-type="reload">查询</div>
                </div>
            </form>
            <!--           主体-->
            <table class="layui-table" style="margin-top: 20px" id="table">
            </table>
            <div id="test1"></div>
        </div>
    </div>
</div>
</body>
</html>