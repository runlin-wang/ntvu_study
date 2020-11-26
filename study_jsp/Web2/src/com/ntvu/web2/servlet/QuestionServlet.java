package com.ntvu.web2.servlet;

import com.ntvu.web2.entity.Questionnaire;
import com.ntvu.web2.service.QuestionService;
import com.ntvu.web2.util.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package com.ntvu.web2.servlet
 * @date 2020/11/26 16:17
 */
@WebServlet("/doQuestion")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Writer writer = resp.getWriter();
        Questionnaire obj = null;
        QuestionService qs = new QuestionService();
        boolean success;

        switch (action) {
            case "insert":
                obj = new Questionnaire(0, req.getParameter("realName"), req.getParameter("telephone"),
                        Tools.getGreaterThanZero(req.getParameter("age"), 0),
                        Boolean.parseBoolean(req.getParameter("sex")), req.getParameter("hobby"), req.getParameter("other"));
                success = qs.insert(obj);
                // {"code" : "200", "msg" : "success"}
                writer.write(success ? "{\"code\" : \"200\", \"msg\" : \"success\"}" : "{\"code\" : \"500\", \"msg\" : \"fail\"}");
                break;
            case "query":
                obj = qs.query(req.getParameter("telephone"));

                if (Tools.isNullOrEmpty(obj)) {
                    writer.write("{\"code\" : \"500\", \"msg\" : \"fail\"}");
                } else {
                    writer.write("{\"code\" : \"200\", \"msg\" : \"success\", \"result\" : [" + obj.toString() + "]}");
                }
                break;
            case "deleteOne":
                break;
            case "deleteAll":
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
