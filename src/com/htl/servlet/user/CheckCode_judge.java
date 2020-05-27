package com.htl.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkCode_judge")
public class CheckCode_judge extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取输入的验证码
        String num = request.getParameter("num");
        HttpSession session = request.getSession();
        //获取生成的验证码
        String sysCode = (String) session.getAttribute("CHECKCODE_SERVER");

        PrintWriter out = response.getWriter();
        //比较验证码是否相同
        if (sysCode.equals(num)){     /** ”equals()”比较字符串中所包含的内容是否相同。 */
            //返回true
            out.print("true");
        }else {
            //返回false
            out.print("false");
        }
        out.close();
    }
}

