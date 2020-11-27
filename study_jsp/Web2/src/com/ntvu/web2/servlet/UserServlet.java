package com.ntvu.web2.servlet;

import com.ntvu.web2.entity.SystemUsers;
import com.ntvu.web2.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="userServlet", value="/doEditUser")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 从页面的输入框获取值
        int id = Integer.parseInt(req.getParameter("id"));
        String loginName = req.getParameter("username");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        boolean status = req.getParameter("status") != null;

        SystemUsers user = new SystemUsers(id, loginName, telephone, email, status, 2);

        String path = req.getContextPath();

        // 判断修改数据是否成功
        if (new LoginService().edit(user)) {
            resp.sendRedirect(path + "/admin/main.jsp");
        } else {
            resp.sendRedirect(path + "/admin/edit.jsp?id=" + id);
        }
    }
}
