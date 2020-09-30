package com.ntvu.web2;

import com.ntvu.web2.util.Tools;

import java.util.Calendar;
import java.util.Date;

public class Student {

    private String no;
    private String name;
    /**
     * 身份证号
     */
    private String idCard;
    private String telephone;
    private String address;
    private boolean sex;

    public Student() {
    }

    public Student(String no,String name,String idCard,String telephone,String address) throws Exception {
        this.no = no;
        this.name = name;
        this.idCard = idCard;
        this.telephone = telephone;
        this.address = address;
        //判断 身份证号是否合法
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

    public void setIdCard(String idCard)throws Exception {
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
     * 通过身份证号解析得到当前学生的年龄
     * @return
     */
    public int getAge()
    {
        if(this.idCard == null || this.idCard.trim().equals(""))
        {
            return 0;
        }

        //取得当前年份-学生的年份
        int age = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int studentYear = Integer.parseInt(idCard.substring(6,10));//32060220000108123x
        age = currentYear - studentYear;
        return age;
    }

    /**
     * 取得当前学生的出生日期，如果非法，抛出异常
     * @return
     * @throws Exception
     */
    public Date getBirthday() throws  Exception
    {
        if(this.idCard == null || this.idCard.trim().equals(""))
        {
            return null;
        }

        int year = 0 ,month = 0 ,day = 0;
        year = Integer.parseInt(idCard.substring(6,10));
        month = Integer.parseInt(idCard.substring(10,12));
        day = Integer.parseInt(idCard.substring(12,14));

        //对日期有效性的判断
        if(month < 1 || month > 12)
        {
            throw new Exception("身份证号生日不正确");
        }
        //是否为闰年
        if(month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {

                if (day < 1 || day > 29) {
                    throw new Exception("身份证号生日不正确");
                }
            } else {
                if (day < 1 || month > 28) {
                    throw new Exception("身份证号生日不正确");
                }
            }
        }
        Date birthday = null;
        //birthday = new Date(year,month,day);
        Calendar cal = Calendar.getInstance();
        cal.set(year,month - 1,day);
        birthday = cal.getTime();
        return birthday;
    }

    /**
     * 男 返回 true
     * 女 返回 false
     * @return 身份证号码错误返回 false
     */
    public boolean getSex() {
        if(this.idCard == null || this.idCard.trim().equals("")) {
            return false;
        }
        return (int)idCard.charAt(17) % 2 == 1;
    }
}
