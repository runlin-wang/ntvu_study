package com.ntvu.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 完成用户注销
 */
public class LogoutControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("CurrentUserName");
        String path = req.getContextPath();
        resp.sendRedirect(path + "/index.html");
    }

}
