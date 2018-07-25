package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public List<User> queryList();
    public int delete(int id);
}
