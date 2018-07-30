package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    @Cacheable(value = "users",key ="#id.toString()")
    public User query(int id) {

        return userDao.query(id);
    }

    @Override
    public int update(User id) {
        return userDao.update(id);
    }

    @Override
    @CacheEvict(value="users",key="#id.toString()")
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public List<User> queryList() {
        return userDao.queryList();
    }
}
