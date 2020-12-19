package study.IO.dictclient;

import java.io.*;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.IO.dictclient
 * @date 2020/12/19 20:21
 */
public class DictClient1 {
    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt")))) {
            writer.write("wrl");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data.txt")))) {
            int ch;
//            char[] cbuf = new char[0];
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (FileWriter writer = new FileWriter("data.txt")) {
//            char[] chars = "hello world".toCharArray();
//            writer.write(chars, 6, 5);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (FileReader reader = new FileReader("data.txt")) {
//            char[] buf = new char[2];
//            int ch;
//            while ((ch = reader.read()) != -1) {
//                System.out.print((char) ch);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
