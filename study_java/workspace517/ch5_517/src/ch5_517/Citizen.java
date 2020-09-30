package ch5_517;

public class Citizen {
	public String idCard = "000000000000000000"; // 身份证号码
	public String name = "无名氏"; // 姓名
	public String sex; // 性别

	public String getSex() {
		int temp = Integer.parseInt(idCard.substring(16, 17));
		temp %= 2;
		if (temp == 0) {
			sex = "女";
		} else {
			sex = "男";
		}
		return sex;
	}

	public void display() { // 定义显示属性的方法
		System.out.println("身份证号码： " + idCard);
		System.out.println("姓名： " + name);
		System.out.println("性别： " + getSex());
		System.out.println(
				"出生年月： " + idCard.substring(6, 10) + "." + idCard.substring(10, 12) + "." + idCard.substring(12, 14));
		// 提取身份证的出生年月
	}
}
