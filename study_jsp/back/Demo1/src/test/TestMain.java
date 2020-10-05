package test;

import ntvu.lf.JavaWeb.Student;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Student stu1 = null;
        Student stu2 = null;

        {
            try {
                stu1 = new Student("190204517", "wrl", "511923200104329179", "17778595680", "南通职业大学");
                stu2 = new Student("1902045900", "张三 ", "51192320010408917x", "17778595680", "南通职业大学");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (stu1 != null) {
            System.out.println(stu1.getIdCard());
            System.out.println(stu1.getAge());
            System.out.println(stu1.getBirthday());
            System.out.println(stu1.getSex() ? "女" : "男");
        }
        if (stu2 != null)
            System.out.println(stu2.getIdCard());
    }

}
