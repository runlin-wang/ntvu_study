package com.ntvu.web2.service;


import java.util.Calendar;
import java.util.Date;

public class Student {

    private String no;
    private String name;
    private int age;
    private Date birthday;
    private String telephone;
    private boolean sex;
    private String address;
    /**
     * 身份证号
     */
    private String idCard;

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

    public int getAge() {
        return age;
    }


    public Date getBirthday() {
        return birthday;
    }



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isSex() {
        return sex;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     * 同时判断其合法性，解析得到生日，年龄，性别
     * @param idCard
     */
    public void setIdCard(String idCard) throws Exception {
        //判断 合法
        if(idCard == null || idCard.trim().length() != 18)
        {
            throw new Exception("身份证号不正确,长度必须为18位");
        }
        String sTemp = idCard.trim();
        for (int index = 0; index < sTemp.length(); index ++)
        {
            if(sTemp.charAt(index) >= '0' && sTemp.charAt(index) <= '9')
            {
                continue;
            }else{
                if(index == 17 && (sTemp.charAt(index) == 'x' || sTemp.charAt(index) == 'X'))
                {
                    continue;
                }else{
                    throw new Exception("身份证号不正确,必须为0-9之间的数字,最后一位可为x");
                }
            }
        }
        this.idCard = idCard;

        //解析得到生日，年龄，性别 320602 200008091234
        Calendar cal = Calendar.getInstance();
        int currentYear = 0;
        currentYear = cal.get(Calendar.YEAR);

        int year = 0,month = 0,day = 0;
        year = Integer.parseInt(sTemp.substring(6,10));
        month = Integer.parseInt(sTemp.substring(10,12));
        day = Integer.parseInt(sTemp.substring(12,14));
        cal.set(year,month,day);
        this.birthday = cal.getTime();

        //年龄
        this.age = currentYear - year;

        //性别
        if(Integer.parseInt(sTemp.substring(16,17)) % 2 == 1)
        {
            this.sex = true;
        }else{
            this.sex = false;
        }

    }



}
