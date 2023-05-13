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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/SubjectManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>查看科任老师信息</title>
</head>
<body onload="showteachifo();CollegeSelect();MajorSelect()">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 查看科任老师信息</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="row">
        <!--          模糊查询-->
        <div class="demoTable" style="margin-top: 20px">
            <!--        内联搜索框-->
            <form class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">学院：</label>
                    </div>
                    <div class="layui-inline">
                        <select id="cid" name="cid" lay-verify="required" >
                            <option value="">请选择学院</option>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">专业：</label>
                    </div>
                    <div class="layui-inline">
                        <select id="mid" name="mid" lay-verify="required" >
                            <option value="">请选择专业</option>
                        </select>
                    </div>
                    <br>
                    <label class="layui-form-label">搜索：</label>
                    <div class="layui-input-inline">
                        <select name="quiz1" lay-filter="test" id="Grades">
                            <option value="0"  selected="">请选择年级</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="quiz2" lay-filter="quiz" id="Class">
                            <option value="0"  selected="">请选择班级</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="quiz3" lay-filter="Subjects" id="Subjects">
                            <option value="0"  selected="">请选择科目</option>
                        </select>
                    </div>
                    <div class="layui-btn" data-type="reload" id="subsea1">搜索</div>
                </div>
            </form>
        </div>
            <!--              表格主体-->
            <div id="LAY_preview" style="margin-top: 10px">
                <table class="layui-table" style="margin-top: 0px" id="table">
                </table>
                <div id="test1"></div>
            </div>
    </div>
</div>
</body>
</html>