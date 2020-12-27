package socket.baidu;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package socket.baidu
 * @date 2020/12/27 20:34
 */
public class FindBaidu {
    public static void main(String[] args) {
//        QueryString queryString = new QueryString();
//        queryString.add("k1", "math english").add("k 2", "val ue2");
//        queryString.add("k 2", "val ue2");

//        System.out.println(queryString);

        try {
            URL url = new URL("http://www.baidu.com/s?" + new QueryString().add("wd", "math english"));
            InputStream in = url.openStream();
            OutputStream writer = new FileOutputStream("result.html");
            int ch;
            while ((ch = in.read()) != -1) {
                System.out.print((char) ch);
                writer.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class QueryString {

    private final StringBuilder query = new StringBuilder();
    private int kvLen = 0;

    public QueryString add(String name, String value) {
        if (kvLen++ > 0) query.append('&');
        encode(name, value);
        return this;
    }

    private void encode(String name, String value) {
        try {
            query.append(URLEncoder.encode(name, "utf-8"));
            query.append('=');
            query.append(URLEncoder.encode(value, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getQuery() {
        return query.toString();
    }

    @Override
    public String toString() {
        return getQuery();
    }
}