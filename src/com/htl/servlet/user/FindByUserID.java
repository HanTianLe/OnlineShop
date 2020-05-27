package com.htl.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.htl.service.FindByUserIDService;
import com.htl.service.Impl.FindByUserIDService_Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findByUserID")
public class FindByUserID extends HttpServlet {

    private FindByUserIDService findByUserIDService = new FindByUserIDService_Impl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("user_Id");
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String, Object>();
        if (findByUserIDService.find(userID)){
            //用户名存在
            map.put("userExist",true);
            map.put("msg","此用户ID已存在！");
        }else {
            //用户名不存在
            map.put("userExist",false);
            map.put("msg", "用户ID可用~");
        }
        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        //传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

