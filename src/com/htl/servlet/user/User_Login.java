package com.htl.servlet.user;

import com.htl.dao.Impl.UserLoginDao_Impl;
import com.htl.dao.UserLoginDao;
import com.htl.entity.Online_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/user_Login")
public class User_Login extends HttpServlet {

    private UserLoginDao userLoginDao = new UserLoginDao_Impl();

    /**
     * 普通用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 获得用户ID和密码
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");
        // 接收用户信息
        Object object = userLoginDao.login(user_id, password);
        if (object != null){
            // 将对象object转为Online_User对象user。
            Online_User user = (Online_User) object;
            // 创建session。
            HttpSession session = request.getSession();
            // 登录信息对象存到session里面。
            session.setAttribute("online_user",user);
            // 下面是重定向，（数据用session存储）。
            response.sendRedirect("index.jsp");
            // 下面的是转发，（数据用request存储）。
            // request.setAttribute();
        }else {
            // 弹出错误
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('登录失败！');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

