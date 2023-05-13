<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/static/layui/css/layui.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/StuInfo.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/table.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/lay/modules/laypage.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ResultManager.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Ajax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/iframe.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
    <title>查看成绩</title>
</head>
<body  style="height: 100%" onload="ShowResult();CollegeSelect();MajorSelect();">
<!--          当前位置导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <p class="text-left addtea pull-left">当前位置 <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 首页
            <i class="layui-icon" style="font-size: 15px;">&#xe602;</i> 查看成绩</p>
    </div>
</nav>
<!--          内容区-->
<div class="container">
    <div id="updateStuResultDiv" style="display: none"></div>
    <div class="row">
        <!--            表格-->
        <div class="demoTable" style="margin-top: 20px">
            <!--        内联搜索框-->
            <form class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 72px">搜索：</label>
                    <div class="layui-input-inline">
                        <select name="college" id="cid" lay-filter="college">
                            <option value="" selected="">请选择学院</option>

                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="major" id="mid" lay-filter="major">
                            <option value="" selected="">请选择专业</option>

                        </select>
                    </div>
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

                    <div class="layui-input-inline" style="margin-top: 5px">
                        <select name="desc" id="desc" lay-filter="desc">
                            <option value="">请选择排序</option>
                            <option value="1">倒序</option>
                        </select>
                    </div>

                    <div class="layui-input-inline" style="width: 170px;margin-top: 5px">
                        <input type="text" name=""  id="code"
                               placeholder="请输入学号"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width: 170px;margin-top: 5px">
                        <input type="text" name="title"  id="name"
                               placeholder="请输入姓名"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-btn" id="Select" data-type="reload">查询</div>
                </div>
            </form>
            <!--           主体-->
            <div id="LAY_preview" style="margin-top: 10px">
                <table class="layui-table" style="margin-top: 0px" id="table">
                </table>
                <div id="test1"></div>
            </div>
            <div style="width: 100%">
                <div id="pie_eCharts" style="width: 400px;height:400px;margin-left: 400px"></div>
<%--                <div id="column_eCharts" style="width: 700px;height:400px;float: left;margin-left: 50px"></div>--%>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function initPieCharts(d){
        var chartDom = document.getElementById('pie_eCharts');
        var myChart = echarts.init(chartDom);
        var option;

        option = {
            title: {
                text: '学生及格/不及格数量',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{b}:{c}({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    type: 'pie',
                    radius: '50%',
                    data: d,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }

                }
            ]
        };

        option && myChart.setOption(option);
    }

    // function  initColumnCharts(d){
    //     var chartDom = document.getElementById('column_eCharts');
    //     var myChart = echarts.init(chartDom);
    //     var option;
    //     var name = ['无数据'];
    //     var value = [0]
    //     debugger;
    //     if(d.name !='' && d.name != null){
    //         name = d.name;
    //     }
    //     if(d.value !='' && d.value != null){
    //         value = d.value;
    //     }
    //
    //     option = {
    //         title: {
    //             text: '单科成绩排名',
    //             left: 'center'
    //         },
    //         xAxis: {
    //             type: 'category',
    //             data: name
    //         },
    //         yAxis: {
    //             type: 'value'
    //         },
    //         series: [
    //             {
    //                 data: value,
    //                 type: 'bar'
    //             }
    //         ]
    //     };
    //
    //     option && myChart.setOption(option);
    // }
</script>
</html>