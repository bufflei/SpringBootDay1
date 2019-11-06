package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public void insert(User user);
    public List<User> showAll(Integer page,Integer rows);
    public void delete(String id);
    public void update(User user);
    public Integer countUser();
    public void deleteByIds(String[] ids);
    public User showByName(String username,String password);
}
