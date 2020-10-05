package com.ntvu.web2.service;

import java.sql.*;

public class LoginService {

    public boolean login(String loginName, String password) {

        boolean succeed = false;
        try {
            // 1. 引入 jdbc 的 jar 包

            // 2. 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 创建连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");

            // 4. 执行 sql 语句
            String sql = String.format("select id, login_name from system_users where login_name='%s' and login_password='%s'", loginName, password);

            // 5. 获取返回结果，判断是否成功
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs != null && rs.next()) {
                succeed = true;
            }

            // 6. 关闭连接
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return succeed;
    }
}
