package com.ntvu.web2.entity;

import com.ntvu.web2.service.LoginService;
import com.ntvu.web2.util.Tools;

/**
 * 数据库 system_users表 对应的java类
 */
public class SystemUsers {
    private int id = 0;
    private String loginName;
    private String loginPassword;
    private String loginSalt = "";
    private String telephone;
    private String email;
    private boolean status = true;
    private int roleId = 2;

    /**
     * 用户对应的角色
     */
    private Roles role;

    public SystemUsers() {}

    public SystemUsers(int id, String loginName, String loginPassword, String loginSalt, String telephone, String email, boolean status, int roleId, Roles role) {
        this.id = id;
        this.loginName = Tools.getNullOrEmpty(loginName, "default");
        this.loginPassword = Tools.getNullOrEmpty(loginPassword, "123456");
        this.loginSalt = Tools.getNullOrEmpty(loginSalt, "salt");
        this.telephone = Tools.getNullOrEmpty(telephone, "1234567890");
        this.email = Tools.getNullOrEmpty(email, "123456@123.top");
        this.status = status;
        this.roleId = roleId;
        this.role = (Roles) Tools.getNullOrEmpty(role, new Roles(2, "普通用户", ""));
    }

    public SystemUsers(String loginName, String pwd, String telephone, String email) {
        this(0, loginName, pwd, null, telephone, email, true, 2, null);
    }

    public SystemUsers(int id, String loginName, String telephone, String email, boolean status, int roleId) {
        this.id = id;
        this.loginName = loginName;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginSalt() {
        return loginSalt;
    }

    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

//    @Override
//    public String toString() {
//        return "SystemUsers{" +
//                "id=" + id +
//                ", loginName='" + loginName + '\'' +
//                ", loginPassword='" + loginPassword + '\'' +
//                ", loginSalt='" + loginSalt + '\'' +
//                ", telephone='" + telephone + '\'' +
//                ", email='" + email + '\'' +
//                ", status=" + status +
//                ", roleId=" + roleId +
//                ", role=" + role +
//                '}';
//    }


    @Override
    public String toString() {
        return String.format("{\"id\" : %d, \"loginName\" : \"%s\", \"telephone\" : \"%s\", \"email\" : \"%s\", \"status\" : %b, \"roleId\" : %d}",
                id, loginName, telephone, email, status, roleId);
    }
}
