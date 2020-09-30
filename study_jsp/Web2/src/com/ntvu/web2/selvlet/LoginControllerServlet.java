package com.ntvu.web2.selvlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginControllerServlet", urlPatterns = "/doLogin")
public class LoginControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String code = request.getParameter("code");

        System.out.println(username);
        System.out.println(password);
        // 用户名与密码正确则跳转到 main 否则 跳转到 login
        if ("admin".equals(username) && "123456".equals(password))
            response.sendRedirect("/main");
        else
            response.sendRedirect("/login");

//        RequestDispatcher rd;
//        if ("admin".equals(username) && "123456".equals(password)) {
//            rd = getServletContext().getRequestDispatcher("/main");
//        } else {
//            rd = getServletContext().getRequestDispatcher("/login");
//        }
//        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}




