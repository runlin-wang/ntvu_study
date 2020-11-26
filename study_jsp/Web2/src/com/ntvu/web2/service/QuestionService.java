package com.ntvu.web2.service;

import com.ntvu.web2.common.DBConfig;
import com.ntvu.web2.entity.Questionnaire;
import com.ntvu.web2.util.Tools;

import java.sql.*;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package com.ntvu.web2.service
 * @date 2020/11/26 14:38
 */
public class QuestionService {

    private Connection conn;
    private Statement stmt;

    /**
     * 向数据库插入数据
     * @param questionnaire 问卷对象
     * @return boolean 成功返回 true，失败返回 false
     */
    public boolean insert(Questionnaire questionnaire) {
        String sql = "insert into questionnaire values (%d, '%s', '%s', %d, %b, '%s', '%s')";
        sql = String.format(sql, questionnaire.getId(), questionnaire.getRealName(), questionnaire.getTelephone(),
                questionnaire.getAge(), questionnaire.isSex(), questionnaire.getHobby(), questionnaire.getOther());

        createConnection();

        int row = 0;
        try {
            row = stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        closeConnection();

        return row == 1;
    }

    /**
     * 通过手机号查询问卷
     * @param telephone 手机号
     * @return Questionnaire 对象
     */
    public Questionnaire query(String telephone) {
        Questionnaire questionnaire = null;
        String sql = String.format("select * from questionnaire where telephone = '%s'", telephone);
        System.out.println(sql);

        createConnection();

        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (!Tools.isNullOrEmpty(rs) && rs.next()) {
                questionnaire = new Questionnaire(
                        rs.getInt("id"),
                        rs.getString("real_name"),
                        rs.getString("telephone"),
                        rs.getInt("age"),
                        rs.getBoolean("sex"),
                        rs.getString("hobby"),
                        rs.getString("other")
                );
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        closeConnection();

        return questionnaire;
    }

    public boolean delete(String telephone) {
        return false;
    }

    /**
     * 生成连接和句柄
     */
    private void createConnection() {
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.创建于数据库的连接
            conn = DriverManager.getConnection(DBConfig.url, DBConfig.dbUserName, DBConfig.dbPwd);
            // 3.获取执行句柄
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 释放连接和句柄
     */
    private void closeConnection() {
        try {
            if (conn != null)
                conn.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Questionnaire questionnaire = new Questionnaire(0, "testName", "13000800090", 21, false, "basketball", "otherTest");
        boolean b = new QuestionService().insert(questionnaire);

    }
}
