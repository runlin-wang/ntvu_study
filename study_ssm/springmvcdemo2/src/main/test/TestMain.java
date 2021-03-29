import edu.ntvu.springmvcdemo2.controller.IndexController;
import edu.ntvu.springmvcdemo2.dao.IUserDAO;
import edu.ntvu.springmvcdemo2.entity.User;
import edu.ntvu.springmvcdemo2.util.EncryptTools;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author alin
 * @Package PACKAGE_NAME
 * @date 2021/3/24 10:31
 * @description todo
 */
public class TestMain {

    @Test
    public void testRegister() {
        User user = new User("testRegister2", "testRegister2", "testRegister2", "testRegister2", "testRegister2", true, 21);
        user.setSalt(EncryptTools.getRandomStr());

        ModelAndView mv = new IndexController().doRegister(user);
        System.out.println(mv);
    }

    @Test
    public void testAddUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-web.xml");
        IUserDAO dao = (IUserDAO) ac.getBean("userDAO");
        User user = new User("leo", "leo", "里昂", "1777893112", "leo@gmail.com", true, 20);

        assert dao.add(user);
    }

    @Test
    public void newIUserDAO() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-web.xml");
        IUserDAO dao = (IUserDAO) ac.getBean("userDAO");
        System.out.println(dao.getClass());
    }

    @Test
    public void newUser() {
        User user = new User("leo", "leo", "里昂", "1777893112", "leo@gmail.com", true, 20);
        System.out.println(user);
    }
}
