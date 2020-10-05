package com.ntvu.web2.service;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> lst = new ArrayList<Student>();
    /**
     * 生成指定个数的学生
     * @param count 个数
     */
    public StudentService(int count)
    {
        lst = new ArrayList<Student>();
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
            lst.add(stu);
        }
    }

    /**
     * 打印当前已有的学生信息
     */
    public void print()
    {
        for (Student stu : lst)
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
//        for(int index = 0; index < lst.size(); index ++)
//        {
//            if(lst.get(index) != null && lst.get(index).getNo().equals(no))
//            {
//                return lst.get(index);
//            }
//        }

        for (Student stu : lst)
        {
            if(stu != null && stu.getNo().equals(no))
            {
                return stu;
            }
        }
        return null;
    }

}
