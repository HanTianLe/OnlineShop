package com.htl.servlet.admin;

import com.htl.dao.AdminLoginDao;
import com.htl.dao.Impl.AdminLoginDao_Impl;
import com.htl.entity.Online_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_Login")
public class Admin_Login extends HttpServlet {

    private AdminLoginDao adminLoginDao = new AdminLoginDao_Impl();

    /**
     * 管理员登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userID = request.getParameter("userID");
        String password = request.getParameter("pwd");
        Object object = adminLoginDao.login(userID, password);

        if (object != null){
            //取出用户身份数据（2代表管理员）
            int status =((Online_User) object).getUSER_STATUS();
            if (status == 2){
                HttpSession session = request.getSession();
                Online_User online_user = (Online_User) object;
                //登录信息存到session里面
                session.setAttribute("online_user",online_user);
                // 跳转到管理管理主页面
                response.sendRedirect("/OnlineShop/manage/admin_index.jsp");
            }else {
                // 弹出错误
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('该用户不是管理员！');");
                out.write("location.href='admin_login.jsp'");
                out.write("</script>");
            }
        }else {
            // 弹出错误
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('登录失败！');");
            out.write("location.href='admin_login.jsp'");
            out.write("</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}

