package com.ntvu.web2.servlet;

import com.ntvu.web2.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String path = req.getContextPath();
        String username = req.getParameter("username");
        String pass = req.getParameter("pass");

        System.out.println(String.format("username = %s, password = %s, path = %s", username, pass, path));
        System.out.println();
//        if("admin".equals(username) && "123456".equals(pass))
        if (new LoginService().login(username, pass))
        {
            //保存用户名
            HttpSession session = req.getSession();
            session.setAttribute("CurrentUserName",username);
            session.setMaxInactiveInterval(1800);//30minutes
            //完成调转
            resp.sendRedirect(path + "/admin/main.jsp");
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/main");
            //rd.forward(req,resp);

        }else{
            resp.sendRedirect(path + "/index.html");
            return;

//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
//            rd.forward(req,resp);
        }
    }

}