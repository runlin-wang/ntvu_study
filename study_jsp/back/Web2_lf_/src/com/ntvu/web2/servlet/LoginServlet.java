package com.ntvu.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        //输出
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta  http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>登录界面</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form id=\"form1\" name=\"form1\" action=\"/doLogin\" method=\"get\">");
        out.println("用户名：<input type=\"text\" id=\"txtUserName\" name=\"txtUserName\" value=\"\"><br>");
        out.println("密码：<input type=\"password\" id=\"txtPassword\" name=\"txtPassword\" value=\"\"><br>");
        out.println("检验码：<img src='images/code.png' style='width:200px,height:32px' /><input type=\"text\" id=\"txtCode\" name=\"txtCode\" value=\"123456\"><br>");
        out.println("<input type=\"submit\" value=\"登录\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        doGet(req,resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }
}
