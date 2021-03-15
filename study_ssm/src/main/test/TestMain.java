import edu.ntvu.web.dao.IUserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.ssm.springdemo.tools.Login;

/**
 * @author alin
 * @Package PACKAGE_NAME
 * @date 2021/3/10 9:29
 * @description TestMain 测试类主类
 */
public class TestMain {
    public static void main(String[] args) {

        testDeleteUserByNo("1902045");

    }

    public static void testDeleteUserByNo(String no) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDAO dao = (IUserDAO) ctx.getBean("userDAO");
        System.out.println(dao.delete(no));
    }

    public static void method1() {
        Login lg = new Login();
        lg.setName("wrl");
        lg.show();
    }
}
