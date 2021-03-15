package edu.ntvu.web.entity;

/**
 * @author alin
 * @Package edu.ntvu.web.entity
 * @date 2021/3/15 20:43
 * @description 用户实体类
 */
public class User {

    private String no;
    private String name;
    private boolean gender;
    private int age;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}