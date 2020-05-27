<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/function.js"></script>
</head>
<body>
<div class="reg">
    <form action="/OnlineShop/user_Register" method="post" >
        <h1 style="padding: 0px;margin: 0px;font-size: 30px;background: #3344AA;
            text-align: center;line-height: 60px">
            <a href="index.jsp" style="color: #ffffff">用户注册</a></h1>
        <p>
            <input type="text" id="user_ID" name="userID" placeholder="请输入用户ID">
            <span id="s_userID"></span>
        </p>
        <p><input type="text" name="name" placeholder="请输入用户姓名"></p>
        <p><input type="text" name="password" placeholder="请输入密码"></p>
        <p><input type="text" name="confirm" onfocus="Focus(this)" onblur="Check(this)" placeholder="请确认密码"><span></span></p>
        <p style="font-size: 16px">
            <input style="width: 15px;height: 15px" type="radio" name="sex" value="T" checked="checked">男
            <input style="width: 15px;height: 15px" type="radio" name="sex" value="W">女
        </p>
        <p><input type="date" name="birthday" placeholder="请输入出生日期"></p>
        <p><input type="text" name="email" placeholder="请输入电子邮箱"></p>
        <p><input type="text" name="telephone" placeholder="请输入手机号"></p>
        <p><input type="text" name="address" placeholder="请输入送货地址"></p>
        <p>
            <input class="code" type="text" name="veryCode" onfocus="Focus(this)" onblur="Check(this)"
                   placeholder="验证码">
            <img src="checkCode" height="32px" alt="看不清，换一张" onclick="changeCheckCode(this)">
            <span></span>
            <script type="text/javascript">
                //图片点击事件（点击刷新验证码）
                function changeCheckCode(img) {
                    //给请求添加时间
                    img.src="checkCode?"+new Date().getTime();
                }
            </script>
        </p>
        <p><input type="submit" name="" value="注册"></p>
        <p><a href="login.jsp"><span></span>已有账号登录</a></p>
    </form>
</div>
</body>
</html>

