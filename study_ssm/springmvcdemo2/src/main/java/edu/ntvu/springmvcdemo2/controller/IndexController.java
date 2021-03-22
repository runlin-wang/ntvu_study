package edu.ntvu.springmvcdemo2.controller;

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

    public ModelAndView register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");

        return mv;
    }

    @RequestMapping(value = "/login")
    public String second() {
        return "login";
    }
}
