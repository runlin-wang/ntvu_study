package com.ntvu.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest req,
                         javax.servlet.http.HttpServletResponse resp)
            throws javax.servlet.ServletException, IOException {
        //输出
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta  http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>学生身份证解析</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form id=\"form1\" name=\"form1\" action=\"/student\" method=\"get\">");
        out.println("身份证号：<input type=\"text\" id=\"idCard\" name=\"idCard\" value=\"320602200011234567\"><br>");


        out.println("<input type=\"submit\" value=\"提交\">");

        out.println("<a href='/login'>登录</a>");
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
