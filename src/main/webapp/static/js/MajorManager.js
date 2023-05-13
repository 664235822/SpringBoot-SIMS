/**
 *
 * 教师管理js
 * **/
//班级年级科目数据
var ClassList = {};
//班级id
var classId = 0;
//科目id
var SubjectsId = 0;
//年级id
var gradeId = 0;

/**
 * @description 添加教师页面初始化
 * **/
function TeacherInfo() {
    $(function () {
        $("#test1").click(function () {
            $("input[type='file']").val("");
            $("#btn_file").click();
        });
        $("#btn_file").change(function () {
            uploadExcel('Teacher');
        });

    });
}


/**
 * @description 获取添加教师页面表单数据
 * **/
function UpMajor() {
    var data = {};
    var Info = {};
    data.tableName = "Major";
    Info.cid = Serch("cid");
    Info.mname = Serch("mname");
    Info.mstatus = Serch("mstatus");
    Info.mremark = Serch("mremark");

    data.info = JSON.stringify(Info);
    var url = "/insert";
    var Menu = Ajax(url, data);
    if (Menu.code == 1) {
        //成功的
        layer.msg(Menu.message, {
            icon: 1
            , time: 1000
        });
        return true;
    } else {
        layer.msg(Menu.message, {
            icon: 5
            , anim: 6
            , time: 1000
        });

    }

}

/**
 * @description 获取当前id标签的value值、
 * @param id 标签的id
 * @return 当前id标签的value值
 * **/
function Serch(id) {
    return $("#" + id).val();
}

/**
 * @description 专业管理页面初始化
 *
 * **/
function ShowTeachers() {
    var collegeList = Ajax("/select", {'tableName': "CollegeAll"});
    var collegeSelect_html = ''
    for (var i = 0; i < collegeList.data.list.length; i++) {
        collegeSelect_html += " <option value=\"" + collegeList.data.list[i].cid + "\" >";
        collegeSelect_html += collegeList.data.list[i].cname + "</option>";
    }
    $('#cid').append(collegeSelect_html);

    layui.use('form', function () {
        var form = layui.form;
        form.render('select','quiz1');
        // form.on('select(test)', function (data) {
        //     gradeId = data.value;
        //     var num=0;
        //     for (var i = 0; i < GradeAll.data.length; i++) {
        //         if (GradeAll.data[i].id == gradeId) {
        //             if(GradeAll.data[i].classes.length==0){
        //                 num=GradeAll.data[i].gradeCode+"01";
        //             }else {
        //                 num = parseInt(GradeAll.data[i].classes[GradeAll.data[i].classes.length - 1].classCode) + 1;
        //             }
        //             $("#MoveGradeId").val(num);
        //             break;
        //         }
        //     }
        // });
    })
    // this.ClassList = Ajax("/select", {'tableName': "GradeAll", 'currentPage': 0});
    var data = {"tableName": "Major","name": "", "currentPage": 1};
    var table = getPage(data);
    if (table.code == 1) {
        TeachresTable(table.data.list);
        Refresh();
        Page("test1", table.data.pageCount, table.data.dataCount);
        TeacherFunction();
    }
}

/**
 * @description 查询数据
 * @param data 请求的数据
 * @return table 查询到的数据
 * **/
function getPage(data) {
    var url = "/select";
    var table = Ajax(url, data);
    return table;
}
/**
 * @description 教师管理页面的查询，单行，多行操作
 * **/
function TeacherFunction() {
    $(function () {
        //查询
        $("#Select").click(function () {
            var name = $("#name").val();
            var cid = $('#cid').val();
            var data = {"tableName": "Major","name": name,"collegeId":cid, "currentPage": 1};
            var table = getPage(data);
            if (table.code == 1) {
                TeachresTable(table.data.list);
                Refresh();
                Page("test1", table.data.pageCount, table.data.dataCount);
                TeacherFunction();
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
        if ($(this).attr("name") == "delete") {
            var codeList = new Array();
            codeList[0] = id;
            Delete(codeList);
        }
        if ($(this).attr("name") == "moveClass") {
            var subid = $(this).parent().attr('name');
            Move(subid);
        }
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
            Delete(codeList);
        }
    });
}

function CollegeSelect(){
    var collegeList = Ajax("/select", {'tableName': "CollegeAll"});
    var text = '';
    for (var i = 0; i < collegeList.data.list.length; i++) {
        text += " <option value=\"" + collegeList.data.list[i].cid + "\" >";
        text += collegeList.data.list[i].cname + "</option>";
    }
    $('#cid').append(text);
    Refresh();
}

/**
 * @description 修改教师信息页面当前学生数据
 * **/
function TeacherModify() {
    if (localStorage.ModifyId != null) {
        var json2 = localStorage.ModifyId;
        var obj = JSON.parse(json2);
    }
    var data = {"tableName": "Major", "code": obj.mid, "name": "", "currentPage": 1};
    var table = getPage(data);
    var list = table.data.list[0];
    var collegeList = Ajax("/select", {'tableName': "CollegeAll"});
    var text
    for (var i = 0; i < collegeList.data.list.length; i++) {
        text += " <option value=\"" + collegeList.data.list[i].cid + "\" >";
        text += collegeList.data.list[i].cname + "</option>";
    }
    $('#cid').append(text);
    // collegeSelect
    // $("#cid").val(list.cid);
    $("#cname").val(list.cname);
    $("#mname").val(list.mname);
    $("#mremark").val(list.mremark);
    $("#mstatus").val(list.mstatus);
    $("#cid").val(list.cid);
    $("#mstatus option:contains(" + list.mstatus + ")").prop("selected", true);
    $("#cid option:contains(" + list.cid + ")").prop("selected", true);
    Refresh();
}

/**
 * @description 显示教师页面的layui弹窗
 * @param id 当前学院id
 * **/
function ShowModify(id) {
    var json1 = {};
    json1.mid = id;
    var str1 = JSON.stringify(json1);
    localStorage.ModifyId = str1;
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            type: 2
            , closeBtn: 2
            , shade: [0.1, '#ffffff']
            , title: ['查看信息', 'color:#ffffff;background-color:#009688;']
            , content: '/SpringBoot-SIMS/static/html/UpdateMajorInfo.jsp'
            , area: ['650px', '500px']
        });
    });
}


/**
 * @description 删除操作的确认弹窗
 * @param codeList 要删除行的name数据
 * **/
function Delete(codeList) {
    layer.confirm('确认删除', {
        icon: 7,
        title: '提示',
        fixed: false,
    }, function (index) {
        var data = {}
        data.tableName = 'Major';
        data.codeList = JSON.stringify(codeList);
        var url = "/delete";
        var Delete = Ajax(url, data);
        DeleteEnd(Delete);
        layer.close(index);
    });

}

/**
 * @description 给老师添加班级科目关系
 * @param codeList 当前行的name值（教师id）
 *
 */
function Move(codeList) {
    var text = "";
    text += " <div class=\"layui-form\">";
    text += "<select name=\"city\"  lay-filter=\"test\">";
    text += "  <option value=\"\">请选择年级</option>";
    text += grade();
    text += "</select>";
    text += "<select name=\"quiz\" id=\"Class\"  lay-filter=\"quiz\" lay-verify=\"\">";
    text += "  <option value=\"\">请选择班级</option>";
    text += "</select> ";
    text += "</select>";
    text += "<select name=\"subjects\" id=\"Subjects\"  lay-filter=\"Subjects\" lay-verify=\"\">";
    text += "  <option value=\"\">请选择科目</option>";
    text += "</select> ";
    text += "    </div>";
    layer.open({
        title: '分配班级',
        btn: ['确定', '取消'],
        content: text,
        skin: 'demo-class',
        btnAlign: 'c',
        move: false,
        shade: [0.1, '#ffffff'],
        yes: function (index) {
            var data = {};
            var url = "/insert";
            data.tableName = "ClassTeacher";
            var info = {};
            info.teacherId = codeList;
            info.classId = classId;
            info.subjectId = SubjectsId;
            data.info = JSON.stringify(info);
            var table = Ajax(url, data);
            DeleteEnd(table);
            layer.close(index);
        }

    });
    layui.use('form', function () {
        var form = layui.form;
        form.render();
        form.on('select(test)', function (data) {
            gradeId = data.value;
            var text = MoveClass();
            $("#Class").html(text);
            var text = Subjects();
            $("#Subjects").html(text);
            Refresh();
        });
        form.on('select(quiz)', function (data) {
            classId = data.value;
            var text = Subjects();
            $("#Subjects").html(text);
            Refresh();
        });
        form.on('select(Subjects)', function (data) {
            SubjectsId = data.value;
        });
    });
}

// /**
//  * @description 班级下拉框
//  * @param gradeId 年级id
//  * @return   text 下拉框代码
//  */
// function Subjects() {
//     var text = "";
//     var subjectsId = 0;
//     text += "  <option value=\"\">请选择科目</option>";
//     if (ClassList.code == 1) {
//         var list = ClassList.data;
//         for (var i = 0; i < list.length; i++) {
//             if (list[i].id == gradeId) {
//                 for (var j = 0; j < list[i].classes.length; j++) {
//                     if (list[i].classes[j].id == classId) {
//                         if (list[i].classes[j].subjects != undefined) {
//                             for (var k = 0; k < list[i].classes[j].subjects.length; k++) {
//                                 if (subjectsId != list[i].classes[j].subjects[k].id) {
//                                     subjectsId = list[i].classes[j].subjects[k].id;
//                                     text += " <option value=\"" + list[i].classes[j].subjects[k].id + "\">";
//                                     text += list[i].classes[j].subjects[k].subjectName + "</option>";
//                                 }
//                             }
//                         }
//                         break;
//                     }
//                 }
//                 break;
//             }
//         }
//     }
//     return text;
// }
//
// /**
//  * @description 班级下拉框
//  * @return   text 下拉框代码
//  */
// function MoveClass() {
//     var text = "";
//     text += "  <option value=\"\">请选择班级</option>";
//     if (ClassList.code == 1) {
//         var list = ClassList.data;
//         for (var i = 0; i < list.length; i++) {
//             if (list[i].id == gradeId) {
//                 for (var j = 0; j < list[i].classes.length; j++) {
//                     text += " <option value=\"" + list[i].classes[j].id + "\">";
//                     text += list[i].classes[j].className + "</option>";
//                 }
//
//             }
//         }
//     }
//     return text;
// }
//
// /**
//  * @description 年级下拉框
//  * @return   text 下拉框代码
//  */
// function grade() {
//     var text = "";
//     if (ClassList.code == 1) {
//         var list = ClassList.data;
//         for (var i = 0; i < list.length; i++) {
//             text += " <option value=\"" + list[i].id + "\" >";
//             text += list[i].gradeName + "</option>";
//         }
//     }
//     return text;
// }
/**
 * @description 操作之后的回调
 * @param Delete 请求后后台发送回来的数据
 *
 * **/
function DeleteEnd(Delete) {
    if (Delete.code == 1) {
        var code = $("#code").val();
        var name = $("#name").val();
        var data = {"tableName": "Major", "name": name, "currentPage": 1};
        var table = getPage(data);
        TeachresTable(table.data.list);
        Refresh();
        Page("test1", table.data.pageCount, table.data.dataCount);
        TeacherFunction();
        layer.msg(Delete.message, {
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
    layui.use('laypage', function () {
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: id //注意，这里的 test1 是 ID，不用加 # 号
            , count: count //数据总数，从服务端得到
            , limit: 10
            , layout: ['prev', 'page', 'next', 'skip']
            , jump: function (obj, first) {
                //首次不执行
                if (!first) {
                    var code = $("#code").val();
                    var name = $("#name").val();
                    var data = {"tableName": "Major","name": name, "currentPage": obj.curr};
                    var table = getPage(data);
                    if (table.code == 1) {
                        TeachresTable(table.data.list);
                        Refresh();
                        TeacherFunction();
                    }
                }
            }
        });
    });
}
/**
 * @description 教师管理页面的表格
 * @param data 教师数据
 * **/
function TeachresTable(data) {
    if (data != null) {
        var text = "";
        text += " <colgroup> <col width=\"50\"><col width=\"150\"><col width=\"200\"><col></colgroup>";
        text += "<thead><tr>";
        text += "<th><div class=\"layui-form\" id=\"allChoose\"> <input  type=\"checkbox\" name=\"delete\" title=\"\" lay-skin=\"primary\" >";
        text += "</div></th>";
        text += "<th style='width: 240px'>学院名称</th><th>专业名称</th><th>状态</th><th>备注</th><th style='width: 240px'>操作</th>";
        text += "</tr></thead>";
        text += "<tbody>";
        for (var i = 0; i < data.length; i++) {
            text += "<tr name=\'" + data[i].mid + "\'>";
            text += "<td><div class=\"layui-form\"> <input type=\"checkbox\" name=\"checkbox\" title=\"\" lay-skin=\"primary\" >";
            text += "</div></td>"
            text += "<td>" + data[i].cname + "</td>";
            text += "<td>" + data[i].mname + "</td>";
            text += "<td>" + (data[i].mstatus == "1" ? '启用':'停用') + "</td>";
            text += "<td>" + data[i].mremark + "</td>";
            text += "<td  name=\'" + data[i].mid + "\'>";
            text += "<button type=\"button\" class=\"layui-btn  layui-btn-sm layui-btn-warm\" name=\"modify\">修改</button>";
            text += "<button type=\"button\" class=\"layui-btn  layui-btn-sm layui-btn-danger\" name=\"delete\">删除</button>";
            // text += "<button type=\"button\" class=\"layui-btn  layui-btn-sm layui-bg-green\" name=\"moveClass\">分配班级</button>";
            text += "</td>";
            text += "</tr>";
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