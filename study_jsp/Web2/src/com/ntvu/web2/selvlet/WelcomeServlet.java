package com.ntvu.web2.selvlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>身份证号解析</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div style=\"height: 150px;\"></div>\n" +
                "\t<!-- 使上方多 150 像素空间 -->\n" +
                "\n" +
                "\t<div style=\"width: 100%;text-align: center;\">\n" +
                "\t\t<h1>身份证号解析</h1>\n" +
                "\t\t<p>通过身份证号解析出 年龄，性别，生日</p>\n" +
                "\t\t<form action=\"/student\" method=\"get\">\t\n" +
                "\t\t\t<!-- 使表格水平居中 -->\n" +
                "\t\t\t<label for=\"idCard\">身份证号：</label>\n" +
                "\t\t\t<input type=\"text\" id=\"idCard\" value=\"511923200104089179\"><br>\n" +
                "\t\t\t<input type=\"submit\" value=\"提交\">\n" +
                "\t\t</form>\n" +
                "\t\t<p><a href=\"/login\">登录页面</a></p>\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>");

        out.close();
    }
}
