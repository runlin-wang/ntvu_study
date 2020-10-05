package com.ntvu.web2.selvlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>登录</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div style=\"height: 100px;\"></div>\n" +
                "\t<!-- 使上方多 100 像素空间 -->\n" +
                "\n" +
                "\t<form action=\"/doLogin\" method=\"get\">\t\n" +
                "\t\t<!-- 使表格水平居中 -->\n" +
                "\t\t<table style=\"margin: 0 auto;\">\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<th colspan=\"2\"><h1>欢迎登录</h1></th>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td><label>用户名：</label></td>\n" +
                "\t\t\t\t<td><input type=\"text\" id=\"username\" value=\"admin\"></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td><label for=\"password\">密码：</label></td>\n" +
                "\t\t\t\t<td><input type=\"password\" id=\"password\" value=\"123456\"></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td><label for=\"code\">验证码：</label></td>\n" +
                "\t\t\t\t<td><input type=\"text\" id=\"code\" value=\"1234\"></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"登录\"></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table>\n" +
                "\t</form>\n" +
                "\t\n" +
                "</body>\n" +
                "</html>");

        out.close();
    }
}
