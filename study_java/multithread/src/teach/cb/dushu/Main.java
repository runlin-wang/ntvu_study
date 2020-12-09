package teach.cb.dushu;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package teach.cb.dushu
 * @date 2020/12/6 20:02
 */
public class Main {

    private static String[] unitDict = new String[]{"", "拾", "佰", "仟", "", "万", "亿"};
    private static String[] digitDict = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static int generateArray(int n, int[] d) {
        int index = -1;
        int highestBit = -1;
        int r;
        do {
            r = n % 10;
            d[++index] = r;
            if (r != 0)
                highestBit = index;
        } while ((n /= 10) != 0);
        return highestBit;
    }

//    public static int generatedArray(int a, int[] d) {
//        int i;
//        for (i = 0; a != 0; i++, a /= 10) {
//            d[i] = a % 10;
//        }
//
//        return i;
//    }

    public static void main(String[] args) {

        int[] d = new int[16];
        int n = 233403200;
        int highestBit = generateArray(n, d);
        StringBuilder sb = new StringBuilder();

        int flag = 1;
        int sectionFlag;
        int section = highestBit / 4;
        int start = highestBit; // 9

        for (int j, i = section; i >= 0; i--) {
            sectionFlag = 0;
            for (j = start; j >= i * 4; j--) {
                if (d[j] != 0) {
                    if (flag == 0) {
                        sb.append(digitDict[0]);
                    }
                    sb.append(digitDict[d[j]]).append(unitDict[j % 4]);
                    sectionFlag = flag = 1;
                } else {
                    flag = 0;
                }
            }
            start = j;
            if (sectionFlag == 1)
                sb.append(unitDict[i + 4]);
            flag = 1;
        }

        System.out.println(sb);


//        int n = 9;
//        int[] d = new int[4];
//        int highestBit = generatedArray(n, d);
//        StringBuilder sb = new StringBuilder();
//
//        boolean flag = false;
//        for (int i = highestBit; i >= 0; i--) {
//            if (d[i] > 0) {
//                if (flag)
//                    sb.append(digitDict[0]);
//                sb.append(digitDict[d[i]]).append(unitDict[i]);
//                flag = false;
//            } else {
//                flag = true;
//            }
//        }
//
//        System.out.println(sb);
    }
}
