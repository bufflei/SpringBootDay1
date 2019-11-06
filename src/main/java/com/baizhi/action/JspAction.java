package com.baizhi.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/jsp")
public class JspAction {
    @RequestMapping("/first")
    public String first() throws Exception{
        System.out.println("我是第一个JSP");
        return "index";
    }
}
