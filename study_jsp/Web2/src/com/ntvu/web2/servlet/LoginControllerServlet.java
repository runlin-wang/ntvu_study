package com.ntvu.web2.servlet;

import com.ntvu.web2.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String path = req.getContextPath();
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        System.out.printf("username = %s, password = %s, path = %s%n", username, pwd, path);

        if (new LoginService().login(username, pwd)) {
            // 保存用户名
            HttpSession session = req.getSession();
            session.setAttribute("CurrentUserName",username);
            session.setMaxInactiveInterval(1800);//30minutes
            // 跳转
            resp.sendRedirect(path + "/admin/main.jsp");
        }else {
            req.setAttribute("txtLoginName", username);
            resp.sendRedirect(path + "/index.html");

//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
//            rd.forward(req,resp);
        }
    }

}
