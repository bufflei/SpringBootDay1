package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public void insert(User user);
    public List<User> queryAll(@Param("page") Integer page,@Param("rows") Integer rows);
    public void delete(String id);
    public Integer countUser();
    public void update(User user);
    public void deleteByIds(String[] ids);
    public User selectByName(@Param("username") String username,@Param("password") String password);
}
