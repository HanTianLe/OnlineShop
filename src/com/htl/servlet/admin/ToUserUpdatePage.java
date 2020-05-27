package com.htl.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htl.entity.Online_User;
import com.htl.service.AdminOperateUserService;
import com.htl.service.Impl.AdminOperateUserService_Impl;

@WebServlet("/manage/admin_toUserUpdatePage")
public class ToUserUpdatePage extends HttpServlet {

	private AdminOperateUserService adminOperateUserService = new AdminOperateUserService_Impl();

	/**
	 * 去修改用户的界面，并调出要修改指定用户的信息。
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		
		//通过ID到数据里查找
		Online_User user = adminOperateUserService.findUserByID(id);
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);

	}

}

