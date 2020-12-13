package study.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.stream
 * @date 2020/12/13 19:11
 */
public class FileInputStreamDemo {

    static void download(String urlString, String filePath) {
        try {
            URL url = new URL(urlString);
            InputStream in = url.openStream();
            FileOutputStream fout = new FileOutputStream(filePath);
            byte[] buf = new byte[32];
            int readLength;

            while ((readLength = in.read(buf)) != -1) {
                fout.write(buf, 0, readLength);
//                System.out.print(new String(buf, 0 , readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        download("https://webmanager1.ntvu.edu.cn/", "W:/ntvu_study/study_java/teach-cb/ntvu.html");
//        download("https://webmanager1.ntvu.edu.cn/", "W:/ntvu_study/study_java/teach-cb/data/ntvu/ntvu.html");
        download("https://attup.ntvu.edu.cn/uploadfile/files/20200831175257939.doc", "data/ntvu/20200831175257939.doc");

    }
}
