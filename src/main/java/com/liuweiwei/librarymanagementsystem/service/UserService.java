package com.liuweiwei.librarymanagementsystem.service;


import com.github.pagehelper.PageInfo;
import com.liuweiwei.librarymanagementsystem.entity.User;

import java.util.List;

public interface UserService {

    void insert(User user) throws Exception;

    void delete(int id) throws Exception;

    User select(int id) throws Exception;

    void update(User user) throws Exception;

    int save(User user) throws Exception;

    PageInfo<User> list(Integer pageNum,Integer pageSize) throws Exception;

    List<User> list(String order, int page, int size) throws Exception;

    int count() throws Exception;
}
