/**
 * @description 新增教师页面重置按钮会重启数据并自动生成账号方法的
 *
 */
$(function () {
    $("#chongzhi").click(function () {
        $("#cname").val("");
        $("#mname").val("");
        $("#mremark").val("");
        $("#tQQ").val("");
        $("#tEmail").val("");
        $("#tAddress").val("");
        $("#tIntorduction").val("");
        $("#tPwd").val("");
        $("#mstatus option").eq(0).prop("selected",true);
        Refresh();
    })
});

/**
 * @description 在页面加载完成就自动生成教师账号
 * **/
function addCode(){
    //获取1970到现在的时间（毫秒显示）
    var mydate= new Date();
   //截取后六位
    var Code = mydate.getTime().toString().slice(5,11);
    //获取教师账号标签
    var TeacherCode = document.getElementById("tCode");
    //添加生成随机账号
    TeacherCode.value="t"+Code;
}

function chongzhiClick(){
    $("#mname").val("");
    $("#cid").val("");
    $("#mstatus").val("");
    $("#mremark").val("");
    Refresh();
}
function chongzhiClick(){
    $("#cid").val("");
    $("#mstatus").val("");
    $("#mremark").val("");
    $("#mname").val("");
    Refresh();
}


/**
 * @description 对表单里的数据进行验证
 * **/
layui.use(['form'], function () {
    var form = layui.form;
    //     //仅输入中文
    var reg = /^[\u4e00-\u9fa5\u3001]+$/;
    //密码必须包含数字和字母，长度6-16！
    var regs = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
    //QQ账号
    var regQQ = /^[1-9][0-9]{5,16}$/;
    //年龄
    var regage= /^[1-9][0-9]*$/;
    //要放在form.on外面，千万不能放在提交步骤中，否则会不触发
    form.verify({
        title: function (value) {
            if (reg.test(value)) {
                //    验证通过
            } else {
                return '请输入学院名称(仅中文汉字)！';
            }
        }
    });

    form.on('submit(component-form-element)', function(data){
        var Judge=UpMajor();
        if(Judge){
            // addCode();
            // $("#chongzhi").click();
            chongzhiClick();
        }
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //监听修改教师页面的提交按钮
    form.on('submit(modify)', function(data){
        var data = {};
        var Info = {};
        if (localStorage.ModifyId != null) {
            var json2 = localStorage.ModifyId;
            var obj = JSON.parse(json2);
        }
        data.tableName = "Major";
        Info.mid = obj.mid
        Info.mname = Serch("mname");
        Info.cname = Serch("cname");
        // Info.mstatus = $("#mstatus option:selected").text();
        Info.mstatus = Serch("mstatus");
        Info.mremark = Serch("mremark");
        Info.cid = Serch("cid");
        data.info = JSON.stringify(Info);
        var url = "/update";
        var Menu = Ajax(url, data);
        if (Menu.code == 1) {
            //成功的
            parent.layer.msg(Menu.message, {
                icon: 1
                , time: 2000
            });
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
            parent.$("#Select").click();
        } else {
            parent.layer.msg(Menu.message, {
                icon: 5
                , anim: 6
                , time: 2000
            });

        }

        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

});
/**
 * @description 获取当前id标签的value值、
 * @param id 标签的id
 * @return 当前id标签的value值
 * **/
function Serch(id) {
    return $("#" + id).val();
}
