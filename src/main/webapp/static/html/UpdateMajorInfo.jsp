<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/TeacherInfo.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/MajorInfo.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/MajorManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>修改专业信息</title>
</head>
<!--<body onload="Modify()">-->
<!--          当前位置导航-->
<body onload="TeacherModify()">
<!--导航栏-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 修改学院信息</p>
    </div>
</nav>
<!--          内容区-->
<div class="layui-container">
    <div class="row">
        <div class="col-md-6 forms">
            <form class="layui-form">
                <!--                学院名称-->
                <div class="layui-form-item">
                    <label class="layui-form-label">学院名称：</label>
                    <div class="layui-input-block">
                        <select id="cid" name="cid" lay-verify="required" lay-reqtext="学院是必填项！">
                            <option value="">请选择状态</option>
                        </select>
                    </div>
                </div>

                <!--                专业名称-->
                <div class="layui-form-item">
                    <label class="layui-form-label">专业名称：</label>
                    <div class="layui-input-block">
                        <input type="text" id="mname" name="mname" lay-verify="required|title" autocomplete="off" placeholder="请输入专业名称"
                               class="layui-input">
                    </div>
                </div>

                <!--                状态-->
                <div class="layui-form-item">
                    <label class="layui-form-label">状态：</label>
                    <div class="layui-input-block">
                        <select id="mstatus" name="mstatus" lay-verify="required" lay-reqtext="状态是必填项！">
                            <option value="">请选择状态</option>
                            <option value="1">启用</option>
                            <option value="0">停用</option>
                        </select>
                    </div>
                </div>

                <!--                备注-->
                <div class="layui-form-item">
                    <label class="layui-form-label">备注：</label>
                    <div class="layui-input-block">
                        <input type="text" id="mremark" name="mremark" lay-verify="required|" autocomplete="off"
                               placeholder=""
                               class="layui-input">
                    </div>
                </div>
                <!--                提交按钮-->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit  id="referto"  lay-filter="modify">立即提交</button>
                        <div id="chongzhi"  class="layui-btn layui-btn-primary">重置</div>

                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>