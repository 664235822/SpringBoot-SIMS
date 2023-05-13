<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <!--    样式与教师信息相同，故引入相同css-->
    <link href="${pageContext.request.contextPath}/static/css/StuInfo.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/CollegeInfo.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/CollegeManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>添加学生</title>
</head>
<body onload="">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 添加学生</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="row">
        <div class="col-md-6 forms">
            <form class="layui-form" method="post">
                <!--                姓名-->
                <div class="layui-form-item">
                    <label class="layui-form-label">学院名称：</label>
                    <div class="layui-input-block">
                        <input type="text" id="cname" name="cname" lay-verify="required|title" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <!--                年级-->
                <div class="layui-form-item">
                    <label class="layui-form-label">状态：</label>
                    <div class="layui-input-block">
                        <select id="cstatus" name="cstatus" lay-verify="required" lay-filter="test">
                            <option value="">--请选择--</option>
                            <option value="1">启用</option>
                            <option value="0">停用</option>
                        </select>
                    </div>
                </div>

                <!--                家庭住址-->
                <div class="layui-form-item">
                    <label class="layui-form-label">学院备注：</label>
                    <div class="layui-input-block">
                        <input type="text" id="cremark" name="cremark" lay-verify="" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <!--                提交按钮-->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <div class="layui-btn" lay-submit  id="referto"  lay-filter="component-form-element">立即提交</div>
                        <div  id="Reset" onclick="chongzhiClick()" class="layui-btn layui-btn-primary">重置</div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>