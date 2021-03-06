package com.htl.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htl.dao.AdminOperateUserDao;
import com.htl.dao.Impl.AdminOperateUserDao_Impl;
import com.htl.entity.Online_User;
import com.htl.service.AdminOperateUserService;
import com.htl.service.Impl.AdminOperateUserService_Impl;

@WebServlet("/manage/admin_findUser")
public class Admin_FindUser extends HttpServlet {

	private AdminOperateUserService adminOperateUserService = new AdminOperateUserService_Impl();

	private AdminOperateUserDao adminOperateUserDao = new AdminOperateUserDao_Impl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cpage = 1;	//当前页
		int count = 5;	//每页显示条数
		
		//获取用户指定的页面
		String cp = request.getParameter("cp");
		//接收用户搜索的关键字
		String keyword = request.getParameter("keywords");
		
		if(cp != null) {
			cpage = Integer.parseInt(cp);
		}
		//获取总记录数和总页数
		int arr[] = adminOperateUserDao.totalPage(count,keyword);
		
		//获取所有用户记录
		ArrayList<Online_User> list = adminOperateUserService.findAllUser(cpage,count,keyword);

		//放到请求对象域里
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		// 转发
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}

}

