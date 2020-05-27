<%--
    左侧栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!------------------------------左边------------------------------>
<div class="zuo fl">
    <h3><a href="#"><img src="img/tx.png"/></a>
        <p class="clearfix">
            <span class="fl">[${sessionScope.online_user.USER_NAME}]</span>
            <span class="fr"><a href="user_Logout">[退出登录]</a></span>
        </p>
    </h3>
    <div><h4>我的交易</h4>
        <ul>
            <li><a href="shopping_cart.jsp">我的购物车</a></li>
            <li><a href="my_order.jsp">我的订单</a></li>
            <li><a href="my_evaluation.jsp">评价晒单</a></li>
        </ul>
        <h4>个人中心</h4>
        <ul>
            <li class="on"><a href="person_center.jsp">我的中心</a></li>
            <li><a href="address_manage.jsp">地址管理</a></li>
        </ul>
        <h4>账户管理</h4>
        <ul>
            <li><a href="person_message.jsp">个人信息</a></li>
            <li><a href="change_password.jsp">修改密码</a></li>
        </ul>
    </div>
</div>

