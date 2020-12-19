package study.IO.dictclient;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.IO.dictclient
 * @date 2020/12/19 21:14
 */
public class SocketStudy {
    public static void main(String[] args) {
        final String HOST = "time.nist.gov";
        final int PORT = 13;
        try (Socket socket = new Socket(HOST, PORT);
             InputStream in = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

//            while ((ch = in.read()) != -1) {
//                System.out.print((char) ch);
//            }

            int ch = -1;
            char[] chars = new char[8192];

            while ((reader.read(chars) != -1));
            System.out.print(chars);

//            while ((ch = reader.read()) != -1) {
//                System.out.print((char) ch);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
