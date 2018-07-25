package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<User> queryList();
    public int delete(@Param("id") int id);
}
