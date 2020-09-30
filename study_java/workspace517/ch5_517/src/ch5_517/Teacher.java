package ch5_517;

public class Teacher extends Citizen {
	public String jobNumber;
	public String tutorship;
	public String course;

	public Teacher() {
		jobNumber = "00000000";
		tutorship = "无";
		course = "无";
	}

	public Teacher(String idCard, String name,String jobNumber, String tutorship, String course) {
		this.idCard = idCard;
		this.name = name;
		this.jobNumber = jobNumber;
		this.tutorship = tutorship;
		this.course = course;
	}

	public void display() {
		super.display();
		System.out.println("教师代码：" + jobNumber);
		System.out.println("教师职位：" + tutorship);
		System.out.println("主讲课程：" + course);
	}
}
