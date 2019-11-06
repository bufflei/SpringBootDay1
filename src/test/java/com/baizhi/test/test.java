package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class) //开启SpringBoot注解版的测试
@SpringBootTest(classes = Application.class) //测试时初始化SpringBoot的配置
public class test {
    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert(){
        //userDao.insert(new User("4","张三","123456","15225789512","123456@qq.com","192.168.0.62","微信","user","激活"));
        //userDao.update(new User("4","某某某","123456123","1522121215789512","123@qq.com","192.168.0.123","QQ","admin","冻结"));
        //userDao.delete("4");
        String[] ids={"1","2","3"};
        //userDao.deleteByIds(ids);
        List<User> users = userDao.queryAll(1,3);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
