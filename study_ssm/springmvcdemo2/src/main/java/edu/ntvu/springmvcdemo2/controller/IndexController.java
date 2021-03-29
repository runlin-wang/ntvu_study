package edu.ntvu.springmvcdemo2.controller;

import edu.ntvu.springmvcdemo2.dao.IUserDAO;
import edu.ntvu.springmvcdemo2.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author alin
 * @Package edu.ntvu.springmvcdemo2.controller
 * @date 2021/3/22 20:02
 * @description todo
 */
@Controller
public class IndexController {

    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");

        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv   = new ModelAndView();
//        Date date = Calendar.getInstance().getTime();
//        mv.addObject(date);
        mv.setViewName("login");

        return mv;
    }

    @RequestMapping("doLogin")
    public ModelAndView doLogin(User user) {
        ModelAndView mv = new ModelAndView();

        System.out.println(user.getUserName());

        if ("admin".equals(user.getUserName()) && "admin".equals(user.getPwd())) {
            mv.setViewName("admin/index");
            mv.addObject("user", "admin");
        } else {
            mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping("/doRegister")
    public ModelAndView doRegister(User user) {
        ModelAndView mv = new ModelAndView();

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-web.xml");
        IUserDAO dao = (IUserDAO) ac.getBean("userDAO");

        System.out.println(user);

        

        if (dao.add(user)) {
            mv.addObject("user", user);
            mv.setViewName("admin/index");
        } else {
            mv.addObject("msg", "注册失败");
            mv.setViewName("register");
        }

        return mv;
    }
}
