package com.baizhi.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloAction {
	
	//这是在本地仓库上修改的
    
    //这是在远程仓库上进行的远程修改
    @RequestMapping("/boot")
    @ResponseBody
    public String boot() throws Exception{
        System.out.println("hello World!");
        return "hello";
    }
}
