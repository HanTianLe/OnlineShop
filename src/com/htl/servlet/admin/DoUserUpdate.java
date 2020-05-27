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

@WebServlet("/manage/admin_doUserUpdate")
public class DoUserUpdate extends HttpServlet {

	private AdminOperateUserService adminOperateUserService = new AdminOperateUserService_Impl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		String psd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String userStatus = request.getParameter("userStatus");
		
		int status = 1;
		
		if(userStatus != null) {
			status = Integer.parseInt(userStatus);
		}
		
		//创建用户实体
		Online_User user = new Online_User(userID, name, psd, sex, birthday, null, email, mobile, address, status);
		
		//更新用户
		int count = adminOperateUserService.update(user);
		
		//成功或失败重定向到哪里
		if(count > 0) {
			//成功
			response.sendRedirect("admin_findUser?cp="+request.getParameter("cpage"));
		}else{
			//失败
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户修改失败');");
			out.write("location.href='admin_toUserUpdatePage?id="+userID+"'");
			out.write("</script>");
		}
		
	}
}

