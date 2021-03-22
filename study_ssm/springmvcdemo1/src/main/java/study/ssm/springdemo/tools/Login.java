package study.ssm.springdemo.tools;

import org.springframework.stereotype.Component;

//@Component("teacher")
public class Login {
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("welcome: " + this.name);
    }
}
