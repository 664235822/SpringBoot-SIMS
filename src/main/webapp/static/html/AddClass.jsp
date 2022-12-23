<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/AddClass.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ClassManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>添加班级信息</title>
</head>
<body onload="ClassInfo()">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 添加班级信息</p>
    </div>
</nav>
<!--            内容区 -->
<div class="container">
    <div class="row layui-form" style="margin-top: 20px">
        <!--             模糊查询 -->
        <div class="col-md-3 forms">
                <div class="layui-form-item">
                    <label class="layui-form-label">年级：</label>
                    <div class="layui-input-block">
                        <select name="quiz1" id="electgGrade" lay-filter="quiz1" lay-verify="required">
                            <option value="" selected="">请选择年级</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                        </select>
                    </div>
                </div>
        </div>
        <div class="col-md-3 forms">
            <!--            年级名称-->
            <div class="layui-form-item">
                <label class="layui-form-label">班级名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="ClassName" name="" lay-verify="required" autocomplete="off"
                           placeholder="必填项不能为空！" class="layui-input">
                </div>
            </div>
        </div>
        <div class="col-md-3 forms">
            <!--            年级编号-->
            <div class="layui-form-item">
                <label class="layui-form-label">班级编号：</label>
                <div class="layui-input-block">
                    <input type="text" id="ClassCode" name="" lay-verify="required" autocomplete="off"
                           placeholder="请选择年级！"class="layui-input" disabled>
                </div>
            </div>
        </div>
        <div class="col-md-1 forms">
            <!--            创建年级按钮-->
            <div class="layui-form-item">
                <div class="layui-btn pull-left" lay-submit   lay-filter="component-form-element"><i class="layui-icon"></i>添加班级</div>
            </div>
        </div>
    </div>
    <div class="row">
        <!--            表格-->
        <div class="demoTable">
            <!--           主体-->
            <table class="layui-table" style="margin-top: 20px" id="table">
            </table>
        </div>
        <div id="test1"></div>
    </div>
</div>
</body>
</html>