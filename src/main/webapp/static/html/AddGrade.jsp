<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/css/AddGrade.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet" media="all"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/GradeManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>添加年级</title>
</head>
<body onload="CollegeSelect();MajorSelect();GradeInfo();" style="padding-top: 50px;">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left" style="margin: 0px;height: 50px;line-height: 50px">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 添加年级</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div class="row layui-form">
        <!--          模糊查询-->
        <div class="col-md-4 forms">
            <!--            年级名称-->
            <div class="layui-form-item">
                <label class="layui-form-label">年级名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="gradeName" name="" lay-verify="required" autocomplete="off"
                           placeholder="必填项不能为空！"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="col-md-4 forms">
            <div class="layui-form-item">
                <label class="layui-form-label" style="width:100px">学院名称：</label>
                <div class="layui-input-block">
                    <select id="cid" name="cid" lay-verify="required" lay-reqtext="学院是必填项！">
                        <option value="">请选择学院</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-md-4 forms">
            <div class="layui-form-item">
                <label class="layui-form-label" style="width:100px">专业名称：</label>
                <div class="layui-input-block">
                    <select id="mid" name="mid" lay-verify="required" lay-reqtext="学院是必填项！">
                        <option value="">请选择专业</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-md-4 forms">
            <div class="layui-form-item">
                <!--            创建年级按钮-->
                <div class="layui-form-item">
                    <div class="layui-btn pull-left" lay-submit lay-filter="Info"><i class="layui-icon">&#xe61f;</i>添加年级</div>
                </div>
            </div>
        </div>
        <div class="col-md-4 forms">

        </div>
    </div>
    <!--            表格主体-->
    <div id="LAY_preview" style="margin-top: 10px">
            <!--                   选项卡-->
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <ul class="layui-tab-title">
                <li class="layui-this">年级</li>
                <li>年级班级</li>
            </ul>
            <div class="layui-tab-content"></div>
        </div>
        <table class="layui-table" id="table">
        </table>
           <!--            分页框-->
        <div id="test1"></div>
        <div id="test2"></div>
    </div>
</div>
</body>


</html>