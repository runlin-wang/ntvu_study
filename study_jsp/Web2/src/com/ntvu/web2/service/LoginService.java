package com.ntvu.web2.service;

import com.ntvu.web2.common.Pager;
import com.ntvu.web2.entity.Roles;
import com.ntvu.web2.entity.SystemUsers;
import com.ntvu.web2.util.Tools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alin
 * 实现数据库后台逻辑代码
 */
public class LoginService {

    private final String url;
    private final String dbUserName;
    private final String dbPwd;

    private List<SystemUsers> users;
    private Connection conn;
    private Statement stmt;

    /**
     * 默认数据库连接信息
     */
    public LoginService() {
        this.url = "jdbc:mysql://localhost:3306/study_jsp?serverTimezone=Asia/Shanghai";
        this.dbUserName = "root";
        this.dbPwd = "root@123";
    }

    public LoginService(String url, String dbUserName, String dbPwd) {
        this.url = url;
        this.dbUserName = dbUserName;
        this.dbPwd = dbPwd;
    }

    /**
     * 实现用户登录功能
     * @param loginName 用户名
     * @param password 用户密码
     * @return Boolean 成功返回 true，失败返回 false
     */
    public boolean login(String loginName, String password) {
        String sql = String.format("select * from system_users where login_name='%s' and login_password='%s'", loginName, Tools.md5(password));
        users = getSystemUsers(sql);
        return users != null && !users.isEmpty();
    }

    /**
     * 实现用户登录功能
     * @param user 用户类 SystemUsers
     * @return Boolean 成功返回 true，失败返回 false
     */
    public boolean login(SystemUsers user) {
        String sql = String.format("select id, login_name from system_users where login_name='%s' and login_password='%s'", user.getLoginName(), Tools.md5(user.getLoginPassword()));
        users = getSystemUsers(sql);
        return users != null && !users.isEmpty();
    }

    public SystemUsers login2(String loginName, String password) {
        String sql = String.format("select * from system_users where login_name='%s' and login_password='%s'", loginName, Tools.md5(password));
        return getSystemUsers(sql).get(0);
    }

    /**
     * 实现用户注册功能
     * @param loginName 用户名
     * @param loginPassword 用户密码
     * @param loginSalt 盐
     * @param telephone 手机号码
     * @param email 邮箱
     * @param status 状态
     * @param role_id 用户身份
     * @return row(s) 受影响的行数
     */
    public boolean register(String loginName, String loginPassword, String loginSalt, String telephone, String email, boolean status, int role_id) {
        String sql = String.format("INSERT INTO system_users(login_name, login_password, login_salt, telephone, email, status, role_id) VALUES ('%s', '%s', '%s', '%s', '%s', %b, %d)",
                loginName, Tools.md5(loginPassword), loginSalt, telephone, email, status, role_id);
        return updateSql(sql) > 0;
    }

    /**
     * 实现用户注册功能
     * @param user 用户类 SystemUsers
     * @return row(s) 受影响的行数
     */
    public boolean register(SystemUsers user) {
        String sql = String.format("INSERT INTO system_users(login_name, login_password, login_salt, telephone, email, status, role_id) VALUES ('%s', '%s', '%s', '%s', '%s', %b, %d)",
                user.getLoginName(), Tools.md5(user.getLoginPassword()), user.getLoginSalt(), user.getTelephone(), user.getEmail(), user.isStatus(), user.getRoleId());

        return updateSql(sql) > 0;
    }

    /**
     * 通过 id 号删除对应用户
     * @param id id
     * @return row(s) 受影响的行数
     */
    public boolean delete(int id) {
        String sql = String.format("delete from system_users where id = %d", id);
        return updateSql(sql) > 0;
    }

    /**
     * 通过一组 id 号删除对应用户
     * @param id 多个id
     * @return row(s) 受影响的行数
     */
    public boolean delete(int...id) {
        StringBuilder ids = new StringBuilder();
        for (int tmp : id) ids.append(tmp).append(",");
        if (ids.length() > 0) {
            ids = new StringBuilder(ids.substring(0, ids.length() - 1));// 去除末尾的逗号
        }
        String sql = String.format("delete from system_users where id in (%s)", ids.toString());
        return updateSql(sql) > 0;
    }

    /**
     * 通过用户名删除对应用户
     * @param loginName 用户名
     * @return row(s) 受影响的行数
     */
    public boolean delete(String loginName) {
        String sql = String.format("delete from system_users where login_name = '%s';", loginName);
        return updateSql(sql) > 0;
    }

    /**
     * 通过一组用户名删除对应用户
     * @param loginName 多个用户名
     * @return row(s) 受影响的行数
     */
    public boolean delete(String...loginName) {
        // 此处 IDEA 智能转换为 StringBuilder 类 使用 append() 代替了 +=
        StringBuilder loginNames = new StringBuilder();
        for (String name : loginName) loginNames.append("'").append(name).append("‘,");
        if (loginNames.length() > 0)
            loginNames = new StringBuilder(loginNames.substring(0, loginNames.length() - 1));     // 去除末尾的逗号
        String sql = String.format("delete from system_users where login_name in (%s)", loginNames.toString());
        return updateSql(sql) > 0;
    }

    /**
     * 通过 roleId 删除对应用户组的数据
     * @param roleId 用户身份
     * @return Boolean 成功返回 true 失败返回 false
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
//        String sql = String.format("select login_name, telephone, email, role_id from system_users where login_name = '%s'", loginName);
        String sql = String.format("select * from system_users where login_name = '%s'", loginName);
        users = getSystemUsers(sql);
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 通过 用户id 获取对应的对象
     * @param id id
     * @return SystemUsers
     */
    public SystemUsers findById(int id) {
//        String sql = String.format("select login_name, telephone, email, role_id from system_users where login_name = %d", id);
        String sql = String.format("select * from system_users where id = %d", id);
        users = getSystemUsers(sql);
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 返回当前所有用户列表
     * @return List<SystemUsers>
     */
    public List<SystemUsers> getUsers() {
        String sql = "select * from system_users";
        return getSystemUsers(sql);
    }

    /**
     * 分页显示查询结果
     * @param pageIndex 页码
     * @param pageSize 显示条数
     * @param key 模糊查找值
     * @return SystemUsers 列表
     */
    public Pager<SystemUsers> getPagers(int pageIndex, int pageSize, String key) {
        Pager<SystemUsers> pager;
        // 判断 pageIndex 和 pageSize 是否为空
        pageIndex = Tools.getGreaterThanZero(pageIndex, 1);
        pageSize = Tools.getGreaterThanZero(pageSize, 10);

        key = "%" + key + "%";
        String sql = "select * from system_users where id like '%s' or login_name like '%s' or telephone like '%s' or email like '%s' or role_id like '%s' limit %d, %d";
        sql = String.format(sql, key, key, key, key, key, (pageIndex - 1) * pageSize, pageSize);

        int totalRecord = getCount(key);
        pager = new Pager<>(pageIndex, pageSize, totalRecord / pageSize + 1, totalRecord, getSystemUsers(sql));
        return pager;
    }

    /**
     *通过 key 查找对应记录条数
     * @param key 关键字
     * @return int
     */
    public int getCount(String key) {
        String sql = "select count(*) from system_users where id like '%s' or login_name like '%s' or telephone like '%s' or email like '%s' or role_id like '%s'";
        sql = String.format(sql, key, key, key, key, key);
        int count = 0;
        try {
            ResultSet rs = executeQuery(sql);
            if (rs.next())
                count = rs.getInt(1);
            rs.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        closeConnection();
        return count;
    }

    /**
     * 返回当前所有角色名称
     * @return 所有角色名称
     */
    public List<String> getRoleNameList() {
        List<String> roleNames = null;
        try {
            String sql = "select role_name from roles";
            ResultSet rs = executeQuery(sql);
            roleNames = new ArrayList<>();
            while (rs.next())
                roleNames.add(rs.getString("role_name"));
            rs.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        closeConnection();
        return roleNames;
    }

    /**
     * 通过 用户 id 号 查找对应用户详细信息
     * @param id id
     * @return List<SystemUsers>
     */
    public SystemUsers getDetails(int id) {
        return findById(id);
    }

    /**
     * 通过 用户id 修改用户信息
     * @param user 用户 (SystemUsers) 对象
     * @return 成功返回 true 失败返回 false
     */
    public boolean edit(SystemUsers user) {
        if(user == null || user.getLoginName() == null || user.getTelephone() == null || user.getEmail() == null)
            return false;

        String sql  = "update system_users set login_name='%s',telephone='%s',email='%s',status=%b,role_id=%d where id=%d";
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
        return updateSql(sql) > 0;
    }

    public int getRoleIdByRoleName(String roleName) {
        String sql = String.format("select id from roles where role_name = '%s'", roleName);
        System.out.println(sql);
        int id = 0;
        try {
            ResultSet rs = executeQuery(sql);
            if (rs.next())
                id = rs.getInt("id");
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return id;
    }

    /**
     * 生成连接和句柄
     */
    private void createConnection() {
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.创建于数据库的连接
            conn = DriverManager.getConnection(url, dbUserName, dbPwd);
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

    /**
     * 执行 INSERT UPDATE DELETE 及 CREATE DROP Sql语句, 返回受影响的行数
     * @param sql 语句
     * @return row(s) 受影响的行数
     */
    private int updateSql(String sql) {
        System.out.println(sql);
        int rows = 0;
        try {
            createConnection();
            rows = stmt.executeUpdate(sql);

            // 5. 关闭连接
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    /**
     * 执行查询语句并返回一个结果集
     * 需要手动释放资源 执行 closeConnection() 方法
     * @param sql 语句
     * @return ResultSet
     * @throws SQLException SQL异常
     */
    private ResultSet executeQuery(String sql) throws SQLException {
        createConnection();
        return stmt.executeQuery(sql);
    }

    /**
     * 打印 sql 语句
     * 获取 SystemUsers 列表
     * @param sql 数据库查询语句
     * @return List<SystemUsers>
     */
    private List<SystemUsers> getSystemUsers(String sql) {
        System.out.println(sql);
        try {
            ResultSet rs = executeQuery(sql);
            // 遍历结果集，转换为 SystemUsers 类并依次添加到列表
            users = new ArrayList<>();
            // 每次添加一个 SystemUsers 对象
            while (rs.next())
                users.add(new SystemUsers(rs.getInt("id"), rs.getString("login_name"), rs.getString("login_password"), null, rs.getString("telephone"), rs.getString("email"),
                        rs.getBoolean("status"), rs.getInt("role_id"), getRole(rs.getInt("role_id"))));
            rs.close();
            closeConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return users;
    }

    private Roles getRole(int roleId) {
        Roles role = null;
        try {
            String sql = String.format("select * from roles where id = %d", roleId);
            ResultSet rs = executeQuery(sql);

            if (rs.next()) {
                role = new Roles();
                role.setId(roleId);
                role.setRoleName(rs.getString("role_name"));
                role.setComments(rs.getString("comments"));
            }
            rs.close();
            // 5. 关闭连接
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public static void main(String[] args) {
        // 测试数据
        LoginService ls = new LoginService("", "", "");
        List<SystemUsers> users = ls.getUsers();
        List<Boolean> success = new ArrayList<>();
        success.add(ls.login(users.get(0)));
        success.add(ls.register("", "", "", "", "", false, 0));
        success.add(ls.delete(0));
        success.add(ls.delete(0, 1));
        success.add(ls.delete(""));
        success.add(ls.delete("", ""));
        success.add(ls.deleteByRoleId(0));
        success.add(ls.valid(0));
        success.add(ls.valid(""));
        SystemUsers su = ls.getDetails(1);
        success.add(ls.resetPassword(su, "123"));

        for (SystemUsers user : users)
            System.out.println(user);
    }
}
