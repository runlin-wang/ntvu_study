package com.ntvu.web2.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class StudentService2 {
    private Hashtable<String,Student> htStudents = new Hashtable<String,Student>();



    /**
     * 生成指定个数的学生
     * @param count 个数
     */
    public StudentService2(int count)
    {
        for(int i = 0 ; i < count; i ++)
        {
            Student stu = new Student();
            //190203001-190203010
            String prefix = "1902030";
            if( i < 9)
            {
                stu.setNo(prefix + "0" + (i + 1));
            }else{
                stu.setNo(prefix + (i + 1));
            }
            stu.setName("name" + i);
            htStudents.put(stu.getNo(),stu);
            //lst.add(stu);
        }
    }

    /**
     * 打印当前已有的学生信息
     */
    public void print()
    {
        Enumeration<String> keys = htStudents.keys();
        while(keys.hasMoreElements())
        {
            String key = keys.nextElement();
            System.out.println("no=" + key );
        }
        System.out.println("-------------" );
        for (Student stu : htStudents.values())
        {
            System.out.println("no=" + stu.getNo() + "\tname=" + stu.getName() );
        }
    }

    /**
     * 查询给定学号的学生对象，如果不存在，则返回null
     * @param no 学号
     * @return
     */
    public Student findByNo(String no)
    {
        Student stu = htStudents.get(no);
        return stu;
    }


    public static  void main(String []rags)
    {
        StudentService2 s2 = new StudentService2(10);
        s2.print();
        System.out.println(s2.findByNo("190203009").getName());
    }
}
