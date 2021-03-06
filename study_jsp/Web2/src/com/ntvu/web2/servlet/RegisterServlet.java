package com.ntvu.web2.servlet;

import com.ntvu.web2.entity.SystemUsers;
import com.ntvu.web2.service.LoginService;
import com.ntvu.web2.util.Tools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 从页面的输入框获取值
        String loginName = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String pwd2 = req.getParameter("pwd2");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");

        SystemUsers user = new SystemUsers(loginName, pwd, telephone, email);
        String path = req.getContextPath();

        // 验证数据合法性 用户名、密码、手机号、邮箱不为空，两次密码必须一致
        if (Tools.isNullOrEmpty(loginName) || Tools.isNullOrEmpty(pwd) || Tools.isNullOrEmpty(telephone) || Tools.isNullOrEmpty(email) || !pwd.equals(pwd2)) {
            req.setAttribute("username", loginName);
            req.setAttribute("telephone", telephone);
            req.setAttribute("email", email);
            resp.sendRedirect(path + "/register.jsp");
            return;
        }

        // 注册成功跳转登录页面 失败继续注册
        boolean success = new LoginService().register(user);
        if (success) {
            resp.sendRedirect(path + "/index.html");
//            resp.sendRedirect(path + String.format("/doLogin?username=%s&password=%s", loginName, pwd));
        } else {
            req.setAttribute("txtLoginName", loginName);
            req.setAttribute("telephone", telephone);
            req.setAttribute("email", email);
            req.getRequestDispatcher(path + "/register.jsp").forward(req, resp);
        }
    }
}
