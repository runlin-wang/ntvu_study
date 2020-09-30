package ntvu.lf.JavaWeb.util;

public class Tools {

    public static void validateIDCard(String idCard) throws Exception {
        for (int index = 0; index < idCard.length(); index++) {
            if (idCard.charAt(index) >= '0' && idCard.charAt(index) <= '9')
                continue;
            else {
                if (index == 17 && idCard.charAt(index) == 'x' || idCard.charAt(index) == 'X')
                    continue;
                else
                    throw new Exception("身份证号长度必须等于 18 位，且必须为纯数字，最后一位可以为X");
            }
        }
    }

    public static boolean isNull(String data) {
        return data == null || data.trim().isEmpty();
    }
}
