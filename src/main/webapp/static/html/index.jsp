<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生信息管理系统</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/img/StudentManageSystom.ico" />
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/index.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>

</head>

<body class="layui-layout-body">
<!-- 导航栏 -->
<nav class="layui-layout-admin">
    <div class="layui-header" style="background: rgb(56,62,73);">
        <div class="layui-logo">
<!--            <img src="${pageContext.request.contextPath}/static/img/logo.png"/>-->
            <a href="${pageContext.request.contextPath}/static/html/HomePage.jsp" target="ifm" style="font-size: 20px; color: white;">
                <i class="layui-icon layui-icon-console" style="font-size: 28px; vertical-align: middle;"></i>学生信息管理系统</a>
        </div>
        <ul class="layui-nav layui-layout-right" id="topnav">
            <li class="layui-nav-item">
                <a href="">
                    <span class="glyphicon glyphicon-user"></span>管理员
                </a>
                <dl class="layui-nav-child"> <!-- 二级菜单 -->
                    <dd><a id="LogOut">注销登录</a></dd>
                    <dd><a id="Reset">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item lay-unselect">
                <a id="about">关于</a>
            </li>
        </ul>
    </div>
</nav>

<!-- 菜单栏 -->
<div class="layui-side layui-bg-black menu">
    <ul class="layui-nav-tree layui-side-scroll pointer" id="leftnav">

    </ul>
</div>

<!-- iframe框架-->
<div class="layui-body ojbk">
    <iframe onload="setHeight()" scrolling="no" class="ifm" name="ifm"
            src="${pageContext.request.contextPath}/static/html/HomePage.jsp"></iframe>
    <!--    <iframe onload="setHeight()"  scrolling="no" class="ifm" src="${pageContext.request.contextPath}/static/html/ShowTeachers.jsp"></iframe>-->
    <!--    <iframe onload="setHeight()"  scrolling="no" class="ifm" src="${pageContext.request.contextPath}/static/html/AddStudent.jsp"></iframe>-->
</div>
<!-- 底部导航栏 -->
<nav class="navbar navbar-default navbar-fixed-bottom">
    <p class="text-center" style="height: 50px; line-height: 50px; margin: 0px;">
        欢迎访问学生信息管理系统，更多信息请联系我们，我们的邮箱是2633944192@qq.com</p>
</nav>
</body>
<script>
    //自适应高度
    function setHeight() {
        var h = $(".ifm").contents().find("body").height();
        $(".ifm").height(h + 100);
    }
    //设置body最小高度
    //浏览器窗口大小发生变化则再次执行自适应高度函数，以适应高度
    window.onresize = function(){
        if (window.innerWidth<1500||window.innerHeight<754){
            $(".navbar-fixed-bottom").hide();
        }else {
            $(".navbar-fixed-bottom").show();
        }
    };
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
    $(".ojbk").scroll(function(){
        //距离顶部
        var scrollTop = $(this).scrollTop();
        //文档高度
        var scrollHeight = $(".ifm").height();
        //当前盒子高度
        var windowHeight = $(this).height();
        if(scrollTop + windowHeight+5 > scrollHeight){
            $(".navbar-fixed-bottom").hide();
        }else {
            $(".navbar-fixed-bottom").show();
            // alert("距顶部："+scrollTop+"ifm高度"+scrollHeight+"盒子高度"+windowHeight);
        }
    });
</script>
</html>