package com.ntvu.web2.entity;

/**
 * 数据库 roles表 对应的java类
 */
public class Roles {
    private int id;
    private String roleName;
    private String comments;

    public Roles() {}

    public Roles(int id, String roleName, String comments) {
        this.id = id;
        this.roleName = roleName;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
