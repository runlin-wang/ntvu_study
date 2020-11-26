package com.ntvu.web2.entity;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package com.ntvu.web2.entity
 * @date 2020/11/26 15:03
 */
public class Questionnaire {

    private int id;
    private String realName;
    private String telephone;
    private int age;
    private boolean sex;
    private String hobby;
    private String other;

    public Questionnaire() {
    }

    public Questionnaire(int id, String realName, String telephone, int age, boolean sex, String hobby, String other) {
        this.id = id;
        this.realName = realName;
        this.telephone = telephone;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return String.format("{\"id\" : %d, \"realName\" : %s, \"telephone\" : %s, \"age\" : %d, \"sex\" : %b, \"hobby\" : %s, \"other\" : %s}",
                id, realName, telephone, age, sex, hobby, other);
    }
}
