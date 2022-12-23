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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/StudentInfo.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/StuManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>添加学生</title>
</head>
<body onload="addCode();StuInfo()">
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
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tName" name="tName" lay-verify="required|title" autocomplete="off" placeholder="姓名必须为中文"
                               class="layui-input">
                    </div>
                </div>
                <!--                账号-->
                <div class="layui-form-item">
                    <label class="layui-form-label">账号：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tCode" name="tCode"  READONLY="true" lay-verify="required|newres" autocomplete="off" placeholder=""
                               class="layui-input">
                    </div>
                </div>
                <!--                密码-->
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tPwd" name="tPwd" lay-verify="required|pwd" autocomplete="off" value="123456" placeholder="密码必须是6-16位字母加数字组合"
                               class="layui-input">
                    </div>
                </div>
                <!--                性别-->
                <div class="layui-form-item">
                    <label class="layui-form-label">性别：</label>
                    <div class="layui-input-block">
                        <input type="radio" id="tMan" name="tSex" value="男" title="男" checked="checked">
                        <div class="layui-unselect layui-form-radio layui-form-radioed"><i
                                class="layui-anim layui-icon"></i>
                            <div>男</div>
                        </div>
                        <input type="radio" id="tWomen" name="tSex" value="女" title="女">
                        <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                            <div>女</div>
                        </div>
                    </div>
                </div>
                <!--                年龄-->
                <div class="layui-form-item">
                    <label class="layui-form-label">年龄：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tAge" name="tAge" lay-verify="required|age" autocomplete="off"
                               placeholder="请输入年龄"
                               class="layui-input">
                    </div>
                </div>
                <!--                年级-->
                <div class="layui-form-item">
                    <label class="layui-form-label">所在年级：</label>
                    <div class="layui-input-block">
                        <select id="tGrade" name="tGrade" lay-verify="required" lay-filter="test" lay-reqtext="年级是必填项！">
                            <option value="">请选择你的年级</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所在班级：</label>
                    <div class="layui-input-block">
                        <select id="tClass" name="tClass" lay-verify="required" lay-reqtext="班级是必填项！">
                            <option value="">请选择你的班级</option>
                        </select>
                    </div>
                </div>
                <!--                电话-->
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tPone" name="tPone" lay-verify="required|phone" autocomplete="off"
                               placeholder="电话必须为11位数字"
                               class="layui-input">
                    </div>
                </div>
                <!--                QQ-->
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ号码：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tQQ" name="tQQ" lay-verify="required|QQ" autocomplete="off"
                               placeholder="QQ必须为6-13位"
                               class="layui-input">
                    </div>
                </div>
                <!--                家庭住址-->
                <div class="layui-form-item">
                    <label class="layui-form-label">家庭地址：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tAddress" name="tAddress" lay-verify="" autocomplete="off" placeholder="请输入家庭地址"
                               class="layui-input">
                    </div>
                </div>
                <!--                提交按钮-->
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <div class="layui-btn" lay-submit  id="referto"  lay-filter="component-form-element">立即提交</div>
                        <div  id="Reset"  class="layui-btn layui-btn-primary">重置</div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>