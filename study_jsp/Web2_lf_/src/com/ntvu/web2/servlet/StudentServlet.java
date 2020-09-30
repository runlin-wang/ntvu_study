package com.ntvu.web2.servlet;

import com.ntvu.web2.Student;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class StudentServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    /**
     * 处理get模式  <form id="form1" name="form1" action="/student" method="get">
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doGet2(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //接收页面值
        String  idCard = request.getParameter("idCard");
        Student stu = new Student();
        try {
            //处理
            stu.setIdCard(idCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出
        ServletOutputStream sos = response.getOutputStream();
        sos.print(stu.getAge());
        sos.close();
    }


    /**
     * 处理get模式  返回一个完事的网页
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        //接收页面值
        request.setCharacterEncoding("utf-8");
        String  idCard = request.getParameter("idCard");
        Student stu = new Student();
        try {
            //处理
            stu.setIdCard(idCard);
            //日期格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //输出

            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta  http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"");
            out.println("<title>学生信息</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form name=\"form1\" action=\"/page1.html\">");
            out.println("身份证号：<input type=\"text\" name=\"txtIdCard\" value=\" " + stu.getIdCard() + "\"><br>");
            out.println("性别：<input type=\"text\" name=\"txtSex\" value=\" " + stu.getSex() + "\"  disabled=\"disabled\"><br>");
            out.println("年龄：<input type=\"text\" name=\"txtAge\" value=\" " + stu.getAge() + "\"  disabled=\"disabled\"><br>");
            out.println("生日：<input type=\"text\" name=\"txtBirthday\" value=\" " + sdf.format(stu.getBirthday()) + "\"  disabled=\"disabled\"><br>");
            out.println("");
            out.println("<input type=\"submit\" value=\"return\">");
            out.println("");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
