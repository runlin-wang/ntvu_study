package ntvu.lf.JavaWeb;

public class StringPars {

    public static void main(String[] args) {
        String idCard = "511923200104089179";
        String birthday;
        int age;
        boolean sex;

        // 获取生日
        birthday = idCard.substring(6, 14);


//        age = Integer.parseInt().charAt(16) % 2 == 0;
        System.out.println(idCard.charAt(16));

        System.out.println(birthday);
    }
}
