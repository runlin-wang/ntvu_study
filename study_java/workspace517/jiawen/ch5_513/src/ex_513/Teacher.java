

package ex_513;
	 class Citizens
	{
		public String personID="000000000000000000";
		public String name="������";
		public String sex="��";
		public String birthday="1900.1.1";
		public void display()
		{
			System.out.println("���֤���룺"+personID);
			System.out.println("������"+name);
			System.out.println("�Ա�"+sex);
			System.out.println("���գ�"+birthday);
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
			position="��ʦ";
		    curriculum="����";
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
			System.out.println("��ţ�"+TeacherID);
			System.out.println("ְλ��"+position);
			System.out.println("���Σ�"+curriculum);
		}
		public static void main(String[] args)
		{
			Teacher teacher_obj1=new Teacher();
			teacher_obj1.display();
			Teacher teacher_obj2=new Teacher("412701197902102755","����","��","1979.2.10","200921521","��ʦ","��ʷ");
			teacher_obj2.display();
		}
	}