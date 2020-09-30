package ntvu.lf.JavaWeb;

import ntvu.lf.JavaWeb.util.Tools;

import java.util.Calendar;
import java.util.Date;

public class Student {

    private String no;
    private String name;
    private String idCard;
    private String telephone;
    private String address;

    public Student() {
    }

    public Student(String no, String name, String idCard, String telephone, String address) throws Exception {
        this.no = no;
        this.name = name;
        this.idCard = idCard;
        this.telephone = telephone;
        this.address = address;
        Tools.validateIDCard(idCard);
    }

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) throws Exception {
        Tools.validateIDCard(idCard);
        this.idCard = idCard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 通过解析 idCard 获取学生生日
     * @return 学生生日 （）
     */
    public Date getBirthday() throws Exception {
        if (Tools.isNull(idCard))
            return null;

        int year = Integer.parseInt(idCard.substring(6, 10));
        int month = Integer.parseInt(idCard.substring(10, 12));
        int day = Integer.parseInt(idCard.substring(12, 14));

        // 对生日月份有效性的判断
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new Exception("身份证号生日格式不正确");
        }

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);


        return cal.getTime();
    }

    /**
     * 通过处理 idCard 的值，返回学生年龄
     * @return 学生年龄 （如果数据无效返回 0）
     */
    public int getAge() {

        if (Tools.isNull(idCard))
            return 0;

        int age = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int studentYear = Integer.parseInt(idCard.substring(6, 10));
        age = currentYear - studentYear;
        return age;
    }

    /**
     * 通过解析 idCard 获取性别
     * @return 女 返回 true 男 返回 false
     */
    public boolean getSex() {
        return false;
    }
}
