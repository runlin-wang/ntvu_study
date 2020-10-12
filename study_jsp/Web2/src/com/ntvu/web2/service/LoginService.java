package com.ntvu.web2.service;

import com.ntvu.web2.util.Tools;

import java.sql.*;
import java.util.List;

public class LoginService {

    /**
     * 实现用户登录功能
     * @param loginName
     * @param password
     * @return
     */
    public boolean login(String loginName, String password) {

        boolean succeed = false;
        try {
            // 1. 引入 jdbc 的 jar 包

            // 2. 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 创建连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");

            // 4. 执行 sql 语句
            String sql = String.format("select id, login_name from system_users where login_name='%s' and login_password='%s'", loginName, Tools.md5(password));

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

    /**
     * 实现用户注册功能
     * @param loginName
     * @param loginPassword
     * @param loginSalt
     * @param telephone
     * @param email
     * @param status
     * @param role_id
     * @return
     */
    public boolean register(String loginName, String loginPassword, String loginSalt, String telephone, String email, boolean status, int role_id) {

        String sql = String.format("INSERT INTO system_users(login_name, login_password, login_salt, telephone, email, status, role_id) VALUES ('%s', '%s', '%s', '%s', '%s', %b, %d)",
                loginName, Tools.md5(loginPassword), loginSalt, telephone, email, status, role_id);

        return updateSql(sql) > 0;
        
//        boolean succeed = false;
//        try {
//            // 1. 引入 jdbc 的 jar 包
//
//            // 2. 加载驱动类
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 3. 创建连接
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");
//
//            // 4. 执行 sql 语句
//            String sql = String.format("INSERT INTO system_users(login_name, login_password, login_salt, telephone, email, status, role_id) VALUES ('%s', '%s', '%s', '%s', '%s', %b, %d)",
//                    loginName, Tools.md5(loginPassword), loginSalt, telephone, email, status, role_id);
//
//            // 5. 获取返回结果，判断是否成功
//            Statement stmt = conn.createStatement();
//            int effectedRows = stmt.executeUpdate(sql);
//            succeed = effectedRows > 0;
//
//            // 6. 关闭连接
//            stmt.close();
//            conn.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            succeed = false;
//        }
//
//        return succeed;
    }

    /**
     * 通过 id 号删除对应用户
     * @param id
     * @return
     */
    public boolean delete(int id) {
        String sql = String.format("delete from system_users where id = %d", id);
        return updateSql(sql) > 0;
    }

    /**
     * 通过一组 id 号删除对应用户
     * @param id
     * @return
     */
    public boolean delete(int...id) {
        String ids = "";
        for (int tmp : id) {
            ids += tmp + ",";
        }
        if (ids.length() > 0)
            ids.substring(0, ids.length() - 1);     // 去除末尾的逗号
        String sql = String.format("delete from system_users where id in (%s)", ids);
        return updateSql(sql) > 0;
    }

    /**
     * 通过用户名删除对应用户
     * @param loginName
     * @return
     */
    public boolean delete(String loginName) {
        String sql = String.format("delete from system_users where login_name = '%s';", loginName);
        return updateSql(sql) > 0;
    }

    /**
     * 通过一组用户名删除对应用户
     * @param loginName
     * @return
     */
    public boolean delete(String...loginName) {
        String loginNames = "";
        for (String name : loginName) {
            loginNames += "'" + name + "',";
        }
        if (loginNames.length() > 0)
            loginNames.substring(0, loginNames.length() - 1);     // 去除末尾的逗号
        String sql = String.format("delete from system_users where login_name in (%s)", loginNames);
        return updateSql(sql) > 0;
    }

    public boolean deleteByRoleId(int roleId) {
        return false;
    }

    public boolean findByLoginName(String loginName) {
        return false;
    }

    public List getList() {
        return null;
    }

    public void getDetails(int id) {

    }

    public boolean edit(String newUser) {
        return false;
    }

    public boolean valid(String loginName) {
        return false;
    }

    public boolean resetPassword(String loginName) {
        return false;
    }

    /**
     * 执行 delete Sql语句
     * @param sql
     * @return
     */
    private boolean deleteSql(String sql) {
        boolean succeed = false;
        try {
            // 1. 引入 jdbc 的 jar 包

            // 2. 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 创建连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");

            // 4. 获取返回结果，判断是否成功
            Statement stmt = conn.createStatement();
            int effectedRows = stmt.executeUpdate(sql);
            succeed = effectedRows > 0;

            // 5. 关闭连接
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            succeed = false;
        }

        return succeed;
    }

    /**
     * 执行 INSERT UPDATE DELETE 及 CREATE DROP Sql语句, 返回受影响的行数
     * @param sql
     * @return row(s)
     */
    private int updateSql(String sql) {
        int rows = 0;
        try {
            // 1. 引入 jdbc 的 jar 包

            // 2. 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 创建连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");

            // 4. 执行 Sql 语句，获取影响的行数
            Statement stmt = conn.createStatement();
            rows = stmt.executeUpdate(sql);

            // 5. 关闭连接
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
