

package ex_513;
	 class Citizens
	{
		public String personID="000000000000000000";
		public String name="无名氏";
		public String sex="男";
		public String birthday="1900.1.1";
		public void display()
		{
			System.out.println("身份证号码："+personID);
			System.out.println("姓名："+name);
			System.out.println("性别："+sex);
			System.out.println("生日："+birthday);
		}
	}
	public class Teacher extends Citizens

	{
		public String TeacherID;
		public String position;
		public String curriculum;
		public  Teacher()
		{
			TeacherID="000000000";
			position="讲师";
		    curriculum="语文";
		}
		public Teacher(String personID,String name,String sex,String birthday,String teacherID,String position,String curriculum)
		{
			this.personID=personID;
			this.name=name;
			this.birthday=birthday;
			this.TeacherID=teacherID;
			this.position=position;
			this.curriculum=curriculum;
		}
		
		 public  void display()
		{
			super.display();
			System.out.println("编号："+TeacherID);
			System.out.println("职位："+position);
			System.out.println("课任："+curriculum);
		}
		public static void main(String[] args)
		{
			Teacher teacher_obj1=new Teacher();
			teacher_obj1.display();
			Teacher teacher_obj2=new Teacher("412701197902102755","王东","男","1979.2.10","200921521","讲师","历史");
			teacher_obj2.display();
		}
	}