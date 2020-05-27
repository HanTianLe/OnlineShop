package com.htl.servlet.user;

import com.htl.entity.Online_User;
import com.htl.service.Impl.UserRegisterService_Impl;
import com.htl.service.UserRegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user_Register")
public class User_Register extends HttpServlet {

    private UserRegisterService userRegisterService = new UserRegisterService_Impl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取用户信息
        String userID = request.getParameter("userID");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        Online_User u = new Online_User(userID,name,password,sex,birthday,null,email,telephone,address,1);
        //注册
        int count = userRegisterService.register(u);
        if (count > 0){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('注册成功！');");
            writer.write("location.href='login.jsp'");
            writer.write("</script>");
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('注册失败！');");
            writer.write("location.href='register.jsp'");
            writer.write("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

