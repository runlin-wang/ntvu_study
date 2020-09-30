package edu.ntvu.jsp.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String txtUserName = req.getParameter("txtUserName");
        String txtPassword = req.getParameter("txtPassword");
        String txtCode = req.getParameter("txtCode");

        // 控制台显示
//        System.out.println(txtUserName + "|" + txtPassword + "|" + txtCode);

        if("admin".equals(txtUserName) && "123456".equals(txtPassword))
        {
            //保存用户名
            req.getSession().setAttribute("CurrentUserName", txtUserName);

            //完成调转
            resp.sendRedirect("/main");
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/main");
//            rd.forward(req,resp);

        }else{
            resp.sendRedirect("login");

//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
//            rd.forward(req,resp);
        }
    }
}
