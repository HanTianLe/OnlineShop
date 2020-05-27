<%--
        我的中心
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body>
<!------------------------------头部------------------------------>
<%@ include file="top.jsp" %>
<!------------------------------路径------------------------------>
<div class="address mt" id="add">
    <div class="wrapper clearfix">
        <a href="index.jsp" class="fl">首页</a><span>/</span>
        <a class="fl">个人中心</a><span>/</span>
        <a class="on">我的中心</a>
    </div>
</div>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <!------------------------------左边------------------------------>
        <%@ include file="left.jsp" %>
        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix"><a href="#" class="fl"><img src="img/tx.png"/></a>
                    <p class="fl"><span>${sessionScope.online_user.USER_NAME}</span>
                        <a href="person_message.jsp">修改个人信息></a></p></div>
                <div class="fr">绑定邮箱：${sessionScope.online_user.USER_EMAIL}</div>
            </div>
            <div class="bott">
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin1.jpg"/></a>
                    <p class="fl"><span>待支付的订单：<strong>0</strong></span><a href="myorderq.html">查看待支付订单></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin2.jpg"/></a>
                    <p class="fl"><span>待收货的订单：<strong>0</strong></span><a href="myorderq.html">查看待收货订单></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin3.jpg"/></a>
                    <p class="fl"><span>待评价的订单：<strong>0</strong></span><a href="myprod.html">查看待评价订单></a></p></div>
                <div class="clearfix"><a href="#" class="fl"><img src="img/gxin4.jpg"/></a>
                    <p class="fl"><span>喜欢的商品：<strong>0</strong></span><a href="#">查看喜欢的商品></a></p></div>
            </div>
        </div>
    </div>
</div>
<!--返回顶部-->
<%@ include file="right_and_bottom.jsp" %>
