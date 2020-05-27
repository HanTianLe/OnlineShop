/**
    用户ID检测是否存在。
*/
$(function () {
    //给userID绑定blur事件
    $("#user_ID").blur(function () {
        //获取userID文本输入框的值
        var user_id = $(this).val();
        var span = $("#s_userID");//展示结果消息。
        if (user_id == ''){
            //用户名为空
            span.css("color","red");
            span.html("用户ID不能为空！");
        }else {
            //发送ajax请求
            //期望服务器响应的数据格式：{"userExist":true,"msg":"此用户名太受欢迎，请更换一个"}
            //                     {"userExist":false,"msg":"用户名可用"}
            $.get("findByUserID",{user_Id:user_id},function (data) {//第一个是键的名称，第二个值。
                //alert(data); //弹出测试用的
                //判断userExist键的值是否为true
                if (data.userExist){
                    //用户名存在
                    span.css("color","red");
                    span.html(data.msg);
                }else {
                    //用户名不存在
                    span.css("color","green");
                    span.html(data.msg);
                }
            });
        }
    });
});


function Focus(obj) {
    if ($(obj).attr('name') == 'veryCode'){
        $(obj).next().next().html('').removeClass('error');
    }else {
        $(obj).next('span').html('').removeClass('error');
    }
}


function Check(obj) {
    var msgBox = $(obj).next('span');
    switch ($(obj).attr('name')) {
        case "confirm":
            if ($(obj).val() != $('input[name="password"]').val()){
                msgBox.html("两次输入的密码不一致！");
                msgBox.css("color","red");
            }
            break;
        case "veryCode":
            var numShow = $(obj).next().next();
            if (obj.value == ""){
                numShow.html("验证码不能为空！");
                numShow.css("color","red");
            }else {
                var url = "checkCode_judge?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
                $.get(url,function (numData) {
                    //判断返回值是否为true。
                    if (numData == "false"){
                        numShow.html("验证码输入有误！");
                        numShow.css("color","red");
                    }else {
                        numShow.html("验证码输入正确~");
                        numShow.css("color","green");
                    }
                });
            }
            break;
    }

}





