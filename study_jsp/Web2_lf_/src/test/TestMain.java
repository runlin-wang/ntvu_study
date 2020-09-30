package test;

import com.ntvu.web2.Student;

import java.text.SimpleDateFormat;

public class TestMain {
    public static void main (String []args)
    {
        Student stu1 = new Student();

        try {
            stu1 = new Student("no","String name","32060220000238123x","String telephone","String address");

            System.out.println(stu1.getIdCard());
            System.out.println(stu1.getAge());

            System.out.println(stu1.getBirthday().toString());

            //日期转化格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            System.out.println(sdf.format(stu1.getBirthday()));


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
