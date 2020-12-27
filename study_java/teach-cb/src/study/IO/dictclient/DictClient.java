package study.IO.dictclient;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.IO.dictclient
 * @date 2020/12/19 18:48
 */
public class DictClient {

    final static String SERVER = "dict.org";
    final static int PORT = 2628;
//    final static int TIMEOUT = 15_000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER, PORT);
             Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner in = new Scanner(System.in)) {
//            socket.setSoTimeout(TIMEOUT);

            String word;
            for (; ; ) {
                System.out.println("Please enter a word: (e or E to exit)");
                word = in.next();
                if ("e".equalsIgnoreCase(word.trim())) break;
                define(word, writer, reader);
            }

            System.out.println("end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void define(String word, Writer writer, BufferedReader reader) {
        try {
            writer.write("define fd-eng-jpn " + word + "\r\n");
            writer.flush();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("250")) break;
                else if (line.startsWith("552")) {
                    System.out.println("No definition found for " + word);
                    break;
                }
                else if (line.startsWith("501")) {
                    System.out.println("syntax error, illegal parameters");
                    break;
                } else if (line.startsWith("500")) {
                    System.out.println("unknown command");
                    break;
                } else if (line.matches("\\d\\d\\d .*") || line.trim().endsWith(".")) continue;

                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
