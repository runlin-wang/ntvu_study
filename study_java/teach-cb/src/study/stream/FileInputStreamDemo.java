package study.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
            byte[] buf = new byte[512];
            int len;

            while ((len = in.read(buf)) != -1) {
                fout.write(buf, 0, len);
//                System.out.print(new String(buf, 0 , len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        download("https://webmanager1.ntvu.edu.cn/", "W:/ntvu_study/study_java/teach-cb/ntvu.html");
//        download("https://webmanager1.ntvu.edu.cn/", "W:/ntvu_study/study_java/teach-cb/data/ntvu/ntvu.html");
//        download("https://attup.ntvu.edu.cn/uploadfile/files/20200831175257939.doc", "data/ntvu/20200831175257939.doc");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            download("https://webmanager1.ntvu.edu.cn/", "data/ntvu/ntvu" + i + ".html");
            download("https://attup.ntvu.edu.cn/uploadfile/files/20200831175257939.doc", "data/ntvu/ntvu" + i + ".doc");
            download("https://attup.ntvu.edu.cn/attachment/core/label/2018_03/05_15/422efb26e8d856e4.jpg", "data/ntvu/ntvu" + i + ".jpg");
        }

        System.out.println(System.currentTimeMillis() - start);
//        String url = "https://attup.ntvu.edu.cn/uploadfile/files/20200831175257939.doc";
//        url = url.substring(url.lastIndexOf(47));
//        System.out.println(url);

    }
}
