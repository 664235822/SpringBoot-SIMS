/**
 * 年级管理js
 * **/
//不同页面的表格名
var tableName="";

/**
 * @description 查看班级初始化
 *
 */
function ShowClass() {
    var grade = getGrade(0);
    var Class = getClass(1, "", "");
    if (Class.code == 1) {
        ClassTable(grade.data.list, Class.data.list);
        Refresh();
        tableName="showTable";
        Page("test1", Class.data.pageCount, Class.data.dataCount);
        ClassFunction();
    }
}
/**
 * @description 新增班级初始化
 *
 */
function ClassInfo() {
    var grade = getGrade(0);
    var Class = getClass(1, "", "");
    if (Class.code == 1) {
        AddClassTable(grade.data.list, Class.data.list);
        Refresh();
        tableName="addTable";
        Page("test1", Class.data.pageCount, Class.data.dataCount);
        AddClass(Class);
    }
}

/**
 * @description 新增班级方法
 *
 */
function AddClass() {
    var GradeAll = Ajax("/select", {'tableName': "GradeAll", 'currentPage': 0});
    var gradeId = -1;
    var num = -1;
    var text = "";
    text += "  <option value=\"\">请选择年级</option>";
    text += grade();
    $("#electgGrade").html(text);
    layui.use('form', function () {
        var form = layui.form;
        form.render();
        form.on('submit(component-form-element)', function (data) {
            var ClassName = $("#ClassName").val();
            erifydata(ClassName, GradeAll, gradeId, num);
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });
        //表单监听事件
        form.on('select(quiz1)', function (data) {
            gradeId = data.value;
            for (var i = 0; i < GradeAll.data.length; i++) {
                if (GradeAll.data[i].id == gradeId) {
                   if(GradeAll.data[i].classes.length==0){
                        num=GradeAll.data[i].gradeCode+"01";
                   }else {
                       num = parseInt(GradeAll.data[i].classes[GradeAll.data[i].classes.length - 1].classCode) + 1;
                   }
                    $("#ClassCode").val(num);
                    break;
                }
            }
        });
    })
}


/**
 * @description 验证班级数据
 * @param  ClassName 新增班级名称
 * @param GradeAll  所有年级
 * @param gradeId  年级id
 * @param num  班级编号
 */
function erifydata(ClassName, GradeAll, gradeId, num) {
    var Judge = false;
    for (var i = 0; i < GradeAll.data.length; i++) {
        if (GradeAll.data[i].id == gradeId) {
            for (var j = 0; j < GradeAll.data[i].classes.length; j++) {
                if (GradeAll.data[i].classes[j].className == ClassName) {
                    Judge = true;
                    break;
                }
            }
            break;
        }
    }
    if (Judge) {
        layer.msg("班级名称重复", {
            icon: 5
            , anim: 6
            , time: 1000
        });
    } else {
        var data = {};
        var Info = {};
        Info.className = ClassName;
        Info.gradeId = gradeId;
        Info.classCode = num;
        Info.createMessage = JSON.parse(localStorage.Login).name;
        data.info = JSON.stringify(Info);
        data.tableName = "Class";
        var grande = Ajax("/insert", data);
        if (grande.code == 1) {
            ClassInfo();
            layer.msg(grande.message, {
                icon: 1
                , time: 1000
            });
        } else {
            layer.msg("操作失败", {
                icon: 5
                , anim: 6
                , time: 1000
            });

        }
    }
}

/**
 * @description 获取年级信息
 * @param  page 页数
 * @param data  访问到的数据
 */
function getGrade(page) {
    var url = "/select";
    var data = Ajax(url, {'tableName': 'Grade', "gradeId": "", 'currentPage': page});
    return data;
}

/**
 * @description 获取班级信息
 * @param  page 页数
 * @param  code 编号
 * @param  name 姓名
 * @param data  访问到的数据
 */
function getClass(page, code, name) {
    var url = "/select";
    var data = Ajax(url, {'tableName': 'Class', 'code': code, 'name': name, "gradeId": "", 'currentPage': page});
    return data;
}

/**
 * @description 班级查询，全选功能，单行操作，多行操作
 *
 */
function ClassFunction() {
    $(function () {
        //查询
        $("#Select").click(function () {
            var code = $("#code").val();
            var name = $("#name").val();
            var Class = getClass(1, code, name);
            var grade = getGrade(0);
            if (Class.code == 1) {
                ClassTable(grade.data.list, Class.data.list);
                Refresh();
                Page("test1", Class.data.pageCount, Class.data.dataCount);
                ClassFunction();
            }

        });

        //全选
        $("#allChoose").click(function () {
            if ($("#allChoose>input").is(':checked')) {
                $("input[name=checkbox]").prop("checked", true);
            } else {
                $("input[name=checkbox]").prop("checked", false);
            }
            layui.use('form', function () {
                var form = layui.form;
                form.render();
            });
        });
    });
    //单行操作
    $("table tbody").find("button[name]").click(function () {
        var id = $(this).parent().parent().attr('name');
        //删除功能
        if ($(this).attr("name") == "delete") {
            var codeList = new Array();
            codeList[0] = id;
            Delete(codeList);
        }
        //转级功能
        if ($(this).attr("name") == "moveGrade") {
            var codeList = new Array();
            codeList[0] = id;
            Move(codeList);
        }
        //修改功能
        if ($(this).attr("name") == "modify") {
            ShowModify(id);
        }

    });
    //多行操作
    $("#moveClassAll").click(function () {
        var codeList = new Array();
        var num = 0;
        $("input[name=checkbox]:checked").each(function () {
            codeList[num] = $(this).parent().parent().parent().attr('name');
            num++;
        });
        if (codeList.length == 0) {
            layer.msg("请选择", {
                icon: 5
                , anim: 6
                , time: 1000
            });
        } else {
            //多行删除
            Delete(codeList);
        }
    });

}


//

/**
 * @description 更改年级
 * @param  codeList 年级编号数组
 */
function Move(codeList) {
    var GradeAll = Ajax("/select", {'tableName': "GradeAll", 'currentPage': 0});
    var gradeId = 0;
    var text = "";
    text += " <div class=\"layui-form\">";
    text +=" <input type=\"text\" id='MoveGradeId' required  lay-verify=\"required\" disabled placeholder=\"班级编号（选择年级后显示）\" autocomplete=\"off\" class=\"layui-input\">"
    text += "<select name=\"city\"  lay-filter=\"test\">";
    text += "  <option value=\"\">请选择年级</option>";
    text += grade();
    text += "</select>";
    text += "</div>";
    layer.open({
        title: '更改年级',
        btn: ['确定', '取消'],
        content: text,
        skin: 'demo-class',
        btnAlign: 'c',
        move: false,
        shade: [0.1, '#ffffff'],
        yes: function (index) {
            var list = new Array;
            var data = {};
            for (var i = 0; i < codeList.length; i++) {
                var obj = {};
                obj.classCode = codeList[i];
                obj.gradeId = gradeId;
                list.push(obj);
            }
            var url = "/update";
            data.tableName = "GradeId";
            data.info = JSON.stringify(list);
            var table = Ajax(url, data);
            Callback(table);
            layer.close(index);
        }

    });
    layui.use('form', function () {
        var form = layui.form;
        form.render();
        form.on('select(test)', function (data) {
            gradeId = data.value;
            var num=0;
            for (var i = 0; i < GradeAll.data.length; i++) {
                if (GradeAll.data[i].id == gradeId) {
                    if(GradeAll.data[i].classes.length==0){
                        num=GradeAll.data[i].gradeCode+"01";
                    }else {
                        num = parseInt(GradeAll.data[i].classes[GradeAll.data[i].classes.length - 1].classCode) + 1;
                    }
                    $("#MoveGradeId").val(num);
                    break;
                }
            }
        });
    })
}


/**
 * @description 修改班级名称
 * @param  code 年级编号
 */
function ShowModify(code) {
    var Class = getClass(0, code, "");
    var text = "";
    text += "<div class=\"layui-form-item\">";
    text += "<label class=\"layui-form-label\">编号</label>";
    text += "<div class=\"layui-input-block\">";
    text += "<input type=\"text\" name=\"title\" value=\"" + Class.data.list[0].classCode + "\"disabled autocomplete=\"off\" class=\"layui-input\">";
    text += "</div></div>";
    text += "<div class=\"layui-form-item\">";
    text += "<label class=\"layui-form-label\">名称</label>";
    text += "<div class=\"layui-input-block\">";
    text += "<input type=\"text\" name=\"title\" id='Classname' value=\"" + Class.data.list[0].className + "\" autocomplete=\"off\" class=\"layui-input\">";
    text += "</div></div>";
    layer.open({
        title: '更改班级名称',
        btn: ['确定', '取消'],
        content: text,
        skin: 'demo-class',
        btnAlign: 'c',
        move: false,
        shade: [0.1, '#ffffff'],
        yes: function (index) {
            var data = {};
            var url = "/update";
            data.tableName = "Class";
            var info = {};
            info.classCode = Class.data.list[0].classCode;
            info.className = $("#Classname").val();
            data.info = JSON.stringify(info);
            var table = Ajax(url, data);
            Callback(table);
            layer.close(index);
        }
    });
}

/**
 * @description 年级下拉框
 *
 */
function grade() {
    var grade = getGrade(0);
    var text = "";
    if (grade.code == 1) {
        var list = grade.data.list;
        for (var i = 0; i < list.length; i++) {
            text += " <option value=\"" + list[i].id + "\" >";
            text += list[i].gradeName + "</option>";
        }
    }
    return text;
}

/**
 * @description 用户删除时判断
 * @param  codeList 年级编号数组
 */
function Delete(codeList) {
    layer.confirm('确认删除', {
        icon: 7,
        title: '提示',
        fixed: false,
    }, function (index) {
        var data = {}
        data.tableName = 'Class';
        data.codeList = JSON.stringify(codeList);
        var url = "/delete";
        var Delete = Ajax(url, data);
        Callback(Delete);
        layer.close(index);
    });

}

/**
 * @description 访问后台的回调
 * @param  Callback 后台返回的数据
 *
 */
function Callback(Callback) {
    if (Callback.code == 1) {
        ShowClass();
        layer.msg(Callback.message, {
            icon: 1
            , time: 1000
        });
    } else {
        layer.msg("操作失败", {
            icon: 5
            , anim: 6
            , time: 1000
        });

    }

}

/**
 * @description layui分页功能
 * @param  id 绑定id
 * @param limit  页数
 * @param count  数据总条数
 *
 */
function Page(id, limit, count) {
    var index = 0;
    layui.use('laypage', function () {
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
            , count: count //数据总数，从服务端得到
            , limit: 10
            , layout: ['prev', 'page', 'next', 'skip']
            , jump: function (obj, first) {
                //首次不执行
                if (!first) {
                    var name=$("#ClassName").val();
                    var code=$("#ClassCode").val();
                    var grade = getGrade(0);
                    var Class = getClass(obj.curr,code,name);
                    if (Class.code == 1) {
                        if(tableName=="showTable"){
                            ClassTable(grade.data.list, Class.data.list);
                        }
                        if(tableName=="addTable"){
                            AddClassTable(grade.data.list, Class.data.list);
                        }
                        Refresh();
                        ClassFunction();
                    }
                }
            }
        });
    });

}

/**
 * @description 添加班级页面表格
 * @param  grade 年级数据
 * @param  Class 班级数据
 */
function AddClassTable(grade, Class) {
    var data = Class;
    if (data != null) {
        var text = "";
        text += "<thead><tr>";
        text += "<th>班级编号</th><th>班级名称</th><th>创建人</th><th>创建时间</th>";
        text += "</tr></thead>";
        text += "<tbody>";
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < grade.length; j++) {
                if (data[i].gradeId == grade[j].id) {
                    text += "<tr name=\'" + data[i].classCode + "\'>";
                    text += "<td>" + data[i].classCode + "</td>";
                    text += "<td>" + data[i].className + "</td>";
                    text += "<td>" + data[i].createMessage + "</td>";
                    text += "<td>" + data[i].createTime + "</td>";
                    text += "</tr>";
                    break;
                }
            }
        }
        text += "</tbody>";
        $("#table").html(text);
    }
}


/**
 * @description 班级管理页面表格
 * @param  grade 年级数据
 * @param  Class 班级数据
 */
function ClassTable(grade, Class) {
    var data = Class;
    if (data != null) {
        var text = "";
        text += " <colgroup> <col width=\"50\"><col width=\"150\"><col width=\"200\"><col></colgroup>";
        text += "<thead><tr>";
        text += "<th><div class=\"layui-form\" id=\"allChoose\"> <input  type=\"checkbox\" name=\"delete\" title=\"\" lay-skin=\"primary\" >";
        text += "</div></th>"
        text += "<th>班级编号</th><th>班级名称</th><th>创建人</th><th>创建时间</th>><th>所属年级编号</th><th>所属年级</th><th style='min-width: 240px'>操作</th>";
        text += "</tr></thead>";
        text += "<tbody>";
        for (var i = 0; i < data.length; i++) {
            for (var j = 0; j < grade.length; j++) {
                if (data[i].gradeId == grade[j].id) {
                    text += "<tr name=\'" + data[i].classCode + "\'>";
                    text += "<td><div class=\"layui-form\"> <input type=\"checkbox\" name=\"checkbox\" title=\"\" lay-skin=\"primary\" >";
                    text += "</div></td>";
                    text += "<td>" + data[i].classCode + "</td>";
                    text += "<td>" + data[i].className + "</td>";
                    text += "<td>" + data[i].createMessage + "</td>";
                    text += "<td>" + data[i].createTime + "</td>";
                    text += "<td>" + grade[j].gradeCode + "</td>";
                    text += "<td>" + grade[j].gradeName + "</td>";
                    text += "<td  name=\'" + data[i].id + "\'>";
                    text += "<button type=\"button\" class=\"layui-btn  layui-btn-sm layui-btn-warm\" name=\"modify\">修改</button>";
                    text += "<button type=\"button\" class=\"layui-btn  layui-btn-sm layui-btn-danger\" name=\"delete\">删除</button>";
                    text += "<button type=\"button\" class=\"layui-btn  layui-btn-sm layui-bg-green\" name=\"moveGrade\">转级</button>";
                    text += "</td>";
                    text += "</tr>";
                    break;
                }
            }
        }

        text += "</tbody>";
        $("#table").html(text);
    }
}

/**
 * @description layui模块重新加载
 *
 */
function Refresh() {
    layui.use('form', function () {
        var form = layui.form;
        form.render();
    });
}