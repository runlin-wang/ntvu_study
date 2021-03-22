import edu.ntvu.web.dao.IUserDAO;
import edu.ntvu.web.entity.User;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.ssm.springdemo.tools.Login;

import java.util.List;

/**
 * @author alin
 * @Package PACKAGE_NAME
 * @date 2021/3/10 9:29
 * @description TestMain 测试类主类
 */
public class TestMain {

    @Test
    public void testSelectByNo() {
//        User user = getIUserDAO().selectByNo("00002");
//        System.out.println(user);
    }

    @Test
    public void testSelectByName() {
        List<User> users = getIUserDAO().selectByName("0");

        System.out.println(users.size());

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testEdit() {
        User user = new User("00002", "Leo", false, 20);
        int result = getIUserDAO().edit(user);

        System.out.println(result);
    }

    @Test
    public void testAdd() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDAO dao = (IUserDAO) ctx.getBean("userDAO");
        User user = new User("00003", "00003", true, 22);
        System.out.println(dao.add(user));
    }

    @Test
    public void testDeleteUserByNo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDAO dao = (IUserDAO) ctx.getBean("userDAO");
        System.out.println(dao.delete("00001"));
    }

    @Test
    public void method1() {
        Login lg = new Login();
        lg.setName("wrl");
        lg.show();
    }

    private IUserDAO getIUserDAO() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDAO dao = null;
        try {
            Object obj = ctx.getBean("userDAO");

            if (obj instanceof IUserDAO) {
                dao = (IUserDAO) obj;
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return dao;
    }
}
