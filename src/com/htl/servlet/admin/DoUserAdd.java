package com.htl.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htl.entity.Online_User;
import com.htl.service.AdminOperateUserService;
import com.htl.service.Impl.AdminOperateUserService_Impl;

@WebServlet("/manage/admin_doUserAdd")
public class DoUserAdd extends HttpServlet {

	private AdminOperateUserService adminOperateUserService = new AdminOperateUserService_Impl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String psd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//创建用户实体
		Online_User u = new Online_User(username, name, psd, sex, year, null, email, mobile, address, 1);
		
		//加入到数据库的用户表中
		int count = adminOperateUserService.insert(u);
		
		//成功或失败重定向到哪里
		if(count > 0) {
			// 用户添加成功
			response.sendRedirect("admin_findUser");
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.href='admin_useradd.jsp'");
			out.write("</script>");
		}
		
	}

}


