package edu.ntvu.springmvcdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;

/**
 * @author alin
 * @Package edu.ntvu.springmvcdemo2.controller
 * @date 2021/3/22 20:02
 * @description todo
 */
@Controller
public class IndexController {

    @RequestMapping("/doRegister")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");

        return mv;
    }

    @RequestMapping(value = {"/login", "index"})
    public ModelAndView login() {
        ModelAndView mv   = new ModelAndView();
        Date date = Calendar.getInstance().getTime();
        mv.addObject(date);
        mv.setViewName("login");

        return mv;
    }

    @RequestMapping("doLogin")
    public ModelAndView doLogin(String username, String pwd) {
        ModelAndView mv = new ModelAndView();

        if ("admin".equals(username) && "admin".equals(pwd)) {
            mv.setViewName("admin/index");
            mv.addObject("user", "admin");
        } else {
            mv.setViewName("login");
        }

        return mv;
    }
}
