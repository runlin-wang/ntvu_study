package study.IO;

import java.io.*;
import java.net.URL;

class DownloadClass {

    private final String urlString;
    private final String filePath;

    public DownloadClass(String urlString, String filePath) {
        this.urlString = urlString;
        this.filePath = filePath;
    }

    public void download() {
        try {
            URL url = new URL(urlString);
            BufferedInputStream in = new BufferedInputStream(url.openStream());
            FileOutputStream fout = new FileOutputStream(filePath);
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            byte[] buf = new byte[512];
            int len;

            while ((len = in.read(buf)) != -1) {
                bout.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {

    private DownloadClass download;

    public MyThread(DownloadClass download) {
        this.download = download;
    }

    @Override
    public void run() {
        download.download();
    }
}

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.stream
 * @date 2020/12/13 19:11
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        try {
            FileInputStream fin = new FileInputStream("src/study/IO/FileInputStreamDemo.java");
            int ch;
            while ((ch = fin.read()) != -1) {
                System.out.print((char) ch);
//                fin.skip(1);
            }

            fin.reset();
//            fin.skip(128);
            while ((ch = fin.read()) != -1) System.out.println((char) ch);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            new MyThread(new DownloadClass("https://webmanager1.ntvu.edu.cn/", "data/ntvu/ntvu" + i + ".html")).start();
//            new MyThread(new DownloadClass("https://attup.ntvu.edu.cn/uploadfile/files/20200831175257939.doc", "data/ntvu/ntvu" + i + ".doc")).start();
//            new MyThread(new DownloadClass("https://attup.ntvu.edu.cn/attachment/core/label/2018_03/05_15/422efb26e8d856e4.jpg", "data/ntvu/ntvu" + i + ".jpg")).start();
//        }
//
//        System.out.println(System.currentTimeMillis() - start);
//        String url = "https://attup.ntvu.edu.cn/uploadfile/files/20200831175257939.doc";
//        url = url.substring(url.lastIndexOf(47));
//        System.out.println(url);

    }
}
