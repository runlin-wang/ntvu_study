package com.ntvu.web2.selvlet;

import com.ntvu.web2.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 以一个 HTML 页面输出学生信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String idCard = request.getParameter("idCard");
        Student stu = new Student();

        try {
            stu.setIdCard(idCard);
            response.setContentType("text/html;charset=UTF-8");

            String sex = stu.getSex() ? "男" : "女";
            PrintWriter out = response.getWriter();
            out.print("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "\t<title>学生信息</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div style=\"height: 150px;\"></div>\n" +
                    "\t<!-- 使上方多 150 像素空间 -->\n" +
                    "\n" +
                    "\t<div style=\"width: 100%;text-align: center;\">\n" +
                    "\t\t<!-- 使表格水平居中 -->\n" +
                    "\t\t<table style=\"margin: 0 auto;\">\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<th colspan=\"2\"><h1>学生信息</h1></th>\n" +
                    "            </tr>\n" +
                    "            <tr>\n" +
                    "                <td>身份证号：</td>\n" +
                    "                <td>" + stu.getIdCard() + "</td>\n" +
                    "            </tr>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>年龄：</label></td>\n" +
                    "\t\t\t\t<td> " + stu.getAge() + " </td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>性别：</td>\n" +
                    "\t\t\t\t<td> " + sex + " </td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t\t<td>生日：</td>\n" +
                    "\t\t\t\t<td> " + sdf.format(stu.getBirthday()) + " </td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t</table>\n" +
                    "\t</div>\n" +
                    "</body>\n" +
                    "</html>");

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出学生信息
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doGet1(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String idCard = request.getParameter("idCard");

        Student stu = new Student();
        try {
            stu.setIdCard(idCard);
            ServletOutputStream sos = response.getOutputStream();
//            sos.print("学生生日：" + stu.getBirthday());
//            sos.print("学生年龄：" + stu.getAge());
            sos.println("studentAge: " + stu.getAge());
            sos.println("studentBirthday" + stu.getBirthday());
            sos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}