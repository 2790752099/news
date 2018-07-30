package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public interface UserDao {

    public List<User> queryList();

    public User query(@Param("id") int id);

    public int delete(@Param("id") int id);
    public int update(@Param("user") User id);
}
