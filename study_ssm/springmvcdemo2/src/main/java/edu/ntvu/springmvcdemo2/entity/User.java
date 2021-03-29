package edu.ntvu.springmvcdemo2.entity;

/**
 * @author alin
 * @Package edu.ntvu.springmvcdemo2.entity
 * @date 2021/3/24 8:18
 * @description todo
 */
public class User {

    private long   id;
    private String userName;
    private String pwd;
    private String salt;
    private String realName;
    private String telephone;
    private String email;
    private boolean gender;
    private int age;

    public User() {
    }

    public User(String userName, String pwd, String realName, String telephone, String email, boolean gender, int age) {
        this.userName  = userName;
        this.pwd       = pwd;
        this.realName  = realName;
        this.telephone = telephone;
        this.email     = email;
        this.gender    = gender;
        this.age       = age;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", realName='" + realName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
