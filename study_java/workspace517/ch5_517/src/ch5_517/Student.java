package ch5_517;

public class Student extends Citizen { // 学生类由公民类派生
	// 学生类的特有属性定义
	public String studentID; // 声明学号
	public String registerTime; // 声明注册时间
	public int init_result; // 入学成绩

	public Student() { // 没参数的构造方法1
		studentID = "000000000";
		registerTime = "1900.1.1";
		init_result = 0;
	}

	public Student(String idCard, String name, String studentID, String registerTime, int init_result) { // 带参数的构造方法
		this.idCard = idCard;
		this.name = name;
		this.studentID = studentID;
		this.registerTime = registerTime;
		this.init_result = init_result;
	}

	public void display() { // 成员方法display(),显示学生属性
		super.display();
		System.out.println("学号：" + studentID);
		System.out.println("入学时间：" + registerTime);
		System.out.println("入学成绩：" + init_result);
	}
}
