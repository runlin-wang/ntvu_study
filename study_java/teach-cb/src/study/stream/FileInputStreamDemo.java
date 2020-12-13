package study.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.stream
 * @date 2020/12/13 19:11
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fin;
//        System.out.println(System.getProperty("user.dir"));
        try {
            fin = new FileInputStream("src/study/stream/FileInputStreamDemo.java");
            int ch;
            while ((ch = fin.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
