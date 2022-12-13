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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/TeacherInfo.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/TeacherManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <title>修改教师信息</title>
</head>
<!--<body onload="Modify()">-->
<!--          当前位置导航-->
<body onload="TeacherModify()">
<!--导航栏-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 修改教师信息</p>
    </div>
</nav>
<!--          内容区-->
<div class="layui-container">
    <div class="row">
        <div class="col-md-6 forms">
            <form class="layui-form">
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
                <!--                学历-->
                <div class="layui-form-item">
                    <label class="layui-form-label">学历：</label>
                    <div class="layui-input-block">
                        <select id="tEducation" name="tEducation" lay-verify="required" lay-reqtext="学历是必填项！">
                            <option value="">请选择您的学历</option>
                            <option value="1">小学</option>
                            <option value="2">初中</option>
                            <option value="3">高中</option>
                            <option value="4">中职</option>
                            <option value="5">专科</option>
                            <option value="6">本科</option>
                            <option value="7">硕士</option>
                            <option value="8">博士</option>
                        </select>
                    </div>
                </div>
                <!--                科目-->
                <div class="layui-form-item">
                    <label class="layui-form-label">擅长科目：</label>
                    <div class="layui-input-block">
                        <input type="text" id="tGoodAt" name="tGoodAt" lay-verify="required" lay-reqtext="擅长科目是必填项！"
                               autocomplete="off" placeholder="多个科目用逗号隔开！"
                               class="layui-input">
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
                <!--                E-meil-->
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱地址：</label>
                    <div class="layui-input-block">
                        <input type="email" id="tEmail" name="tEmail" lay-verify="required|email" autocomplete="off" placeholder="必须包含@符号"
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
                <!--                个人简介-->
                <div class="layui-form-item">
                    <label class="layui-form-label">个人简介：</label>
                    <div class="layui-input-block">
                        <textarea name="tIntorduction" id="tIntorduction" placeholder="个人介绍" class="layui-textarea"></textarea>
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