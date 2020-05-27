package com.htl.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htl.service.AdminOperateUserService;
import com.htl.service.Impl.AdminOperateUserService_Impl;

@WebServlet("/manage/admin_doUserDelete")
public class DoUserDelete extends HttpServlet {

	private AdminOperateUserService adminOperateUserService = new AdminOperateUserService_Impl();

	/**
	 * 删除一个用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取用户ID
		String id = request.getParameter("id");
		//根据 ID 删除用户
		int count = adminOperateUserService.delete(id);

		//成功或失败重定向到哪里
		if(count > 0) {
			// 删除成功
			response.sendRedirect("admin_findUser?cp="+request.getParameter("cpage"));
		}else{
			// 删除失败
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败')");
			out.write("location.href='manage/admin_findUser?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}

	/**
	 * 批量删除用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取多个用户ID集合
		String ids[] = request.getParameterValues("id[]");
		//遍历ID集合删除用户
		for(int i=0; i<ids.length; i++) {
			/** 批量删除 */
 			adminOperateUserService.delete(ids[i]);
		}
		//重定向
		response.sendRedirect("/OnlineShop/manage/admin_findUser");

	}

}


