package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) throws Exception{
        User user1= userService.showByName(user.getUsername(),user.getPassword());
        session.setAttribute("login","Y");
        return "redirect:/showAll.jsp";
    }
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows) throws Exception{
        Map<String, Object> maps = new HashMap<>();
        Integer count = userService.countUser();
        List<User> users = userService.showAll(page, rows);
        Integer pageCount=count%rows==0?count/rows:count/rows+1;
        maps.put("rows",users);
        maps.put("total",pageCount);
        maps.put("records",count);
        maps.put("page",page);
        return maps;
    }
    @RequestMapping("/edit")
    @ResponseBody
    public void edit(String oper,User user,String[] id) throws Exception{
        if("add".equals(oper)){
            userService.insert(user);
        }else if("edit".equals(oper)){
            userService.update(user);
        }else if("del".equals(oper)){
            userService.delete(user.getId());
            userService.deleteByIds(id);
        }
    }
}
