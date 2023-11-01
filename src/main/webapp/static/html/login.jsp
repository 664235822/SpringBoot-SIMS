<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Login.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <title>教务管理系统</title>
    <style>
        /* 使元素始终位于网页最下方中央 */
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            text-align: center;
            color: white;
        }

        /* 使a标签的文字颜色始终为白色 */
        .footer a {
            color: white;
            text-decoration: none;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
        <div class="layadmin-user-login-main layui-anim layui-anim-scale">
            <div class="layadmin-user-login-box layadmin-user-login-header">
                <h2>教务管理系统</h2>
            </div>

            <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                <!-- 分割线 -->
                <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                    <ul class="layui-tab-title">
                        <li class="layui-this" name="3">学生</li>
                        <li name="2">教师</li>
                        <li name="1">管理员</li>
                    </ul>
                </div>
                <!-- 分割线 -->
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                           for="LAY-user-login-username"></label>
                    <input type="text" name="username" id="LAY-user-login-username" lay-verify="required"
                           placeholder="用户名" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                           for="LAY-user-login-password"></label>
                    <input type="password" name="password" id="LAY-user-login-password" lay-verify="required"
                           placeholder="密码" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <div class="layui-row">
                        <div class="layui-col-xs7">
                            <label class="layadmin-user-login-icon layui-icon layui-icon-vercode"
                                   for="LAY-user-login-vercode"></label>
                            <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required"
                                   placeholder="验证码" class="layui-input">
                        </div>
                        <div class="layui-col-xs5">
                            <div style="margin-left: 10px;">
                                <div class="RandomCode"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="margin-bottom: 20px;">
                    <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                    <div class="layui-unselect layui-form-checkbox" id="Checked" lay-skin="primary"><span>记住密码</span><i
                            class="layui-icon layui-icon-ok"></i></div>
                    <a lay-href="/user/forget" class="layadmin-user-jump-change layadmin-link"
                       style="margin-top: 7px;">忘记密码？</a>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit" id="btn-login">登
                        入</button>
                </div>

            </div>
        </div>
        <p class="footer"><a href="https://beian.miit.gov.cn">蜀ICP备2023027868号-1</a>
            SmallPig1997版权所有
        </p>
    </div>
</div>
</body>

</html>