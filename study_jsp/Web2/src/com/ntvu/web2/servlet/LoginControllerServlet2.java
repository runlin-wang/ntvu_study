package com.ntvu.web2.servlet;

import com.ntvu.web2.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/doLogin2")
public class LoginControllerServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("utf-8");

        String path = req.getContextPath();
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        System.out.printf("username = %s, password = %s, path = %s%n", username, pwd, path);

        PrintWriter writer = resp.getWriter();
        if (new LoginService().login(username, pwd)) {
            writer.print("{\"code\" : \"200\", \"msg\" : \"success\"}");
        }else {
            writer.print("{\"code\" : \"500\", \"msg\" : \"fail\"}");
        }
        writer.flush();
        writer.close();
    }

}
