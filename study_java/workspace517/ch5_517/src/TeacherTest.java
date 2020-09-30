// Citizen.java 公民类定义
class Citizen {
	String personID = "000000000000000000"; // 身份证号码
	public String name = "无名氏"; // 姓名
	public String sex = "男"; // 性别
	public String birthday = "1900.1.1"; // 生日

	public void display() { // 定义显示属性的方法
		System.out.println("身份证号码：" + personID);
		System.out.println("姓名：" + name);
		System.out.println("性别：" + sex);
		System.out.println("生日：" + birthday);
	}
}

class Teacher extends Citizen {
	private String workNum = "0000000";
	private String post = "无";
	private String course = "无";

	Teacher() {
	}

	Teacher(String personID, String name, String sex, String birthday, String workNum, String post, String course) {
		this.personID = personID;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.workNum = workNum;
		this.post = post;
		this.course = course;
	}

	public void display() {
		super.display();
		System.out.println("教师代码：" + workNum);
		System.out.println("教师职位：" + post);
		System.out.println("主讲课程：" + course);
	}
}

//TeacherTest.java
public class TeacherTest {
	public static void main(String[] args) {
		Teacher teacher_obj1 = new Teacher();
		Teacher teacher_obj2 = new Teacher("417231197612092395", "大魔王", "男", "1976.12.09", "12345678", "教导主任",
				"python");
		teacher_obj1.display();
		teacher_obj2.display();
	}
}