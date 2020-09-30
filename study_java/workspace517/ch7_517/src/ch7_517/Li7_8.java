package ch7_517;

import java.util.*;

public class Li7_8 {
	public static void main(String[] args) {
		// 1.创建 4 个学生对象
		Student stu1 = new Student("Tom", 10);
		Student stu2 = new Student("Aimee", 11);
		Student stu3 = new Student("George", 11);
		Student stu4 = new Student("Angelia", 13);
		// 2.创建 ArrayList 集合对象并把 4 个学生对象放入其中
		List<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(2, stu4); // 添加 stu4 到指定的位置
		// 3.显示第三个元素的信息
		Student student = list.get(2);
		System.out.println("第三个学生的信息如下：");
		System.out.println(student.getName() + "\t" + student.getAge());
		// 4.使用 Iterator 遍历所有学生的信息
		System.out.println("所有学生信息如下：");
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			student = it.next();
			System.out.println(student.getName() + "\t" + student.getAge());
		}
	}
}

class Student {
	String name;
	int age;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}