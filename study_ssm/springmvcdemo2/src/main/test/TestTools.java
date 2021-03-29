import edu.ntvu.springmvcdemo2.util.EncryptTools;
import org.junit.Test;

/**
 * @author alin
 * @Package PACKAGE_NAME
 * @date 2021/3/29 19:44
 * @description todo
 */
public class TestTools {

    @Test
    public void testMd52() {
        String data = "123456";
        String salt = EncryptTools.getRandomStr();
        System.out.println(EncryptTools.md5(data, salt));
    }

    @Test
    public void testMd5() {
        String data = "123456";
        System.out.println(EncryptTools.md5(data));
    }

    @Test
    public void testGetRandomStr() {
        System.out.println(EncryptTools.getRandomStr());
    }
}
