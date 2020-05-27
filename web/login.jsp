<%--
    普通用户登录页面（普通与管理员用户都能登进去）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<!-------------------login-------------------------->
<body>
<div class="login">
    <form action="/OnlineShop/user_Login" method="post">
        <a href="index.jsp" style="padding: 0px;margin: 0px;font-size: 30px;
            text-align: center;line-height: 60px;color: #1A1A1A">用户登录</a>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="user_id" value="" placeholder="用户ID"></p>
        <p><input type="password" name="password" value="" placeholder="密码"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt">
            <a class="" href="register.jsp">免费注册</a>
            <a href="forget.html">忘记密码？</a>
        </p>
    </form>
</div>
</body>
</html>

