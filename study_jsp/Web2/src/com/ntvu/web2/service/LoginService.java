package com.ntvu.web2.service;

import com.ntvu.web2.entity.SystemUsers;
import com.ntvu.web2.util.Tools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginService {

    /**
     * 实现用户登录功能
     * @param loginName
     * @param password
     * @return
     */
    public boolean login(String loginName, String password) {

//        String sql = String.format("select id, login_name from system_users where login_name='%s' and login_password='%s'", loginName, Tools.md5(password));
        String sql = String.format("select * from system_users where login_name='%s' and login_password='%s'", loginName, Tools.md5(password));
//        SystemUsers user = querySql(sql).get(0);
//        return rs != null;

        return querySql(sql) != null && !querySql(sql).isEmpty();
//        return rs != null && rs.next();
    }

    /**
     * 实现用户登录功能
     * @param user
     * @return
     */
    public boolean login(SystemUsers user) {
        String sql = String.format("select id, login_name from system_users where login_name='%s' and login_password='%s'", user.getLoginName(), Tools.md5(user.getLoginPassword()));
//        ResultSet rs = querySql(sql);
//        return rs != null;
        return querySql(sql).isEmpty();
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
    }

    /**
     * 实现用户注册功能
     * @param user
     * @return
     */
    public boolean register(SystemUsers user) {
        String sql = String.format("INSERT INTO system_users(login_name, login_password, login_salt, telephone, email, status, role_id) VALUES ('%s', '%s', '%s', '%s', '%s', %b, %d)",
                user.getLoginName(), Tools.md5(user.getLoginPassword()), user.getLoginSalt(), user.getTelephone(), user.getEmail(), user.isStatus(), user.getRoleId());

        return updateSql(sql) > 0;
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

    /**
     * 通过 roleId 删除对应用户组的数据
     * @param roleId
     * @return
     */
    public boolean deleteByRoleId(int roleId) {
        String sql = "delete form system_users where role_id = " + roleId;
        return updateSql(sql) > 0;
    }

    /**
     * 通过用户名获取对应的对象
     * @param loginName 用户名
     * @return SystemUsers 对象
     */
    public SystemUsers findByLoginName(String loginName) {
        String sql = String.format("select login_name, telephone, email, role_id from system_users where login_name = '%s'", loginName);
        List<SystemUsers> lst = querySql(sql);
        return lst.isEmpty() ? null : lst.get(0);
    }

    /**
     * 通过 用户id 获取对应的对象
     * @param id
     * @return SystemUsers
     */
    public SystemUsers findById(int id) {
        String sql = String.format("select login_name, telephone, email, role_id from system_users where login_name = %d", id);
        List<SystemUsers> lst = querySql(sql);
        return lst.isEmpty() ? null : lst.get(0);
    }

    /**
     * 返回当前所有用户列表
     * @return List<SystemUsers>
     */
    public List<SystemUsers> getList() {
//        String sql = String.format("select login_name, telephone, email, role_id from system_users");
        String sql = String.format("select * from system_users");
        return querySql(sql);
    }

    /**
     * 通过 用户 id 号 查找对应用户详细信息
     * @param id
     * @return List<SystemUsers>
     */
    public SystemUsers getDetails(int id) {
        return findById(id);
    }

    /**
     * 通过 用户id 修改用户信息
     * @param user
     * @return 成功返回 true 失败返回 false
     */
    public boolean edit(SystemUsers user) {
        if(user == null || user.getLoginName() == null || user.getTelephone() == null || user.getEmail() == null)
        {
            return false;
        }
        String sql  = "update system_users set login_name=%s,telephone=%s,email=%s,status=%b,role_id=%d where id=%d";
        sql = String.format(sql,user.getLoginName(),user.getTelephone(),user.getEmail(),user.isStatus(),user.getRoleId(),user.getId());
        return updateSql(sql) > 0;
    }

    /**
     * 通过 用户名 查询该用户状态是否可用
     * @param loginName 用户名
     * @return 可用为 true， 不可以为 false
     */
    public boolean valid(String loginName) {
        return findByLoginName(loginName).isStatus();
    }

    /**
     * 通过 用户id 查询该用户状态是否可用
     * @param id 用户 id
     * @return 可用为 true， 不可以为 false
     */
    public boolean valid(int id) {
        return findById(id).isStatus();
    }

    /**
     * 修改对应用户的密码
     * @param user 用户对象
     * @param pwd 新密码
     * @return 设置新密码
     */
    public boolean resetPassword(SystemUsers user, String pwd) {
        String sql = String.format("update system_users set login_password = '%s' where login_name = '%s'", user.getLoginName(), pwd);
        return false;
    }

    /**
     * 执行 delete Sql语句
     * 可使用新的 updateSql 来代替
     * @param sql
     * @return
     */
    @Deprecated
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
     * @param sql 语句
     * @return row(s) 受影响的行数
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

    /**
     * 执行 select 查询语句
     * 查询必须为 *
     * @param sql select 语句
     * @return ResultSet 结果集 ，sql异常返回 null
     */
//    private boolean isQuerySql(String sql) {
//        ResultSet rs = null;
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            // 1. 引入 jdbc 的 jar 包
//            // 2. 加载驱动类
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 3. 创建连接
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");
//
//            // 4. 获取返回结果，判断是否成功
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//
//            return rs != null;
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // 5. 关闭连接
//                rs.close();
//                stmt.close();
//                conn.close();
//            } catch (SQLException throwable) {
//                throwable.printStackTrace();
//            }
//        }
//        return false;
//    }

    private List<SystemUsers> querySql(String sql) {
        List<SystemUsers> lst = null;
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. 引入 jdbc 的 jar 包
            // 2. 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai", "root", "root@123");

            // 4. 获取返回结果，判断是否成功
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            lst = new ArrayList<>();
            // 遍历结果集，转换为 SystemUsers 类并依次添加到列表
            while (rs.next()) {
                /**
                 * 未处理，没找到对应值的默认值
                 */
                SystemUsers user = new SystemUsers();
                user.setId(rs.getInt("id"));
                user.setLoginName(rs.getString("login_name"));
                user.setLoginPassword(rs.getString("login_password"));
                user.setTelephone(rs.getString("telephone"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getBoolean("status"));
                user.setRoleId(rs.getInt("role_id"));
                lst.add(user);  // 向列表添加 user 对象
            }

            // 5. 关闭连接
            rs.close();
            stmt.close();
            conn.close();
            return lst;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
