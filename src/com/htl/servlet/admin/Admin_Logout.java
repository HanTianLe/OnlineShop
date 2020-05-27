package com.htl.servlet.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/manage/admin_Logout")
public class Admin_Logout extends HttpServlet {
    /**
     * 管理员账户退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建session
        HttpSession session = request.getSession();
        //销毁session
        session.invalidate();
        //重定向到管理员登录页面
        response.sendRedirect("admin_login.jsp");
    }
}

