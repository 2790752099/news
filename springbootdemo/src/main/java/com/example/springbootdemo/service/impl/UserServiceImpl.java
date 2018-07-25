package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public List<User> queryList() {
        return userDao.queryList();
    }
}
